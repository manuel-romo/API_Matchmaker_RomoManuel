package com.apimatchmaker_romomanuel;

import api.PerfilesResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Romo López Manuel
 * ID: 00000253080
 */

@ApplicationPath("/api")
public class JakartaRestConfiguration extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(PerfilesResource.class);
        
        return classes;
    }
    
}
