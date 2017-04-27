package connectionController;

/**
 * Created by Ivan on 25.04.2017.
 */
public abstract class Comands {
    public static final String GET_PAGE = "get page";
    public static final String GET_SEARCH_RESULT_SIZE = "get search result size";
    public static final String GET_SEARCH_RESULT_PAGE = "get search result page";
    public static final String DELETE_SEARCH_RESULT = "delete search result";
    public static final String CHECK_CONNECTION = "check connection";
    public static final String GET_AMOUNT_OF_RECORDS = "get amount of records";
    public static final String ADD_PERSON = "add person";
    public static final String DELETE_PERSON_BY_ID = "delete person id";
    public static final String DELETE_PERSON_BY_GROUP = "delete person group";
    public static final String DELETE_PERSON_BY_MARKS = "delete person marks";
    public static final String DELETE_PERSON_BY_EXAM_RESULT = "delete person exam resul";
    public static final String SEARCH_PERSON_BY_ID = "search person id";
    public static final String SEARCH_PERSON_BY_GROUP = "search person group";
    public static final String SEARCH_PERSON_BY_MARKS = "search person marks";
    public static final String SEARCH_PERSON_BY_EXAM_RESULT = "search person exam resul";
    public static final String SAVE = "save";
    public static final String OPEN = "open";
    public static final String KILL_CONNECTION = "kill connection";
}
