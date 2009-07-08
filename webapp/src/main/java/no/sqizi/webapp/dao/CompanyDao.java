package no.sqizi.webapp.dao;

import no.sqizi.webapp.domain.Company;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 18, 2009
 * Time: 7:55:55 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CompanyDao {
    Company getCompanyData(String companyName);
}
