package randomaccessmachine;

/**
 * Die Klasse Ram repräsentiert die Instruktionsverarbeitungseinheit einer Random Access Machine.
 * Sie enthält verschiedene Befehle zur Ausführung von Operationen auf dem Speicher und der Akkumulator-Register.
 * 
 * @author Z.Li
 */
public class Ram {
    private  int[] memory;
    private int accumulator;
    private int programCounter;

    /**
     * Erzeugt eine konstruktor von der klasse Ram
     * Der übergebene Parameter `size` gibt die Größe des Speichers an, der in der Ram-Klasse verwendet wird.
     * Der Akkumulator wird mit 0 initialisiert und der Programmzähler auf 0 gesetzt.
     *
     * @param size Die Größe des Speichers.
     */
    public Ram(int size) {
        memory = new int[size];
        accumulator = 0;
        programCounter = 0;

    }

    /**
     * Lädt die übergebenen Werte in den Speicher der RAM.
     * Der übergebene Parameter `memo` enthält die Werte, die in den Speicher geladen werden sollen.
     * Die Werte werden von Index 0 bis Index memo.length in den Speicher kopiert.
     *
     * @param memo Das zu ladende Speicherarray.
     */
    public void load(int[] memo) {
        for (int i = 0; i < memo.length; i++) {
            memory[i] = memo[i];
          //  System.arraycopy(memo, 0, memory, 0, memo.length); auch eine Variante
        }
    }

    /**
     * Führt den "ADD" (Add) Befehl aus.
     * Der Wert an der Speicheradresse `x` wird zum Akkumulator addiert.
     * Der Programmzähler wird um 1 erhöht.
     *
     * @param x Die Speicheradresse.
     */
    public void ADD(int x) {
        accumulator += memory[x];
        programCounter++;
    }

    /**
     * Führt den "SUB" (Subtract) Befehl aus.
     * Der Wert an der Speicheradresse `x` wird vom Akkumulator subtrahiert.
     * Der Programmzähler wird um 1 erhöht.
     *
     * @param x Die Speicheradresse.
     * @autor Z.Li
     */
    public void SUB(int x) {
        accumulator -= memory[x];
        programCounter++;
    }

    /**
     * Führt den "LIDA" (Load in Accumulator) Befehl aus.
     * Der Wert an der Speicheradresse `x` wird in den Akkumulator geladen.
     * Der Programmzähler wird um 1 erhöht.
     *
     * @param x Die Speicheradresse.
     */
    public void LIDA(int x) {
        accumulator = memory[x];
        programCounter++;
    }

    /**
     * Führt den "STA" (Store Accumulator) Befehl aus.
     * Der Wert im Akkumulator wird in den Speicher an der Speicheradresse `x` geschrieben.
     * Der Akkumulator wird anschließend auf 0 zurückgesetzt.
     * Der Programmzähler wird um 1 erhöht.
     *
     * @param x Die Speicheradresse.
     */
    public void STA(int x) {
        memory[x] = accumulator;
        accumulator = 0;
        programCounter++;
    }

    /**
     * Führt den "LDI" (Load Indirect) Befehl aus.
     * Der indirekte Speicherwert an der Speicheradresse `x` wird in den Akkumulator geladen.
     * Der Programmzähler wird um 1 erhöht.
     *
     * @param x Die Speicheradresse.
     */
    public void LDI(int x) {
        accumulator = memory[memory[x]];
        programCounter++;
    }

    /**
     * Führt den "STI" (Store Indirect) Befehl aus.
     * Der Wert im Akkumulator wird in den Speicher an der indirekten Speicheradresse `x` geschrieben.
     * Der Programmzähler wird um 1 erhöht.
     *
     * @param x Die indirekte Speicheradresse.
     */
    public void STI(int x) {
        memory[memory[x]] = accumulator;
        programCounter++;
    }

    /**
     * Führt den "JMP" (Jump) Befehl aus.
     * Der Programmzähler wird auf den Wert `x` gesetzt, um einen Sprung im Programmablauf durchzuführen.
     *
     * @param x Der neue Wert des Programmzählers.
     */
    public void JMP(int x) {
        programCounter = x;
    }

    /**
     * Führt den "JMZ" (Jump if Zero) Befehl aus.
     * Wenn der Wert im Akkumulator 0 ist, wird der Programmzähler auf den Wert `x` gesetzt.
     * Andernfalls wird der Programmzähler um 1 erhöht.
     *
     * @param x Der neue Wert des Programmzählers.
     */
    public void JMZ(int x) {
        if (accumulator == 0) {
            programCounter = x;
        } else {
            programCounter++;
        }
    }
/**
 * Führt den "ADDLDI" (Add from a indrektaddress in acc) aus.
 * Der indirekte Speicherwert an der Speicheradresse `x` wird in den Akkumulator addiert
 * Der Programmzähler wird um 1 erhöht.
 * @param x Die indirekte Speicheradresse.
 */
    public void ADDLDI(int x) {  // Zusätzliche Befehl
        accumulator += memory[memory[x]];
        programCounter++;
    }

    /**
     * Führt den "HLT" (Halt) Befehl aus.
     * Es interpretiert das Akkumulator als Resultat.
     * Beendet das Programm und gibt eine entsprechende Nachricht aus.
     */
    public void HLT() {
        System.out.println("Resultat = " + accumulator);
        System.out.println("Programm beendet");

    }
    //Hier kännen weitere Methode implementiert werden

    /**
     * Gibt den aktuellen Speicher zurück.
     *
     * @return Das Speicherarray.
     */
    public int[] getMemory() {
        return memory;
    }

    /**
     * Gibt den aktuellen Wert des Akkumulators zurück.
     *
     * @return Der Wert des Akkumulators.
     */
    public int getAccumulator() {
        return accumulator;
    }

    /**
     * Gibt den aktuellen Wert des Programmzählers zurück.
     *
     * @return Der Wert des Programmzählers.
     */
    public int getProgramCounter() {
        return programCounter;
    }
    /**
     * Gibt den Ram länge an.
     *
     * @return Der länge des speicher grösse.
     */
    public int getRamSize() {
        return memory.length;
    }

    /**
     * Setzt den accumulator
     *
     * @param accumulator
     */
    public void setAccumulator(int accumulator) {
        this.accumulator = accumulator;
    }


}

	

