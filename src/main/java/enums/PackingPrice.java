package enums;

public enum PackingPrice {

    BIG_POUCH(1.81, "Große Verandtasche"),
    TINY_POUCH(1.71, "Kleine Verandtasche"),
    BIG_KARTON_5KG(7.22, "Großer Karton bis 5kg"),
    BIG_KARTON_2KG(5.72, "Großer Karton bis 2kg"),
    MIDDLE_KARTON_5KG(7.17, "Mittlerer Karton bis 5kg"),
    MIDDLE_KARTON_2KG(5.67, "Mittlerer Karton bis 2kg"),
    TINY_KARTON_5KG(7.12, "Kleiner Karton bis 5kg"),
    TINY_KARTON_2KG(5.62, "Kleiner Karton bis 2kg"),
    MIDDLE_KARTON_2KG_AGE_VERIFICATION(6.86, "Mittlerer Karton mit Alterssichtprüfung");

    double price;
    String name;

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
