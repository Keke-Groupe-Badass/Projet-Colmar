package whole.exception;

import whole.Metadonnee;

/**
 * Exception arrivant quand une lettrine ne possède pas une métadonnée
 * @see whole.Lettrine
 * @see whole.LettrineDAO
 * @see Metadonnee
 */
public class WrongLettrineException extends  Exception{
    public WrongLettrineException() {
    }

    public WrongLettrineException(String message) {
        super(message);
    }
}
