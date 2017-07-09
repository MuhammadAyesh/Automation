package servlet;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageElements.Click;
import pageElements.Element;
import pageElements.NavigateTo;
import pageElements.Text;
import test.Commands;
import xmlElements.Page;
import xmlElements.Scenario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by mayesh on 7/9/17.
 */
public class automationController extends HttpServlet {
    private static final String BOOKSTORE_XML = "Test.xml";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            creatingXml(request, response);
            runTheTest();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            creatingXml(request, response);
            runTheTest();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private void creatingXml(HttpServletRequest request, HttpServletResponse response) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Scenario.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Scenario scenario = new Scenario();
        Page page = new Page();
        ArrayList<Page> pageList = new ArrayList<>();

        if (request.getParameter("tableSubmit") != null) {
            page.setElementsList(saveMarks(request, response));
        }

        pageList.add(page);
        scenario.setPageList(pageList);
        m.marshal(scenario, System.out);
        m.marshal(scenario, new File(BOOKSTORE_XML));

    }

    private ArrayList<Element> saveMarks(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        ArrayList<Element> elementsList = new ArrayList<>();

        String[] actions = parameterMap.get("action");
        String[] stringType = parameterMap.get("stringType");
        String[] string = parameterMap.get("string");
        String[] textValue = parameterMap.get("textValue");
        String[] verificationMessage = parameterMap.get("verificationMessage");

        for (int i = 0; i < actions.length; i++) {
            if (actions[i].equalsIgnoreCase("action")) {

            } else if (actions[i].equalsIgnoreCase("NavigateTo")) {

                NavigateTo navigateTo = new NavigateTo();

                navigateTo.setString(string[i]);
                navigateTo.setStringType(stringType[i]);
                navigateTo.setVerificationMessage(verificationMessage[i]);

                elementsList.add(navigateTo);
            } else if (actions[i].equalsIgnoreCase(Click.CLICK)) {
                Click click = new Click();

                click.setString(string[i]);
                click.setStringType(stringType[i]);
                click.setVerificationMessage(verificationMessage[i]);

                elementsList.add(click);
            } else if (actions[i].equalsIgnoreCase("Text")) {
                Text text = new Text();

                text.setString(string[i]);
                text.setStringType(stringType[i]);
                text.setText(textValue[i]);
                text.setVerificationMessage(verificationMessage[i]);

                elementsList.add(text);
            }
        }

        return elementsList;
    }

    private void runTheTest() throws JAXBException, FileNotFoundException {
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
                    Thread.sleep(1000);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
