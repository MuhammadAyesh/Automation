package test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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


        JAXBContext context = JAXBContext.newInstance(Scenario.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Unmarshaller um = context.createUnmarshaller();
        Scenario scenario = (Scenario) um.unmarshal(new FileReader(BOOKSTORE_XML));
        ArrayList<Page> list = scenario.getPageList();

        try (Commands commands = new Commands(driver)) {
                for (Page page2 : list) {
                    for (Element element : page2.getElementsList()) {
                        commands.handleContent(element);
                        Thread.sleep(2000);
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
