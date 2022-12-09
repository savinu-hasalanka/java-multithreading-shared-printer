public interface ServicePrinter {
    int PAPER_TRAY_MAX_SIZE = 250;
    int SHEETS_PER_PACK = 50;

    int TONER_LEVEL_MAX = 500;
    int TONER_LEVEL_MIN = 10;
    int PAGES_PER_TONER_CARTRIDGE = 500;

    void refillPaperTray();
    void replaceTonerCartridge();

}
