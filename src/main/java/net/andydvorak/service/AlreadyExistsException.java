package net.andydvorak.service;

/**
 * @author Andrew C. Dvorak
 * @since 3/15/13
 */
public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException() {
        super();
    }

    public AlreadyExistsException(String s) {
        super(s);
    }

    public AlreadyExistsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public AlreadyExistsException(Throwable throwable) {
        super(throwable);
    }
}
