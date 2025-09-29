public class WeaponDatabase {
    public static final Weapon[] BASE_WEAPONS = {
        new Weapon("Sword", Rarity.COMMON, 5.0, new Attack[] { new Attack("Slash", 8, false, 0) }, false),
        new Weapon("Magic Wand", Rarity.UNCOMMON, 3.0, new Attack[] { new Attack("Fireball", 12, true, 5) }, true),//yooooo magic wand???? thilo der ersteller?
        // Add more weapons here
    };
}