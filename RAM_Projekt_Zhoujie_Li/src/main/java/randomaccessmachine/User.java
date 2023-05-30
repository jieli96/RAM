package randomaccessmachine;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Die Klasse User enthält die main-Methode, die den Einstiegspunkt des Programms darstellt.
 * Das Programm ermöglicht die Interaktion mit einer ControllUnit, um verschiedene Aktionen auszuführen.
 */
public class User {

    public static void main(String[] args) {

        // Initialiesieren
        Scanner scanner = new Scanner(System.in);
        // ControllUnit myController = new ControllUnit();
        ReadProgram reader = new ReadProgram();
        Random random = new Random();
        int zufall = random.nextInt(0, 5); // Zufällige Zahl generieren
        int[] memory = {9, 3, 0, 1}; // vordenierte Memory erstellt
        int[] fibomemo = {3, 4, 5, 6, 1, 1, 0}; // vordefinierter Fibomemo erstellt
        int program; // Scanner program input
        String eingabe; // Scanner eingabe

        // Ausführen
        System.out.println("Speicher Grösse eingeben");
        int memo = scanner.nextInt();
        ControllUnit myController = new ControllUnit(memo);
        if (memo <= 0) {
            throw new NegativeArraySizeException("Muss grösser also 0 sein"); // zeigt Fehlermeldung wenn zahl kleiner als 0 ist
        }
        int[] myMemory = new int[myController.getMemorysize()]; // Speichergrösse für den Array definieren
        System.out.println("Haben sie eine eigene Speicher? J/N");
        eingabe = scanner.next();


        if (eingabe.charAt(0) == 'n' || eingabe.charAt(0) == 'N') {
            // Zufällige Auswahl eines vordefinierten Programms
            switch (zufall) {
                case 0:
                    myController.load(fibomemo);
                    myController.run(ReadProgram.readProgram("program/Fibo.txt"));
                    System.out.println("Fibonacci wurde aufgerufen");
                    System.exit(2);

                case 1:
                    myController.load(memory);
                    myController.run(ReadProgram.readProgram("program/DIV.txt"));
                    System.out.println("Division wurde aufgerufen");
                    System.exit(2);
                case 2:
                    myController.load(memory);
                    myController.run(ReadProgram.readProgram("program/MUL.txt"));
                    System.out.println("Multiplikation wurde aufgerufen");
                    System.exit(2);
                case 3:
                    myController.load(memory);
                    myController.run(ReadProgram.readProgram("program/SUB.txt"));
                    System.out.println("Subtraktion wurde aufgerufen");
                    System.exit(2);
                case 4:
                    myController.load(memory);
                    myController.run(ReadProgram.readProgram("program/ADD.txt"));
                    System.out.println("Addition wurde aufgerufen");
                    System.exit(2);
            }
            // falls ja kann man eine Speicherwerte eingeben
        } else if (eingabe.charAt(0) == 'j' || eingabe.charAt(0) == 'J') {

            System.out.println("Geben Sie die Anzahl der Speicherwerte ein:");
            try {
                int size = scanner.nextInt();
                if (size <= 0) {
                    System.out.println("Speicherwert zu klein");
                    System.exit(4);
                }
                System.out.println("Geben Sie die Speicherwerte ein: 'Beispiel': 6 3 0 1 0");
                for (int i = 0; i <= size - 1; i++) {
                    myMemory[i] = scanner.nextInt();
                }

            } catch (Exception e) {
                System.out.println("Bitte Zahlen eingeben");
                System.exit(4);
            }

        } else {
            throw new InputMismatchException("du muss Ja oder Nein wählen");
        }
        System.out.println("Haben sie eine eigene Programm? J/N");
        eingabe = scanner.next();

        if (eingabe.charAt(0) == 'n' || eingabe.charAt(0) == 'N') {
            System.out.println("1 = ADD, 2 = SUB, 3 = MUL , 4 = DIV, 5 = FIBO");
            program = scanner.nextInt();
            if (program <= 0 || program > 5) {
                System.out.println("Ungültiger Programm!");
            }
            switch (program) {
                case 1:
                    myController.load(myMemory);
                    myController.run(ReadProgram.readProgram("program/ADD.txt"));
                    System.out.println("Addition wurde aufgerufen");
                    break;
                case 2:
                    myController.load(myMemory);
                    myController.run(ReadProgram.readProgram("program/SUB.txt"));
                    System.out.println("Subtraktion wurde aufgerufen");
                    break;

                case 3:
                    myController.load(myMemory);
                    myController.run(ReadProgram.readProgram("program/MUL.txt"));
                    System.out.println("Multiplikation wurde aufgerufen");
                    break;
                case 4:
                    myController.load(myMemory);
                    myController.run(ReadProgram.readProgram("program/DIV.txt"));
                    System.out.println("Division wurde aufgerufen");
                    break;
                case 5:
                    myController.load(myMemory);
                    myController.run(ReadProgram.readProgram("program/Fibo.txt"));
                    System.out.println("Fibonacci wurde aufgerufen");
                    break;
            }

            // Ausgabe
        } else if (eingabe.charAt(0) == 'j' || eingabe.charAt(0) == 'J') {
            System.out.println("Bitte hier eine absolute oder relative Path eingeben ");
            eingabe = scanner.next();
            myController.run(ReadProgram.readProgram(eingabe));
        }
    }

}



