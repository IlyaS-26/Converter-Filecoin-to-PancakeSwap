
public class Main {
    public static void main(String[] args) {
        if (!args[0].matches("[0-9]+(\\.[0-9]+)?") || !args[1].matches("CAKE|FIL")) {
            System.out.println("Введите корректную строку вида: число_(FIL|CAKE)");
        } else {
            double value;
            Converter converter = new Converter();
            value = Double.parseDouble(args[0]);
            if (args[1].matches("CAKE")) {
                converter.CAKEtoFIL(value);
            } else {
                converter.FILtoCAKE(value);
            }
        }
    }
}

