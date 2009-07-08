package no.sqizi.flexclient.model {
import no.sqizi.flexclient.domain.User;

[Bindable]
public class UserModel {
    public function UserModel() {
    }

    private var _loggedInUser:User = null;


    public function get loggedInUser():User {
        return _loggedInUser;
    }

    public function set loggedInUser(value:User):void {
        _loggedInUser = value;
    }
}
}