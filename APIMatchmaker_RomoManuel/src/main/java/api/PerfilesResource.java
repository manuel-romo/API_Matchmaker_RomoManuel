
package api;

import definiciones.IPerfilesDAO;
import dtos.ProfileDTO;
import entidades.Perfil;
import excepciones.PersistenciaException;
import fabrica.FabricaDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mapeadores.ProfileMapeador;

/**
 * Servicio REST Web.
 *
 * @author Romo López Manuel
 * ID: 00000253080
 * 
 */
@Path("/perfiles")
@RequestScoped
public class PerfilesResource {

    private IPerfilesDAO perfilesDAO;

    /**
     * Constructor de la clase.
     */
    public PerfilesResource() {
        // Se obtiene la fábrica de perfilesDAO para obtener un objeto que implementa
        // la interfaz IPerfilesDAO.
        this.perfilesDAO = FabricaDAO.obtenerPerfilesDAO();
        
    }

    /**
     * Permite obtener la lista de perfiles que coincidan con el país, edad y género
     * de los parámetros.
     * @param pais País del perfil.
     * @param edad Edad del perfil.
     * @param genero Género del perfil.
     * @return Lista de objetos PerfilDTO que representan los perfiles obtenidos
     * en la búsqueda, se obtiene sólo un perfil al azar si se reciben dos o más
     * criterios y si esos coincidenc on dos o más perfiles.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProfileDTO> obtenerPerfiles(
            @QueryParam("pais") String pais, 
            @QueryParam("edad") Integer edad, 
            @QueryParam("genero") String genero) {
        
        try {
            // Lista para guardar los perfiles coincidentes.
            List<Perfil> perfiles = new ArrayList<>();
            boolean consultaRealizada = false;

            // Si se especificó un país, se obtienen los perfiles que tienen ese país. 
            if (pais != null && !pais.isBlank()) {
                perfiles = perfilesDAO.obtenerPerfilesPais(pais);
                consultaRealizada = true;
            }
            
            // Se verifica si se especificó una edad.
            if (edad != null && edad > 0) {
                if (!consultaRealizada) {
                    // Si no se había recibido otra cosa, se inicializa la lista.
                    perfiles = perfilesDAO.obtenerPerfilesEdad(edad);
                    consultaRealizada = true;
                } else {
                    // Si ya se habían obtenido perfiles, se obtienen sólo los que
                    // también cumplan con la edad indicada.
                    List<Perfil> listaAuxiliar = new ArrayList<>();
                    
                    for (Perfil perfil : perfiles) {
                        if (perfil.getEdad() == edad) {
                            listaAuxiliar.add(perfil);
                        }
                    }
                    
                    // Se actualiza la lista.
                    perfiles = listaAuxiliar;
                }
            }
            
            // Se verifica si se especificó un género.
            if (genero != null && !genero.isBlank()) {
                if (!consultaRealizada) {
                    
                    // Si no se había recibido otra cosa, se inicializa la lista.
                    perfiles = perfilesDAO.obtenerPerfilesGenero(genero);
                    consultaRealizada = true;
                } else {
                    // Si ya se habían obtenido perfiles, se obtienen sólo los que
                    // también cumplan con el género indicado.
                    List<Perfil> listaAuxiliar = new ArrayList<>();
                    
                    for (Perfil perfil: perfiles) {
                        if (perfil.getGenero().equalsIgnoreCase(genero)) {
                            listaAuxiliar.add(perfil);
                        }
                    }
                    // Se actualiza la lista.
                    perfiles = listaAuxiliar;
                }
            }
            
            // Si no hay resultados, se devuelve nulo.
            if (perfiles.isEmpty()) {
                return new ArrayList<>();
            }
            
            // Se cuenta la cantidad de criterios enviados por el usuario.
            int cantidadRequisitosRecibidos = 0;
            if (pais != null && !pais.isBlank()){
                cantidadRequisitosRecibidos++;
            }
            
            if (edad != null && edad > 0){
                cantidadRequisitosRecibidos++;
            }
            
            if (genero != null && !genero.isBlank()){
                cantidadRequisitosRecibidos++;
            }
            
            // Si hay más de un resultado, y se enviaron dos o más requisitos, se devuelve
            // uno aleatoriamente.
            if (perfiles.size() > 1 && cantidadRequisitosRecibidos >= 2) {
                
                Random random = new Random();
                int indice = random.nextInt(perfiles.size());
                Perfil perfilRandom = perfiles.get(indice);

                ArrayList<ProfileDTO> listaPerfilRandom = new ArrayList<>();
                listaPerfilRandom.add(ProfileMapeador.toDTO(perfilRandom));
                return listaPerfilRandom;
            }

            // Si hay sólo un resultado o se cumplió con sólo 1 requisito enviado, se devuelve la lista completa.
            List<ProfileDTO> perfilesResultado = new ArrayList<>();
            
            for (Perfil perfil : perfiles) {
                perfilesResultado.add(ProfileMapeador.toDTO(perfil));
            }
            
            return perfilesResultado;

        } catch (PersistenciaException e) {
            return null;
        }
    }
    
    
    /**
     * Permite registrar una nueva instancia de Perfil.
     * Recibe la representación JSON y la persiste en la base de datos.
     * @param nuevoPerfil Objeto Perfil recibido en el cuerpo de la solicitud.
     * @return ProfileDTO Es el perfil registrado, es nulo si ocurre un error en el registor.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProfileDTO registrarPerfil(ProfileDTO content) {
        
        Perfil perfil = ProfileMapeador.toEntity(content);
        try {
            // Se invoca el método de lógica para registrar el perfil.
            Perfil perfilRegistrado = perfilesDAO.registrarPerfil(perfil);
            
            // Se obtiene y devuelve el perfil registrado.
            ProfileDTO perfilRegistradoDto = ProfileMapeador.toDTO(perfilRegistrado);
            
            return perfilRegistradoDto;
            
        } catch (PersistenciaException e) {
            return null;
        }
    }
}
