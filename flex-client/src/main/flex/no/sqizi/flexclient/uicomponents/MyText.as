package no.sqizi.flexclient.uicomponents {
import mx.controls.Text;
import mx.core.IUITextField;

public class MyText  extends Text{
    public function MyText() {
        super();
    }

    public function getUITextField():IUITextField{
        return this.textField;
    }
}
}