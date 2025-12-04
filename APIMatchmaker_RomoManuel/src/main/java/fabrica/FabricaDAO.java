
package fabrica;

import daos.PerfilesDAO;
import definiciones.IPerfilesDAO;

/**
 *
 * @author Romo López Manuel
 * ID: 00000253080
 */
public class FabricaDAO {
    
    public static IPerfilesDAO obtenerPerfilesDAO(){
        
        IPerfilesDAO perfilesDAO = new PerfilesDAO();
        
        return perfilesDAO;
        
    }
}
