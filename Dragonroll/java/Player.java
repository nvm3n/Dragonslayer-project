public class Player {
    private String name;
    private int health = 100, shield = 0, maxMana = 50, mana = 50;
    private double agility = 10, strength = 10, power = 10, defence = 5, intelligence = 10;
    private Inventory inventory = new Inventory();
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Player(String name) { this.name = name; }

    public void giveStartingItems(ClassType classType) {
        // Give items based on classType
    }

    public void dealDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public void regenMana() {
        mana += (intelligence * 0.5);
    }

    public void drainMana(int amount) {
        mana -= (amount / (intelligence * 0.1));
    }

    public int getHealth() { return health; }
    public double getAgility() { return agility; }
    public double getPower() { return power; }
    public double getIntelligence() { return intelligence; }
    public double getDefence() { return defence; }
    public Weapon getEquippedWeapon() { return equippedWeapon; }
    public Inventory getInventory() { return inventory; }
    public int getMana() { return mana; }
    public int getMaxMana() { return maxMana; }

    public void showStats() {
        // Print player stats
    }
    // Methods: attack, useItem, switchWeapon, etc.

    
}