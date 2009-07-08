package no.sqizi.webapp.dao;

import no.sqizi.webapp.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 16, 2009
 * Time: 11:32:23 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    User getUser(String userName);
}
