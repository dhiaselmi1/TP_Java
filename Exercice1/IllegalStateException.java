
/**
 * Exception levée lorsqu'une opération est tentée sur une épreuve déjà terminée
 */
public class IllegalStateException extends Exception {
    public IllegalStateException() {
        super("L'épreuve a déjà été marquée comme terminée");
    }
    
    public IllegalStateException(String message) {
        super(message);
    }
}