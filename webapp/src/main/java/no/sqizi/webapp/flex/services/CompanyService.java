package no.sqizi.webapp.flex.services;

import no.sqizi.webapp.domain.Company;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 18, 2009
 * Time: 7:58:55 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CompanyService {
    Company getCompanyData(String companyName);
}
