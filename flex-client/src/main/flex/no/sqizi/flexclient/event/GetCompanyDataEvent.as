package no.sqizi.flexclient.event {
import flash.events.Event;

public class GetCompanyDataEvent  extends Event{

     public static const TYPE:String = "getCompanyDataEvent";
    private var _companyName:String;


    public function get companyName():String {
        return _companyName;
    }

    public function GetCompanyDataEvent(companyName:String) {
        _companyName = companyName;
        super(TYPE);
    }
}
}