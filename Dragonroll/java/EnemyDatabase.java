public class EnemyDatabase {
    public static final Enemy[] BASE_ENEMIES = {
        new Enemy("Goblin", 20, 8, 4, new Attack[] { new Attack("Slash", 4, false, 0) }),
        new Enemy("Orc", 30, 5, 7, new Attack[] { new Attack("Smash", 5, false, 0) }),
        // TODO: Add more enemies
    };
}