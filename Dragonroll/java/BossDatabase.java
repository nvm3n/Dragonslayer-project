public class BossDatabase {
    public static final Boss[] BASE_BOSSES = {
        new Boss("Dragon", 120, 12, 20, new Attack[] { new Attack("Fire Breath", 25, true, 0), new Attack("Dragon roar", 20, false, 0) }),
        new Boss("Alpha Wolf", 80, 16, 15, new Attack[] { new Attack("Boit", 20, false, 0), new Attack("dash attack", 30, true, 0) }),
        new Boss("Mermaid", 60, 20, 14, new Attack[] { new Attack("Water tornado", 40, true, 0), new Attack("Serenade", 25, false, 0) }),
        new Boss("Ice Golem", 150, 8, 20, new Attack[] { new Attack("Ice Hammer", 30, false, 0), new Attack("Ice Beam", 40, true, 0) }),
        new Boss("Basilisk", 100, 20, 15, new Attack[] { new Attack("Poison Bite", 30, true, 0), new Attack("Acid rain", 25, false, 0) }),
    };
}