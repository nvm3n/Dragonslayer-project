public class EnemyDatabase {
    public static final Enemy[] BASE_ENEMIES = {
        new Enemy("Goblin", 30, 8, 6, new Attack[] { new Attack("Slash", 8, false, 0) }),
        new Enemy("Orc", 50, 5, 10, new Attack[] { new Attack("Smash", 12, false, 0) }),
        // TODO: Add more enemies
    };
}