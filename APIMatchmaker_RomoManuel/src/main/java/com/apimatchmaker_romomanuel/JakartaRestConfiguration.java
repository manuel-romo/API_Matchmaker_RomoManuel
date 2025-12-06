package com.apimatchmaker_romomanuel;

import api.PerfilesResource;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configura Servicios RESTful Web de Jakarta para la aplicación.
 * 
 * @author Romo López Manuel
 * ID: 00000253080
 * 
 */

@ApplicationPath("/api")
public class JakartaRestConfiguration extends Application {
    
    /**
     * Permite obtener el conjunto de clases que contienen los recursos expuestos por
     * la API.
     * @return Un conjunto con las clases que el servidor debe cargar e instanciar.
     */
    @Override
    public Set<Class<?>> getClasses() {
        
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(PerfilesResource.class);
        
        return classes;
    }
    
}
