public class Zimmer {

    private int zimmerNummer;
    private String kategorie;
    private double preisProNacht;
    private boolean verfuegbar;

    public Zimmer(int zimmerNummer, String kategorie, double preisProNacht, boolean verfuegbar) {
        this.zimmerNummer = zimmerNummer;
        this.kategorie = kategorie;
        this.preisProNacht = preisProNacht;
        this.verfuegbar = verfuegbar;
    }

    public int getZimmerNummer() {
        return zimmerNummer;
    }

    public String getKategorie() {
        return kategorie;
    }

    public double getPreisProNacht() {
        return preisProNacht;
    }

    public boolean istVerfuegbar() {
        return verfuegbar;
    }



    public void setVerfuegbar(boolean verfuegbar) {
        this.verfuegbar = verfuegbar;
    }

    public String toString() {
        return "Zimmernummer: " + zimmerNummer +
                ", Kategorie: " + kategorie +
                ", Preis pro Nacht: " + preisProNacht +
                " €, Verfügbar: " + (verfuegbar ? "ja" : "nein");
    }
}
