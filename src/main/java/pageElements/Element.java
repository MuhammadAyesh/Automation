package pageElements;

import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Created by mayesh on 6/21/17.
 */
@XmlSeeAlso({Text.class, NavigateTo.class, Click.class})
public abstract class Element {
    private String stringType;
    private String string;
    private String verificationMessage;


    public void setStringType(String stringType) {
        this.stringType = stringType;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setVerificationMessage(String verificationMessage) {
        this.verificationMessage = verificationMessage;
    }

    public String getStringType() {
        return stringType;
    }

    public String getString() {
        return string;
    }

    public String getVerificationMessage() {
        return verificationMessage;
    }


}
