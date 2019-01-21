package edu.aem.training.filtermodifyresponse.models;

import edu.aem.training.filtermodifyresponse.HelloService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;


@Model(adaptables = Resource.class)
public class HelloModel {
    @Inject
    private HelloService helloService;

    public String getGreeting() {
        return helloService.getGreeting()[0];
    }
}
