package randomaccessmachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllUnittest {
    ControllUnit testController;

// Überprüfung der Index 
@Test
public void testIndexNotFound() {
    testController = new ControllUnit(10);
    String[] testProgram = {
            "HLT",
            "LIDA",
            "ADD 1"
    };
    String[] testProgram1 = {
            "HLT",
            "LIDA A",
            "ADD 1"
    };
    int[] testMemory = {2, 2, 0};
    testController.load(testMemory);
    testController.run(testProgram1);
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
        testController.run(testProgram);
    });
}

// Überprüfen ob eine ungültige Speichergrösse erkannt wird 
    @Test
    public void testValidMemorySize() {

    assertThrows(NegativeArraySizeException.class, () -> {
        testController = new ControllUnit(-2);
    });

    
    }
    
    // Überprüfen ob eine ungültige Befehl erkannt wird
    @Test
    public void testInvalidCommand() {
    testController = new ControllUnit(10);
        String[] program = {
                "ADD 1",
                "XYZ 2", // ungültige befehl
                "SUB 3"
        };

        testController.run(program);

    }
    
    // Überprüfen ob eine ungültige Arrayspeicher
    @Test
    public void testArrays() {
        int[] testMemory = new int[3];
        testController = new ControllUnit(2);
        assertThrows(ArrayIndexOutOfBoundsException.class,() -> {
            testController.load(testMemory);
        });

    }
}
