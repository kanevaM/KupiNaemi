package kupinaemitests.util.enums;

public enum Pages {

    KUPINAEMI_LOGIN_PAGE("/potrebitelski-akaunt/vhod"),
    KUPINAEMI_REGISTRATION_PAGE("/potrebitelski-akaunt/registraciq"),
    KUPINAEMI_DETAILED_SEARCH_PAGE("/tyrsene-na-obiava/predlagashta-imot");



    private final String path;

    Pages(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
