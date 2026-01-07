import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZimmerVerwaltungGUI extends JFrame {
    private JPanel hauptPanel;
    private JTextField preisTF;
    private JTextField zimmerNrTF;
    private JLabel zimmerNrLabel;
    private JLabel preisLabel;
    private JLabel kategorieLabel;
    private JComboBox kategorieComboBox;
    private JButton speichernButton;
    private JButton freieZimmerButton;
    private JButton auslastungButton;
    private JButton loeschenButton;
    private JButton alleZimmerButton;
    private JCheckBox verfuegbarCheckBox;
    private JList anzeigenList;
    private JLabel zimmeruebersichtLabel;
    private JScrollPane anzeigenScrollPane;
    private JPanel Button;
    private ArrayList<String> zimmerListe;
    private DefaultListModel<String>listModel;
    private ZimmerVerwaltung zimmerVerwaltung;


    public ZimmerVerwaltungGUI(){

        zimmerVerwaltung= new ZimmerVerwaltung();

        listModel = new DefaultListModel<>();
        anzeigenList.setModel(listModel);

        setTitle("Zimmerverwaltung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setContentPane(hauptPanel);
        setVisible(true);

        alleZimmerAnzeigen();



        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speichern();

            }
        });
        auslastungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auslastungAnzeigen();

            }
        });
        freieZimmerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                freieZimmerAnzeigen();

            }
        });
        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loeschen();

            }
        });
        alleZimmerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alleZimmerAnzeigen();

            }
        });
    }

    private void speichern() {

        try {
            // Texte holen
            String nummerEingabe = zimmerNrTF.getText();
            String preisEingabe = preisTF.getText();

            // Leere Felder prüfen
            if (nummerEingabe.isEmpty() || preisEingabe.isEmpty()) {
                throw new IllegalArgumentException("Bitte alle Felder ausfüllen.");
            }


            // Umwandlung
            int nummer = Integer.parseInt(nummerEingabe);
            double preis = Double.parseDouble(preisEingabe);

            if(nummer<=0 || preis<=0){
                throw new IllegalArgumentException("Zimmernummer muss größer als 0 sein !");
            }


            String kategorie = (String) kategorieComboBox.getSelectedItem();
            boolean verfuegbar = verfuegbarCheckBox.isSelected();

            Zimmer neuesZimmer = new Zimmer(nummer, kategorie, preis, verfuegbar);
            zimmerVerwaltung.addZimmer(neuesZimmer);

            alleZimmerAnzeigen();

            // Felder zurücksetzen
            zimmerNrTF.setText("");
            preisTF.setText("");
            verfuegbarCheckBox.setSelected(false);

        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Zimmernummer und Preis müssen Zahlen sein!",
                    "Eingabefehler",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage(),
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }


    private void alleZimmerAnzeigen() {
        listModel.clear();
        for (Zimmer aktuellesZimmer : zimmerVerwaltung.getAlleZimmer()) {
            listModel.addElement(aktuellesZimmer.toString());
        }
    }

    private void freieZimmerAnzeigen() {
        listModel.clear();
        for (Zimmer aktuellesZimmer : zimmerVerwaltung.getVerfuegbareZimmer()) {
            listModel.addElement(aktuellesZimmer.toString());
        }
    }

    private void auslastungAnzeigen() {
        int gesamt = zimmerVerwaltung.size();
        int nichtVerfuegbar = zimmerVerwaltung.countNichtVerfuegbar();

        JOptionPane.showMessageDialog(this,
                "Gesamtzimmer: " + gesamt +
                        "\nNicht verfügbar: " + nichtVerfuegbar,
                "Auslastung",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void loeschen() {
        int i = anzeigenList.getSelectedIndex();

        if (i == -1) {
            JOptionPane.showMessageDialog(this,
                    "Bitte ein Zimmer auswählen!",
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        zimmerVerwaltung.removeZimmer(i);
        alleZimmerAnzeigen();
    }





    static void main(String[] args) {
        new ZimmerVerwaltungGUI();

    }
}
