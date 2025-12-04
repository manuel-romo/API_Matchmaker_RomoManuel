
package mapeadores;

import dtos.ProfileDTO;
import entidades.Perfil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Romo López Manuel 
 * ID: 00000253080
 */
public class ProfileMapeador {
    
    public static Perfil toEntity(ProfileDTO perfilDTO){
        

        Perfil perfil = new Perfil(
            perfilDTO.getNombre(),
            perfilDTO.getApellidoPaterno(),
            perfilDTO.getApellidoMaterno(),
            perfilDTO.getFechaNacimiento(),
            perfilDTO.getFoto(),
            perfilDTO.getCorreoElectronico(),
            perfilDTO.getGenero(),
            perfilDTO.getPais(),
            perfilDTO.getTelefono(),
            perfilDTO.getCelular(),
            perfilDTO.getDireccion(),
            perfilDTO.getEdad()
        );

        return perfil;
    }
    
    public static ProfileDTO toDTO(Perfil perfil) {

        ProfileDTO dto = new ProfileDTO();

        dto.setNombre(perfil.getNombre());
        dto.setApellidoPaterno(perfil.getApellidoPaterno());
        dto.setApellidoMaterno(perfil.getApellidoMaterno());
        dto.setFechaNacimiento(perfil.getFechaNacimiento());
        dto.setFoto(perfil.getFoto());
        dto.setCorreoElectronico(perfil.getCorreoElectronico());
        dto.setGenero(perfil.getGenero());
        dto.setPais(perfil.getPais());
        dto.setTelefono(perfil.getTelefono());
        dto.setCelular(perfil.getCelular());
        dto.setDireccion(perfil.getDireccion());
        dto.setEdad(perfil.getEdad());

        return dto;
    }
    
    public static List<ProfileDTO> toDTOList(List<Perfil> perfiles) {
        List<ProfileDTO> listaDTO = new ArrayList<>();

        for (Perfil perfil : perfiles) {
            listaDTO.add(toDTO(perfil));
        }

        return listaDTO;
    }

}
