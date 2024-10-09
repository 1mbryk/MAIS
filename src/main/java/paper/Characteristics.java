package paper;

public class Characteristics {
    private boolean isColored;
    private int pages;
    private boolean isGlossy;
    private boolean isHomeDeliveryAvailable;

    public Characteristics(boolean isColored, int pages, boolean isGlossy, boolean isHomeDeliveryAvailable) {
        this.isColored = isColored;
        this.pages = pages;
        this.isGlossy = isGlossy;
        this.isHomeDeliveryAvailable = isHomeDeliveryAvailable;
    }

    @Override
    public String toString() {
        return  "\t\tisColored: " + isColored + '\n' +
                "\t\tpages: " + pages + '\n' +
                "\t\tisGlossy: " + isGlossy + '\n' +
                "\t\tisHomeDeliveryAvailable: " + isHomeDeliveryAvailable;
    }

    public boolean isColored() {
        return isColored;
    }

    public void setColored(boolean colored) {
        isColored = colored;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isGlossy() {
        return isGlossy;
    }

    public void setGlossy(boolean glossy) {
        isGlossy = glossy;
    }

    public boolean isHomeDeliveryAvailable() {
        return isHomeDeliveryAvailable;
    }

    public void setHomeDeliveryAvailable(boolean homeDeliveryAvailable) {
        isHomeDeliveryAvailable = homeDeliveryAvailable;
    }
}
