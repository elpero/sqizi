package no.sqizi.flexclient.event {
import flash.events.Event;

public class LoginEvent  extends Event{
    public static const TYPE:String = "loginEvent";

    public function LoginEvent(userName:String, password:String) {
        _userName = userName;
        _password = password;
        super(TYPE);
    }

    private var _password:String;

    private var _userName:String;


    public function get password():String {
        return _password;
    }

    public function set password(value:String):void {
        _password = value;
    }

    public function get userName():String {
        return _userName;
    }

    public function set userName(value:String):void {
        _userName = value;
    }
}
}