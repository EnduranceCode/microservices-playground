package com.di4.bootcamp.subscriptions.utils.constants;

public class ExceptionConstants {

    public static final String ERROR = "ERROR";

    public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR - An internal server error has occurred";

    public static final String NON_EXISTENT_SUBSCRIPTION = "NON EXISTENT SUBSCRIPTION - Given Subscription does not exist";
    public static final String NON_EXISTENT_PROFILE = "NON EXISTENT PROFILE - Given Profile does not exist";

    public static final String BAD_REQUEST_PROFILE = "BAD PROFILE REQUEST - Given Profile is not currently assigned to the given Subscription";

    private ExceptionConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
