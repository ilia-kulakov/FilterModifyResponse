package edu.aem.training.filtermodifyresponse;

/**
 * A simple service interface
 */
public interface ReplacementService {
    
    /**
     * @return the name of the underlying JCR repository implementation
     */
    String getRepositoryName();

    String getFindWhat();

    String getReplaceWith();
}