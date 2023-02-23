import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConverterTests {

    @Test
    public void testCAKEtoFIL() {
        PrintStream outBackup = System.out;
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        Converter converter = new Converter();
        converter.CAKE = 4.0;
        converter.FIL = 5.0;
        converter.CAKEtoFIL(5.0);
        System.setOut(outBackup);
        String[] str = os.toString().replace(',', '.').split(" ");
        Double result = 4.0;
        Assertions.assertEquals(Double.parseDouble(str[3]), result);
    }

    @Test
    public void testFILtoCAKE() {
        PrintStream outBackup = System.out;
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        Converter converter = new Converter();
        converter.CAKE = 4.0;
        converter.FIL = 5.0;
        converter.FILtoCAKE(2.0);
        System.setOut(outBackup);
        String[] str = os.toString().replace(',', '.').split(" ");
        Double result = 2.5;
        Assertions.assertEquals(Double.parseDouble(str[3]), result);
    }
}