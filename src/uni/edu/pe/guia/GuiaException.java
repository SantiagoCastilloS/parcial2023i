package uni.edu.pe.guia;
public class GuiaException extends RuntimeException {
    public static String msgError = "SURGIO EL ERROR";
    public GuiaException(String message) {
        super(msgError + ": " + message);
    }
    public GuiaException() {
        super(msgError);
    }
}
