package models;

public class Symbol {
    String achar;
    String avatharURL;

    public Symbol(String achar) {
        this.achar = achar;
    }

    public String getAchar() {
        return achar;
    }

    public void setAchar(String achar) {
        this.achar = achar;
    }

    public String getAvatharURL() {
        return avatharURL;
    }

    public void setAvatharURL(String avatharURL) {
        this.avatharURL = avatharURL;
    }
}
