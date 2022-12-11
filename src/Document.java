public class Document {
    private final int ID;
    private final String Name;
    private final int noPages;

    public Document(int ID, String name, int noPages) {
        this.ID = ID;
        Name = name;
        this.noPages = noPages;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public int getNoPages() {
        return noPages;
    }
}
