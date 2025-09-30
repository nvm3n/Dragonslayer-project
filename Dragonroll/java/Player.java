public class Player {
    private String name;
    private int health = 100, shield = 0, maxMana = 50, mana = 50;
    private double agility = 10, strength = 10, power = 10, defence = 5, intelligence = 10;
    private Inventory inventory = new Inventory();
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Player(String name) { this.name = name; }

    public void giveStartingItems(ClassType classType) {
        switch (classType) {
            case WARRIOR: inventory.addWeapon("Sword"); break;
            case MAGE: inventory.addWeapon("Magic Wand"); break;
        }
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
        System.out.println("\n--- Player Stats ---");
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Mana: " + mana + "/" + maxMana);
        System.out.println("Agility: " + agility);
        System.out.println("Strength: " + strength);
        System.out.println("Power: " + power);
        System.out.println("Defence: " + defence);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Equipped Weapon: " + (equippedWeapon != null ? equippedWeapon.getName() : "None"));
        System.out.println("Equipped Armor: " + (equippedArmor != null ? equippedArmor.getName() : "None"));
    }
    // Methods: attack, useItem, switchWeapon, etc.

    
}

//TODO: WEAPON EQUIPPING!!!!!!!!