package servlet;

import xmlElements.Scenario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.util.Map;

/**
 * Created by mayesh on 7/9/17.
 */
public class automationController extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            creatingXml(request, response);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            creatingXml(request, response);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private void creatingXml(HttpServletRequest request, HttpServletResponse response) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Scenario.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        if (request.getParameter("tableSubmit") != null) {
            saveMarks();
        }

//        m.marshal(, new File());

    }

    private void saveMarks() {
        Map<String, String[]> parameterMap = request.getParameterMap();

        String[] actions = parameterMap.get("action");
        String[] stringType = parameterMap.get("stringType");
        String[] string = parameterMap.get("string");
        String[] textValue = parameterMap.get("textValue");
        String[] verificationMessage = parameterMap.get("verificationMessage");

        for (int i = 0; i < actions.length; i++) {
                System.out.println(actions[i]);
        }
    }
}
