package no.sqizi.flexclient.event {
import flash.events.Event;

public class DisplayAllCategoriesEvent  extends Event{

    public static const TYPE:String = "DisplayAllCategoriesEvent";

    public function DisplayAllCategoriesEvent() {
        super(TYPE);
    }
}
}