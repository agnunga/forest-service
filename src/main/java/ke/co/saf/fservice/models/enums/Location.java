package ke.co.saf.fservice.models.enums;

public enum Location {
    ZONE_A("Zone A"),
    NEAR_THE_RIVER("Near_the_River"),
    NE_QUADRANT("NE_Quadrant");
    private String description;

    private Location(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
