public class Attack {
    private String name;
    private int basePower, manaCost;
    private boolean isMagic;

    public Attack(String name, int basePower, boolean isMagic, int manaCost) {
        this.name = name;
        this.basePower = basePower;
        this.isMagic = isMagic;
        this.manaCost = manaCost;
    }

    public String getName() { return name; }
    public int getBaseStrength() { return basePower; }
    public boolean isMagic() { return isMagic; }
    public int getManaCost() { return manaCost; }
}