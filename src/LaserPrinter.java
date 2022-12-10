public class LaserPrinter implements ServicePrinter {

    private volatile int availableSheets;
    private volatile int currentTonerLevel;
    private volatile int printCounter;
    private final Object monitor;

    public LaserPrinter() {
        this.availableSheets = PAPER_TRAY_MAX_SIZE;
        this.currentTonerLevel = TONER_LEVEL_MAX;
        this.printCounter = 0;
        this.monitor = new Object();
    }

    @Override
    public void print(Document document) throws InterruptedException {
        int requiredSheets = document.getNoPages();
        synchronized (monitor) {
            if (checkResources(requiredSheets)) {
                consumeResources(requiredSheets);
                printCounter++;
            } else {
                monitor.wait();
                print(document);
            }
        }
    }

    @Override
    public void refillPaperTray() {
        synchronized (monitor) {
            if (SHEETS_PER_PACK + availableSheets <= PAPER_TRAY_MAX_SIZE) {
                availableSheets += SHEETS_PER_PACK;
                monitor.notifyAll();
            }
        }
    }

    @Override
    public void replaceTonerCartridge() {
        synchronized (monitor) {
            if (currentTonerLevel < TONER_LEVEL_MIN) {
                currentTonerLevel = TONER_LEVEL_MAX;
                monitor.notifyAll();
            }
        }
    }

    @Override
    public String toString() {
        return "LaserPrinter{" +
                "availableSheets=" + availableSheets +
                ", currentTonerLevel=" + currentTonerLevel +
                ", printCounter=" + printCounter +
                '}';
    }

    private boolean checkResources(int requiredSheets) {
        return availableSheets >= requiredSheets && currentTonerLevel >= requiredSheets;
    }

    private void consumeResources(int requiredSheets) {
        availableSheets -= requiredSheets;
        currentTonerLevel -= requiredSheets;
    }



}
