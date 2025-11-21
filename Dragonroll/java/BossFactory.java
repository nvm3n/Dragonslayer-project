import java.util.Random;

public class BossFactory {

    public static Boss createRandomBoss(int bossesDefeated) {
        double multiplier = 1.0 + (bossesDefeated * 0.15);
        Random rand = new Random();
        Boss randomBoss = BossDatabase.BASE_BOSSES[rand.nextInt(BossDatabase.BASE_BOSSES.length)];
        // Return a new Boss with scaled stats
        return new Boss(
            randomBoss.name,
            (int)(randomBoss.baseHealth * multiplier),
            randomBoss.baseAgility * multiplier,
            (int)(randomBoss.basePower * multiplier),
            randomBoss.attacks
        );
    }
}
