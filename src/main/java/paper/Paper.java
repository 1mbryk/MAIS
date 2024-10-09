package paper;

public class Paper {
    private String id;
    private String title;
    private String type;
    private boolean isMonthly;
    private Characteristics characteristics;

    public Paper(String id, String title, String type, boolean isMonthly, Characteristics characteristics) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.isMonthly = isMonthly;
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "Paper:\n" +
                "\tid: " + id + "\n" +
                "\tTitle: " + title + '\n' +
                "\tType: " + type + '\n' +
                "\tIsMonthly: " + isMonthly + '\n' +
                "\tCharacteristics:\n" + characteristics;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isMonthly() {
        return isMonthly;
    }

    public void setMonthly(boolean monthly) {
        isMonthly = monthly;
    }

    public Characteristics getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Characteristics characteristics) {
        this.characteristics = characteristics;
    }
}
