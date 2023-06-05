package backend.Infrastructure;

public record ErrorMessages() {
    public static final String UserNotFound = "User was not found";
    public static final String InvalidEmail = "Email must be of a valid format";

    public static final String MedicineNotFound = "Medicine was not found";
    public static final String OrderNotFound = "Order was not found";
    public static final String SectionNotFound = "Section was not found";
}
