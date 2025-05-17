package machine;

public enum Recipe {
    ESPRESSO   (250, 0,   16, 4),
    LATTE      (350, 75,  20, 7),
    CAPPUCCINO (200, 100, 12, 6);

    public final int water;
    public final int milk;
    public final int beans;
    public final int price;

    Recipe(int water, int milk, int beans, int price) {
        this.water = water;
        this.milk  = milk;
        this.beans = beans;
        this.price = price;
    }
}
