package no.sqizi.flexclient.controller {
import flash.events.Event;

import mx.controls.Alert;
import mx.rpc.AsyncResponder;

import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;

import no.sqizi.flexclient.delegate.LoginDelegate;

import no.sqizi.flexclient.domain.User;
import no.sqizi.flexclient.event.LoginEvent;

import no.sqizi.flexclient.event.LogOutEvent;
import no.sqizi.flexclient.model.UserModel;

import org.swizframework.Swiz;
import org.swizframework.controller.AbstractController;

public class LoginController extends AbstractController{

    
    [Autowire(bean="loginDelegate")]
    public var loginDelegate:LoginDelegate;

    [Autowire(bean="userModel")]
    public var userModel:UserModel;
    
    public function LoginController() {
        Swiz.addEventListener(LoginEvent.TYPE, handleLoginEvent);
        Swiz.addEventListener(LogOutEvent.TYPE, handleLogoutEvent);
    }

    private function handleLogoutEvent(event:LogOutEvent):void {
        if(loginDelegate.loginService.channelSet.authenticated){
            loginDelegate.loginService.channelSet.logout();
        }
        Swiz.dispatchEvent( new Event(Sqizi.loggedOutMessage));
    }

    private function handleLoginEvent(event:LoginEvent):void {
        if(loginDelegate.loginService.channelSet.authenticated){
            loginDelegate.loginService.channelSet.logout();
        } else {
            loginDelegate.loginService.channelSet.login(event.userName, event.password).addResponder(
                new AsyncResponder(onChannelLogInSucc, onChannelLogInFault)
                );
        }
    }

    private function onChannelLogInSucc(result: ResultEvent, token:Object = null):void{
             getUserData(result.result.name as String);

    }
    private function onChannelLogInFault(fault: FaultEvent, token:Object = null):void{
        Alert.show(fault.fault.faultString, "Login Failed");
    }

    private function getUserData(userName:String):void{
        loginDelegate.getUser(userName).addResponder(
                new AsyncResponder(
                        function(result:ResultEvent, token:Object = null):void{
                              userModel.loggedInUser = User(result.result);
                              Swiz.dispatchEvent(new Event(Sqizi.loggedInMessage));
                        },
                        function (fault:FaultEvent, token:Object = null):void{
                            Alert.show(fault.fault.faultString, "Login Failed");                    
                        }
                        )
                );
    }

}
}