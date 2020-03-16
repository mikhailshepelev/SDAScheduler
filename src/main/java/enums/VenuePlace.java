package enums;

public enum VenuePlace {
    SEASIDE("SeaSide"),
    CITYSIDE("CItySide"),
    STOCKHOLM("Stockholm"),
    ONLINE("Online - home"),
    KREUTZWALD_HOTEL("Kreutzwald Hotel");

    public String venuePlace;

    VenuePlace(String venuePlace) {
        this.venuePlace = venuePlace;
    }
}
