import java.util.ArrayList;

public class Inventory {
    private ArrayList<Weapon> weapon = new ArrayList<>();
    //private ArrayList<Consumable> consumable = new ArrayList<>();
    //private ArrayList<Wildcard> wildcard = new ArrayList<>();
    private ArrayList<Armor> armor = new ArrayList<>();

    public void showInventory() {
        System.out.println("\n--- Inventory ---");
        System.out.println("Weapons: " + (weapon.isEmpty() ? "None" : String.join(", ", getWeapons())));
        //System.out.println("Consumables: " + (consumable.isEmpty() ? "None" : String.join(", ", getConsumables())));
        //System.out.println("Wildcards: " + (wildcard.isEmpty() ? "None" : String.join(", ", getWildcards())));
        System.out.println("Armors: " + (armor.isEmpty() ? "None" : String.join(", ", getArmors())));
    }

    /*public void addRandomWeaponByRarity(Rarity pRarity) {
        Weapon[] weaponsRChoice = WeaponDatabase.findWeaponByRarity(pRarity);
         
    }*/
    
    public void addWeaponByName(String weaponName) {
    Weapon foundWeapon = WeaponDatabase.findWeaponByName(weaponName);
    if (foundWeapon != null) {
        this.weapon.add(foundWeapon);
    } else {
        System.out.println("Waffe mit Namen '" + weaponName + "' nicht gefunden.");
    }

    }

    /**public void addConsumable(String consumableName) {
    Consumable foundConsumable = ConsumableDatabase.findConsumableByName(consumableName);
    if (foundConsumable != null) {
        this.consumable.add(foundConsumable);
    } else {
        System.out.println("Consumable mit Namen '" + consumableName + "' nicht gefunden.");
    }
        
    }**/

    /**
    public void addWildcard(String wildcardName) {
    Wildcard foundWildcard = WildcardDatabase.findWildcardByName(wildcardName);
    if (foundWildcard != null) {
        this.wildcard.add(foundWildcard);
    } else {
        System.out.println("Wildcard mit Namen '" + wildcardName + "' nicht gefunden.");
    }

    }    **/

    public void addArmorByName(String armorName) {
    Armor foundArmor = ArmorDatabase.findArmorByName(armorName);
    if (foundArmor != null) {
        this.armor.add(foundArmor);
    } else {
        System.out.println("Rüstung mit Namen '" + armorName + "' nicht gefunden.");
    }
    }

    public void removeWeapon(Weapon weapon) {
        this.weapon.remove(weapon);
    }

    /**public void removeConsumables(Consumable consumable) {
        this.consumable.remove(consumable);
    }**/

    /**public void removeWildcard(Wildcard wildcard) {
        this.wildcard.remove(wildcard);
    }**/

    public void removeArmor(Armor armor) {
        this.armor.remove(armor);
    }

    public ArrayList<String> getWeapons() {
        ArrayList<String> weaponNames = new ArrayList<>();
        for (Weapon i : weapon) {
            weaponNames.add(i.getName());
        }
        return weaponNames;
    }
  
    /**public ArrayList<String> getConsumables() {
        ArrayList<String> consumableNames = new ArrayList<>();
        for (Consumable i : consumable) {
            consumableNames.add(i.getName());
        }
        return consumableNames;
    }**/

    /**public ArrayList<String> getWildcards() {
        ArrayList<String> wildcardNames = new ArrayList<>();
        for (Wildcard i : wildcard) {
            wildcardNames.add(i.getName());
        }
        return wildcardNames;
    }**/

    public ArrayList<String> getArmors() {
        ArrayList<String> armorNames = new ArrayList<>();
        for (Armor i : armor) {
            armorNames.add(i.getName());
        }
        return armorNames;
    }
}    