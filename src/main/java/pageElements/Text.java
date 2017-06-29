package pageElements;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by mayesh on 6/21/17.
 */
@XmlRootElement(name="text")
public class Text extends Element {
    private String text;
    public static String TEXT = "text";

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


}
