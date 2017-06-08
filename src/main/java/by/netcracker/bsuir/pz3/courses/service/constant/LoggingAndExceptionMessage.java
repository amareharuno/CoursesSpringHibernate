package by.netcracker.bsuir.pz3.courses.service.constant;

public final class LoggingAndExceptionMessage {

    //user
    public static final String USER_SIGN_IN = "signInUser method: UserServiceImpl";
    public static final String USER_SIGN_UP = "signUpUser method: UserServiceImpl";

    public static final String SERVICE_ADD = "add method: ServiceImpl";
    public static final String SERVICE_GET = "getById method: ServiceImpl";
    public static final String SERVICE_UPDATE = "update method: ServiceImpl";
    public static final String SERVICE_DELETE = "delete method: ServiceImpl";
    public static final String SERVICE_GET_ALL = "getAll method: ServiceImpl";
    
    public static final String ADD_OK = "Add complete: service";
    public static final String GET_OK = "Get by id complete: service";
    public static final String UPDATE_OK = "Update complete: service";
    public static final String DELETE_OK = "Delete complete: service";
    public static final String GET_ALL_OK = "Get all complete: service";

    // Exceptions message
    public static final String ADD_FAIL = "Adding was failed: service";
    public static final String GET_FAIL = "Getting by id was failed: service";
    public static final String UPDATE_FAIL = "Updating was failed: service";
    public static final String DELETE_FAIL = "Deleting was failed: service";
    public static final String GET_ALL_FAIL = "Getting all was failed: service";
}
