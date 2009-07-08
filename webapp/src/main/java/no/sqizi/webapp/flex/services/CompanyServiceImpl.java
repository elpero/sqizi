package no.sqizi.webapp.flex.services;

import org.springframework.beans.factory.annotation.Autowired;
import no.sqizi.webapp.dao.CompanyDao;
import no.sqizi.webapp.domain.Company;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 18, 2009
 * Time: 7:57:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    public CompanyDao getCompanyDao() {
        return companyDao;
    }

    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public Company getCompanyData(String companyName){
        return companyDao.getCompanyData(companyName);
    }
}
