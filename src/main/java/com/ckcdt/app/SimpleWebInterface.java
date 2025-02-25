package com.ckcdt.app;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class SimpleWebInterface {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new InputServlet()), "/input");

        server.start();
        server.join();
    }

    public static class InputServlet extends HttpServlet {
        
        String values = com.ckcdt.app.Main.initiate();
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h2>Enter values</h2>");
            out.println("<form method='POST'>");
            out.println("Name <input type='text' name='value1'/>");
            out.println("Total loan: <input type='text' name='value2'/>");
            out.println("Interest (%): <input type='text' name='value3'/>");
            out.println("Years: <input type='text' name='value4'/>");
            out.println("<input type='submit' value='Submit'/>");
            out.println("</form>");
            
            out.println("<h3>Prospects:</h3>");
            out.println("<p>" + com.ckcdt.app.Main.output(values).replace("\n", "<br>") + "</p>");
            
            out.println("</body></html>");
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String value1 = req.getParameter("value1").trim();
            String value2 = req.getParameter("value2").trim();
            String value3 = req.getParameter("value3").trim();
            String value4 = req.getParameter("value4").trim();
            values = values.concat(value1 +"," + value2 + "," + value3 + "," + value4 + "\n");
            resp.sendRedirect("/input");
        }
    }
}