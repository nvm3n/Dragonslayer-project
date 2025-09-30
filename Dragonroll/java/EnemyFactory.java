package java;
import java.util.Random;

public class EnemyFactory {

    public static Enemy createRandomEnemy(int bossesDefeated) {
        double multiplier = 1.0 + bossesDefeated * 0.15; // Example scaling
        Random rand = new Random();
        Enemy randomEnemy = EnemyDatabase.BASE_ENEMIES[rand.nextInt(EnemyDatabase.BASE_ENEMIES.length)];
        // Return a new Enemy with scaled stats
        return new Enemy(
            randomEnemy.name,
            (int)(randomEnemy.baseHealth * multiplier),
            randomEnemy.baseAgility * multiplier,
            (int)(randomEnemy.basePower * multiplier),
            randomEnemy.attacks
        );
    }
}