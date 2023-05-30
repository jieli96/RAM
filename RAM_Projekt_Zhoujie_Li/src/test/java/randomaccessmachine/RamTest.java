package randomaccessmachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RamTest {

        Ram ram = new Ram(100);

        @Test
        public void testSTI() {
            int [] memory = {3,0,0,0,0};
            ram.load(memory);
            ram.setAccumulator(32);
            ram.STI(0);

            assertEquals(32, ram.getMemory()[3]);
        }


        @Test
        public  void testLDI() {
            int [] memory = {5,0,0,9,0,200,0,0,0,0};
            ram.load(memory);
            ram.LDI(0);

            assertNotEquals(5, ram.getAccumulator());
            assertEquals(200,ram.getAccumulator());

        }
    @Test
        public void testJMZ() {

            ram.setAccumulator(0);
            ram.JMZ(9);

            assertEquals(9,ram.getProgramCounter());
        }
}
