package backend.Infrastructure;

public record RegEx() {
    public static final String Email = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String Alpha = "User was not found";
    public static final String NoWhiteSpaces = "User was not found";
}
