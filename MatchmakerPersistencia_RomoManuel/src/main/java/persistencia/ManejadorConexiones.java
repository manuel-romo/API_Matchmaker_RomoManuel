
package persistencia;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Romo López Manuel
 * ID: 00000253080
 */
public class ManejadorConexiones {
    private static EntityManagerFactory emFactory;
    
    private static boolean conexionTest = true; 

    private static void inicializarFactory() {
        Properties propiedades = new Properties();
        
        try (InputStream inputStream = ManejadorConexiones.class.getClassLoader().getResourceAsStream("META-INF/properties.txt")) {
            if (inputStream == null) {
                throw new RuntimeException("No se encontró el archivo META-INF/properties.txt");
            }
            propiedades.load(inputStream);
        } catch (IOException ex) {
            throw new RuntimeException("Error al cargar configuración de base de datos", ex);
        }

        Properties propiedadesFiltradas = new Properties();
        String prefijo;
        String nombreUnidad;

        
        if (conexionTest) {
            prefijo = "equipo04_ecommerce_persistencia_jar_1.0PU_Tests.";
            nombreUnidad = "equipo04_ecommerce_persistencia_jar_1.0PU_Tests";
        } else {
            prefijo = "equipo04_ecommerce_persistencia_jar_1.0PU.";
            nombreUnidad = "equipo04_ecommerce_persistencia_jar_1.0PU";
        }

        for (String key : propiedades.stringPropertyNames()) {
            if (key.startsWith(prefijo)) {
                String keyPropiedad = key.substring(prefijo.length());
                propiedadesFiltradas.put(keyPropiedad, propiedades.getProperty(key));
            }
        }


        emFactory = Persistence.createEntityManagerFactory(nombreUnidad, propiedadesFiltradas);

    }

    public static EntityManager getEntityManager() {

        if (emFactory == null || !emFactory.isOpen()) {
            inicializarFactory();
        }
        
        return emFactory.createEntityManager();
    }
}
