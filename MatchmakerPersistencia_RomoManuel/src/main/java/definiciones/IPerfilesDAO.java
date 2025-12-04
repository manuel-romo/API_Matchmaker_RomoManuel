
package definiciones;

import entidades.Perfil;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Romo López Manuel
 * ID: 00000253080
 * 
 */
public interface IPerfilesDAO {
    
    public abstract Perfil registrarPerfil(Perfil perfil) throws PersistenciaException;
    public abstract List<Perfil> obtenerPerfilesEdad(int edad) throws PersistenciaException;
    public abstract List<Perfil> obtenerPerfilesPais(String pais) throws PersistenciaException;
    public abstract List<Perfil> obtenerPerfilesGenero(String genero) throws PersistenciaException;
    
    
}
