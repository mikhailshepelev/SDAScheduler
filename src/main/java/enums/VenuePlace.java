package enums;

public enum VenuePlace {
    SEASIDE("SeaSide"),
    CITYSIDE("CitySide"),
    STOCKHOLM("Stockholm"),
    HELSINKI("Helsinki"),
    RIGA("Riga"),
    TALLINN("Tallinn"),
    MARIEHAMN("Mariehamn"),
    ONLINE("Online - home"),
    DORPAT_HOTEL("Dorpat Hotel"),
    TALLINK_HOTEL("Tallink Hotel"),
    JUSTUS_HOTEL("Justus Hotel"),
    KREUTZWALD_HOTEL("Kreutzwald Hotel"),
    EMPTY("");

    public String venuePlace;

    VenuePlace(String venuePlace) {
        this.venuePlace = venuePlace;
    }
}
