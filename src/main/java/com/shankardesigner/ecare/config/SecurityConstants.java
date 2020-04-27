package com.shankardesigner.ecare.config;

public class SecurityConstants {
    public static final String SIGN_UP_URLS = "/ecare/users/**";
    public static final String ADMIN_URLS = "/ecare/admin/**";
    public static final String EMPLOYEE_URLS = "/ecare/employee/**";
    public static final String DOCTOR_URLS = "/ecare/doctor/**";
    public static final String PATIENT_URLS = "/ecare/patient/**";

    public static final String H2_URL = "h2-console/**";
    public static final String SECRET_KEY = "SecretKeyToGenerateJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 3000000; //3s

    public static final String ADMIN_ROLE = "ADMIN";
    public static final String EMPLOYEE_ROLE = "EMPLOYEE";
    public static final String DOCTOR_ROLE = "DOCTOR";
    public static final String PATIENT_ROLE = "PATIENT";
}
