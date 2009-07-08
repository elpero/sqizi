package no.sqizi.flexclient.event {
import flash.events.Event;

public class LogOutEvent  extends Event {

    public static const TYPE:String = "LogOutEvent";
    public function LogOutEvent(){
        super(TYPE);
    }
}
}