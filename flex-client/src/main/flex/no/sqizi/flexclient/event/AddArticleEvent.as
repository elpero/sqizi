package no.sqizi.flexclient.event {
import flash.events.Event;

public class AddArticleEvent extends Event{
    public static const TYPE:String = "AddArticleEvent";

    private var _title:String;
    private var _content:String;
    private var _abstract:String;
    private var _articleContent:String;
    private var _categoryId:int;



    public function AddArticleEvent(title:String, categoryId:int, content:String, abstract:String) {
        super(TYPE);
        _title = title;
        _categoryId = categoryId;
        _articleContent = content;
        _abstract = abstract;
    }

    public function get categoryId():int {
        return _categoryId;
    }
    
    public function get title():String {
        return _title;
    }

    public function get content():String {
        return _articleContent;
    }

    public function get abstract():String {
        return _abstract;
    }
}
}