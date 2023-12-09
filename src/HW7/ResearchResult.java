package HW7;

public class ResearchResult {

    private String name;
    private Integer occurrence;

    public ResearchResult(String name, Integer occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public String toString() {
        return "{name: \""+ this.name + "\", occurrence: " + this.occurrence + "}";
    }
}
