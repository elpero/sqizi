package no.sqizi.flexclient.event {
import flash.events.Event;

public class ImageDeletedEvent extends Event{

    public static const TYPE:String = "ImageDeletedEvent";

    public function ImageDeletedEvent() {
        super(TYPE);
    }
}
}