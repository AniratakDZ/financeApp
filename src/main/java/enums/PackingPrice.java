package enums;

public enum PackingPrice {

    KLEINE_VERSANDTASCHE_NATIONAL(4.08, "Kleine Versandtasche National"),
    KLEINE_VERSANDTASCHE_INTERNATIONAL(7.33, "Kleine Versandtasche International"),
    GROSSE_VERSANDTASCHE_ALS_GROSSBRIEF_NATIONAL(4.18, "Große Versandtasche als Grossbrief National"),
    GROSSE_VERSANDTASCHE_ALS_GROSSBRIEF_INTERNATINAL(7.43, "Große Versandtasche als Grossbrief International"),
    GROSSE_VERSANDTASCHE_ALS_MAXIBRIEF_NATIONAL(5.33, "Große Versandtasche als Maxibrief National"),
    GROSSE_VERSANDTASCHE_ALS_MAXIBRIEF_INTERNATIONAL(10.73, "Große Versandtasche als Maxibrief International"),
    PAKET_2KG_NATIONAL(6.54, "2kg Paket National"),
    PAKET_2KG_INTERNATIONAL(15.04, "2kg Paket International"),
    PAKET_5KG_NATIONAL(8.04, "5kg Paket National"),
    PAKET_5KG_INTERNATIONAL(17.04, "5kg Paket International"),
    PAKET_10KG_NATIONAL(10.54, "10kg Paket National"),
    PAKET_10KG_INTERNATIONAL(22.04, "10kg Paket International");

    final double price;
    final String name;

    PackingPrice(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
