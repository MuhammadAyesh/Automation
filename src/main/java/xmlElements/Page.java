package xmlElements;

import pageElements.Element;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayesh on 6/20/17.
 */
@XmlRootElement(name = "page")
public class Page {

    @XmlElementRef
    private ArrayList<Element> elementsList = new ArrayList<>();

    public List<Element> getElementsList() {
        return elementsList;
    }

    public void setElementsList(ArrayList<Element> elementsList) {
        this.elementsList = elementsList;
    }

}
