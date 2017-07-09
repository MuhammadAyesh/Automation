package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by mayesh on 7/9/17.
 */
public class report extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String htmlFilePath = "report.jsp"; // path to your new file
        File htmlFile = new File(htmlFilePath);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(String.valueOf(htmlFile.toURI()));
        requestDispatcher.forward(request, response);

//        Desktop.getDesktop().browse(htmlFile.toURI());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("report.jsp");
        requestDispatcher.forward(request, response);

    }
}
