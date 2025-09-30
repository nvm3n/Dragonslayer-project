package java;
public abstract class Item {
    protected String name;
    protected Rarity rarity;
    protected double weight;
    public String getName() { return name; }
    public Rarity getRarity() { return rarity; }
    public double getWeight() { return weight; }
}