package com.nttdata.di4.netflixsubscriptions.utils.constants;

public class RestConstants {

    public static final String APPLICATION_NAME = "/netflix-subscriptions";
    public static final String API_VERSION_1 = "/v1";

    public static final String RESOURCE_SUBSCRIPTION = "/subscriptions";
    public static final String RESOURCE_PROFILE = "/subscriptions/{subscription-id}/profiles";

    private RestConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
