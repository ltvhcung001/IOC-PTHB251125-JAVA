public class CurrencyConverter {
    private static double rate;

    public static void setRate(double r){
        rate = r;
    }

    public static double getRate(){
        return rate;
    }

    public static double toUSD(int vnd){
        return vnd / rate;
    }

    public static String formatUSD(double usd, int decimalPlaces){
        return String.format("%." + decimalPlaces + "f", usd);
    }
}
