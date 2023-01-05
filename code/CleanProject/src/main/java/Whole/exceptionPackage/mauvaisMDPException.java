package Whole.exceptionPackage;

public class mauvaisMDPException extends Exception{
    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public mauvaisMDPException() {
        super("Le mot de passe ne correspond pas à l'utilisateur");
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public mauvaisMDPException(String message) {
        super(message);
    }
}
