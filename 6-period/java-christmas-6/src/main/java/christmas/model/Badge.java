package christmas.model;

public enum Badge {
    산타(20_000), 트리(10_000), 별(5_000), 없음(0);
    private final int price;

    Badge(int price) {
        this.price = price;
    }

    public static Badge valueOf(int price) {
        Badge[] values = Badge.values();
        for (Badge value : values) {
            if (value.price <= price) {
                return value;
            }
        }
        return 없음;
    }

    public int getPrice() {
        return price;
    }
}
