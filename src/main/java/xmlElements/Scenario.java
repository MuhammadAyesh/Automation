package xmlElements;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by mayesh on 6/20/17.
 */
@XmlRootElement(namespace = "xmlElements")
@XmlAccessorType(XmlAccessType.FIELD)
public class Scenario {

    @XmlElementWrapper(name = "Scenario")
    @XmlElement(name = "page")
    private ArrayList<Page> pageList;

    public ArrayList<Page> getPageList() {
        return pageList;
    }

    public void setPageList(ArrayList<Page> pageList) {
        this.pageList = pageList;
    }
}
