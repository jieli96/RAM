package randomaccessmachine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Die Klasse SimplePrinter implementiert das Printer-Interface und dient zum Drucken des Speicherinhalts und des Zustands der Random Access Machine.
 * Es bietet Methoden zum Drucken der Informationen auf der Konsole und in eine Datei.
 *
 * @author Z.Li
 */
public class SimplePrinter implements printer {
    private Ram ram;

    /**
     * Erzeugt eine neue Instanz des SimplePrinters mit dem angegebenen Ram-Objekt.
     *
     * @param memory das Ram-Objekt, das den Speicher und den Zustand der Maschine enthält
     */
    public SimplePrinter(Ram memory) {
        ram = memory;
    }

    /**
     * Diese Methode gibt den Speicherinhalt und den Zustand der Maschine auf der Konsole aus.
     * Der Speicherinhalt wird als Liste von Zahlenwerten dargestellt.
     * Der Zustand der Maschine umfasst den Wert des Akkumulators und den Wert des Program Counters.
     */
    @Override
    public void ConsolePrinter() {
        System.out.print("Memory: ");
        for (int i = 0; i < ram.getMemory().length; i++) {
            System.out.print(ram.getMemory()[i] + ",");
        }
        System.out.println();
        System.out.println("Accumulator: " + ram.getAccumulator());
        System.out.println("Program Counter: " + ram.getProgramCounter());
        System.out.println();
    }

    /**
     * 
     * Diese Methode schreibt den Speicherinhalt und den Zustand der Maschine in eine Datei.
     * Der Speicherinhalt wird als Liste von Zahlenwerten dargestellt.
     * Der Zustand der Maschine umfasst den Wert des Akkumulators und den Wert des Program Counters.
     */
    @Override
    public void FilePrinter() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("+---------------------+\n");
            writer.write("|       Memory        |\n");
            writer.write("+---------------------+\n");
            writer.write("|  Index  |  Value   |\n");
            writer.write("+---------------------+\n");

            int[] memoryArray = ram.getMemory();
            for (int i = 0; i < memoryArray.length; i++) {
                writer.write(String.format("|   %-5d |   %-6d |\n", i, memoryArray[i]));
            }

            writer.write("+---------------------+\n");
            writer.write(String.format("| Accumulator: %-6d |\n", ram.getAccumulator()));
            writer.write("+---------------------+\n");
            writer.write(String.format("| Program Counter: %-4d |\n", ram.getProgramCounter()));
            writer.write("+---------------------+\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


