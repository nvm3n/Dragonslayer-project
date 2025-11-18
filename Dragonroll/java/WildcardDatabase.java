public class WildcardDatabase {
    public static final Item[] BASE_WILDCARDS = {
    };

    public static Item findWildcardByName(String name) {
    for (Item w : BASE_WILDCARDS) { // wildcardList ist deine Wildcard-Liste //woaaaaas
        if (w.getName().equalsIgnoreCase(name)) {
            return w;
        }
    }
    return null;
}
}