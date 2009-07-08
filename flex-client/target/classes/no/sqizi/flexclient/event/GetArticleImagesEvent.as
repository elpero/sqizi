package no.sqizi.flexclient.event {
import flash.events.Event;

public class GetArticleImagesEvent extends Event {
    public static const TYPE:String = "GetArticleImagesEvent";
    public function GetArticleImagesEvent(id:int) {
        super(TYPE)
        _id = id;
    }

    private var _id:int;


    public function get id():int {
        return _id;
    }

    public function set id(value:int):void {
        _id = value;
    }
}
}