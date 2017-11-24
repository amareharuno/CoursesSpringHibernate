package by.netcracker.bsuir.pz3.courses.web.constant;

public final class LoggingAndExceptionMessage {
    // User
    public static final String USER_CONTROLLER_SIGN_IN = "signIn method: UserController";
    public static final String USER_CONTROLLER_SIGN_UP = "signUp method: UserController";
    public static final String USER_CONTROLLER_GET_INDEX_PAGE = "getIndexPage method: UserController";
    public static final String USER_CONTROLLER_SIGN_IN_USER = "signInUser method: UserController";
    public static final String USER_CONTROLLER_SIGN_UP_USER = "signUpUser method: UserController";
    public static final String USER_ALREADY_EXISTS = "A user with such login already exists. Please try again.";
    public static final String NO_SUCH_USER = "No such user. Try to enter your login and password again.";

    // Common
    public static final String EMPTY_FIELDS = "Some form fields may be empty. Please enter all required information.";
    public static final String NO_ROLE_DEFINED_TO_THE_USER = "No role (teacher|student) defined to the user." +
            "You can sign up or enter other logIn information.";
    public static final String WRONG_INPUT = "Some form fields contains wrong information. Please enter wright values.";
    public static final String NO_CHECKED_ITEM = "No checked item.";
}
