public class ArmorDatabase {
    public static final Armor[] BASE_ARMORS = {
        new Armor("Leather Armor", Rarity.COMMON, 4.0),
        new Armor("Mage Robe", Rarity.UNCOMMON, 2.0),
        // Add more armor here
    };

    public static Armor findArmorByName(String name) {
    for (Armor armor : BASE_ARMORS) { // armorList ist deine Liste mit allen Rüstungen
        if (armor.getName().equalsIgnoreCase(name)) {
            return armor;
        }
    }
    return null;
}
}