package java;
public class Player {
    private String name;
    private int health = 100, shield = 0, mana = 50;
    private double agility = 10, strength = 10, power = 10, defence = 5, intelligence = 10;
    private Inventory inventory = new Inventory();
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Player(String name) { this.name = name; }

    public void giveStartingItems(ClassType classType) {
        // Give items based on classType
    }

    public int getHealth() { return health; }
    public Inventory getInventory() { return inventory; }
    public void showStats() {
        // Print player stats
    }
    // Methods: attack, useItem, switchWeapon, etc.
}