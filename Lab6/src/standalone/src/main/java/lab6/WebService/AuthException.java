package lab6.WebService;

public class AuthException extends Exception {

    private static final long serialVersionUID = -6647544772732631047L;
    public static AuthException DEFAULT_INSTANCE = new
            AuthException("Invalid login-password");

    AuthException(String message) {
        super(message);
    }
}
