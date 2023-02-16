public class Converter {
    private final String fileCoin = "https://api.coincap.io/v2/assets/filecoin";
    private final String panCakeSwap = "https://api.coincap.io/v2/assets/pancakeswap";
    private final Parser parser = new Parser();
    Double CAKE = Double.parseDouble(parser.getRate(panCakeSwap));
    Double FIL = Double.parseDouble(parser.getRate(fileCoin));

    public void FILtoCAKE(double value) {
        double temp = FIL * value;
        double result = temp / CAKE;
        System.out.printf("%.4f FIL = %.4f CAKE", value, result);
    }
}
