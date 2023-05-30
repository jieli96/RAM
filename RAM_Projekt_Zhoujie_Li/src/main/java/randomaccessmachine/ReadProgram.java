package randomaccessmachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Die Klasse ReadProgram bietet eine statische Methode zum Lesen eines Programms aus einer Datei.
 * Das Programm wird als Array von Strings zurückgegeben, wobei jede Zeile des Programms einem Element im Array entspricht.
 *
 * @author Z.Li
 */
public class ReadProgram {
    /**
     * Konstruktor für die ReadProgram-Klasse.
     */
    public ReadProgram() {
    }

    /**
     * Liest das Programm aus der angegebenen Datei und gibt es als Array von Strings zurück.
     *
     * @param filename der Dateiname bzw. der Pfad zur Datei, die das Programm enthält
     * @return ein Array von Strings, das gelesene Programm repräsentiert
     */
    public static String[] readProgram(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            StringBuilder programBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                programBuilder.append(line).append("\n"); // Setzt die Zeichen kette zusammen
            }

            reader.close();

            String programString = programBuilder.toString().trim();
            return programString.split("\n");
        } catch (IOException e) {
            System.out.println("Keine File erkannt");
            e.printStackTrace();
            return null;
        }
    }
}
