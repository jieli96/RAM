package randomaccessmachine;

/**
 * Das Interface printer definiert Methoden zum Drucken von Informationen.
 * Implementierende Klassen müssen die Methoden ConsolePrinter() und FilePrinter() implementieren.
 *
 * @author z.Li
 */
public interface printer {
    /**
     * Gibt die Informationen auf der Konsole aus.
     */
	void ConsolePrinter();

    /**
     * Schreibt die Informationen in eine Datei.
     */
	void FilePrinter();
}
