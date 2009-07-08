package no.sqizi.flexclient.event {
import flash.events.Event;

public class NewArticleEvent  extends Event{

    public static const TYPE:String = "NewArticleEvent";
    private var _newArticleId:int;


    public function get newArticleId():int {
        return _newArticleId;
    }

    public function NewArticleEvent(id:int) {
        _newArticleId = id;
        super(TYPE);
    }
}
}