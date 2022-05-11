package com.mir00r.studentscrudapis.routes;

/**
 * @author mir00r on 11/5/22
 * @project IntelliJ IDEA
 */
public class Router {
    public static final String REST_API = "Rest API";
    public static final String API = "api/";
    public static final String VERSION = "v1";

    public static final String CREATE_STUDENTS = API + VERSION + "/students";
    public static final String FIND_STUDENTS_BY_ID = API + VERSION + "/students/{id}";
    public static final String UPDATE_STUDENTS_BY_ID = API + VERSION + "/students/{id}";
    public static final String DELETE_STUDENTS_BY_ID = API + VERSION + "/students/{id}";
    public static final String SEARCH_ALL_STUDENTS = API + VERSION + "/students";
}
