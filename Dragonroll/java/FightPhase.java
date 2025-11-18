import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class FightPhase {
    private Player player;
    private Enemy enemy;
    private Scanner scanner;
    private Random rand = new Random();
    private double damageCalcMultiplier = 0.1;

    public FightPhase(Player player, Enemy enemy, Scanner scanner) {
        this.player = player;
        this.enemy = enemy;
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("\n--- Fight Phase ---");
        boolean fightOngoing = true;

        int playerHealth = player.getHealth();
        int enemyHealth = enemy.getHealth();

        while (fightOngoing) {
            // Determine turn order (agility-based)
            boolean playerFirst = determineTurnOrder(player.getAgility(), enemy.getAgility());

            if (playerFirst) {
                System.out.println("Du fängst zuerst an!");
                fightOngoing = playerTurn();
                if (!fightOngoing) break;
                fightOngoing = enemyTurn();
            } else {
                System.out.println("Der Gegner fängt zuerst an!");
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
        if (player.getMana() < player.getMaxMana())
        {
            player.regenMana();
            System.out.println("You regenerated some mana. Current mana: " + player.getMana() + "/" + player.getMaxMana());
        }
        player.regenMana();
        System.out.println("\nYour turn! Choose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Use Consumable");
        System.out.println("3. Switch Weapon");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                // Attack selection
                Weapon weapon = player.getEquippedWeapon();
                Attack[] attacks = weapon.getAttacks();
                System.out.println("Choose your attack:");
                for (int i = 0; i < attacks.length; i++) {
                    if (attacks[i].isMagic() && player.getMana() < attacks[i].getManaCost()) {
                        System.out.println((i + 1) + ". " + attacks[i].getName() + " (Not enough mana)");
                    } else
                    System.out.println((i + 1) + ". " + attacks[i].getName());
                }
                int attackChoice = scanner.nextInt() - 1;
                scanner.nextLine();
                Attack chosenAttack = attacks[attackChoice];

                // Dodge check
                double dodgeChance = Math.min(0.05, enemy.getAgility() / 100); // Example formula
                if (rand.nextDouble() < dodgeChance) {
                    System.out.println("Enemy dodged your attack!");
                    break;
                }

                // Damage calculation
                int damage = chosenAttack.getBaseStrength();
                if (chosenAttack.isMagic()) {
                    damage = (int)(damage * damageCalcMultiplier * player.getIntelligence());
                    player.drainMana(chosenAttack.getManaCost());
                } else {
                    damage = (int)(damage * damageCalcMultiplier * player.getPower());
                }
                enemy.dealDamage(damage);
                System.out.println("You dealt " + damage + " damage!");
                System.out.println("You have " + player.getHealth() + " health!");
                System.out.println("The enemy has " + enemy.getHealth() + " health!");

                // Check if enemy is defeated
                if (enemy.getHealth() <= 0) {
                    System.out.println("Enemy defeated!");
                    return false;
                    //TODO: IMPORTANT!!! LOOT SYSTEM
                }
                break;
            /*case 2:
                // TODO: Implement consumable use
                System.out.println("You use a consumable (not yet implemented).");
                break;*/
            case 3:
                ArrayList<String> weapons = player.getInventory().getWeapons();
                if (weapons.size() <= 1){
                    System.out.println("You have no other weapons to switch to.");

                    break;
                }
                System.out.println("Choose a weapon to equip: " + weapons);
                String inputWeapon = scanner.nextLine();
                if (weapons.contains(inputWeapon)){
                    player.equipWeapon(inputWeapon);
                    System.out.println("Equipped " + inputWeapon + ".");
                } else {
                    System.out.println("Invalid selection, choose a valid weapon!");
                }
                break;
                
            default:
                System.out.println("Invalid choice, you lose your turn!");
        }
        return true;
    }

    private boolean enemyTurn() {
        System.out.println("\nEnemy's turn!");
        // Randomly select attack
        Attack[] attacks = enemy.getAttacks();
        int attackIndex = rand.nextInt(attacks.length);
        Attack chosenAttack = attacks[attackIndex];
        System.out.println("Enemy uses " + chosenAttack.getName() + "!");

        // Dodge check
        double dodgeChance = Math.min(0.05, player.getAgility() / 1000); // Example formula
        if (rand.nextDouble() < dodgeChance) {
            System.out.println("You dodged the attack!");
            return true;
        }

        // Damage calculation
        // Formula: (BaseStrength * EnemyPower * Multiplier) - (Defence * Multiplier)
        int damage = (int)(((chosenAttack.getBaseStrength() * enemy.getPower()) - (player.getDefence())) * damageCalcMultiplier);
        if (damage < 1) damage = 1;
        player.dealDamage(damage);
        System.out.println("You took " + damage + " damage!");
        System.out.println("You have " + player.getHealth() + " health!");
        System.out.println("The enemy has " + enemy.getHealth() + " health!");

        // Check if player is defeated
        if (player.getHealth() <= 0) {
            System.out.println("You were defeated!");
            return false;
        }
        return true;
    }
}