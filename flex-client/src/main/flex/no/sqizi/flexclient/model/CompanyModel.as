package no.sqizi.flexclient.model {
import no.sqizi.flexclient.domain.Company;

[Bindable]
public class CompanyModel {

    public function CompanyModel() {
    }

    private var _currentCompanyData:Company;

    public function get currentCompanyData():Company {
        return _currentCompanyData;
    }

    public function set currentCompanyData(value:Company):void {
        _currentCompanyData = value;
    }

    
}
}