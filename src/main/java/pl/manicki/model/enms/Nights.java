package pl.manicki.model.enms;

public enum Nights {
    NIGHTS07("7 nights", 7),
    NIGHTS10("10 nights", 10),
    NIGHTS14("14 nights", 14),
    NIGHTS21("21 nights", 21);

    private String name;
    private int value;

    Nights(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
