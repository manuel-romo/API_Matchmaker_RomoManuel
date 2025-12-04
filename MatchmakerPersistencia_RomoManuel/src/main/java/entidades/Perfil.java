
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Romo López Manuel
 * ID: 00000253080
 * 
 */
@Entity
public class Perfil implements Serializable {

    /**
     * Dato Long que representa el identificador del Perfil.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_perfil")
    private Long id;
    
    @Column (name = "nombre", length = 50, nullable = false)
    private String nombre;
    
    @Column (name = "apellido_paterno", length = 50, nullable = false)
    private String apellidoPaterno;
    
    @Column (name = "apellido_materno", length = 50, nullable = false)
    private String apellidoMaterno;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private Calendar fechaNacimiento;
    
    @Column (name = "foto", length = 300, nullable = false)
    private String foto;
    
    @Column (name = "correoElectronico", length = 320, nullable = false)
    private String correoElectronico;
    
    @Column (name = "genero", length = 20, nullable = false)
    private String genero;
    
    @Column (name = "pais", length = 100, nullable = false)
    private String pais;
    
    @Column (name = "telefono", length = 10, nullable = false)
    private String telefono;
    
    @Column (name = "celular", length = 10, nullable = false)
    private String celular;
    
    @Column (name = "direccion", length = 100, nullable = false)
    private String direccion;
    
    @Column (name = "edad")
    private int edad;

    public Perfil() {
    }
    
    public Perfil(
            String nombre,
            String apellidoPaterno, 
            String apellidoMaterno, 
            Calendar fechaNacimiento, 
            String foto, 
            String correoElectronico, 
            String genero, 
            String pais, 
            String telefono, 
            String celular,
            String direccion, 
            int edad) {
        
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.foto = foto;
        this.correoElectronico = correoElectronico;
        this.genero = genero;
        this.pais = pais;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.edad = edad;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }   
    
}
