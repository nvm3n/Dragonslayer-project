public class Enemy {
    protected String name;
    protected int baseHealth, basePower;
    protected double baseAgility;
    protected Attack[] attacks;

    public Enemy(String name, int health, double agility, int power, Attack[] attacks) {
        this.name = name;
        this.baseHealth = health;
        this.baseAgility = agility;
        this.basePower = power;
        this.attacks = attacks;
    }

    public int getHealth(double multiplier) { return (int)(baseHealth * multiplier); }
    public double getAgility(double multiplier) { return baseAgility * multiplier; }
    public int getPower(double multiplier) { return (int)(basePower * multiplier); }
    public String getName() { return name; }
    // Other combat methods
}