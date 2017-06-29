package test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageElements.Element;
import xmlElements.Page;
import xmlElements.Scenario;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mayesh on 6/20/17.
 */
public class main {
    private static final String BOOKSTORE_XML = "./QA.xml";

    public static void main(String[] args) throws JAXBException, FileNotFoundException, InterruptedException {

        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

//        ArrayList<Page> pageList = new ArrayList<Page>();
//        ArrayList<Element> contentsList = new ArrayList<>();
//
//        NavigateTo navigateTo = new NavigateTo();
//        navigateTo.setStringType("URL");
//        navigateTo.setString("https://www.google.jo/");
//        navigateTo.setVerificationMessage("HelloWorld");
//
//        Text text = new Text();
//        text.setStringType("name");
//        text.setString("q");
//        text.setText("TARDIS");
//        text.setVerificationMessage("Dr. who");
//
//        Click click = new Click();
//
//        click.setStringType(Commands.NAME);
//        click.setString("btnK");
//        contentsList.add(navigateTo);
//        contentsList.add(text);
//        contentsList.add(click);
//
//        Page page = new Page();
//        page.setElementsList(contentsList);
//        page.getElementsList();
//        pageList.add(page);
//
//        Scenario scenario1 = new Scenario();
//        scenario1.setPageList(pageList);

        // create JAXB context and instantiate marshaller

        JAXBContext context = JAXBContext.newInstance(Scenario.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


//        m.marshal(scenario1, new File(BOOKSTORE_XML));

        // get variables from our xml file, created before
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        Scenario scenario = (Scenario) um.unmarshal(new FileReader(BOOKSTORE_XML));
        ArrayList<Page> list = scenario.getPageList();

        try (Commands commands = new Commands(driver)) {
            for (int i = 0; i < 1000; i++) {


                for (Page page2 : list) {
                    for (Element element : page2.getElementsList()) {
                        commands.handleContent(element);
                        Thread.sleep(5000);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
