public class Document {
    private final int ID;
    private final int Name;
    private final int NoPages;

    public Document(int ID, int name, int noPages) {
        this.ID = ID;
        Name = name;
        NoPages = noPages;
    }

    public int getID() {
        return ID;
    }

    public int getName() {
        return Name;
    }

    public int getNoPages() {
        return NoPages;
    }
}
