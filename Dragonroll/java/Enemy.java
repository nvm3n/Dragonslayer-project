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

    public void dealDamage(int damage) {
        this.baseHealth -= damage;
        if (this.baseHealth < 0) this.baseHealth = 0;
    }

    public int getHealth() { return (int)(baseHealth); }
    public double getAgility() { return baseAgility; }
    public int getPower() { return (int)(basePower); }
    public Attack[] getAttacks() { return attacks; }
    public String getName() { return name; }
    // Other combat methods
}