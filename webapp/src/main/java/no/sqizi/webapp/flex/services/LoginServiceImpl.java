package no.sqizi.webapp.flex.services;

import no.sqizi.webapp.domain.User;
import no.sqizi.webapp.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 16, 2009
 * Time: 11:24:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(String userName){

        return userDao.getUser(userName);

    }

}
