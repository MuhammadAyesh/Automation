package test;

import java.io.*;

/**
 * Created by mayesh on 6/22/17.
 */
public class FileManager implements Closeable {
    private PrintWriter printWriter;

    public FileManager() throws FileNotFoundException {
        printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File("report.html"))));
        createHtml();
    }

    private void createHtml() {
        printWriter.println("<!DOCTYPE html>\n" + "<html>\n" + "<body>");
    }

    public void createTable(String... headers) {
        printWriter.println("<style>\n" +
                "table, th, td {\n" +
                "    border: 1px solid black;\n" +
                "}\n" +
                "th, td {\n" +
                "    padding: 15px;\n" +
                "text-align: center;" +
                "}" +
                "</style>");
        printWriter.println("<table>\n" + "  <tr>");
        for (String th : headers) {
            printWriter.println("<th>" + th + "</th>");
        }
        printWriter.println("</tr>");
        printWriter.flush();
    }

    public void addRowsToTable(String... columnValue) {
        printWriter.println("  <tr>");
        for (String td : columnValue) {
            printWriter.println("<td>" + td + "</td>");
        }
        printWriter.println("</tr>");
        printWriter.flush();
    }

    public void closeTable() {
        printWriter.println("</table>\n");
    }


    public static void main(String[] args) {

        try (FileManager fileManager = new FileManager()) {
            fileManager.createTable("Number", "value");
            fileManager.addRowsToTable("1", "Success");
            fileManager.closeTable();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        printWriter.println("</body>\n" + "</html>");
        printWriter.close();
    }
}
