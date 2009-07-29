package no.sqizi.flexclient.controller {
import flash.events.Event;

import mx.controls.Alert;
import mx.rpc.AsyncResponder;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;

import no.sqizi.flexclient.event.ImageDeletedEvent;

import org.swizframework.Swiz;

public class DeleteImageResponder  extends AsyncResponder{
    public function DeleteImageResponder() {
        super(handleResult, handleFault);
    }

    private function handleFault(fault:FaultEvent, token:Object = null):void {
        Alert.show(fault.fault.faultString, "Delete Image Failed");
    }


    private function handleResult(result:ResultEvent, token:Object = null):void{
        Swiz.dispatchEvent(new ImageDeletedEvent());

    }


}
}