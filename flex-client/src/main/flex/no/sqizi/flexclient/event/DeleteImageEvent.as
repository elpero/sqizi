package no.sqizi.flexclient.event {
import flash.events.Event;

public class DeleteImageEvent  extends Event{

    private var _imageId:int;


    public function get imageId():int {
        return _imageId;
    }

    public static const TYPE:String = "DeleteImageEvent";

    public function DeleteImageEvent(imageId:int) {
        _imageId = imageId;
        super(TYPE);
    }
}
}