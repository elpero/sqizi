package no.sqizi.flexclient.controller {
import mx.rpc.AsyncResponder;

import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;

import no.sqizi.flexclient.delegate.CompanyDelegate;

import no.sqizi.flexclient.domain.Company;
import no.sqizi.flexclient.event.GetCompanyDataEvent;
import no.sqizi.flexclient.model.CompanyModel;

import org.swizframework.Swiz;
import org.swizframework.controller.AbstractController;

public class CompanyController  extends AbstractController{


    

    [Autowire(bean="companyDelegate")]
    public var companyDelegate:CompanyDelegate;

    [Autowire(bean="companyModel")]
    public var companyModel:CompanyModel;


    public function CompanyController() {
        Swiz.addEventListener(GetCompanyDataEvent.TYPE, getCompanyData)
        super();
    }

    public function getCompanyData(event:GetCompanyDataEvent):void{
        companyDelegate.getCompanyData(event.companyName).addResponder(
                new AsyncResponder(handleSuccess, handleFailure));
    }

    private function handleSuccess(result:ResultEvent, token:Object = null):void{
        companyModel.currentCompanyData = Company(result.result);

    }
    private function handleFailure(fault:FaultEvent, token:Object = null):void{
        
    }
}
}