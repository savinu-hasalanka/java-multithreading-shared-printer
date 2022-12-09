public class Document {
    private final int ID;
    private final int Name;
    private final int noPages;

    public Document(int ID, int name, int noPages) {
        this.ID = ID;
        Name = name;
        this.noPages = noPages;
    }

    public int getID() {
        return ID;
    }

    public int getName() {
        return Name;
    }

    public int getNoPages() {
        return noPages;
    }
}
