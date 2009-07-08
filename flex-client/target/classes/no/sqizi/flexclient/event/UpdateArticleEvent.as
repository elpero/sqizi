package no.sqizi.flexclient.event {
import flash.events.Event;

import no.sqizi.flexclient.domain.User;

public class UpdateArticleEvent  extends Event{
    public static const TYPE:String = "UpdateArticleEvent";

    private var _id:int;
    private var _title:String;
    private var _abstract:String;
    private var _content:String;
    private var _author:User;
    private var _date:Date;


    public function UpdateArticleEvent(id:int, title:String, abstract:String, content:String, author:User, date:Date) {
        super(TYPE);
        _id = id;
        _title = title;
        _abstract = abstract;
        _content = content;
        _author = author;
        _date = date;
    }

    public function get id():int {
        return _id;
    }

    public function set id(value:int):void {
        _id = value;
    }

    public function get title():String {
        return _title;
    }

    public function set title(value:String):void {
        _title = value;
    }

    public function get abstract():String {
        return _abstract;
    }

    public function set abstract(value:String):void {
        _abstract = value;
    }

    public function get content():String {
        return _content;
    }

    public function set content(value:String):void {
        _content = value;
    }

    public function get author():User {
        return _author;
    }

    public function set author(value:User):void {
        _author = value;
    }

    public function get date():Date {
        return _date;
    }

    public function set date(value:Date):void {
        _date = value;
    }


}
}