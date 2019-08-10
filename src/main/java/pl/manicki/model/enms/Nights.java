package pl.manicki.model.enms;

public enum Nights {
    NIGHTS07("7 nights", 7),
    NIGHTS10("10 nights", 10),
    NIGHTS14("14 nights", 14),
    NIGHTS21("21 nights", 21);

    private String name;
    private int duration;

    Nights(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}
