public class Player {
    private final String name;
    private final int health = 100;
    private int shield = 0, mana = 50;
    private double agility = 10, strength = 10, power = 10, defence = 5, intelligence = 10;
    private Inventory inventory = new Inventory();
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Player(String name) { 
        this.name = name; 
    }

    public void giveStartingItems(ClassType classType) {
        switch (classType) {
            case WARRIOR: Inventory.addWeapon("Sword"); break;
            case MAGE: Inventory.addWeapon("Magic Wand"); break;
        }
    }

    public int getHealth() { return health; }
    public Inventory getInventory() { return inventory; }
    public void showStats() {
        // Print player stats
    }
    // Methods: attack, useItem, switchWeapon, etc.
}