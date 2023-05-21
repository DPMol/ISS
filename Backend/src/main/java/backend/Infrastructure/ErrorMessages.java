package backend.Infrastructure;

public record ErrorMessages() {
    public static final String UserNotFound = "User was not found";
    public static final String UserAlreadyExists = "User with given email already exists";
    public static final String InvalidEmail = "Email must be of a valid format";
    public static final String FriendshipAlreadyExists = "Friendship between given users already exists";
    public static final String FriendshipNotFound = "Friendship was not found";

    public static final String FriendshipInvalidReceiver = "Sender cannot accept friendship";
    public static final String DuplicateEmails = "Given emails must be different";
}
