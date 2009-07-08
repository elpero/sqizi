package no.sqizi.flexclient.uicomponents {
import mx.controls.Text;

public class MyText  extends Text{
    public function MyText() {
        super();
    }

    public function getUITextField(){
        return this.textField;
    }
}
}