package kupinaemitests.util;

public class Constants {
    public static final String USERNAME = "kaneva.marieta@gmail.com";
    public static final String PASSWORD = "wordToPass!";
    public static final String KUPINAEMI_HOME_PAGE = "https://kupinaemi.bg";

    private final String path;

    Constants(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

