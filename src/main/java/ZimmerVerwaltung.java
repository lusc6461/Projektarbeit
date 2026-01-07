import java.util.ArrayList;

public class ZimmerVerwaltung {

    private ArrayList<Zimmer> zimmerListe;

    public ZimmerVerwaltung() {
        zimmerListe = new ArrayList<>();
        initObjekte();
    }

    // Startzimmer anlegen
    public void initObjekte() {
        zimmerListe.clear();
        zimmerListe.add(new Zimmer(101, "Einzel", 79.99, true));
        zimmerListe.add(new Zimmer(102, "Doppel", 119.99, false));
        zimmerListe.add(new Zimmer(201, "Suite", 249.99, true));
    }

    // Alle Zimmer zurückgeben
    public ArrayList<Zimmer> getAlleZimmer() {
        return zimmerListe;
    }

    // Neues Zimmer hinzufügen
    public void addZimmer(Zimmer neuesZimmer) {

        if (neuesZimmer == null) {
            throw new IllegalArgumentException("Zimmer darf nicht null sein.");
        }

        // Prüfen, ob Zimmernummer bereits existiert
        for (Zimmer aktuellesZimmer : zimmerListe) {
            if (aktuellesZimmer.getZimmerNummer()
                    == neuesZimmer.getZimmerNummer()) {
                throw new IllegalArgumentException("Zimmernummer existiert bereits.");
            }
        }

        zimmerListe.add(neuesZimmer);
    }

    // Zimmer löschen
    public void removeZimmer(int i) {
        if (i < 0 || i >= zimmerListe.size()) {
            throw new IllegalArgumentException("Ungültiger Index.");
        }
        zimmerListe.remove(i);
    }

    // Verfügbare Zimmer ermitteln
    public ArrayList<Zimmer> getVerfuegbareZimmer() {

        ArrayList<Zimmer> verfuegbareZimmer = new ArrayList<>();

        for (Zimmer aktuellesZimmer : zimmerListe) {
            if (aktuellesZimmer.istVerfuegbar()) {
                verfuegbareZimmer.add(aktuellesZimmer);
            }
        }

        return verfuegbareZimmer;
    }

    // Anzahl nicht verfügbarer Zimmer zählen
    public int countNichtVerfuegbar() {

        int count = 0;

        for (Zimmer aktuellesZimmer : zimmerListe) {
            if (!aktuellesZimmer.istVerfuegbar()) {
                count++;
            }
        }

        return count;
    }

    public int size() {

        return zimmerListe.size();
    }
}
