package com.d4i.bootcamp.utils.constants;

public class ExceptionConstants {

	public static final String ERROR = "ERROR";

	public static final String MESSAGE_INEXISTENT_ACTOR = "ACTOR INEXISTENT - Actor does not exist";
	public static final String MESSAGE_INEXISTENT_SEASON = "SEASON INEXISTENT - Season does not exist";
	public static final String MESSAGE_INEXISTENT_CHAPTER = "CHAPTER INEXISTENT - Chapter does not exist";
	public static final String MESSAGE_INEXISTENT_TV_SHOW = "TV SHOW INEXISTENT - TV Show does not exist";

	public static final String MESSAGE_MALFORMED_CHAPTER = "MALFORMED DATA - The given Chapter doesn't include a proper ID";

	public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR - An internal server error has ocurred";

	private ExceptionConstants() {
		throw new IllegalStateException("Utility Class");
	}
}
