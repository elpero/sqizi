package no.sqizi.flexclient.event {
import flash.events.Event;

public class AddCategoryEvent  extends Event{

    public static const TYPE:String = "AddCategoryEvent";

    private var _name:String;
    private var _description:String;
    private var _parent:int;


    public function AddCategoryEvent(name:String, description:String, parent:int) {
        super(TYPE);
        _name = name;
        _description = description;
        _parent = parent;
    }


    public function get name():String {
        return _name;
    }

    public function get description():String {
        return _description;
    }

    public function get parent():int {
        return _parent;
    }
}
}