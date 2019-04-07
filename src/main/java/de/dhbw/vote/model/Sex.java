package de.dhbw.vote.model;

public enum Sex {
    MÄNNLICH, WEIBLICH, DIVERS, UNBEKANNT;
    
    /**
     * Bezeichnung ermitteln
     * @return Bezeichnung
     */
    public String getLabel() {
        switch (this) {
            case MÄNNLICH:
                return "männlich";
            case WEIBLICH:
                return "weiblich";
            case DIVERS:
                return "divers";
            default:
                return this.toString();
        }
    }
    
    /***
     * 
     * @param sex
     * @return 
     */
    public static Sex getSex(String sex){
        switch (sex) {
            case "männlich":
                return MÄNNLICH;
            case "weiblich":
                return WEIBLICH;
            case "divers":
                return DIVERS;
            default:
                return UNBEKANNT;
        }
    }
}
