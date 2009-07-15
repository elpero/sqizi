package no.sqizi.flexclient.event {
import flash.events.Event;

public class GetRecentArticlesEvent  extends Event{

    public static const TYPE:String = "GetRecentArticlesEvent";
    
    private var _number:int = 5;

    public function get number():int {
        return _number;
    }

    public function GetRecentArticlesEvent(number:int) {
        super(TYPE);
        _number = number;
    }
}
}