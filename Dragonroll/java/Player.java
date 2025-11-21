public class Player {
    private String name;
    private int health = 100, shield = 0, maxMana = 50, mana = 50;
    private double agility = 13, strength = 14, power = 13, defence = 7, intelligence = 15;
    private Inventory inventory = new Inventory();
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Player(String name) { this.name = name; }

    public void giveStartingItems(ClassType classType) {
        switch (classType) {
            case WARRIOR: inventory.addWeaponByName("Sword"); inventory.addArmorByName("Leather Armor"); equipWeapon("Sword"); equipArmor("Leather Armor");break;
            case MAGE: inventory.addWeaponByName("Magic Wand"); inventory.addArmorByName("Mage Robe"); equipWeapon("Magic Wand"); equipArmor("Mage Robe");break;
        }
    }


    public void dealDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public void regenMana() {
        mana += (intelligence * 0.5);
        if (mana > maxMana) {
            mana = maxMana;
        }
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

    public Weapon getequippedWeapon() { return equippedWeapon; }
    public Armor getequippedArmor() { return equippedArmor; }
    public void setWeapon(Weapon EQ) { equippedWeapon = EQ; }
    public void setArmor(Armor EA) { equippedArmor = EA; }

    // Equipment methods - allows equipping weapons and armor from inventory
    public boolean equipWeapon(String weaponName) {
        // Search for weapon in inventory
        for (String invWeaponName : inventory.getWeapons()) {
            if (invWeaponName.equalsIgnoreCase(weaponName)) {
                // Find the actual Weapon object from the database
                Weapon weaponToEquip = WeaponDatabase.findWeaponByName(weaponName);
                if (weaponToEquip != null) {
                    // Unequip current weapon if one is equipped
                    if (equippedWeapon != null) {
                        System.out.println("Unequipping: " + equippedWeapon.getName()); 
                    }
                    // Equip new weapon
                    equippedWeapon = weaponToEquip;
                    System.out.println("Equipped weapon: " + equippedWeapon.getName());
                    return true;
                }
            }
        }
        System.out.println("Weapon '" + weaponName + "' not found in inventory!");
        return false;
    }

    public boolean equipArmor(String armorName) {
        // Search for armor in inventory
        for (String invArmorName : inventory.getArmors()) {
            if (invArmorName.equalsIgnoreCase(armorName)) {
                // Find the actual Armor object from the database
                Armor armorToEquip = ArmorDatabase.findArmorByName(armorName);
                if (armorToEquip != null) {
                    // Unequip current armor if one is equipped
                    if (equippedArmor != null) {
                        System.out.println("Unequipping: " + equippedArmor.getName());
                    }
                    // Equip new armor
                    equippedArmor = armorToEquip;
                    System.out.println("Equipped armor: " + equippedArmor.getName());
                    return true;
                }
            }
        }
        System.out.println("Armor '" + armorName + "' not found in inventory!");
        return false;
    }

}