package randomaccessmachine;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Die Klasse ControllUnit repräsentiert die Steuereinheit einer Random Access Machine.
 * Sie ermöglicht das Laden von Programmen in den Speicher und den Ausführungsprozess der Befehle.
 *
 * @author Z.Li
 */
public class ControllUnit {
    private Ram ram;

    /**
     * Erzeugt eine Construktor der ControllUnit-Klasse.
     * Beim Erstellen der Instanz wird der Benutzer aufgefordert, die Größe des Speichers einzugeben.
     *
     */
    public ControllUnit(int size) {

        ram = new Ram(size);

/* erste Methode
        try {
            scanner = new Scanner(System.in);
            System.out.println("Speicher Grösse eingeben");
            int size = scanner.nextInt();
            if (size <= 0) {
                System.out.println("Ungültiger Speichergrösse: " + size);
                System.exit(1);
            }
            ram = new Ram(size);
        } catch (InputMismatchException e) {
            System.out.println("Keine gültige Zahl erkannt");
        }
*/

    }
    /**
     * Lädt ein Speicherarray in die Ram-Klasse.
     * Der übergebene Speicher wird verwendet, um den internen Speicher der Ram-Klasse zu aktualisieren.
     *
     * @param memory Das zu ladende Speicherarray.
     */
    public void load(int[] memory) {
        ram.load(memory);
    }

    /**
     * Führt das Programm aus, das durch das gegebene String-Array repräsentiert wird.
     * Der übergebene Programmcode wird sequenziell ausgeführt, Befehl für Befehl.
     * Bei ungültigen Befehlen oder Fehlern wird die Ausführung gestoppt und eine Fehlermeldung ausgegeben.
     * Während der Ausführung werden die Ausgabe auf der Konsole und in eine Datei geschrieben.
     *
     * @param program Das auszuführende Programm als String-Array.
     */
    public void run(String[] program) {

        boolean stop = false; // Stopt den Loop
        SimplePrinter print = new SimplePrinter(ram);

        for (int i = 1; i < program.length; i++) {

            String[] parts = program[i].split(" "); // Hier wird der String Array gesplittet und in 'parts' gespeichert
            String opcode = parts[0]; // Der erste part von der String wird als opcode übernommen
            try {
                if (!opcode.equals("HLT")) {
                    int index = Integer.parseInt(parts[1]); // Der Wert an Index 1 von 'parts' wird in 'index' als Integer umgewandelt "muss eine Zahl sein"

                    switch (opcode) {
                        case "ADD": // Der Wert an der Speicheradresse `x` wird zum Akkumulator addiert.
                            ram.ADD(index);
                            print.ConsolePrinter();
                            print.FilePrinter();
                            break;
                        case "SUB": // Der Wert an der Speicheradresse `x` wird vom Akkumulator subtrahiert.
                            ram.SUB(index);
                            print.ConsolePrinter();
                            print.FilePrinter();
                            break;
                        case "LIDA": // Der Wert an der Speicheradresse `x` wird in den Akkumulator geladen.
                            ram.LIDA(index);
                            print.ConsolePrinter();
                            print.FilePrinter();
                            break;
                        case "STA": // Der Wert im Akkumulator wird in den Speicher an der Speicheradresse `x` geschrieben.
                            ram.STA(index);
                            print.ConsolePrinter();
                            print.FilePrinter();
                            break;
                        case "LDI": // Der indirekte Speicherwert an der Speicheradresse `x` wird in den Akkumulator geladen.
                            ram.LDI(index);
                            print.ConsolePrinter();
                            print.FilePrinter();
                            break;
                        case "STI": // Der Wert im Akkumulator wird in den Speicher an der indirekten Speicheradresse `x` geschrieben.
                            ram.STI(index);
                            print.ConsolePrinter();
                            print.FilePrinter();
                            break;

                        case "JMP": // Der Programmzähler wird auf den Wert `x` gesetzt, um einen Sprung im Programmablauf durchzuführen.
                            ram.JMP(index);
                            i = ram.getProgramCounter() - 1;
                            print.ConsolePrinter();
                            print.FilePrinter();
                            break;
                        case "JMZ": // Wenn der Wert im Akkumulator 0 ist, wird der Programmzähler auf den Wert `x` gesetzt.
                            ram.JMZ(index);
                            if (ram.getAccumulator() == 0) {
                                i = ram.getProgramCounter() - 1;
                            }
                            print.ConsolePrinter();
                            print.FilePrinter();
                            break;
                        case "ADDLDI": // // Addiert den Wert x zum indirekten Speicherwert am angegebenen Index und speichert das Ergebnis im Akkumulator
                            ram.ADDLDI(index);
                            print.ConsolePrinter();
                            print.FilePrinter();
                            break;
                            // Hier kann man neue case einfügen wenn man eine neue Methode hat
                        default:
                            System.out.println("Ungültige Befehl beim " + i + ". Stelle '" + program[i] + "'");
                            stop = true;
                            break;
                    }
                } else {
                    ram.HLT(); // Beendet das Programm
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Index nicht erkannt"); // Fehlerausgabe wenn keine Index erkannt wurde
                break;
            }
            if (stop) { // stopt den schleife wenn stop = true ist
                break;
            }
        }

    }

   

    /**
     * Gibt die Größe des RAMs zurück.
     *
     * @return Die Größe des RAMs.
     */
    public int getMemorysize() {
        return ram.getRamSize();
    }

}





