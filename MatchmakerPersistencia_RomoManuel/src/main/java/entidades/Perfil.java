
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
 * Clase que representa a un perfil que se almacena en la base de datos.
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
    
    /**
     * Objeto String que representa el nombre del Perfi.
     */
    @Column (name = "nombre", length = 50, nullable = false)
    private String nombre;
    
    /**
     * Objeto String que representa el apellido paterno del Perfil.
     */
    @Column (name = "apellido_paterno", length = 50, nullable = false)
    private String apellidoPaterno;
    
    /**
     * Objeto String que representa el apellido materno del Perfil.
     */
    @Column (name = "apellido_materno", length = 50, nullable = false)
    private String apellidoMaterno;
    
    /**
     * Objeto Calendar que representa la fecha de nacimiento del Perfil.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private Calendar fechaNacimiento;
    
    /**
     * Objeto String que representa la dirección de la imagen del Perfil.
     */
    @Column (name = "foto", length = 300, nullable = false)
    private String foto;
    
    /**
     * Objeto String que representa la dirección de correo electrónico el Perfil.
     */
    @Column (name = "correoElectronico", length = 320, nullable = false)
    private String correoElectronico;
    
    /**
     * Objeto String que representa el género del Perfil.
     */
    @Column (name = "genero", length = 20, nullable = false)
    private String genero;
    
    /**
     * Objeto String que representa el país del Perfil.
     */
    @Column (name = "pais", length = 100, nullable = false)
    private String pais;
    
    /**
     * Objeto String que representa el teléfono del Perfil.
     */
    @Column (name = "telefono", length = 10, nullable = false)
    private String telefono;
    
    /**
     * Objeto String que representa el celular del Perfil.
     */
    @Column (name = "celular", length = 10, nullable = false)
    private String celular;
    
    /**
     * Objeto String que representa la dirección del Perfil.
     */
    @Column (name = "direccion", length = 100, nullable = false)
    private String direccion;
    
    /**
     * Dato int que representa la edad del Perfil.
     */
    @Column (name = "edad")
    private int edad;

    /**
     * Constructor por defecto.
     */
    public Perfil() {
    }
    
    /**
     * Constructor que recibe los valores de todos los atributos de un Perfil para crearlo.
     * @param nombre Objeto String que representa el nombre del Perfi.
     * @param apellidoPaterno Objeto String que representa el apellido paterno del Perfil.
     * @param apellidoMaterno Objeto String que representa el apellido materno del Perfil.
     * @param fechaNacimiento Objeto Calendar que representa la fecha de nacimiento del Perfil.
     * @param foto Objeto String que representa la dirección de la imagen del Perfil.
     * @param correoElectronico Objeto String que representa la dirección de correo electrónico el Perfil.
     * @param genero Objeto String que representa el género del Perfil.
     * @param pais Objeto String que representa el país del Perfil.
     * @param telefono Objeto String que representa el teléfono del Perfil.
     * @param celular Objeto String que representa el celular del Perfil.
     * @param direccion Objeto String que representa la dirección del Perfil.
     * @param edad Dato int que representa la edad del Perfil.
     */
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

    
    /**
     * Permite obtener el ID del Perfil.
     * @return Objeto Long que representa el ID del perfil.
     */
    public Long getId() {
        return id;
    }

    /**
     * Permite establecer el ID del Perfil.
     * @param id Objeto Long que representa el nuevo ID del perfil.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Permite obtener el nombre del Perfil.
     * @return Objeto String que representa el nombre del Perfil.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Permite establecer el nombre del Perfil.
     * @param nombre Objeto String que representa el nuevo nombre del Perfil.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Permite obtener el apellido paterno del Perfil.
     * @return Objeto String que representa el apellido paterno del Perfil.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Permite establecer el apellido paterno del Perfil.
     * @param apellidoPaterno Objeto String que representa el nuevo apellido paterno del Perfil.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Permite obtener el apellido materno del Perfil.
     * @return Objeto String que representa el apellido materno del Perfil.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Permite establecer el apellido materno del Perfil.
     * @param apellidoPaterno Objeto String que representa el nuevo apellido materno del Perfil.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Permite obtener la fecha de nacimiento del Perfil.
     * @return Objeto Calendar que representa la fecha de nacimiento del Perfil.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Permite esatblecer la fecha de nacimiento del Perfil.
     * @param fechaNacimiento Objeto Calendar que representa la nueva fecha de nacimiento del Perfil.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Permite obtener la dirección de la foto del Perfil.
     * @return Objeto String que representa la dirección de la foto del Perfil.
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Permite establecer la dirección de la foto de perfil.
     * @param foto Objeto String que representa la nueva dirección de la foto del Perfil.
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Permite obtener la dirección de correo electrónico del Perfil.
     * @return Permite obtener la dirección del correo electrónico de Perfil.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Permite establecer la dirección del correo electrónico del Perfil.
     * @param correoElectronico Permite establecer la dirección del correo electrónico de Perfil.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Permite obtener el género del Perfil.
     * @return Objeto String que representa el nombre del género del Perfil.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Permite establecer el género del Perfil.
     * @param genero Objeto String que representa el nuevo nombre del género del Perfil.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Permite obtener el país del Perfil.
     * @return Objeto String que representa el País del Perfil.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Permite establecer el país el Perfil.
     * @param pais Objeto String que representa el nuevo País del Perfil.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Permite obtener el teléfono del Perfil.
     * @return Objeto String que representa el teléfono del Perfil.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Permite establecer el teléfono del Perfil.
     * @param telefono Objeto String que representa el nuevo teléfono del Perfil.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Permite obtener el celcular del Perfil.
     * @return Objeto String que representa el número del Perfil.
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Permite establecer el celular del Perfil.
     * @param celular Objeto String que representa el nuevo número del Perfil.
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Permite obtener la dirección del Perfil.
     * @return Objeto String que representa la dirección del Perfil.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Permite establecer la dirección del Perfil.
     * @param direccion Objeto String que representa la dirección del Perfil.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Permite obtener la edad del Perfil.
     * @return Dato int que representa la edad del Perfil.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Permite establecer la edad del Perfil.
     * @param edad Dato int que representa la nueva edad del Perfil.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }   
    
}
