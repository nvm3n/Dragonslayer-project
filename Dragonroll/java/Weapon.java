package java;
public class Weapon extends Item {
    private Attack[] attacks;
    private boolean isMagic;
    public Weapon(String name, Rarity rarity, double weight, Attack[] attacks, boolean isMagic) {
        this.name = name;
        this.rarity = rarity;
        this.weight = weight;
        this.attacks = attacks;
        this.isMagic = isMagic;
    }
    // Getters
}