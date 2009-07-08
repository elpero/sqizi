package no.sqizi.flexclient.event {
import flash.events.Event;

public class DisplaySpecificCategoryEvent  extends Event{
    public static const TYPE:String = "DisplaySpecificCategoryEvent";
    public function DisplaySpecificCategoryEvent(categoryId:int) {
        super(TYPE);
        _categoryId=categoryId;
    }

    private var _categoryId:int;


    public function get categoryId():int {
        return _categoryId;
    }
}
}