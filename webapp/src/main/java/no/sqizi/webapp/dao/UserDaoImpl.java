package no.sqizi.webapp.dao;

import no.sqizi.webapp.domain.User;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 16, 2009
 * Time: 11:28:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlMapClientTemplate template;

    public SqlMapClientTemplate getTemplate() {
        return template;
    }

    public void setTemplate(SqlMapClientTemplate template) {
        this.template = template;
    }

    @Override
    public User getUser(String userName){

        final HashMap<String, String> params = new HashMap<String, String>();
        params.put("userName", userName);
        final User user = (User) template.queryForObject("getUser", params);
        return user;

    }


}
