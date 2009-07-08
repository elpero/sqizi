package no.sqizi.webapp.dao;

import no.sqizi.webapp.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 18, 2009
 * Time: 7:49:07 AM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CompanyDaoImpl implements CompanyDao {

     @Autowired
    private SqlMapClientTemplate template;

    public SqlMapClientTemplate getTemplate() {
        return template;
    }

    public void setTemplate(SqlMapClientTemplate template) {
        this.template = template;
    }

    @Override
    public Company getCompanyData(String companyName){
        return (Company) template.queryForObject("getCompanyData", companyName);
    }
}
