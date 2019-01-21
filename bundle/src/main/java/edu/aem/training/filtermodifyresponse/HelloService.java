package edu.aem.training.filtermodifyresponse;

/**
 * A simple service interface
 */
public interface HelloService {
    
    /**
     * @return the name of the underlying JCR repository implementation
     */
    String getRepositoryName();

    String[] getGreeting();

    Long getCount();
}