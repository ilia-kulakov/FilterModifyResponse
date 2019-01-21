package edu.aem.training.filtermodifyresponse.servlets;

import edu.aem.training.filtermodifyresponse.models.HelloModel;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SlingServlet(resourceTypes =  {"sling/servlet/default"},
    selectors = "hello")
public class HelloServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html");

        Resource r = request.getResource();
        HelloModel hm = r.adaptTo(HelloModel.class);

        PrintWriter writer = response.getWriter();
        writer.write("<p>"+ hm.getGreeting() + "</p>");
        writer.flush();
        writer.close();
    }
}
