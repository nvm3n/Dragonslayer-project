public class ConsumableDatabase {
    public static final Item[] BASE_CONSUMABLES = {
        // Example: new Consumable("Health Potion", Rarity.COMMON, 0, ...),
        // Add consumables here
    };

    public static Item findConsumableByName(String name) {
    for (Item consumable : BASE_CONSUMABLES) { // consumableList ist deine Consumable-Liste
        if (consumable.getName().equalsIgnoreCase(name)) {
            return consumable;
        }
    }
    return null;
}
}