package edu.aem.training.filtermodifyresponse.impl.filters;

import edu.aem.training.filtermodifyresponse.ReplacementService;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingFilter;
import org.apache.felix.scr.annotations.sling.SlingFilterScope;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.adobe.acs.commons.util.BufferingResponse;

@SlingFilter(
        label = "ACS AEM Samples - Sling REQUEST Filter",
        description = "Sling filter that looks through HTML and JSON responses that contain Geometrixx website pages and replaces the company name",
        generateComponent = false, generateService = true, order = 0, scope = SlingFilterScope.REQUEST)
@Component(immediate = true, metatype = false)
public class RespReplaceFilter implements Filter {


    @Reference
    ReplacementService replacementService;

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {


        BufferingResponse capturingResponseWrapper = new BufferingResponse(
                (HttpServletResponse) response);

        chain.doFilter(request, capturingResponseWrapper);

        if (response.getContentType() != null
                && (
                        response.getContentType().contains("text/html") ||
                        response.getContentType().contains("application/json")
                    )) {

            String content = capturingResponseWrapper.getContents();

            // replace stuff here
            String replacedContent = content.replaceAll(
                    replacementService.getFindWhat(),
                    replacementService.getReplaceWith());

            response.getWriter().write(replacedContent);

        }
    }

    public void destroy() {
    }

}
