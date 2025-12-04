
package daos;

import definiciones.IPerfilesDAO;
import entidades.Perfil;
import excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import persistencia.ManejadorConexiones;

/**
 *
 * @author Romo López Manuel
 * ID: 00000253080
 * 
 */
public class PerfilesDAO implements IPerfilesDAO{

    @Override
    public Perfil registrarPerfil(Perfil nuevoPerfil) throws PersistenciaException{
        
        // Se valida que el perfil contenga todos los datos obligatorios.
        if (nuevoPerfil.getNombre() == null || 
            nuevoPerfil.getApellidoPaterno() == null || 
            nuevoPerfil.getApellidoMaterno() == null ||
            nuevoPerfil.getCorreoElectronico() == null ||
            nuevoPerfil.getPais() == null ||
            nuevoPerfil.getGenero() == null ||
            nuevoPerfil.getDireccion() == null ||
            nuevoPerfil.getTelefono() == null ||
            nuevoPerfil.getCelular() == null ||
            nuevoPerfil.getFechaNacimiento() == null) {
            
            throw new PersistenciaException("El perfil que se intentó registrar tiene datos faltantes.");
        }

        // Se crea el objeto EntityManager.
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try {
            // Se crea la consulta JPQL para obtener la cantidad de perfiles
            // que tengan el mismo nombre completo recibido.
            String jpqlQuery = """
                               SELECT COUNT(p) FROM Perfil p
                               WHERE p.nombre = :nombre
                               AND p.apellidoPaterno = :apellidoPaterno
                               AND p.apellidoMaterno = :apellidoMaterno
                               """;
            
            // Se crea el objeto Query con la consulta.
            TypedQuery<Long> query = entityManager.createQuery(jpqlQuery, Long.class);
            
            // Se establecen los parámetros para la consulta.
            query.setParameter("nombre", nuevoPerfil.getNombre());
            query.setParameter("apellidoPaterno", nuevoPerfil.getApellidoPaterno());
            query.setParameter("apellidoMaterno", nuevoPerfil.getApellidoMaterno());
            
            // Se obtiene la cantidad de perfiles coincidentes.
            Long cantidadPerfilesMismoNombre = query.getSingleResult();
            
            // Si la cantidad de perfiles es mayor a 0, se lanza una excepción.
            if (cantidadPerfilesMismoNombre > 0) {
                throw new PersistenciaException("Ya existe un perfil con el mismo nombre completo.");
            }
            
            // Se inicia una transacción para registrar el nuevo Perfil.
            entityManager.getTransaction().begin();
            
            // Se persiste el nuevo Perfil.
            entityManager.persist(nuevoPerfil);
            
            // Se confirman los cambios en la base de datos.
            entityManager.getTransaction().commit();
            
            return nuevoPerfil;
            
        } catch (PersistenceException e) {
            
            // Se maneja la excepción, asegurando rollback en caso de fallo.
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            
            // Se relanza la excepción encapsulada.
            throw new PersistenciaException("Error al registrar el perfil.");
            
        } finally {
            
            // Se cierra el EntityManager.
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Perfil> obtenerPerfilesEdad(int edad) {
        
        // Se crea el objeto EntityManager.
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try {
            // Se crea el objeto CriteriaBuilder.
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            
            // Se crea la consulta de tipo CriteriaQuery para la entidad Perfil.
            CriteriaQuery<Perfil> criteria = criteriaBuilder.createQuery(Perfil.class);
            
            // Se define la raíz de la consulta.
            Root<Perfil> entidadPerfil = criteria.from(Perfil.class);
            
            // Se establece la condición de búsqueda: la edad debe ser igual al parámetro recibido.
            criteria.select(entidadPerfil).where(criteriaBuilder.equal(entidadPerfil.get("edad"), edad));
            
            // Se crea y ejecuta la consulta tipada para obtener los resultados.
            TypedQuery<Perfil> query = entityManager.createQuery(criteria);
            
            return query.getResultList();
            
        } finally {
            
            // Se cierra el EntityManager.
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    public List<Perfil> obtenerPerfilesPais(String pais) throws PersistenciaException{
        
        // Se valida que el parámetro pais no sea nulo.
        if (pais == null) {
            throw new PersistenciaException("El criterio de búsqueda por país no puede ser nulo.");
        }
        
        // Se crea el objeto EntityManager.
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try {
            // Se crea el objeto CriteriaBuilder.
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            
            // Se crea la consulta de tipo CriteriaQuery para la entidad Perfil.
            CriteriaQuery<Perfil> criteria = criteriaBuilder.createQuery(Perfil.class);
            
            // Se define la raíz de la consulta.
            Root<Perfil> entidadPerfil = criteria.from(Perfil.class);
            
            // Se establece la condición de búsqueda: el país debe ser igual al parámetro recibido.
            criteria.select(entidadPerfil).where(criteriaBuilder.equal(entidadPerfil.get("pais"), pais));
            
            // Se crea y ejecuta la consulta tipada para obtener los resultados.
            TypedQuery<Perfil> query = entityManager.createQuery(criteria);
            
            return query.getResultList();
            
        } finally {
            
            // Se cierra el EntityManager.
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public List<Perfil> obtenerPerfilesGenero(String genero) throws PersistenciaException {
        
        // Se valida que el parámetro genero no sea nulo.
        if (genero == null) {
            throw new PersistenciaException("El criterio de búsqueda por género no puede ser nulo.");
        }
        
        // Se crea el objeto EntityManager.
        EntityManager entityManager = ManejadorConexiones.getEntityManager();
        
        try {
            // Se crea el objeto CriteriaBuilder.
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            
            // Se crea la consulta de tipo CriteriaQuery para la entidad Perfil.
            CriteriaQuery<Perfil> criteria = criteriaBuilder.createQuery(Perfil.class);
            
            // Se define la raíz de la consulta.
            Root<Perfil> entidadPerfil = criteria.from(Perfil.class);
            
            // Se establece la condición de búsqueda: el género debe ser igual al parámetro recibido.
            criteria.select(entidadPerfil).where(criteriaBuilder.equal(entidadPerfil.get("genero"), genero));
            
            // Se crea y ejecuta la consulta tipada para obtener los resultados.
            TypedQuery<Perfil> query = entityManager.createQuery(criteria);
            
            return query.getResultList();
            
        } finally {
            
            // Se cierra el EntityManager.
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
    
}
