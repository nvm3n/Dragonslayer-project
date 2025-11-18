public class ConsumableDatabase {
    public static final Item[] BASE_CONSUMABLES = {
    };

    public static Item findConsumableByName(String name) {
    for (Item consumable : BASE_CONSUMABLES) { // consumableList ist deine Consumable-Liste //danke diggi
        if (consumable.getName().equalsIgnoreCase(name)) {
            return consumable;
        }
    }
    return null;
}
}