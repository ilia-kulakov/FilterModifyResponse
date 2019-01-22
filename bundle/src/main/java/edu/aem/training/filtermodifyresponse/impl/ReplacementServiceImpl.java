package edu.aem.training.filtermodifyresponse.impl;

import javax.jcr.Repository;

import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.apache.sling.jcr.api.SlingRepository;

import edu.aem.training.filtermodifyresponse.ReplacementService;
import org.osgi.service.component.ComponentContext;

import java.util.Dictionary;

/**
 * One implementation of the {@link ReplacementService}. Note that
 * the repository is injected, not retrieved.
 */
@Service(ReplacementService.class)
@Component(immediate=true, metatype = true)
public class ReplacementServiceImpl implements ReplacementService {

    public static final String DEFAULT_FIND_WHAT = "Geometrixx";
    public static final String DEFAULT_REPLACE_WITH = "Geometrio, LLC";

    public static final String PN_FIND_WHAT = "aem.training.find.what";
    public static final String PN_REPLACE_WITH = "aem.training.replace.with";

    @Property(name= PN_FIND_WHAT, label = "Find what",  value = DEFAULT_FIND_WHAT)
    private static String findWhat;

    @Property(name= PN_REPLACE_WITH, label = "Replace with",  value = DEFAULT_REPLACE_WITH)
    private static String replaceWith;

    @Reference
    private SlingRepository repository;

    public String getRepositoryName() {
        return repository.getDescriptor(Repository.REP_NAME_DESC);
    }

    @Activate
    @Modified
    protected void onChangeProperties(ComponentContext context) {
        Dictionary properties = context.getProperties();
        findWhat = PropertiesUtil.toString(
                properties.get(PN_FIND_WHAT), DEFAULT_FIND_WHAT );
        replaceWith = PropertiesUtil.toString(
                properties.get(PN_REPLACE_WITH), DEFAULT_REPLACE_WITH );
    }

    public String getFindWhat() {
        return findWhat;
    }

    public String getReplaceWith() {
        return replaceWith;
    }
}
