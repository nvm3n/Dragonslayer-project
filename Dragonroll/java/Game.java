import java.util.Scanner;

public class Game {
    private Player player;
    private int bossesDefeated = 0;
    private boolean running = true;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Dragonroll!");
        while (running) {
            setupPlayer();
            mainMenu();
        }
    }

    private void setupPlayer() {
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine().trim();
        }
        player = new Player(name);
        chooseClass();
    }

    private void chooseClass() {
        System.out.println("\nChoose your class:");
        System.out.println("1. Warrior (Sword, Leather Armor)");
        System.out.println("2. Mage (Magic Wand, Mage Robe)"); //thilo der ersteller ruft an
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        switch (choice) {
            case 1: player.giveStartingItems(ClassType.WARRIOR); break;
            case 2: player.giveStartingItems(ClassType.MAGE); break;
            default: System.out.println("Invalid choice, defaulting to Warrior.");
                     player.giveStartingItems(ClassType.WARRIOR);
        }
    }

    private void mainMenu() {
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Continue");
            System.out.println("2. View Inventory");
            System.out.println("3. View Stats");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    startFight();
                    if (player.getHealth() <= 0) {
                        gameOver();
                        return;
                    }
                    break;
                case 2: player.getInventory().showInventory(); break;
                case 3: player.showStats(); break;
                case 4: running = false; System.out.println("Thanks for playing!"); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private void startFight() {
        Enemy enemy = EnemyFactory.createRandomEnemy(bossesDefeated);
        System.out.println("\nA wild " + enemy.getName() + " appears!");
        FightPhase fight = new FightPhase(player, enemy, scanner);
        fight.run();
        if (enemy instanceof Boss && enemy.getHealth() <= 0) {
            bossesDefeated++;
            // Give wildcard reward, etc.
        }
    }

    private void gameOver() {
        System.out.println("\n--- GAME OVER ---");
        System.out.println("Restarting game...\n");
    }

    public static void main(String[] args) {
        new Game().start();
    }
}


//TODO: shops, saving/loading