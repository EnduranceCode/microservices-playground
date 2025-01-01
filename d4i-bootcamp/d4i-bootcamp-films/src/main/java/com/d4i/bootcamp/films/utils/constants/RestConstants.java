package com.d4i.bootcamp.films.utils.constants;

public class RestConstants {

    public static final String APPLICATION_NAME = "/films-api";
    public static final String API_VERSION_1 = "/v1";

    public static final String RESOURCE_FILM = "/films";

    public static final String TV_SHOWS_API_BASE_URL = "http://localhost:8088/tv-shows-api/v1";
    public static final String TV_SHOWS_RESOURCE_CATEGORY = "/categories";

    private RestConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
