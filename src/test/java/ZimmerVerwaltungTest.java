import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ZimmerVerwaltungTest {

    private ZimmerVerwaltung zimmerVerwaltung;

   @BeforeEach
   void testvorbereitung(){
        zimmerVerwaltung = new ZimmerVerwaltung();
    }

    @Test
    void initObjekte() {
        assertEquals(3,zimmerVerwaltung.size());
    }

    @Test
    void getAlleZimmer() {
        ArrayList<Zimmer> alleZimmer= zimmerVerwaltung.getAlleZimmer();
        assertNotNull(alleZimmer);
        assertEquals(3,alleZimmer.size());
    }

    @Test
    void addZimmer() {
        Zimmer neuesZimmer = new Zimmer(301,"Einzel",89.99,true);
        zimmerVerwaltung.addZimmer(neuesZimmer);
        assertEquals(4,zimmerVerwaltung.size());
    }

    @Test
    void removeZimmer() {
        zimmerVerwaltung.removeZimmer(0);
        assertEquals(2,zimmerVerwaltung.size());
    }

    @Test
    void getVerfuegbareZimmer() {
        ArrayList<Zimmer> verfuegbareZimmer= zimmerVerwaltung.getVerfuegbareZimmer();
        assertEquals(2,verfuegbareZimmer.size());
        for (Zimmer zimmer : verfuegbareZimmer){
            assertTrue(zimmer.istVerfuegbar());
        }
    }

    @Test
    void countNichtVerfuegbar() {
        int nichtVerfuegbar = zimmerVerwaltung.countNichtVerfuegbar();
        assertEquals(1,nichtVerfuegbar);
    }

    @Test
    void size() {
        assertEquals(3,zimmerVerwaltung.size());
    }
}