package data.databases;

import data.dataobjects.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDatabase {

    private static ItemDatabase itemDatabase;

    private List<Item> items = new ArrayList<>();

    private ItemDatabase() {
        addItems();
    }

    private void addItems() {
        //Special case. Coins can't be alched so value is so Ironmen perceive it as value of 1
        items.add(new Item("Coins", 4));

        items.add(new Item("Bones", 1));
        items.add(new Item("Wolf bones", 1));
        items.add(new Item("Bat bones", 1));
        items.add(new Item("Pouch", 1));
        items.add(new Item("Cowhide", 1));
        items.add(new Item("Leather", 1));
        items.add(new Item("Empty pot", 1));
        items.add(new Item("Teasing stick", 1));
        items.add(new Item("Tinderbox", 1));
        items.add(new Item("Mort myre stem", 1));
        items.add(new Item("Fiyr remains", 1));
        items.add(new Item("Wine of Zamorak", 1));
        items.add(new Item("Potato cactus", 1));
        items.add(new Item("Mithril grapple", 1));
        items.add(new Item("Muddy key", 1));
        items.add(new Item("Jogre bones", 1));
        items.add(new Item("Headless arrow", 1));
        items.add(new Item("Jug of water", 1));
        items.add(new Item("Trading sticks", 1));
        items.add(new Item("Loar remains", 1));
        items.add(new Item("Empty sack", 1));
        items.add(new Item("Fishbowl", 1));
        items.add(new Item("Swamp tar", 1));
        items.add(new Item("Pineapple chunks", 1));
        items.add(new Item("Granite (500g)", 1));
        items.add(new Item("Granite (5kg)", 1));
        items.add(new Item("Sandstone (10kg)", 1));
        items.add(new Item("Sandstone (2kg)", 1));
        items.add(new Item("Plant pot", 1));
        items.add(new Item("Wooden cat", 1));
        items.add(new Item("Needle", 1));
        items.add(new Item("Hard leather", 1));
        items.add(new Item("Dragon bones", 1));
        items.add(new Item("Bucket", 2));
        items.add(new Item("Bucket of sand", 2));
        items.add(new Item("Wizard hat (blue)", 2));
        items.add(new Item("Soda ash", 2));
        items.add(new Item("Wizard robe skirt", 2));
        items.add(new Item("Toad crunchies", 2));
        items.add(new Item("Wheat", 2));
        items.add(new Item("Soft clay", 2));
        items.add(new Item("Searing ashes", 2));
        items.add(new Item("Cider", 2));
        items.add(new Item("Willow branch", 2));
        items.add(new Item("Raw ugthanki meat", 2));
        items.add(new Item("Seaweed", 2));
        items.add(new Item("Ashes", 2));
        items.add(new Item("Bowl (unfired)", 2));
        items.add(new Item("Wizard's mind bomb", 2));
        items.add(new Item("Banana", 2));
        items.add(new Item("Dragon bitter", 2));
        items.add(new Item("Greenman's ale", 2));
        items.add(new Item("Beer", 2));
        items.add(new Item("Black wizard hat", 2));
        items.add(new Item("Eye of newt", 3));
        items.add(new Item("Molten glass", 3));
        items.add(new Item("Pie dish", 3));
        items.add(new Item("Garlic", 3));
        items.add(new Item("Fishing bait", 3));
        items.add(new Item("Spade", 3));
        items.add(new Item("Redberries", 3));
        items.add(new Item("Chopped onion", 3));
        items.add(new Item("Candle", 3));
        items.add(new Item("Air talisman", 4));
        items.add(new Item("Dwellberries", 4));
        items.add(new Item("Egg", 4));
        items.add(new Item("Logs", 4));
        items.add(new Item("Nature talisman", 4));
        items.add(new Item("Earth talisman", 4));
        items.add(new Item("Death talisman", 4));
        items.add(new Item("Water talisman", 4));
        items.add(new Item("Pure essence", 4));
        items.add(new Item("Mind talisman", 4));
        items.add(new Item("Fire talisman", 4));
        items.add(new Item("Thread", 4));
        items.add(new Item("Bowl", 4));
        items.add(new Item("Achey tree logs", 4));
        items.add(new Item("Unlit torch", 4));
        items.add(new Item("Bowl of water", 4));
        items.add(new Item("Shrimps", 5));
        items.add(new Item("Crayfish", 5));
        items.add(new Item("Raw crayfish", 5));
        items.add(new Item("Ball of wool", 5));
        items.add(new Item("Secateurs", 5));
        items.add(new Item("Vial", 5));
        items.add(new Item("Clean marrentill", 5));
        items.add(new Item("Vodka", 5));
        items.add(new Item("Fishing rod", 5));
        items.add(new Item("Flax", 5));
        items.add(new Item("Feather", 6));
        items.add(new Item("Raw shrimps", 6));
        items.add(new Item("Blue dye", 6));
        items.add(new Item("Red dye", 6));
        items.add(new Item("Yellow dye", 6));
        items.add(new Item("Orange dye", 6));
        items.add(new Item("Leather boots", 6));
        items.add(new Item("Pale energy", 6));
        items.add(new Item("Uncooked berry pie", 6));
        items.add(new Item("Bucket of water", 6));
        items.add(new Item("Acorn", 6));
        items.add(new Item("Bird snare", 6));
        items.add(new Item("Leather gloves", 6));
        items.add(new Item("Bronze arrow", 7));
        items.add(new Item("Bronze nails", 7));
        items.add(new Item("Red spiders' eggs", 7));
        items.add(new Item("Limpwurt root", 7));
        items.add(new Item("Bronze bar", 8));
        items.add(new Item("Cheese", 8));
        items.add(new Item("Potato seed", 8));
        items.add(new Item("Sweetcorn seed", 8));
        items.add(new Item("Pyre logs", 8));
        items.add(new Item("Watering can", 8));
        items.add(new Item("Raw sardine", 10));
        items.add(new Item("Sardine", 10));
        items.add(new Item("Snape grass", 10));
        items.add(new Item("Bowl of hot water", 10));
        items.add(new Item("Bear fur", 10));
        items.add(new Item("Strip of cloth", 10));
        items.add(new Item("Limestone", 10));
        items.add(new Item("Vial of water", 10));
        items.add(new Item("Bag of salt", 10));
        items.add(new Item("White berries", 10));
        items.add(new Item("Cup of tea", 10));
        items.add(new Item("Papyrus", 10));
        items.add(new Item("Onion seed", 10));
        items.add(new Item("Cake tin", 10));
        items.add(new Item("Clean tarromin", 11));
        items.add(new Item("Bucket of milk", 12));
        items.add(new Item("Cooked chicken", 12));
        items.add(new Item("Limpwurt seed", 12));
        items.add(new Item("Arrow shaft", 12));
        items.add(new Item("Onion", 12));
        items.add(new Item("Apple tree seed", 13));
        items.add(new Item("Hammer", 13));
        items.add(new Item("Tomato", 14));
        items.add(new Item("Chisel", 14));
        items.add(new Item("Staff", 15));
        items.add(new Item("Waterskin (0)", 15));
        items.add(new Item("Wizard robe top", 15));
        items.add(new Item("Raw cave eel", 15));
        items.add(new Item("Raw potato", 16));
        items.add(new Item("Bronze hatchet", 16));
        items.add(new Item("Raw anchovies", 16));
        items.add(new Item("Air rune", 17));
        items.add(new Item("Earth rune", 17));
        items.add(new Item("Mind rune", 17));
        items.add(new Item("Water rune", 17));
        items.add(new Item("Fire rune", 17));
        items.add(new Item("Iron ore", 17));
        items.add(new Item("Strawberry", 17));
        items.add(new Item("Leather vambraces", 18));
        items.add(new Item("Rope", 18));
        items.add(new Item("Mithril nails", 18));
        items.add(new Item("Cooked rabbit", 19));
        items.add(new Item("Leather chaps", 20));
        items.add(new Item("Chargebow", 20));
        items.add(new Item("Chocolate dust", 20));
        items.add(new Item("Copper ore", 20));
        items.add(new Item("Tin ore", 20));
        items.add(new Item("Unicorn horn", 20));
        items.add(new Item("Unicorn horn dust", 20));
        items.add(new Item("Clean harralander", 20));
        items.add(new Item("Poison chalice", 20));
        items.add(new Item("Chocolate bar", 20));
        items.add(new Item("Uncut opal", 20));
        items.add(new Item("Cape (black)", 20));
        items.add(new Item("Stripy feather", 20));
        items.add(new Item("Lockpick", 20));
        items.add(new Item("Mud rune", 20));
        items.add(new Item("Oak logs", 20));
        items.add(new Item("Bronze wire", 20));
        items.add(new Item("Crayfish cage", 20));
        items.add(new Item("Desert boots", 20));
        items.add(new Item("Compost", 20));
        items.add(new Item("Harralander potion (unf)", 20));
        items.add(new Item("Leather body", 21));
        items.add(new Item("Leather cowl", 24));
        items.add(new Item("Bronze helm", 24));
        items.add(new Item("Bread", 24));
        items.add(new Item("Spirit shards", 25));
        items.add(new Item("Archery ticket", 25));
        items.add(new Item("Ranarr potion (unf)", 25));
        items.add(new Item("Spider on stick (raw)", 25));
        items.add(new Item("Cabbage seed", 25));
        items.add(new Item("Knife", 25));
        items.add(new Item("Bronze sword", 26));
        items.add(new Item("Raw mackerel", 26));
        items.add(new Item("Bronze spear", 26));
        items.add(new Item("Iron bar", 28));
        items.add(new Item("Cooked meat", 30));
        items.add(new Item("Clean guam", 30));
        items.add(new Item("Grimy guam", 30));
        items.add(new Item("Waterskin (4)", 30));
        items.add(new Item("Fruit Blast", 30));
        items.add(new Item("Gold seal", 30));
        items.add(new Item("Swamp paste", 31));
        items.add(new Item("Raw cod", 34));
        items.add(new Item("Arctic pine logs", 35));
        items.add(new Item("Cooked oomlie wrap", 35));
        items.add(new Item("Cooking apple", 36));
        items.add(new Item("Box trap", 38));
        items.add(new Item("Raw rat meat", 39));
        items.add(new Item("Plant cure", 40));
        items.add(new Item("Desert robe", 40));
        items.add(new Item("Desert shirt", 40));
        items.add(new Item("Willow logs", 40));
        items.add(new Item("Small fishing net", 40));
        items.add(new Item("Clean irit", 40));
        items.add(new Item("Coal", 45));
        items.add(new Item("Charcoal", 45));
        items.add(new Item("Bronze sq shield", 48));
        items.add(new Item("Watermelon", 48));
        items.add(new Item("Shortbow", 50));
        items.add(new Item("Mahogany logs", 50));
        items.add(new Item("Caviar", 50));
        items.add(new Item("Broad arrowheads", 50));
        items.add(new Item("Meat pizza", 50));
        items.add(new Item("Casket", 50));
        items.add(new Item("Bronze battleaxe", 52));
        items.add(new Item("Steel nails", 52));
        items.add(new Item("Silk", 55));
        items.add(new Item("Clay ring (unfired)", 55));
        items.add(new Item("Watermelon seed", 56));
        items.add(new Item("Raw beef", 59));
        items.add(new Item("Raw chicken", 60));
        items.add(new Item("Bronze chainbody", 60));
        items.add(new Item("Thin snail", 60));
        items.add(new Item("Sacred oil (1)", 60));
        items.add(new Item("Fellstalk seed", 64));
        items.add(new Item("Bloodweed seed", 64));
        items.add(new Item("Leather shield", 68));
        items.add(new Item("Clean dwarf weed", 70));
        items.add(new Item("Chocolate cake", 70));
        items.add(new Item("Lantern lens", 70));
        items.add(new Item("Tatty larupia fur", 72));
        items.add(new Item("Silver ore", 75));
        items.add(new Item("H.a.m. hood", 75));
        items.add(new Item("H.a.m. shirt", 75));
        items.add(new Item("H.a.m. robe", 75));
        items.add(new Item("H.a.m. gloves", 75));
        items.add(new Item("H.a.m. boots", 75));
        items.add(new Item("H.a.m. cloak", 75));
        items.add(new Item("H.a.m. logo", 75));
        items.add(new Item("Shieldbow", 80));
        items.add(new Item("Bronze platelegs", 80));
        items.add(new Item("Bronze plateskirt", 80));
        items.add(new Item("Bronze 2h sword", 80));
        items.add(new Item("Maple logs", 80));
        items.add(new Item("Bacon mound", 80));
        items.add(new Item("Iron helm", 84));
        items.add(new Item("Marigold seed", 84));
        items.add(new Item("Raw chompy", 85));
        items.add(new Item("Acadia logs", 85));
        items.add(new Item("Morchella mushroom spore", 86));
        items.add(new Item("Bittercap mushroom spore", 86));
        items.add(new Item("Jute seed", 86));
        items.add(new Item("Restore potion (3)", 88));
        items.add(new Item("Salmon", 88));
        items.add(new Item("Iron spear", 91));
        items.add(new Item("Cactus seed", 99));
        items.add(new Item("Hard leather cowl", 100));
        items.add(new Item("Wizard gloves", 100));
        items.add(new Item("Wizard boots", 100));
        items.add(new Item("Wizard shield", 100));
        items.add(new Item("Imphide gloves", 100));
        items.add(new Item("Imphide boots", 100));
        items.add(new Item("Death tiara", 100));
        items.add(new Item("Bowstring", 100));
        items.add(new Item("Plank", 100));
        items.add(new Item("Unpowered orb", 100));
        items.add(new Item("Teak pyre logs", 100));
        items.add(new Item("Steel bar", 100));
        items.add(new Item("Tiara", 100));
        items.add(new Item("Living minerals", 100));
        items.add(new Item("Giant frog legs", 100));
        items.add(new Item("Opal", 100));
        items.add(new Item("Earth tiara", 100));
        items.add(new Item("Pirate bandana (white)", 100));
        items.add(new Item("Chaos rune", 101));
        items.add(new Item("Papaya tree seed", 115));
        items.add(new Item("Tuna", 120));
        items.add(new Item("Steel dagger", 125));
        items.add(new Item("Eucalyptus logs", 126));
        items.add(new Item("Jug of wine", 128));
        items.add(new Item("Yew seed", 143));
        items.add(new Item("Redberry pie", 150));
        items.add(new Item("Silver bar", 150));
        items.add(new Item("Blamish myre shell (round)", 150));
        items.add(new Item("Jade", 150));
        items.add(new Item("Iron crossbow", 157));
        items.add(new Item("Bronze platebody", 160));
        items.add(new Item("Oak shieldbow", 160));
        items.add(new Item("Yew logs", 160));
        items.add(new Item("Poison ivy seed", 166));
        items.add(new Item("Iron sq shield", 168));
        items.add(new Item("Hard leather body", 170));
        items.add(new Item("Hard leather chaps", 170));
        items.add(new Item("Silver sickle", 175));
        items.add(new Item("Iron battleaxe", 182));
        items.add(new Item("Wild pie", 182));
        items.add(new Item("Hard leather gloves", 200));
        items.add(new Item("Hard leather boots", 200));
        items.add(new Item("Magic staff", 200));
        items.add(new Item("Agility potion (4)", 200));
        items.add(new Item("Black salamander", 200));
        items.add(new Item("Grenwall spikes", 200));
        items.add(new Item("Gout tuber", 200));
        items.add(new Item("Silver dust", 200));
        items.add(new Item("Face mask", 200));
        items.add(new Item("Red topaz", 200));
        items.add(new Item("Insulated boots", 200));
        items.add(new Item("Earmuffs", 200));
        items.add(new Item("Iron chainbody", 210));
        items.add(new Item("Super ranging potion (2)", 216));
        items.add(new Item("Astral rune", 220));
        items.add(new Item("Steel mace", 225));
        items.add(new Item("Spice", 230));
        items.add(new Item("Cosmic rune", 232));
        items.add(new Item("Hard leather shield", 238));
        items.add(new Item("Sapphire", 250));
        items.add(new Item("Oak plank", 250));
        items.add(new Item("Super defence (3)", 264));
        items.add(new Item("Antifire (3)", 264));
        items.add(new Item("Dashing kebbit fur", 270));
        items.add(new Item("Bass", 270));
        items.add(new Item("Iron platelegs", 280));
        items.add(new Item("Iron plateskirt", 280));
        items.add(new Item("Iron 2h sword", 280));
        items.add(new Item("Raw bass", 280));
        items.add(new Item("Raw lobster", 284));
        items.add(new Item("Gold bar", 300));
        items.add(new Item("Mithril seeds", 300));
        items.add(new Item("Mithril bar", 300));
        items.add(new Item("Raw shark", 300));
        items.add(new Item("Saradomin arrows", 300));
        items.add(new Item("Pirate shirt (white)", 300));
        items.add(new Item("Holy symbol", 300));
        items.add(new Item("Death rune", 310));
        items.add(new Item("Magic logs", 320));
        items.add(new Item("Steel sword", 325));
        items.add(new Item("Raw swordfish", 340));
        items.add(new Item("Gold ring", 350));
        items.add(new Item("Gold amulet (unstrung)", 350));
        items.add(new Item("Pirate leggings (white)", 350));
        items.add(new Item("Super ranging potion (4)", 360));
        items.add(new Item("Antipoison (4)", 360));
        items.add(new Item("Regrowth scroll", 362));
        items.add(new Item("Nature rune", 372));
        items.add(new Item("Law rune", 378));
        items.add(new Item("Swordfish", 400));
        items.add(new Item("Soul rune", 410));
        items.add(new Item("Bullseye lantern (oil)", 420));
        items.add(new Item("Magic seed", 422));
        items.add(new Item("Raw karambwan", 440));
        items.add(new Item("Emerald", 500));
        items.add(new Item("Steel longsword", 500));
        items.add(new Item("Teak plank", 500));
        items.add(new Item("Mithril hatchet", 520));
        items.add(new Item("Blood rune", 550));
        items.add(new Item("Iron platebody", 560));
        items.add(new Item("Spirit wolf pouch", 599));
        items.add(new Item("Gloves of silence", 600));
        items.add(new Item("Adamant bar", 640));
        items.add(new Item("Magic pyre logs", 640));
        items.add(new Item("Bolt of cloth", 650));
        items.add(new Item("Ranging potion (4)", 700));
        items.add(new Item("Magic shortbow (u)", 800));
        items.add(new Item("Steel warhammer", 832));
        items.add(new Item("Sapphire amulet", 900));
        items.add(new Item("Ruby", 1000));
        items.add(new Item("Uncut dragonstone", 1000));
        items.add(new Item("Bagged plant 1", 1000));
        items.add(new Item("Elder seed", 1000));
        items.add(new Item("Games necklace (8)", 1050));
        items.add(new Item("Sapphire necklace", 1050));
        items.add(new Item("Sailfish soup", 1200));
        items.add(new Item("Tyras helm", 1265));
        items.add(new Item("Ring of duelling (8)", 1275));
        items.add(new Item("Mahogany plank", 1500));
        items.add(new Item("Grand defence potion (6)", 1500));
        items.add(new Item("Desert wyrm pouch", 1549));
        items.add(new Item("Magic shortbow", 1600));
        items.add(new Item("Spirit scorpion pouch", 1849));
        items.add(new Item("Diamond", 2000));
        items.add(new Item("Steel platebody", 2000));
        items.add(new Item("Ruby necklace", 2175));
        items.add(new Item("Albino rat pouch", 2299));
        items.add(new Item("Macaw pouch", 2374));
        items.add(new Item("Mithril 2h sword", 2600));
        items.add(new Item("Ibis pouch", 3149));
        items.add(new Item("Pyrelord pouch", 3199));
        items.add(new Item("Abyssal titan pouch", 3249));
        items.add(new Item("Ring of life", 3525));
        items.add(new Item("Hydra pouch", 3624));
        items.add(new Item("Light creature pouch", 3924));
        items.add(new Item("Amulet of accuracy", 5000));
        items.add(new Item("Rune bar", 5000));
        items.add(new Item("Moss titan pouch", 5474));
        items.add(new Item("Initiate sallet", 6000));
        items.add(new Item("Battlestaff", 7000));
        items.add(new Item("Initiate cuisse", 8000));
        items.add(new Item("Proselyte sallet", 8000));
        items.add(new Item("Proselyte cuisse", 10000));
        items.add(new Item("Malevolent energy", 10000));
        items.add(new Item("Proselyte hauberk", 12000));
        items.add(new Item("Rune hatchet", 12800));
        items.add(new Item("Ahrim's hood", 13000));
        items.add(new Item("Combat bracelet", 21040));
        items.add(new Item("Combat bracelet (4)", 21040));
        items.add(new Item("Ahrim's robe skirt", 47000));
        items.add(new Item("Ahrim's robe top", 50000));
        items.add(new Item("Ahrim's staff", 85000));
    }

    public static ItemDatabase getItemDatabase() {
        if (itemDatabase == null) {
            itemDatabase = new ItemDatabase();
        }
        return itemDatabase;
    }

    public List<Item> getItems() {
        return items;
    }
}
