package no.sqizi.flexclient.delegate {
import mx.rpc.AsyncToken;
import mx.rpc.remoting.RemoteObject;

import no.sqizi.flexclient.domain.Company;

public class CompanyDelegate {
    public function CompanyDelegate() {
    }

    public function getCompanyData(name:String):AsyncToken{
         return companyService.getCompanyData(name);
    }

    [Autowire(bean="companyService")]
    public var companyService:RemoteObject;
}
}