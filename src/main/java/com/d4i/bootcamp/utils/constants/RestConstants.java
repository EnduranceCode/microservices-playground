package com.d4i.bootcamp.utils.constants;

public class RestConstants {

	public static final String APPLICATION_NAME = "/tv-shows-api";
	public static final String API_VERSION_1 = "/v1";
	public static final String SUCCESS = "Success";

	public static final String RESOURCE_ACTOR = "/actors";
	public static final String RESOURCE_AWARDS = "/awards";
	public static final String RESOURCE_ACTOR_SEASON = "/{id}/seasons";
	public static final String RESOURCE_ACTOR_CHAPTER = "/{id}/chapters";
	public static final String RESOURCE_CATEGORY = "/categories";
	public static final String RESOURCE_TV_SHOW = "/tv-shows";
	public static final String RESOURCE_SEASON = "/tv-shows/{tvShowId}/seasons";
	public static final String RESOURCE_CHAPTER = "/tv-shows/{tvShowId}/seasons/{seasonNumber}/chapters";
	public static final String RESOURCE_ID = "/{id}";
	public static final String RESOURCE_NUMBER = "/{number}";

	public static final String PARAMETER_ACTOR = "actor";
	public static final String PARAMETER_CATEGORY = "category";
	public static final String PARAMETER_TV_SHOW = "tv-show";
	public static final String PARAMETER_TV_CHAPTER = "chapter";

	private RestConstants() {
		throw new IllegalStateException("Utility Class");
	}
}
