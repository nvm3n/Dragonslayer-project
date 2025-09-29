import java.util.Random;
import java.util.Scanner;

public class FightPhase {
    private Player player;
    private Enemy enemy;
    private Scanner scanner;
    private Random rand = new Random();

    public FightPhase(Player player, Enemy enemy, Scanner scanner) {
        this.player = player;
        this.enemy = enemy;
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("\n--- Fight Phase ---");
        boolean fightOngoing = true;

        // Example: Both combatants start with full stats for this fight
        int playerHealth = player.getHealth();
        int enemyHealth = enemy.getHealth(1.0); // Pass multiplier if needed

        while (fightOngoing) {
            // Determine turn order (agility-based)
            boolean playerFirst = determineTurnOrder(player.getAgility(), enemy.getAgility(1.0));

            if (playerFirst) {
                fightOngoing = playerTurn();
                if (!fightOngoing) break;
                fightOngoing = enemyTurn();
            } else {
                fightOngoing = enemyTurn();
                if (!fightOngoing) break;
                fightOngoing = playerTurn();
            }
        }
    }

    private boolean determineTurnOrder(double playerAgility, double enemyAgility) {
        double total = playerAgility + enemyAgility;
        double roll = rand.nextDouble() * total;
        return roll < playerAgility;
    }

    private boolean playerTurn() {
        System.out.println("\nYour turn! Choose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Use Consumable");
        System.out.println("3. Switch Weapon");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                // TODO: Implement attack selection and execution
                System.out.println("You attack the enemy!");
                // Example: Check for dodge, calculate damage, apply to enemy
                break;
            case 2:
                // TODO: Implement consumable use
                System.out.println("You use a consumable (not yet implemented).");
                break;
            case 3:
                // TODO: Implement weapon switching
                System.out.println("You switch your weapon (not yet implemented).");
                break;
            default:
                System.out.println("Invalid choice, you lose your turn!");
        }
        // TODO: Check if enemy is defeated
        // Return false if fight should end
        return true;
    }

    private boolean enemyTurn() {
        System.out.println("\nEnemy's turn!");
        // TODO: Randomly select attack, check for dodge, calculate damage, apply to player
        System.out.println("The enemy attacks you!");
        // TODO: Check if player is defeated
        // Return false if fight should end
        return true;
    }
}