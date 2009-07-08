package no.sqizi.flexclient.domain {

[RemoteClass(alias="no.sqizi.webapp.domain.User")]
[Bindable]
public class User {
    public function User() {
    }

    public var firstName:String;
    public var lastName:String;
    public var userName:String;
    public var companyName:String

}
}