package no.sqizi.flexclient.delegate {
import mx.rpc.AsyncToken;
import mx.rpc.remoting.RemoteObject;

public class LoginDelegate  {
    public function LoginDelegate() {
    }

    public function getUser(userName:String):AsyncToken{
        return loginService.getUser(userName);
    }

    [Autowire(bean="loginService")]
    public var loginService:RemoteObject;
}
}