
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
 * 
 * Clase que crea una instancia de EntityManager para manipular la base de datos, 
 * pudiendo configurarla para hacer pruebas o no.
 * 
 */
public class ManejadorConexiones {
    
    /**
     * Fábrica de EntityManager.
     */
    private static EntityManagerFactory emFactory;
    
    /**
     * Dato booleano que determina si la conexión a usar es de pruebas o no.
     */
    private static boolean conexionTest = true; 

    /**
     * Permite inicializar la conexión con la base de datos y crear la fábrica de
     * EntityManager.
     */
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
            prefijo = "com_MatchmakerPersistencia_RomoManuel_jar_1.0-SNAPSHOTPU_Tests.";
            nombreUnidad = "com_MatchmakerPersistencia_RomoManuel_jar_1.0-SNAPSHOTPU_Tests";
        } else {
            prefijo = "com_MatchmakerPersistencia_RomoManuel_jar_1.0-SNAPSHOTPU.";
            nombreUnidad = "com_MatchmakerPersistencia_RomoManuel_jar_1.0-SNAPSHOTPU";
        }

        for (String key : propiedades.stringPropertyNames()) {
            if (key.startsWith(prefijo)) {
                String keyPropiedad = key.substring(prefijo.length());
                propiedadesFiltradas.put(keyPropiedad, propiedades.getProperty(key));
            }
        }


        emFactory = Persistence.createEntityManagerFactory(nombreUnidad, propiedadesFiltradas);

    }

    /**
     * Permite obtener el EntityManger actual, usando un patrón singleton.
     * @return Objeto EntityManager que permite manipular la base de datos.
     */
    public static EntityManager getEntityManager() {

        if (emFactory == null || !emFactory.isOpen()) {
            inicializarFactory();
        }
        
        return emFactory.createEntityManager();
    }
}
