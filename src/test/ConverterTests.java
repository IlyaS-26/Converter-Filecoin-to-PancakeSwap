import org.junit.Assert;
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
        converter.CAKE = 4.107233;
        converter.FIL = 5.818333;
        converter.CAKEtoFIL(3);
        System.setOut(outBackup);
        Assert.assertEquals("3,0000 CAKE = 2,1177 FIL", os.toString());
    }

    @Test
    public void testFILtoCAKE() {
        PrintStream outBackup = System.out;
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        Converter converter = new Converter();
        converter.CAKE = 3.907143;
        converter.FIL = 5.718111;
        converter.FILtoCAKE(2.1);
        System.setOut(outBackup);
        Assert.assertEquals("2,1000 FIL = 3,0734 CAKE", os.toString());
    }
}
