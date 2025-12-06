
package excepciones;

/**
 *
 * Representa una exceción lanzada por los métodos de las clases DAO de este componente.
 * 
 * @author Romo López Manuel
 * ID: 00000253080
 * 
 */
public class PersistenciaException extends Exception{

    /**
     * Constructor de la clase que recibe un mensaje de la excepción.
     * @param message Objeto String que representa el mensaje que tendrá la excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }
    
    
    
}
