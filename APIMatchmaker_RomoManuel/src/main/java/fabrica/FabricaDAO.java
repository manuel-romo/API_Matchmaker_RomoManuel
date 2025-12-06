
package fabrica;

import daos.PerfilesDAO;
import definiciones.IPerfilesDAO;

/**
 * 
 * Fábrica que permite crear objetos que implementa la clase IPerfilesDAO.
 * El objeto obtenido permite manipular objetos de Perfil en la base de datos.
 * 
 * @author Romo López Manuel
 * ID: 00000253080
 */
public class FabricaDAO {
    
    /**
     * Obtiene la instancia del objeto que implementa la interfaz IPerfilesDAO.
     * @return Objeto que implementa la interfaz IPerfilesDAO.
     */
    public static IPerfilesDAO obtenerPerfilesDAO(){
        
        IPerfilesDAO perfilesDAO = new PerfilesDAO();
        
        return perfilesDAO;
        
    }
}
