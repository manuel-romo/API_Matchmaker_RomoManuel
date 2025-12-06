
package definiciones;

import entidades.Perfil;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * Interfaz que define métodos necesarios para acceder a la base de datos y modificar
 * o consultar registros de la entidad Perfil.
 * 
 * @author Romo López Manuel
 * ID: 00000253080
 * 
 */
public interface IPerfilesDAO {
    
    /**
     * Registra un nuevo perfil en la base de datos.
     * Valida que no existan duplicados por nombre completo (nombre, apellido paterno y apellido materno) antes de guardar.
     * Si el registro es exitoso, se asigna automáticamente un ID al nuevo perfil.
     * @param perfil El objeto Perfil con la información a persistir. Éste no debe ser nulo.
     * @return El objeto Perfil persistido, con su ID generado por la base de datos.
     * @throws PersistenciaException Si el perfil es nulo, si faltan datos obligatorios 
     * o si ya existe un usuario con el mismo nombre completo.
     */
    public abstract Perfil registrarPerfil(Perfil perfil) throws PersistenciaException;

    /**
     * Recupera una lista de perfiles que coinciden con la edad especificada.
     * Realiza una consulta a la base de datos filtrando perfiles por la edad del parámetro.
     * @param edad La edad a buscar.
     * @return Una lista de objetos Perfil que tienen la edad indicada. Devuelve una lista vacía si no hay coincidencias.
     * @throws PersistenciaException Si ocurre un error de conexión o consulta en la base de datos.
     */
    public abstract List<Perfil> obtenerPerfilesEdad(int edad) throws PersistenciaException;

    /**
     * Recupera una lista de perfiles filtrados por país.
     * @param pais El nombre del país a buscar. Éste no debe ser nulo ni estar vacío.
     * @return Una lista de objetos Perfil que tienen el país del parámetro. Devuelve una lista vacía si no se encuentran resultados.
     * @throws PersistenciaException Si el parámetro país no es válido, o si ocurre un error durante la consulta.
     */
    public abstract List<Perfil> obtenerPerfilesPais(String pais) throws PersistenciaException;

    /**
     * Recupera una lista de perfiles que tienen el género especificado.
     * @param genero El género a buscar. Éste no debe ser nulo ni estar vacío.
     * @return Una lista de objetos Perfil que tienen el género especificado. Devuelve una lista vacía si no hay coincidencias.
     * @throws PersistenciaException Si el parámetro género es nulo o si ocurre un error interno en la base de datos.
     */
    public abstract List<Perfil> obtenerPerfilesGenero(String genero) throws PersistenciaException;
    
    
}
