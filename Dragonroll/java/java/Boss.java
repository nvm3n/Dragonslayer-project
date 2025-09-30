public class Boss extends Enemy {
    private int summoned = 0, phase = 1;

    public Boss(String name, int health, double agility, int power, Attack[] attacks) {
        super(name, health, agility, power, attacks);
    }
    // Methods for summoning, phase changes, etc.
}