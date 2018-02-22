package staticdata;

import dynamicdata.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public enum Achievement {
    /*This lists not only achievements, but all non-repeatables.
    TODO: put list in topological order of requirements (all achievements are listed after their prerequisites.)*/
    AVOIDING_CONFLICT(new AchievementBuilder("A-Voiding Conflict", 0.05, true).requirement("Combat", 35)),
    A_CAT_IS_FOR_LIFE(new AchievementBuilder("A Cat is for Life...", 0, true).requirement("Plague City", 1).requirement("Gertrude's Cat", 1)
        .requirement("Cat", 1)),
    A_GAME_OF_TOMBS_I(new AchievementBuilder("A Game of Tombs I", 0, true).requirement("Shifting Tombs", 1)),
    A_GAME_OF_TOMBS_II(new AchievementBuilder("A Game of Tombs II", 0, true).requirement("Shifting Tombs", 10)),
    A_GAME_OF_TOMBS_III(new AchievementBuilder("A Game of Tombs III", 0, true).requirement("Shifting Tombs", 50)),
    A_GAME_OF_TOMBS_IV(new AchievementBuilder("A Game of Tombs IV", 0, true).requirement("Shifting Tombs", 100)),
    A_GAME_OF_TOMBS_V(new AchievementBuilder("A Game of Tombs V", 0, true).requirement("Shifting Tombs", 200)),
    A_GIFT_FROM_KHAZARD(new AchievementBuilder("A Gift From Khazard", 0, true)),
    A_WIZARD_DID_IT(new AchievementBuilder("A Wizard Did It", 0, true)),
    A_WORLD_IN_MICROCOSM(new AchievementBuilder("A World In Microcosm", 0, true)),
    ABYSSAL_REACH(new AchievementBuilder("Abyssal Reach", 0.25, true).requirement("Rune Mysteries", 1).reward("Runecrafting", 1000)),
    ABYSSAL_VALET(new AchievementBuilder("Abyssal Valet", 0, true).requirement("Abyssal titan pouch", 1).requirement("Summoning", 93)
        .requirement("Pure essence", 2).reward("Summoning", 2)),
    ADVANCED_SWEEPING(new AchievementBuilder("Advanced Sweeping", 0, true).requirement("Broomstick enchantments", 5)),
    ADVENTURERS_LOG(new AchievementBuilder("Adventurer's Log", 0, true).reward("Logs", 1).reward("Woodcutting", 25)),
    AERECKS_OLD_BONES(new AchievementBuilder("Aereck's Old Bones", 0, true).requirement("The Restless Ghost", 1)),
    AGILE_FROM_HEAD_TO_TOE(new AchievementBuilder("Agile from Head to Toe", 0, true).requirement("Agile top", 1)
        .requirement("Agile legs", 1)),
    AGILITY_DOJO_MOJO(new AchievementBuilder("Agility - Dojo Mojo", 0, true).requirement("Dojo Mojo", 1)),
    AGILITY_5(new AchievementBuilder("Agility 5", 0, true).requirement("Agility", 5)),
    AGILITY_10(new AchievementBuilder("Agility 10", 0, true).requirement("Agility", 10)),
    AGILITY_20(new AchievementBuilder("Agility 20", 0, true).requirement("Agility", 20)),
    AGILITY_30(new AchievementBuilder("Agility 30", 0, true).requirement("Agility", 30)),
    AGILITY_40(new AchievementBuilder("Agility 40", 0, true).requirement("Agility", 40)),
    AGILITY_50(new AchievementBuilder("Agility 50", 0, true).requirement("Agility", 50)),
    AGILITY_60(new AchievementBuilder("Agility 60", 0, true).requirement("Agility", 60)),
    AGILITY_70(new AchievementBuilder("Agility 70", 0, true).requirement("Agility", 70)),
    AGILITY_80(new AchievementBuilder("Agility 80", 0, true).requirement("Agility", 80)),
    AGILITY_90(new AchievementBuilder("Agility 90", 0, true).requirement("Agility", 90)),
    AGILITY_92(new AchievementBuilder("Agility 92", 0, true).requirement("Agility", 92)),
    AGILITY_99(new AchievementBuilder("Agility 99", 0, true).requirement("Agility", 99)),
    AHRIM_BOBBLEHEAD(new AchievementBuilder("Ahrim Bobblehead", 0, true).requirement("Ahrim the Bobbled", 1)),
    AL_KHARID(new AchievementBuilder("Al Kharid", 0, true)),
    ALI_THE_TRADER(new AchievementBuilder("Ali The Trader", 0, true).requirement("Rogue Trader parts", 3)),
    ALL_ABOARD(new AchievementBuilder("All Aboard", 0, true).requirement("Ranged", 70).encounter(new Encounter(Enemy.KREEARRA))),
    ALL_RISE(new AchievementBuilder("All Rise", 0, true).requirement("Court Cases", 16)),
    ALL_TOGETHER_NOW(new AchievementBuilder("All Together Now", 0, true).requirement("Beastmaster Durzag", 1)
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.YAKAMARU), Arrays.asList(Enemy.IMAGE_OF_YAKAMARU,
            Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU, Enemy.IMAGE_OF_YAKAMARU))))),
    ALMOST_MADE_IN_ARDOUGNE(new AchievementBuilder("Almost Made In Ardougne", 0, true).requirement("Yew logs", 1).requirement("Raw beef", 1)
        .requirement("Rune bar", 1).requirement("Smithing", 91).requirement("Fletching", 69).requirement("Crafting", 10)
        .reward("Rune crossbow", 1).reward("Cooking", 3).reward("Fletching", 100).reward("Smithing", 75).reward("Crafting", 15)),
    ALMOST_AS_PERKY_AS_A_PRAWN(new AchievementBuilder("Almost as Perky as a Prawn", 0, true).requirement("Prawn perk", 15)),
    ALONG_CAME_A_SPIDER_I(new AchievementBuilder("Along Came A Spider I", 0, true).requirement("Araxxi", 5)),
    ALONG_CAME_A_SPIDER_II(new AchievementBuilder("Along Came A Spider II", 0, true).requirement("Araxxi", 10)),
    ALONG_CAME_A_SPIDER_III(new AchievementBuilder("Along Came A Spider III", 0, true).requirement("Araxxi", 25)),
    ALONG_CAME_A_SPIDER_IV(new AchievementBuilder("Along Came A Spider IV", 0, true).requirement("Araxxi", 50)),
    ALONG_CAME_A_SPIDER_V(new AchievementBuilder("Along Came A Spider V", 0, true).requirement("Araxxi", 75)),
    ALONG_CAME_A_SPIDER_VI(new AchievementBuilder("Along Came A Spider VI", 0, true).requirement("Araxxi", 100)),
    ALTAR_EXPLORER(new AchievementBuilder("Altar Explorer", 0.3, true).requirement("Runecrafting", 50)),
    ANGS_OFF_MY_RING(new AchievementBuilder("Angs off my Ring", 0, true).requirement("Ancient elven wedding ring", 1)),
    ANIMAL_CRUELTY(new AchievementBuilder("Animal Cruelty", 0, true).encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT,
        Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
        Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT,
            Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER,
            Enemy.CHARGER, Enemy.CORMES), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT,
            Enemy.AIRUT), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
        Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG))))),
    ANNIHILATOR(new AchievementBuilder("Annihilator", 0, true).requirement("Fate of the Gods", 1)
        .encounter(new Encounter(Collections.singletonList(Arrays.asList(Enemy.SMOKE_NIHIL, Enemy.SHADOW_NIHIL,
            Enemy.BLOOD_NIHIL, Enemy.ICE_NIHIL))))),
    ANY_ODD_CHICKEN(new AchievementBuilder("Any Odd Chicken", 0, true).requirement("Ernest the Chicken", 1)),
    APE_AHOLLOW(new AchievementBuilder("Ape A'hollow", 0.05, true).requirement("Fairy Tale Part III", 1).requirement("Monkey Madness", 1)
        .requirement("Agility", 48)),
    ARC_ALL_YOUR_ENERGIES(new AchievementBuilder("Arc - All Your Energies", 0, true).requirement("Chimes", 5000).requirement("Tajitu", 5)
        .requirement("Impressing the Locals", 1)),
    ARC_ANCIENT_EASTERN_TORTLE_PORTALS(new AchievementBuilder("Arc - Ancient Eastern Tortle Portals", 0.05, true)
        .requirement("Divination", 90).requirement("Ancestral energy", 100).requirement("Impressing the Locals", 1)),
    ARC_BONE_TO_PICK_WITH_YOU(new AchievementBuilder("Arc - Bone to Pick with You", 0, true).requirement("Chimes", 25000)
        .requirement("Tajitu", 25).requirement("Impressing the Locals", 1).requirement("Bonecrusher", 1)),
    ARC_DONT_CRUSH_MY_MEMORIES(new AchievementBuilder("Arc - Don't Crush My Memories", 0, true).requirement("Chimes", 5000)
        .requirement("Tajitu", 5).requirement("Impressing the Locals", 1)),
    ARC_FLIPPERS(new AchievementBuilder("Arc - Flippers", 0, true).requirement("Impressing the Locals", 1).requirement("Raw tarpon", 1)),
    ARC_MITTS_AND_WADERS_DEATH_LOTUS(new AchievementBuilder("Arc - Mitts and Waders - Death Lotus", 0, true).requirement("Chimes", 5000)
        .requirement("Tajitu", 6).requirement("Impressing the Locals", 1)),
    ARC_MITTS_AND_WADERS_SEASINGER(new AchievementBuilder("Arc - Mitts and Waders - Seasinger", 0, true).requirement("Chimes", 5000)
        .requirement("Tajitu", 6).requirement("Impressing the Locals", 1)),
    ARC_MITTS_AND_WADERS_TETSU(new AchievementBuilder("Arc - Mitts and Waders - Tetsu", 0, true).requirement("Chimes", 5000)
        .requirement("Tajitu", 6).requirement("Impressing the Locals", 1)),
    ARC_REWARDS(new AchievementBuilder("Arc - Rewards", 0, true).requirement("Impressing the Locals", 1).requirement("Birds of the Arc", 1)
        .requirement("Berries of the Arc", 1).requirement("Kami", 16).reward("Hunter", 50000)),
    ARC_UNLOCKING_MORE_WAIKO(new AchievementBuilder("Arc - Unlocking More Waiko", 0, true).requirement("Sojobo contract guru", 1)
        .requirement("Ancestral Divination I", 1).requirement("Ancestral Divination II", 1).requirement("Ancestral Conversion", 1)
        .requirement("Spirit dragon pet", 1).requirement("Idol crabletine pet", 1).requirement("Gu ronin outfit", 1)
        .requirement("Death lotus rogue outfit", 1).requirement("Seasinger acolyte outfit", 1).requirement("Hunter outfit", 1)
        .requirement("Hanto outfit", 1).requirement("Thalassia's Revenge", 1).requirement("Winds of Waiko", 1)
        .requirement("Rage of Hyu-ji", 1)),
    ARC_UNLOCKING_WAIKO(new AchievementBuilder("Arc - Unlocking Waiko", 0, true).requirement("Waiko Grill", 1)
        .requirement("Whale's Maw Camp Fire", 1).requirement("Whale's Maw Deposit Box", 1).requirement("Arc journal teletabs", 1)
        .requirement("Crystal tool siphon blueprint", 1).requirement("Impressing the Locals", 1)),
    ARC_UPGRADING_ALL_OF_THE_WAIKO(new AchievementBuilder("Arc - Upgrading All of the Waiko", 0, true)
        .requirement("Commodity sell per day increase", 2).requirement("Supplies cap increase", 4)
        .requirement("Contracts per day increase", 4).requirement("Supplies cost reduction", 5)
        .requirement("Commodity sell price increase", 2).requirement("Impressing the Locals", 1)),
    ARC_UPGRADING_WAIKO(new AchievementBuilder("Arc - Upgrading Waiko", 0, true).requirement("Commodity sell per day increase", 1)
        .requirement("Supplies cap increase", 1).requirement("Contracts per day increase", 1).requirement("Supplies cost reduction", 1)
        .requirement("Commodity sell price increase", 1).requirement("Impressing the Locals", 1)),
    ARC_SALTY(new AchievementBuilder("Arc - Salty", 0, true).requirement("Wushanko Isles: The Arc", 1)
        .requirement("Arc - Unlocking More Waiko", 1).requirement("Arc - Upgrading All of the Waiko", 1)
        .requirement("Arc - Ancient Eastern Tortle Portals", 1).requirement("Arc - Flippers", 1)
        .requirement("Arc - Mitts and Waders - Death Lotus", 1).requirement("Arc - All Your Energies", 1)
        .requirement("Arc - Mitts and Waders - Tetsu", 1).requirement("Arc - Unlocking Waiko", 1)
        .requirement("Arc - Mitts and Waders - Seasinger", 1).requirement("Arc - Rewards", 1)
        .requirement("Arc - Don't Crush My Memories", 1).requirement("Arc - Bone to Pick with You", 1)),
    ARC_III_SPIRITUAL_ENLIGHTENMENT(new AchievementBuilder("Arc III - Spiritual Enlightenment", 0.75, true)
        .requirement("Impressing the Locals", 1).requirement("Meet the Assassin", 1).requirement("Slayer", 90)
        .requirement("The Path of the Monk", 1).requirement("The Path of the Elemental", 1).requirement("The Path of the Dragon", 1)
        .reward("Chimes", 250).reward("Tajitu", 3).lamp(Collections.singletonList("Slayer"), -3, 1)),
    ARC_II_HEAD_OF_THE_FAMILY(new AchievementBuilder("Arc II - Head of the Family", 0.75, true).requirement("Impressing the Locals", 1)
        .requirement("Fish oil", 15).requirement("Woodcutting", 90).requirement("Fishing", 90).requirement("Cooking", 91)
        .requirement("Chimes", 450).requirement("Bamboo", 5)
        .encounter(new Encounter(Collections.singletonList(Arrays.asList(Enemy.CAPN_EKAHI, Enemy.CYCLOPS_LABOURER,
            Enemy.CYCLOPS_LABOURER)))).reward("Chimes", 1300).reward("Fish oil", 30).reward("Bundle of bamboo", 4).reward("Tajitu", 5)
        .lamp(Collections.singletonList("Agility"), -3, 1)),
    ARC_I_FLAG_FALL(new AchievementBuilder("Arc I - Flag Fall", 0.5, true).requirement("Impressing the Locals", 1).reward("Chimes", 500)
        .reward("Tajitu", 2)),
    ARC_IV_JED_HUNTER(new AchievementBuilder("Arc IV - Jed Hunter", 0.25, true).requirement("Flag Fall", 1)
        .requirement("Spiritual Enlightenment", 1).requirement("Head of the Family", 1).requirement("Hunter", 90)
        .requirement("Crafting", 91).requirement("Driftwood", 10).requirement("Sea shell", 5).requirement("Tortle shell bowl", 2)
        .requirement("Tajitu", 1).requirement("Chimes", 200).encounter(new Encounter(Enemy.GU_RONIN))
        .encounter(new Encounter(Enemy.GU_RONIN)).encounter(new Encounter(Enemy.GU_RONIN)).reward("Chimes", 2000).reward("Tajitu", 10)
        .lamp(Collections.singletonList("Hunter"), -3, 1)),
    ARC_V_EYE_FOR_AN_EYE(new AchievementBuilder("Arc V - Eye for an Eye", 0.25, true).requirement("Jed Hunter", 1)
        .requirement("Mining", 90).requirement("Sea salt", 30)
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS),Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS),
            Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS),
        Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS),
        Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS,
                Enemy.ZYCLOPS, Enemy.ZYCLOPS), Arrays.asList(Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS, Enemy.ZYCLOPS))))
        .reward("Chimes", 250).reward("Tajitu", 1).reward("Alalea sea salt", 25).lamp(Collections.singletonList("Prayer"), -3, 1)),
    ARC_VI_HARBINGER_OF_DOOM(new AchievementBuilder("Arc VI - Harbinger of Doom", 0.25, true).requirement("Eye for an Eye", 1)
        .reward("Chimes", 250).reward("Tajitu", 2).lamp(Collections.singletonList("Construction"), -3, 1)),
    ARC_IX_DAMAGE_CONTROL(new AchievementBuilder("Arc IX - Damage Control", 0.25, true).requirement("Harbinger", 1)
        .requirement("Chimes", 2500).reward("Chimes", 3000).reward("Tajitu", 2).lamp(Collections.singletonList("Thieving"), -3, 1)),
    ARC_VIII_GHOSTS_FROM_THE_PAST(new AchievementBuilder("Arc VIII - Ghosts from the Past", 0.25, true).requirement("Harbinger", 1)
        .reward("Chimes", 500).reward("Tajitu", 2).lamp(Arrays.asList("Agility", "Herblore", "Fishing", "Thieving", "Cooking",
            "Prayer", "Runecrafting", "Slayer", "Construction", "Hunter", "Dungeoneering", "Divination"), -3, 1)),
    ARC_VII_TUAI_LETS_OWN(new AchievementBuilder("Arc VII - Tuai Let's Own", 0.5, true).requirement("Harbinger", 1)
        .requirement("Farming", 86).requirement("Divination", 90).requirement("Rumberry", 30).requirement("Positive energy", 30)
        .requirement("Spirit dragon charm", 1).reward("Chimes", 500).reward("Tajitu", 2).reward("Rumberry", 50)
        .reward("Ancestral energy", 50)),
    ARC_X_FINAL_DESTINATION(new AchievementBuilder("Arc X - Final Destination", 0.25, true).requirement("Tuai Let's Own", 1)
        .requirement("Damage Control", 1).requirement("Ghosts from the Past", 1)
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.ZYCLOPS_CANNONEER, Enemy.ZYCLOPS_CANNONEER, Enemy.ZYCLOPS_CANNONEER),
            Arrays.asList(Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI, Enemy.ZOMBIE_UI),
            Arrays.asList(Enemy.SKELETON_UI, Enemy.SKELETON_UI), Arrays.asList(Enemy.ZYCLOPS_FD, Enemy.ZYCLOPS_FD))))
        .reward("Chimes", 2000).reward("Tajitu", 10)
        .lamp(Arrays.asList("Attack", "Constitution", "Defense", "Strength", "Ranged", "Prayer", "Magic", "Summoning"), -4, 1)),
    ARDOUGNE(new AchievementBuilder("Ardougne", 0, true)),
    ARE_YOU_BEING_SERVED(new AchievementBuilder("Are You Being Served?", 0, true)),
    ARDOUGNE_SET_TASKS_EASY(new AchievementBuilder("Ardougne Set Tasks - Easy", 0, true).requirement("Yoink!", 1)
        .requirement("The Essence of Magic", 1).requirement("Silky Smooth", 1).requirement("Preaching to the Infected", 1)
        .requirement("Playing the Waiting Game", 1).requirement("Gone Fishing", 1).requirement("Boot Camp", 1)
        .requirement("A Cat is for Life...", 1).requirement("Creator and Destroyer", 1).requirement("Red Revolution", 1)
        .requirement("Going on a Summer Holiday", 1).requirement("Breaking and Entering", 1).requirement("P-P-P-Pick Up Some Prizes", 1)
        .requirement("A Gift from Khazard", 1).requirement("Party Pooper", 1).requirement("Vial Deeds", 1).requirement("Star Seeker", 1)
        .requirement("Dukes of Khazard", 1).requirement("Don't Eat the Pointy Bit", 1).requirement("Bargain Hunter", 1)
        .requirement("Are You Being Served?", 1).requirement("No Time to Lose", 1).requirement("They're Long and Pointy", 1)
        .lamp(Player.ALL_SKILLS, 1000, 25)),
    ARDOUGNE_SET_TASKS_ELITE(new AchievementBuilder("Ardougne Set Tasks - Elite", 0, true).requirement("Catching Some Rays", 1)
        .requirement("Abyssal Valet", 1).requirement("You Could Just Knock", 1).requirement("Honestly, It's Not a Purse", 1)
        .requirement("Almost Made in Ardougne", 1).lamp(Player.ALL_SKILLS, 50000, 85).lamp(Player.ALL_SKILLS, 50000, 85)
        .lamp(Player.ALL_SKILLS, 50000, 85).lamp(Player.ALL_SKILLS, 50000, 85)),
    ARDOUGNE_SET_TASKS_HARD(new AchievementBuilder("Ardougne Set Tasks - Hard", 0, true).requirement("Brace Yourself", 1)
        .requirement("Shadow Boxing", 1).requirement("Just Like That", 1).requirement("Nice View", 1)
        .requirement("You're the Dirty Rascal", 1).requirement("Ourania Mania", 1).requirement("Not on My Watch", 1)
        .requirement("It Just Croaked", 1).requirement("Get Your Stinking Hands Off Me", 1).requirement("Vine-detta", 1)
        .requirement("Living on a Prayer", 1).requirement("Who Wants to Watch the Watchtower?", 1).requirement("Monkey Business", 1)
        .requirement("It's My Newt", 1).requirement("A Taste of the Exotic", 1).requirement("Blood Bank Withdrawal", 1)
        .requirement("Artillery Strike", 1).lamp(Player.ALL_SKILLS, 28000, 60)),
    ARDOUGNE_SET_TASKS_MEDIUM(new AchievementBuilder("Ardougne Set Tasks - Medium", 0, true).requirement("A Visit to Charlie", 1)
        .requirement("I Wonder What This Does", 1).requirement("Sandy's Secret Getaway", 1).requirement("I Know a Shortcut", 1)
        .requirement("Volatile Valuables", 1).requirement("What, a Melon?", 1).requirement("Ardougne Express", 1)
        .requirement("Arriving in Style", 1).requirement("By the Bucketload", 1).requirement("Meeting History, Again", 1)
        .requirement("Fearless Fishing", 1).requirement("Water Logged", 1).requirement("Green Fingers", 1).requirement("A Natural Thief", 1)
        .requirement("The Coal Train", 1).requirement("Are You Chicken?", 1).lamp(Player.ALL_SKILLS, 7500, 45)),
    ARE_YOU_CHICKEN(new AchievementBuilder("Are You Chicken?", 0, true).requirement("Tower of Life", 1).requirement("Raw chicken", 1)
        .requirement("Raw swordfish", 1).encounter(new Encounter(Enemy.SWORDCHICK))),
    ARE_YOU_NEEDING_ACCESS(new AchievementBuilder("Are You Needing Access?", 0, true).requirement("Do No Evil", 1)
        .requirement("Agility", 80).reward("Agility", 20000)),
    ARISE_FROM_THE_ASH(new AchievementBuilder("Arise from the Ash", 0, true).requirement("In Pyre Need", 1).requirement("Phoenix Lair", 1)),
    AROUND_THE_WORLD_IN_SIX_WAYS(new AchievementBuilder("Around the World in Six Ways", 0, true)
        .requirement("Balloon transport system routes", 6)),
    AS_TAXED_AS_A_YAK(new AchievementBuilder("As Taxed as a Yak", 0, true).requirement("The Fremennik Isles", 1)
        .requirement("Coins", 5000)),
    AS_CLEAR_AS_A_CRYSTAL_SEED(new AchievementBuilder("As Clear as a Crystal Seed", 0, true).requirement("Within the Light", 1)),
    ASHDALE(new AchievementBuilder("Ashdale", 0, true)),
    ATTACK_SIFU(new AchievementBuilder("Attack - Sifu", 0, true).requirement("Sifu", 1)),
    ATTACK_5(new AchievementBuilder("Attack 5", 0, true).requirement("Attack", 5)),
    ATTACK_10(new AchievementBuilder("Attack 10", 0, true).requirement("Attack", 10)),
    ATTACK_20(new AchievementBuilder("Attack 20", 0, true).requirement("Attack", 20)),
    ATTACK_30(new AchievementBuilder("Attack 30", 0, true).requirement("Attack", 30)),
    ATTACK_40(new AchievementBuilder("Attack 40", 0, true).requirement("Attack", 40)),
    ATTACK_50(new AchievementBuilder("Attack 50", 0, true).requirement("Attack", 50)),
    ATTACK_60(new AchievementBuilder("Attack 60", 0, true).requirement("Attack", 60)),
    ATTACK_70(new AchievementBuilder("Attack 70", 0, true).requirement("Attack", 70)),
    ATTACK_80(new AchievementBuilder("Attack 80", 0, true).requirement("Attack", 80)),
    ATTACK_90(new AchievementBuilder("Attack 90", 0, true).requirement("Attack", 90)),
    ATTACK_92(new AchievementBuilder("Attack 92", 0, true).requirement("Attack", 92)),
    ATTACK_99(new AchievementBuilder("Attack 99", 0, true).requirement("Attack", 99)),
    AVA(new AchievementBuilder("Ava", 0, true).requirement("Ava", 1)),
    AZACORAXS_REWARDS(new AchievementBuilder("Azacorax's Rewards", 0, true).requirement("Rune Memories", 1).requirement("Magic", 50)
        .requirement("Prayer", 50).lamp(Arrays.asList("Magic", "Prayer"), 10000, 50)),
    AZDARAN_BIRTHRIGHT(new AchievementBuilder("Azdaran Birthright", 0, true).requirement("Azdaran fragment", 10)),
    BANDIT_CAMP(new AchievementBuilder("Bandit Camp", 0, true).requirement("Desert Treasure", 1)),
    BANDOSS_MEMORIES(new AchievementBuilder("Bandos's Memories", 0, true).requirement("Bandos chronicles", 13)),
    BANE_TUNER(new AchievementBuilder("Bane Tuner", 0, true).requirement("Tune Bane Ore", 1)),
    BANK_Z(new AchievementBuilder("Bank-Z", 0, true).requirement("Dimension of Disaster: Curse of Arrav", 1).reward("Zemomark", 30)),
    BANKING_HISTORY(new AchievementBuilder("Banking History", 0, true).requirement("Enchanted key miniquest", 2)),
    BARBARIAN_SCAVENGER(new AchievementBuilder("Barbarian Scavenger", 0, true).requirement("Ancient page", 26)),
    BARGAIN_HUNTER(new AchievementBuilder("Bargain Hunter", 0, true)),
    BAROO_QUALITY(new AchievementBuilder("Baroo Quality", 0, true).requirement("Yak-hide armour (top)", 1)
        .requirement("Yak-hide armour (legs)", 1).requirement("Fremennik round shield", 1).encounter(new Encounter(Enemy.DAGANNOTH_SUPREME,
            Arrays.asList(new Restriction("Yak-hide armour (top)", 1), new Restriction("Yak-hide armour (legs)", 1),
                new Restriction("Fremennik round shield", 1))))),
    BARROWED_POWER_I(new AchievementBuilder("Barrowed Power I", 0, true).requirement("Rise of the Six", 5)),
    BARROWED_POWER_II(new AchievementBuilder("Barrowed Power II", 0, true).requirement("Rise of the Six", 10)),
    BARROWED_POWER_III(new AchievementBuilder("Barrowed Power III", 0, true).requirement("Rise of the Six", 25)),
    BARROWED_POWER_IV(new AchievementBuilder("Barrowed Power IV", 0, true).requirement("Rise of the Six", 50)),
    BARROWED_POWER_V(new AchievementBuilder("Barrowed Power V", 0, true).requirement("Rise of the Six", 75)),
    BARROWED_POWER_VI(new AchievementBuilder("Barrowed Power VI", 0, true).requirement("Rise of the Six", 100)),
    BARROWED_TIME(new AchievementBuilder("Barrowed Time", 0, true).requirement("Barrows uniques", 38)),
    BARRY(new AchievementBuilder("Barry", 0, true).requirement("Barry", 1)),
    BEGGARS_CANT_BE_CHOOSERS(new AchievementBuilder("Beggars Can't Be Choosers", 0.05, true).requirement("In Aid of the Myreque", 1)
        .requirement("Great maki", 1)),
    BEHEMOTH_NOTES(new AchievementBuilder("Behemoth Notes", 0, true).requirement("Behemoth notes", 5)),
    BERRIES_OF_THE_ARC(new AchievementBuilder("Berries of the Arc", 0, true).requirement("Arc berries", 16).reward("Farming", 50000)),
    BEST_OFFENCE(new AchievementBuilder("Best Offence", 0, true).encounter(new Encounter(Enemy.KALPHITE_KING))),
    BETTER_NOT_TOUCH(new AchievementBuilder("Better Not Touch", 0, true).requirement("Beastmaster Durzag", 1)
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.YAKAMARU),
            Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU),
            Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU))))),
    BIG_CHINCHOMPA(new AchievementBuilder("Big Chinchompa", 0.25, true).requirement("Hunter", 78).reward("Competence points", 1111)),
    BIPEDAL_MASK(new AchievementBuilder("Bipedal Mask", 0, true).requirement("Tuska mask", 1)
        .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic"), 43680, 90)),
    BIRD_IS_THE_WORD_I(new AchievementBuilder("Bird is the Word I", 0, true).requirement("Kree'arra", 5)),
    BIRD_IS_THE_WORD_II(new AchievementBuilder("Bird is the Word II", 0, true).requirement("Kree'arra", 10)),
    BIRD_IS_THE_WORD_III(new AchievementBuilder("Bird is the Word III", 0, true).requirement("Kree'arra", 25)),
    BIRD_IS_THE_WORD_IV(new AchievementBuilder("Bird is the Word IV", 0, true).requirement("Kree'arra", 50)),
    BIRD_IS_THE_WORD_V(new AchievementBuilder("Bird is the Word V", 0, true).requirement("Kree'arra", 75)),
    BIRD_IS_THE_WORD_VI(new AchievementBuilder("Bird is the Word VI", 0, true).requirement("Kree'arra", 100)),
    BIRDS_OF_THE_ARC(new AchievementBuilder("Birds of the Arc", 0, true).requirement("Arc birds", 16)),
    BIRDSTRIKE_I(new AchievementBuilder("Birdstrike I", 0, true).requirement("Kree'arra (HM)", 5)),
    BIRDSTRIKE_II(new AchievementBuilder("Birdstrike II", 0, true).requirement("Kree'arra (HM)", 10)),
    BIRDSTRIKE_III(new AchievementBuilder("Birdstrike III", 0, true).requirement("Kree'arra (HM)", 25)),
    BIRDSTRIKE_IV(new AchievementBuilder("Birdstrike IV", 0, true).requirement("Kree'arra (HM)", 50)),
    BIRDSTRIKE_V(new AchievementBuilder("Birdstrike V", 0, true).requirement("Kree'arra (HM)", 75)),
    BIRDSTRIKE_VI(new AchievementBuilder("Birdstrike VI", 0, true).requirement("Kree'arra (HM)", 100)),
    BLACKOUT(new AchievementBuilder("Blackout", 0, true).requirement("Queen Black Dragon uniques", 12)),
    BLINDED_BY_RAMARNOS_TEACHING(new AchievementBuilder("Blinded by Ramarno's Teaching", 0, true).requirement("Defender of Varrock", 1)
        .requirement("Redberry pie", 1).reward("Smithing", 1000)),
    BLOOD_STAINED_TREASURE(new AchievementBuilder("Blood Stained Treasure", 0.05, true).requirement("Legacy of Seergaze", 1)
        .reward("Blood rune", 100)),
    BOMBI(new AchievementBuilder("Bombi", 0, true).requirement("Bombi", 1)),
    BONE_I_FIRED(new AchievementBuilder("Bone I Fired", 0, true).requirement("Zanik's crossbow", 1).requirement("Bone bolt", 2)
        .requirement("Rag and Bone Man wish list", 1).requirement("Fur'n'Seek wish list", 1).requirement("Ranged", 48)
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_1),
        Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_2), Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_3),
        Collections.singletonList(Enemy.SKELETAL_HORROR_PHASE_4)), Arrays.asList(new Restriction("Zanik's crossbow", 1),
        new Restriction("Bone bolt", 1)))).reward("Slayer", 10000).reward("Prayer", 7000)),
    BOOT_CAMP(new AchievementBuilder("Boot Camp", 0, true).requirement("Biohazard", 1)),
    BOVINE_INTERVENTION(new AchievementBuilder("Bovine Intervention", 0, true).encounter(new Encounter(Enemy.COW))),
    BOYS_TO_MENAPHITES(new AchievementBuilder("Boys to Menaphites", 0, true).requirement("Menaphos reputation", 330000)),
    BRASS_NEX_I(new AchievementBuilder("Brass Nex I", 0, true).requirement("Nex", 5)),
    BRASS_NEX_II(new AchievementBuilder("Brass Nex II", 0, true).requirement("Nex", 10)),
    BRASS_NEX_III(new AchievementBuilder("Brass Nex III", 0, true).requirement("Nex", 25)),
    BRASS_NEX_IV(new AchievementBuilder("Brass Nex IV", 0, true).requirement("Nex", 50)),
    BRASS_NEX_V(new AchievementBuilder("Brass Nex V", 0, true).requirement("Nex", 75)),
    BRASS_NEX_VI(new AchievementBuilder("Brass Nex VI", 0, true).requirement("Nex", 100)),
    BREAKING_AND_ENTERING(new AchievementBuilder("Breaking and Entering", 0, true).requirement("Thieving", 16)),
    BRIDGE_OVER_FREMMY_WATERS(new AchievementBuilder("Bridge over Fremmy Waters", 0, true)
        .requirement("Unabridged Fremennik sagas", 5)),
    BRING_IT_ALL_BACK(new AchievementBuilder("Bring It All Back", 0, true).requirement("Ranged", 80).requirement("Blade of Avaryss", 1)
        .requirement("Blade of Nymora", 1).requirement("Attack", 85).encounter(new Encounter(Enemy.TWIN_FURIES,
            Arrays.asList(new Restriction("Blade of Avaryss", 1), new Restriction("Blade of Nymora", 1))))),
    BROTHERS_GOWER(new AchievementBuilder("Brothers Gower", 0, true).requirement("Gower lamp", 3)),
    BROTHERS_IN_ARMS(new AchievementBuilder("Brothers in Arms", 0, true).requirement("Ritual of the Mahjarrat", 1)
        .requirement("Kindred Spirits", 1).requirement("Ahrim's staff", 1).requirement("Akrisae's war mace", 1)
        .requirement("Dharok's greataxe", 1).requirement("Guthan's warspear", 1).requirement("Karil's crossbow", 1)
        .requirement("Linza's hammer", 1).requirement("Torag's hammer", 1).requirement("Verac's flail", 1).requirement("Magic", 70)
        .requirement("Attack", 80).requirement("Prayer", 70).requirement("Strength", 70).requirement("Ranged", 70)
        .encounter(new Encounter(Enemy.AHRIM_THE_BLIGHTED, Collections.singletonList(new Restriction("Ahrim's staff", 1))))
        .encounter(new Encounter(Enemy.DHAROK_THE_WRETCHED, Collections.singletonList(new Restriction("Dharok's greataxe", 1))))
        .encounter(new Encounter(Enemy.LINZA_THE_DISGRACED, Collections.singletonList(new Restriction("Linza's hammer", 1))))
        .encounter(new Encounter(Enemy.KARIL_THE_TAINTED, Collections.singletonList(new Restriction("Karil's crossbow", 1))))
        .encounter(new Encounter(Enemy.TORAG_THE_CORRUPTED, Collections.singletonList(new Restriction("Torag's hammer", 1))))
        .encounter(new Encounter(Enemy.GUTHAN_THE_INFESTED, Collections.singletonList(new Restriction("Guthan's warspear", 1))))
        .encounter(new Encounter(Enemy.AKRISAE_THE_DOOMED, Collections.singletonList(new Restriction("Akrisae's war mace", 1))))
        .encounter(new Encounter(Enemy.VERAC_THE_DEFILED, Collections.singletonList(new Restriction("Verac's flail", 1))))),
    BROTHERS_IN_MORE_ARMS(new AchievementBuilder("Brothers in More Arms", 0, true).requirement("Barrows totem", 6)
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KARIL_THE_TAINTED_ROTS, Enemy.TORAG_THE_CORRUPTED_ROTS,
            Enemy.DHAROK_THE_WRETCHED_ROTS), Arrays.asList(Enemy.GUTHAN_THE_INFESTED_ROTS, Enemy.AHRIM_THE_BLIGHTED_ROTS,
            Enemy.VERAC_THE_DEFILED_ROTS))))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KARIL_THE_TAINTED_ROTS, Enemy.TORAG_THE_CORRUPTED_ROTS,
            Enemy.DHAROK_THE_WRETCHED_ROTS), Arrays.asList(Enemy.GUTHAN_THE_INFESTED_ROTS, Enemy.VERAC_THE_DEFILED_ROTS,
            Enemy.AHRIM_THE_BLIGHTED_ROTS))))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KARIL_THE_TAINTED_ROTS, Enemy.TORAG_THE_CORRUPTED_ROTS,
            Enemy.DHAROK_THE_WRETCHED_ROTS), Arrays.asList(Enemy.AHRIM_THE_BLIGHTED_ROTS, Enemy.VERAC_THE_DEFILED_ROTS,
            Enemy.GUTHAN_THE_INFESTED_ROTS))))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KARIL_THE_TAINTED_ROTS, Enemy.TORAG_THE_CORRUPTED_ROTS,
            Enemy.GUTHAN_THE_INFESTED_ROTS), Arrays.asList(Enemy.AHRIM_THE_BLIGHTED_ROTS, Enemy.VERAC_THE_DEFILED_ROTS,
            Enemy.DHAROK_THE_WRETCHED_ROTS))))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KARIL_THE_TAINTED_ROTS, Enemy.DHAROK_THE_WRETCHED_ROTS,
            Enemy.GUTHAN_THE_INFESTED_ROTS), Arrays.asList(Enemy.AHRIM_THE_BLIGHTED_ROTS, Enemy.VERAC_THE_DEFILED_ROTS,
            Enemy.TORAG_THE_CORRUPTED_ROTS))))
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.TORAG_THE_CORRUPTED_ROTS, Enemy.DHAROK_THE_WRETCHED_ROTS,
            Enemy.GUTHAN_THE_INFESTED_ROTS), Arrays.asList(Enemy.AHRIM_THE_BLIGHTED_ROTS, Enemy.VERAC_THE_DEFILED_ROTS,
            Enemy.KARIL_THE_TAINTED_ROTS))))),
    BRUTAL_STUFFIES(new AchievementBuilder("Brutal Stuffies", 0, true).requirement("Zogre Flesh Eaters", 1)
        .requirement("Relicym's balm", 1)),
    BUG_SWATTER_I(new AchievementBuilder("Bug Swatter I", 0, true).requirement("Kalphite Queen", 5)),
    BUG_SWATTER_II(new AchievementBuilder("Bug Swatter II", 0, true).requirement("Kalphite Queen", 10)),
    BUG_SWATTER_III(new AchievementBuilder("Bug Swatter III", 0, true).requirement("Kalphite Queen", 25)),
    BUG_SWATTER_IV(new AchievementBuilder("Bug Swatter IV", 0, true).requirement("Kalphite Queen", 50)),
    BUG_SWATTER_V(new AchievementBuilder("Bug Swatter V", 0, true).requirement("Kalphite Queen", 75)),
    BUG_SWATTER_VI(new AchievementBuilder("Bug Swatter VI", 0, true).requirement("Kalphite Queen", 100)),
    BUG_ZAPPER_I(new AchievementBuilder("Bug Zapper I", 0, true).requirement("Kalphite King", 5)),
    BUG_ZAPPER_II(new AchievementBuilder("Bug Zapper II", 0, true).requirement("Kalphite King", 10)),
    BUG_ZAPPER_III(new AchievementBuilder("Bug Zapper III", 0, true).requirement("Kalphite King", 25)),
    BUG_ZAPPER_IV(new AchievementBuilder("Bug Zapper IV", 0, true).requirement("Kalphite King", 50)),
    BUG_ZAPPER_V(new AchievementBuilder("Bug Zapper V", 0, true).requirement("Kalphite King", 75)),
    BUG_ZAPPER_VI(new AchievementBuilder("Bug Zapper VI", 0, true).requirement("Kalphite King", 100)),
    BURN_FURY_BURN(new AchievementBuilder("Burn, Fury, Burn", 0, true).requirement("Ranged", 80)
        .encounter(new Encounter(Enemy.TWIN_FURIES))),
    BURTHORPE(new AchievementBuilder("Burthorpe", 0, true)),
    BURTHORPE_TROLLS(new AchievementBuilder("Burthorpe Trolls", 0, true)),
    BUSINESS_IS_BOONING(new AchievementBuilder("Business Is Booning!", 0, true).requirement("Divination", 10)
        .requirement("Pale energy", 100).reward("Divination", 3)),
    BUY_AND_SELL_SOME_XP(new AchievementBuilder("Buy and Sell Some XP", 0, true).requirement("Thieving", 62)
        .requirement("Buyers and Cellars", 1).reward("Thieving", 2000)),
    BUYING_UP_ANCIENT_ARTIFACTS(new AchievementBuilder("Buying Up Ancient Artifacts", 0, true).requirement("Desert Treasure", 1)
        .requirement("Coins", 80000)),
    CANT_MAKE_AN_OMELETTE(new AchievementBuilder("Can't Make and Omelette", 0, true).reward("Red spider eggs", 1)),
    CAN_YOU_DIG_IT(new AchievementBuilder("Can You Dig It?", 0, true).requirement("Giant Mole uniques", 3)),
    CANIFIS(new AchievementBuilder("Canifis", 0, true)),
    CAREFUL_THERE_ARE_SNAKES(new AchievementBuilder("Careful, There Are Snakes", 0.05, true).requirement("Thieving", 31)),
    CASTAWAYS_OF_THE_ARC(new AchievementBuilder("Castaways of the Arc", 0, true).requirement("Arc castaways", 10)),
    CASTING_A_SHADOW(new AchievementBuilder("Casting a Shadow", 0, true).requirement("Blissful shadow core", 1)
        .requirement("Divination", 81).requirement("Plague's End", 1).reward("Divination", 455)),
    CASTLES_IN_THE_SKY(new AchievementBuilder("Castles in the Sky", 0, true)),
    CATCHING_SOME_RAYS(new AchievementBuilder("Catching Some Rays", 0.2, true).requirement("Fishing", 81).requirement("Swamp paste", 200)
        .requirement("Bucket", 10).requirement("Rope", 10).reward("Raw manta ray", 1).reward("Fishing", 40)),
    CATS_BANE(new AchievementBuilder("Cat's Bane", 0, true).requirement("New Varrock stray cats", 4).reward("Zemomark", 20)),
    CATHERBY(new AchievementBuilder("Catherby", 0, true)),
    CAVING_INTO_THE_GAINS(new AchievementBuilder("Caving Into the Gains", 0, true)
        .requirement("Myths of the White Lands post-quest rewards", 4)),
    CECELIA_IM_BEGGING_YOU_PLEASE(new AchievementBuilder("Cecelia, I'm Begging You, Please...", 0, true)
        .requirement("One Piercing Note", 1)),
    CHALLENGE_MARIA(new AchievementBuilder("Challenge Maria", 0, true).requirement("Broken Home bonus lamps", 9)
        .requirement("Broken Home replay challenges", 3)),
    CHALLENGING_CHAT(new AchievementBuilder("Challenging Chat", 0, true)),
    CHAMPIONS_WHAT_CHAMPIONS(new AchievementBuilder("Champions? What Champions", 0, true).requirement("Champions", 15)
        .reward("Coins", 50000).lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defense", "Constitution",
            "Prayer", "Summoning"), 10000, 50).lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged", "Defense",
            "Constitution", "Prayer", "Summoning"), 10000, 50).lamp(Arrays.asList("Attack", "Strength", "Magic", "Ranged",
            "Defense", "Constitution", "Prayer", "Summoning"), 10000, 50).lamp(Arrays.asList("Attack", "Strength", "Magic",
            "Ranged", "Defense", "Constitution", "Prayer", "Summoning"), 10000, 50)),
    CHANGING_OF_THE_GUARD(new AchievementBuilder("Changing of the Guard", 0, true).requirement("Defense", 60)
        .requirement("Black dragonhide coif", 1).requirement("Black dragonhide body", 1).requirement("Black dragonhide chaps", 1)
        .requirement("Black dragonhide boots", 1).requirement("Black dragonhide vambraces", 1).requirement("Black dragonhide shield", 1)
        .encounter(new Encounter(Enemy.KING_BLACK_DRAGON, Arrays.asList(new Restriction("Black dragonhide coif", 1),
            new Restriction("Black dragonhide body", 1), new Restriction("Black dragonhide chaps", 1),
            new Restriction("Black dragonhide boots", 1), new Restriction("Black dragonhide vambraces", 1),
            new Restriction("Black dragonhide shield", 1))))),
    CHAOS_THEORY(new AchievementBuilder("Chaos Theory", 0, true).requirement("Chaos Elemental uniques", 30)),
    CHECKMATE(new AchievementBuilder("Checkmate", 0, true).requirement("Kalphite Queen uniques", 4)),
    CHICKARRA(new AchievementBuilder("Chick'arra", 0, true).requirement("Chick'arra", 1)),
    CHILLING_WITH_ARRAV(new AchievementBuilder("Chilling with Arrav", 0, true).requirement("Ritual of the Mahjarrat", 1)
        .reward("Prayer", 3000)),
    CHIPPY_TRANSPORT(new AchievementBuilder("Chippy Transport", 0, true).requirement("Love Story", 1)),
    CHIVALRY_IS_FED(new AchievementBuilder("Chivalry is Fed", 0, true).requirement("The Death of Chivalry", 1)
        .requirement("Cabbage seeds", 12).requirement("Farming", 7).reward("Farming", 250)),
    CHIVALRY_IS_THREADS(new AchievementBuilder("Chivalry is Threads", 0, true).requirement("Templar armour", 1)
        .requirement("Dulcin armour", 1)),
    CHIVALRY_IS_DEAD(new AchievementBuilder("Chivalry is Dead", 0, true).requirement("The Death of Chivalry post-quest rewards", 4)),
    CHOMPY_MASSACRE(new AchievementBuilder("Chompy Massacre", 0, true).requirement("Chompy kills", 4000).reward("Ranged", 30000)),
    CIRCUS_OF_FIRE(new AchievementBuilder("Circus of Fire", 0.05, true).requirement("The Firemaker's Curse", 1)),
    CITADELEMENTARY(new AchievementBuilder("Citadelementary", 0, true)),
    CLAIMING_AZZANADRAS_HEART(new AchievementBuilder("Claiming Azzanadra's Heart", 0, true).requirement("Heart of Stone", 1)
        .requirement("The Temple at Senntisten", 1).lamp(Player.ALL_SKILLS, -2, 1)),
    CLASS_CROWN(new AchievementBuilder("Class Crown", 0, true).requirement("Imperial reputation", 300000)),
    CLASSIC_DRAGON_KILLING(new AchievementBuilder("Classic Dragon Killing", 0, true).requirement("Attack", 80)
        .requirement("Dragonfire shield", 1).encounter(new Encounter(Enemy.VINDICTA,
            Collections.singletonList(new Restriction("Dragonfire shield", 1))))),
    CLASSIC_ROCK(new AchievementBuilder("Classic Rock", 0, true).encounter(new Encounter(Enemy.VORAGO,
        Collections.singletonList(new Restriction("Defensive abilities", 0))))),
    CLAUS_IS_RISING(new AchievementBuilder("Claus Is Rising", 0, true).requirement("Claus the chef reward", 1)),
    CLAYMATION(new AchievementBuilder("Claymation", 0.33, true)),
    CLUES_IN_THE_MONKEY_DROOL(new AchievementBuilder("Clue's In The Monkey Drool", 0, true).requirement("Monkey clue scroll", 1)),
    COLLECTING_MEMORABILIA(new AchievementBuilder("Collecting Memorabilia", 0, true).reward("Divination", 1)),
    COME_AND_HAVE_VORAGO_I(new AchievementBuilder("Come and Have Vorago I", 0, true).requirement("Vorago", 5)),
    COME_AND_HAVE_VORAGO_II(new AchievementBuilder("Come and Have Vorago II", 0, true).requirement("Vorago", 10)),
    COME_AND_HAVE_VORAGO_III(new AchievementBuilder("Come and Have Vorago III", 0, true).requirement("Vorago", 25)),
    COME_AND_HAVE_VORAGO_IV(new AchievementBuilder("Come and Have Vorago IV", 0, true).requirement("Vorago", 50)),
    COME_AND_HAVE_VORAGO_V(new AchievementBuilder("Come and Have Vorago V", 0, true).requirement("Vorago", 75)),
    COME_AND_HAVE_VORAGO_VI(new AchievementBuilder("Come and Have Vorago VI", 0, true).requirement("Vorago", 100)),
    COMMANDER_MINIANA(new AchievementBuilder("Commander Miniana", 0, true).requirement("Commander Miniana", 1)),
    COMMERCE_BREAK(new AchievementBuilder("Commerce Break", 0, true)),
    COMPLETE_HISTORY_OF_DROALAK(new AchievementBuilder("Complete History of Droalak", 0, true).requirement("Making History", 1)),
    COMPLETE_TREKKY(new AchievementBuilder("Complete Trekky", 0, true).requirement("Temple Trekking total level", 594)),
    COMPLETIONIST_CAPE(new AchievementBuilder("Completionist Cape", 0, true).requirement("Abyssal Reach", 1)
        .requirement("Almost as Perky as a Prawn", 1).requirement("Annihilator", 1).requirement("Arc - Ancient Eastern Tortle Portals", 1)
        .requirement("Arc - Unlocking Waiko", 1).requirement("Arc - Upgrading Waiko", 1).requirement("Arc III - Spiritual Enlightenment", 1)
        .requirement("Arc II - Head of the Family", 1).requirement("Arc IV - Jed Hunter", 1).requirement("Arc IX - Damage Control", 1)
        .requirement("Arc I - Flag Fall", 1).requirement("Arc VIII - Ghosts from the Past", 1).requirement("Arc VII - Tuai Leit's Own", 1)
        .requirement("Arc VI - Harbinger of Doom", 1).requirement("Arc V - Eye for an Eye", 1).requirement("Arc X - Final Destination", 1)
        .requirement("Bandos's Memories", 1).requirement("Bane Tuner", 1).requirement("Big Chinchompa", 1).requirement("Bipedal Mask", 1)
        .requirement("Bridge over Fremmy Waters", 1).requirement("Claus Is Rising", 1).requirement("Deadlier Catch", 1)
        .requirement("Desert-ed Ghosts", 1).requirement("Diaries of the Clans", 1).requirement("Elven Titles", 1)
        .requirement("Family Spirit Tree", 1).requirement("Famous", 1).requirement("Heal, Quickly", 1)
        .requirement("I'm Forever Washing Shadows", 1).requirement("Imping Around", 1).requirement("Invention Gives Me the Blues", 1)
        .requirement("Kharshai's Memories", 1).requirement("Kiln Fighter", 1).requirement("Kudos to You", 1)
        .requirement("Long Live the Queen", 1).requirement("Lost Toys", 1).requirement("Lunar Master", 1).requirement("Make Them Bleed", 1)
        .requirement("Master Quester", 1).requirement("Master Skiller", 1).requirement("Memories of Guthis", 1)
        .requirement("Music Maestro", 1).requirement("Myreque in Memoriam", 1).requirement("One Foot in the Grave", 1)
        .requirement("Out into the Ourania", 1).requirement("Peachy Bones", 1).requirement("Pious Prayers", 1).requirement("Port Life", 1)
        .requirement("Potion Mixer Master", 1).requirement("Potion for a Lady", 1).requirement("Reaper Crew", 1)
        .requirement("Rhian in Gold - The Original", 1).requirement("Seren Memories", 1).requirement("Sing for the Lady", 1)
        .requirement("Slayer Master", 1).requirement("Stay Safe", 1).requirement("Stay Secure", 1).requirement("Task Master", 1)
        .requirement("Tell Tale Tarn", 1).requirement("Trip to the East", 1).requirement("Troublesome Crystals", 1)
        .requirement("Uncorrupted Ore", 1).requirement("Walking the Reef", 1).requirement("What's Mine Is Also Doric's", 1)
        .requirement("Yaktwee's a Charm", 1).requirement("You Be Dead", 1).requirement("Zarosian Memories", 1)),
    CONQUEST_ADORE(new AchievementBuilder("Conquest Adore", 0, true).requirement("Conquest rank", 1250)),
    CONSTITUTION_MORTY(new AchievementBuilder("Constitution - Morty", 0, true).requirement("Morty", 1)),
    CONSTITUTION_15(new AchievementBuilder("Constitution 15", 0, true).requirement("Constitution", 15)),
    CONSTITUTION_20(new AchievementBuilder("Constitution 20", 0, true).requirement("Constitution", 20)),
    CONSTITUTION_30(new AchievementBuilder("Constitution 30", 0, true).requirement("Constitution", 30)),
    CONSTITUTION_40(new AchievementBuilder("Constitution 40", 0, true).requirement("Constitution", 40)),
    CONSTITUTION_50(new AchievementBuilder("Constitution 50", 0, true).requirement("Constitution", 50)),
    CONSTITUTION_60(new AchievementBuilder("Constitution 60", 0, true).requirement("Constitution", 60)),
    CONSTITUTION_70(new AchievementBuilder("Constitution 70", 0, true).requirement("Constitution", 70)),
    CONSTITUTION_80(new AchievementBuilder("Constitution 80", 0, true).requirement("Constitution", 80)),
    CONSTITUTION_90(new AchievementBuilder("Constitution 90", 0, true).requirement("Constitution", 90)),
    CONSTITUTION_92(new AchievementBuilder("Constitution 92", 0, true).requirement("Constitution", 92)),
    CONSTITUTION_99(new AchievementBuilder("Constitution 99", 0, true).requirement("Constitution", 99)),
    CONSTRUCTION_BABA_YAGAS_HOUSE(new AchievementBuilder("Construction - Baba Yaga's House", 0, true).requirement("Baby Yaga's House'", 1)),
    CONSTRUCTION_5(new AchievementBuilder("Construction 5", 0, true).requirement("Construction", 5)),
    CONSTRUCTION_10(new AchievementBuilder("Construction 10", 0, true).requirement("Construction", 10)),
    CONSTRUCTION_20(new AchievementBuilder("Construction 20", 0, true).requirement("Construction", 20)),
    CONSTRUCTION_30(new AchievementBuilder("Construction 30", 0, true).requirement("Construction", 30)),
    CONSTRUCTION_40(new AchievementBuilder("Construction 40", 0, true).requirement("Construction", 40)),
    CONSTRUCTION_50(new AchievementBuilder("Construction 50", 0, true).requirement("Construction", 50)),
    CONSTRUCTION_60(new AchievementBuilder("Construction 60", 0, true).requirement("Construction", 60)),
    CONSTRUCTION_70(new AchievementBuilder("Construction 70", 0, true).requirement("Construction", 70)),
    CONSTRUCTION_80(new AchievementBuilder("Construction 80", 0, true).requirement("Construction", 80)),
    CONSTRUCTION_90(new AchievementBuilder("Construction 90", 0, true).requirement("Construction", 90)),
    CONSTRUCTION_92(new AchievementBuilder("Construction 92", 0, true).requirement("Construction", 92)),
    CONSTRUCTION_99(new AchievementBuilder("Construction 99", 0, true).requirement("Construction", 99)),
    COOKS_DELIGHT(new AchievementBuilder("Cook's Delight", 0, true).requirement("Cook's Assistant", 1)),
    COOKING_RAMSAY(new AchievementBuilder("Cooking - Ramsay", 0, true).requirement("Ramsay", 1)),
    COOKING_5(new AchievementBuilder("Cooking 5", 0, true).requirement("Cooking", 5)),
    COOKING_10(new AchievementBuilder("Cooking 10", 0, true).requirement("Cooking", 10)),
    COOKING_20(new AchievementBuilder("Cooking 20", 0, true).requirement("Cooking", 20)),
    COOKING_30(new AchievementBuilder("Cooking 30", 0, true).requirement("Cooking", 30)),
    COOKING_40(new AchievementBuilder("Cooking 40", 0, true).requirement("Cooking", 40)),
    COOKING_50(new AchievementBuilder("Cooking 50", 0, true).requirement("Cooking", 50)),
    COOKING_60(new AchievementBuilder("Cooking 60", 0, true).requirement("Cooking", 60)),
    COOKING_70(new AchievementBuilder("Cooking 70", 0, true).requirement("Cooking", 70)),
    COOKING_80(new AchievementBuilder("Cooking 80", 0, true).requirement("Cooking", 80)),
    COOKING_90(new AchievementBuilder("Cooking 90", 0, true).requirement("Cooking", 90)),
    COOKING_92(new AchievementBuilder("Cooking 92", 0, true).requirement("Cooking", 92)),
    COOKING_99(new AchievementBuilder("Cooking 99", 0, true).requirement("Cooking", 99)),
    CORMES_AND_GOES(new AchievementBuilder("Cormes and Goes", 0, true).encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT,
        Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
        Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT,
            Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER,
            Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
        Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
        Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG))))),
    CORPOREAL_PUNISHMENT_I(new AchievementBuilder("Corporeal Punishment I", 0, true).requirement("Corporeal Beast", 5)),
    CORPOREAL_PUNISHMENT_II(new AchievementBuilder("Corporeal Punishment II", 0, true).requirement("Corporeal Beast", 10)),
    CORPOREAL_PUNISHMENT_III(new AchievementBuilder("Corporeal Punishment III", 0, true).requirement("Corporeal Beast", 25)),
    CORPOREAL_PUNISHMENT_IV(new AchievementBuilder("Corporeal Punishment IV", 0, true).requirement("Corporeal Beast", 50)),
    CORPOREAL_PUNISHMENT_V(new AchievementBuilder("Corporeal Punishment V", 0, true).requirement("Corporeal Beast", 75)),
    CORPOREAL_PUNISHMENT_VI(new AchievementBuilder("Corporeal Punishment VI", 0, true).requirement("Corporeal Beast", 100)),
    CORPOREAL_PUPPY(new AchievementBuilder("Corporeal Puppy", 0, true).requirement("Corporeal Puppy", 1)),
    COUNT_ALL_LIGHT_FINGERS(new AchievementBuilder("Count All Light Fingers", 0, true).requirement("From Tiny Acorns", 1)
        .requirement("Lost Her Marbles", 1).requirement("A Guild of Our Own", 1)),
    COURSING_THROUGH_YOU(new AchievementBuilder("Coursing Through You", 0, true).requirement("Max Telos enrage", 95)
        .encounter(new Encounter(Enemy.TELOS_100_ENRAGE))),
    COWER_BEHIND_THE_CHOSEN_COMMANDER(new AchievementBuilder("Cower Behind the Chosen Commander", 0, true)
        .requirement("The Chosen Commander", 1).lamp(Arrays.asList("Constitution", "Attack", "Defense"), 1000, 1)),
    CRAFTING_GEMI(new AchievementBuilder("Crafting - Gemi", 0, true).requirement("Gemi", 1)),
    CRAFTING_5(new AchievementBuilder("Crafting 5", 0, true).requirement("Crafting", 5)),
    CRAFTING_10(new AchievementBuilder("Crafting 10", 0, true).requirement("Crafting", 10)),
    CRAFTING_20(new AchievementBuilder("Crafting 20", 0, true).requirement("Crafting", 20)),
    CRAFTING_30(new AchievementBuilder("Crafting 30", 0, true).requirement("Crafting", 30)),
    CRAFTING_40(new AchievementBuilder("Crafting 40", 0, true).requirement("Crafting", 40)),
    CRAFTING_50(new AchievementBuilder("Crafting 50", 0, true).requirement("Crafting", 50)),
    CRAFTING_60(new AchievementBuilder("Crafting 60", 0, true).requirement("Crafting", 60)),
    CRAFTING_70(new AchievementBuilder("Crafting 70", 0, true).requirement("Crafting", 70)),
    CRAFTING_80(new AchievementBuilder("Crafting 80", 0, true).requirement("Crafting", 80)),
    CRAFTING_90(new AchievementBuilder("Crafting 90", 0, true).requirement("Crafting", 90)),
    CRAFTING_92(new AchievementBuilder("Crafting 92", 0, true).requirement("Crafting", 92)),
    CRAFTING_99(new AchievementBuilder("Crafting 99", 0, true).requirement("Crafting", 99)),
    CRAN_DOORS_SECRET(new AchievementBuilder("Cran Door's Secret", 0, true).requirement("Dragon Slayer", 1)),
    CRAYFISH_ROASTING_ON_AN_OPEN_FIRE(new AchievementBuilder("Crayfish Roasting On An Open Fire", 0, true).requirement("Raw crayfish", 1)
        .reward("Crayfish", 1).reward("Cooking", 30)),
    CREATOR_AND_DESTROYER(new AchievementBuilder("Creator and Destroyer", 0, true).requirement("Tower of Life", 1).requirement("Cowhide", 1)
        .requirement("Unicorn horn", 1).encounter(new Encounter(Enemy.UNICOW))),
    CROCODILE_TEARS(new AchievementBuilder("Crocodile Tears", 0, true).requirement("Crocodile Tears", 1)),
    CROSSING_OVER_I(new AchievementBuilder("Crossing Over I", 0, true).requirement("The Magister", 5)),
    CROSSING_OVER_II(new AchievementBuilder("Crossing Over II", 0, true).requirement("The Magister", 10)),
    CROSSING_OVER_III(new AchievementBuilder("Crossing Over III", 0, true).requirement("The Magister", 25)),
    CROSSING_OVER_IV(new AchievementBuilder("Crossing Over IV", 0, true).requirement("The Magister", 50)),
    CROSSING_OVER_V(new AchievementBuilder("Crossing Over V", 0, true).requirement("The Magister", 75)),
    CROSSING_OVER_VI(new AchievementBuilder("Crossing Over VI", 0, true).requirement("The Magister", 100)),
    DAEMONHEIM_SET_TASKS_EASY(new AchievementBuilder("Daemonheim Set Tasks - Easy", 0, true).requirement("Setting Up", 1)
        .requirement("It's Dangerous to go Alone", 1).requirement("Kitchen Aid", 1).requirement("The Lone Dungeoneer", 1)
        .requirement("Dere-licked", 1).requirement("Take It From the Top", 1).requirement("Change of a Dress", 1)
        .requirement("Gorajo Fandago", 1).requirement("You're Not the Boss of Me", 1).requirement("A Road Less Travelled", 1)
        .requirement("Invisible Ink", 1).requirement("Untouchable", 1).requirement("Fashion Victim", 1).requirement("Sinking Fast", 1)
        .requirement("Tales of Old", 1).requirement("A Flicker in Darkness", 1).lamp(Player.ALL_SKILLS, 2000, 23)),
    DAEMONHEIM_SET_TASKS_ELITE(new AchievementBuilder("Daemonheim Set Tasks - Elite", 0, true).requirement("Any fin is Possible", 1)
        .requirement("Orbful", 1).requirement("Top Hat", 1).requirement("In the Darkness Bind Them", 1).requirement("Pass the Port", 1)
        .requirement("Gulega-d to Rest", 1).lamp(Player.ALL_SKILLS, 60000, 98).lamp(Player.ALL_SKILLS, 50000, 90)
        .lamp(Player.ALL_SKILLS, 50000, 90).lamp(Player.ALL_SKILLS, 50000, 90)),
    DAEMONHEIM_SET_TASKS_HARD(new AchievementBuilder("Daemonheim Set Tasks - Hard", 0, true).requirement("Occult Classic", 1)
        .requirement("Stacked", 1).requirement("Kinprovements", 1).requirement("Lawful Crafting", 1)
        .requirement("Thanks for the Memories", 1).requirement("Healing Factor", 1).requirement("Alcrabholic", 1)
        .requirement("Hoof Rot", 1).requirement("A Prayer Opportunity", 1).requirement("The Wanderer", 1).requirement("Get Stuffed", 1)
        .requirement("Epic Epic", 1).reward("Dungeoneering token", 38000).lamp(Player.ALL_SKILLS, 20000, 74)),
    DAEMONHEIM_SET_TASKS_MEDIUM(new AchievementBuilder("Daemonheim Set Tasks - Medium", 0, true)
        .requirement("You Got Some Nice Drapes There", 1).requirement("I Want It All", 1).requirement("And I Want It Now", 1)
        .requirement("Marm's Armoury", 1).requirement("Tactical Retreat", 1).requirement("Port Enter", 1)
        .requirement("Totem Pole Position", 1).requirement("Nice to Meet You, Wall", 1).requirement("300", 1).requirement("Drink Me", 1)
        .requirement("Spinal Tap", 1).requirement("Cache Box", 1).requirement("Up to the Gods", 1).reward("Dungeoneering token", 2000)
        .lamp(Player.ALL_SKILLS, 8000, 41)),
    DAEMONOLOGY_OF_CELERITY(new AchievementBuilder("Daemonology of Celerity", 0, true).requirement("Demon flash mob", 1)),
    DAERO_TAKE_THIS_EXPERIENCE(new AchievementBuilder("Daero Take This Experience?", 0, true).requirement("Monkey Madness", 1)
        .reward("Attack", 20000).reward("Strength", 20000).reward("Defense", 10000).reward("Constitution", 20000)
        .lamp(Arrays.asList("Attack", "Strength"), 15000, 1).lamp(Arrays.asList("Constitution", "Defense"), 15000, 1)),
    DAGANNOTH_TRAFFIC_WARDENS(new AchievementBuilder("Dagannoth Traffic Wardens", 0, true).requirement("Koschei's Troubles", 1)
        .encounter(new Encounter(Enemy.DAGANNOTH_SUPREME, Collections.singletonList(new Restriction("Achromatic Balmung", 1))))
        .encounter(new Encounter(Enemy.DAGANNOTH_SUPREME, Collections.singletonList(new Restriction("Cobalt Balmung", 1))))
        .encounter(new Encounter(Enemy.DAGANNOTH_SUPREME, Collections.singletonList(new Restriction("Crimson Balmung", 1))))
        .encounter(new Encounter(Enemy.DAGANNOTH_SUPREME, Collections.singletonList(new Restriction("Viridian Balmung", 1))))),
    DAGANNOTH_FOR_EVERYONE_I(new AchievementBuilder("Dagannoth For Everyone I", 0, true).requirement("Dagannoth Kings", 5)),
    DAGANNOTH_FOR_EVERYONE_II(new AchievementBuilder("Dagannoth For Everyone II", 0, true).requirement("Dagannoth Kings", 10)),
    DAGANNOTH_FOR_EVERYONE_III(new AchievementBuilder("Dagannoth For Everyone III", 0, true).requirement("Dagannoth Kings", 25)),
    DAGANNOTH_FOR_EVERYONE_IV(new AchievementBuilder("Dagannoth For Everyone IV", 0, true).requirement("Dagannoth Kings", 50)),
    DAGANNOTH_FOR_EVERYONE_V(new AchievementBuilder("Dagannoth For Everyone V", 0, true).requirement("Dagannoth Kings", 75)),
    DAGANNOTH_FOR_EVERYONE_VI(new AchievementBuilder("Dagannoth For Everyone VI", 0, true).requirement("Dagannoth Kings", 100)),
    DARK_IMPERATORMENT(new AchievementBuilder("Dark Imperator-ment", 0, true).requirement("Constitution", 91).requirement("Attack", 75)
        .requirement("Magic", 75).requirement("Ranged", 75).requirement("Dimension of Disaster: Coin of the Realm", 1)
        .reward("Zemomark", 40)),
    DAY_AT_THE_AQUARIUM(new AchievementBuilder("Day at the Aquarium", 0, true).requirement("Beastmaster Durzag", 1)
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.YAKAMARU),
            Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU),
            Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU), Collections.singletonList(Enemy.IMAGE_OF_YAKAMARU))))),
    DAY_AT_THE_POUND(new AchievementBuilder("Day at the Pound", 0, true).encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT,
        Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER), Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
        Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER),
        Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
        Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CORMES),
        Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
        Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
        Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG))))),
    DEADLIER_CATCH(new AchievementBuilder("Deadlier Catch", 0, true).requirement("Thalassus hunts", 10)),
    DEATH_EFFECT(new AchievementBuilder("Death Effect", 0, true).requirement("Book of death", 1).requirement("Reaper's choice", 1)
        .requirement("Rainbow loot beam", 1).requirement("Grave loot beam", 1).requirement("Bonfire booster", 1)
        .requirement("Instance cost", 1).requirement("Additional tasks", 1).requirement("Reaper scroll", 1)
        .requirement("Death's support", 1)),
    DEATH_TO_THE_MAHJARRAT(new AchievementBuilder("Death to the Mahjarrat", 0, true).requirement("Mahjarrat deathstone", 4)),
    DEEP_AND_BLOODY_EXPERIENCE(new AchievementBuilder("Deep and Bloody Experience", 0, true).requirement("Blood Runs Deep", 1)
        .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75)
        .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75)
        .lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Ranged", "Magic", "Prayer"), 150000, 75)),
    DEFENSE_WALLACE(new AchievementBuilder("Defence - Wallace", 0, true).requirement("Wallace", 1)),
    DEFENSE_5(new AchievementBuilder("Defense 5", 0, true).requirement("Defense", 5)),
    DEFENSE_10(new AchievementBuilder("Defense 10", 0, true).requirement("Defense", 10)),
    DEFENSE_20(new AchievementBuilder("Defense 20", 0, true).requirement("Defense", 20)),
    DEFENSE_30(new AchievementBuilder("Defense 30", 0, true).requirement("Defense", 30)),
    DEFENSE_40(new AchievementBuilder("Defense 40", 0, true).requirement("Defense", 40)),
    DEFENSE_50(new AchievementBuilder("Defense 50", 0, true).requirement("Defense", 50)),
    DEFENSE_60(new AchievementBuilder("Defense 60", 0, true).requirement("Defense", 60)),
    DEFENSE_70(new AchievementBuilder("Defense 70", 0, true).requirement("Defense", 70)),
    DEFENSE_80(new AchievementBuilder("Defense 80", 0, true).requirement("Defense", 80)),
    DEFENSE_90(new AchievementBuilder("Defense 90", 0, true).requirement("Defense", 90)),
    DEFENSE_92(new AchievementBuilder("Defense 92", 0, true).requirement("Defense", 92)),
    DEFENSE_99(new AchievementBuilder("Defense 99", 0, true).requirement("Defense", 99)),
    DESCENSION_I(new AchievementBuilder("Descension I", 0, true).requirement("Legiones", 5)),
    DESCENSION_II(new AchievementBuilder("Descension II", 0, true).requirement("Legiones", 10)),
    DESCENSION_III(new AchievementBuilder("Descension III", 0, true).requirement("Legiones", 25)),
    DESCENSION_IV(new AchievementBuilder("Descension IV", 0, true).requirement("Legiones", 50)),
    DESCENSION_V(new AchievementBuilder("Descension V", 0, true).requirement("Legiones", 75)),
    DESCENSION_VI(new AchievementBuilder("Descension VI", 0, true).requirement("Legiones", 100)),
    DESERTED_GHOSTS(new AchievementBuilder("Desert-ed Ghosts", 0, true).requirement("The Curse of Zaros", 1)),
    DESERT_SET_TASKS_EASY(new AchievementBuilder("Desert Set Tasks - Easy", 0, true).requirement("Assassin's Feed", 1)
        .requirement("Touring Gear", 1).requirement("Memento Mori", 1).requirement("Fool's Gold", 1)
        .requirement("Don't You Dare Close Your Eyes", 1).requirement("Slash Fund", 1).requirement("Kookookachat", 1)
        .requirement("Fire at Will", 1).requirement("Seems Legit", 1).requirement("Extra Cheese", 1).requirement("I Like to Watch", 1)
        .requirement("Wiggle Room", 1).lamp(Player.ALL_SKILLS, 2000, 29)),
    DESERT_SET_TASKS_ELITE(new AchievementBuilder("Desert Set Tasks - Elite", 0, true).requirement("Staff on Stryke", 1)
        .requirement("Room Service", 1).requirement("Sun Shade", 1).requirement("A. B. Cithara", 1).requirement("Ankle Support", 1)
        .requirement("I'm Super", 1).lamp(Player.ALL_SKILLS, 30000, 77).lamp(Player.ALL_SKILLS, 30000, 77)
        .lamp(Player.ALL_SKILLS, 50000, 93).lamp(Player.ALL_SKILLS, 50000, 93)),
    DESERT_SET_TASKS_HARD(new AchievementBuilder("Desert Set Tasks - Hard", 0, true).requirement("Skinful", 1)
        .requirement("Water on the Brain", 1).requirement("More Fletcher than Sumona", 1).requirement("Ug Thankee Kindly", 1)
        .requirement("Nipped in the Bug", 1).requirement("Drafty in Here", 1).requirement("Enaqua", 1)
        .requirement("Say It, Don't Spray It", 1).requirement("1001 Kharidian Spikes", 1).requirement("Ice-Cold Killer", 1)
        .requirement("Ludikeris", 1).requirement("Security through Obscurity", 1).requirement("Wake-Up Call", 1)
        .requirement("Open Sesame", 1).lamp(Player.ALL_SKILLS, 20000, 1)),
    DESERT_SET_TASKS_MEDIUM(new AchievementBuilder("Desert Set Tasks - Medium", 0, true).requirement("So Su Me", 1)
        .requirement("Faster than a Speeding Bullet", 1).requirement("A Bridge Not Far", 1).requirement("Heathen Idle", 1)
        .requirement("Away with the Kalphites", 1).requirement("All Square", 1).requirement("Goat Harralader?", 1)
        .requirement("Taken for Granite", 1).requirement("Unbeetleable", 1).requirement("An Teak", 1).requirement("Overcut", 1)
        .lamp(Player.ALL_SKILLS, 8000, 43)),
    DHAROK_BOBBLEHEAD(new AchievementBuilder("Dharok Bobblehead", 0, true).requirement("Dharok the Bobbled", 1)),
    DIARIES_OF_THE_CLANS(new AchievementBuilder("Diaries of the Clans", 0, true).requirement("Voice of the Elders", 8)),
    DIARY_OF_OREB(new AchievementBuilder("Diary of Oreb", 0, true).requirement("The Magister's Journals", 5)),
    DIARY_OF_THE_GODS(new AchievementBuilder("Diary of the Gods", 0, true).requirement("God journals", 5)),
    DIDDYZAG(new AchievementBuilder("Diddyzag", 0, true).requirement("Diddyzag", 1)),
    DISHONOURABLE_GAINS(new AchievementBuilder("Dishonourable Gains", 0, true).requirement("Zamorak hideout XP chests", 3)),
    DISHONOURABLE_LOOT(new AchievementBuilder("Dishonourable Gains", 0, true).requirement("Zamorak hideout loot chests", 6)),
    DISOWNED(new AchievementBuilder("Disowned", 0, true).requirement("Reforged Sunspear", 1).requirement("House Drakan hood", 1)
        .requirement("House Drakan top", 1).requirement("House Drakan trousers", 1).requirement("House Drakan boots", 1)
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.VANSTROM_KLAUSE),
        Collections.singletonList(Enemy.VANSTROM_KLAUSE)), Arrays.asList(new Restriction("Reforged Sunspear", 1),
        new Restriction("House Drakan hood", 1), new Restriction("House Drakan top", 1), new Restriction("House Drakan trousers", 1),
            new Restriction("House Drakan boots", 1))))),
    DISTORTED_DIV(new AchievementBuilder("Distorted Div", 0, true).requirement("Distorted engrammeter", 1).reward("Divination", 25000)),
    DIVINATION_WILLOW(new AchievementBuilder("Divination - Willow", 0, true).requirement("Willow", 1)),
    DIVINATION_5(new AchievementBuilder("Divination 5", 0, true).requirement("Divination", 5)),
    DIVINATION_10(new AchievementBuilder("Divination 10", 0, true).requirement("Divination", 10)),
    DIVINATION_20(new AchievementBuilder("Divination 20", 0, true).requirement("Divination", 20)),
    DIVINATION_30(new AchievementBuilder("Divination 30", 0, true).requirement("Divination", 30)),
    DIVINATION_40(new AchievementBuilder("Divination 40", 0, true).requirement("Divination", 40)),
    DIVINATION_50(new AchievementBuilder("Divination 50", 0, true).requirement("Divination", 50)),
    DIVINATION_60(new AchievementBuilder("Divination 60", 0, true).requirement("Divination", 60)),
    DIVINATION_70(new AchievementBuilder("Divination 70", 0, true).requirement("Divination", 70)),
    DIVINATION_80(new AchievementBuilder("Divination 80", 0, true).requirement("Divination", 80)),
    DIVINATION_90(new AchievementBuilder("Divination 90", 0, true).requirement("Divination", 90)),
    DIVINATION_92(new AchievementBuilder("Divination 92", 0, true).requirement("Divination", 92)),
    DIVINATION_99(new AchievementBuilder("Divination 99", 0, true).requirement("Divination", 99)),
    DIVINE_RETRIBUTION(new AchievementBuilder("Divine Retribution", 0, true).requirement("Business Is Booning", 1)
        .requirement("Collecting Memorabilia", 1).requirement("Energy Generator", 1).requirement("Enrichment Programme", 1)
        .requirement("Just Give Me a Sign", 1).requirement("Let's Enhance", 1).requirement("Mighty Morphing", 1)
        .requirement("Portentially Hazardous", 1).requirement("Simply Divine", 1).requirement("What an Experience", 1)
        .reward("Flickering energy", 500)),
    DO_NO_ELITE(new AchievementBuilder("Do No Elite", 0, true).requirement("Do No Evil elite clue", 1)),
    DO_A_MINION_TAKE_NOTES(new AchievementBuilder("Do a Minion, Take Notes", 0, true).requirement("Dominion page", 20)),
    DOING_THE_IRONING(new AchievementBuilder("Doing the Ironing", 0, true).requirement("Mining", 15).reward("Iron ore", 1)),
    DONT_EAT_THE_POINTY_BIT(new AchievementBuilder("Don't Eat the Pointy Bit", 0, true).requirement("Coins", 25)
        .reward("Skewered kebab", 1)),
    DONT_FEAR_THE_RIPPER(new AchievementBuilder("Don't Fear the Ripper", 0, true).requirement("Miner's journals", 6)),
    DOUBLE_SWOOP(new AchievementBuilder("Double Swoop", 0, true).requirement("Ranged", 70)
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.FLIGHT_KILISA, Enemy.WINGMAN_SKREE, Enemy.FLOCKLEADER_GEERIN),
            Arrays.asList(Enemy.FLIGHT_KILISA, Enemy.WINGMAN_SKREE, Enemy.FLOCKLEADER_GEERIN, Enemy.KREEARRA))))),
    DRAGONKIN_LOGS(new AchievementBuilder("Dragonkin Logs", 0, true).requirement("Dragonkin journals", 4)),
    DRAYNOR(new AchievementBuilder("Draynor", 0, true)),
    DUKES_OF_KHAZARD(new AchievementBuilder("Dukes of Khazard", 0, true).encounter(new Encounter(Enemy.GNOME_TROOP))),
    DUNGEONEERING_GORDIE(new AchievementBuilder("Dungeoneering - Gordie", 0, true).requirement("Gordie", 1)),
    DUNGEONEERING_5(new AchievementBuilder("Dungeoneering 5", 0, true).requirement("Dungeoneering", 5)),
    DUNGEONEERING_10(new AchievementBuilder("Dungeoneering 10", 0, true).requirement("Dungeoneering", 10)),
    DUNGEONEERING_20(new AchievementBuilder("Dungeoneering 20", 0, true).requirement("Dungeoneering", 20)),
    DUNGEONEERING_30(new AchievementBuilder("Dungeoneering 30", 0, true).requirement("Dungeoneering", 30)),
    DUNGEONEERING_40(new AchievementBuilder("Dungeoneering 40", 0, true).requirement("Dungeoneering", 40)),
    DUNGEONEERING_50(new AchievementBuilder("Dungeoneering 50", 0, true).requirement("Dungeoneering", 50)),
    DUNGEONEERING_60(new AchievementBuilder("Dungeoneering 60", 0, true).requirement("Dungeoneering", 60)),
    DUNGEONEERING_70(new AchievementBuilder("Dungeoneering 70", 0, true).requirement("Dungeoneering", 70)),
    DUNGEONEERING_80(new AchievementBuilder("Dungeoneering 80", 0, true).requirement("Dungeoneering", 80)),
    DUNGEONEERING_90(new AchievementBuilder("Dungeoneering 90", 0, true).requirement("Dungeoneering", 90)),
    DUNGEONEERING_99(new AchievementBuilder("Dungeoneering 99", 0, true).requirement("Dungeoneering", 99)),
    DUNGEONEERING_110(new AchievementBuilder("Dungeoneering 110", 0, true).requirement("Dungeoneering", 110)),
    DUNGEONEERING_120(new AchievementBuilder("Dungeoneering 120", 0, true).requirement("Dungeoneering", 120)),
    DUSTING_MURIAL(new AchievementBuilder("Dusting Murial", 0, true).requirement("Dusted murals", 2)),
    EAGLES_PEAK(new AchievementBuilder("Eagles' Peak", 0, true)),
    EASTERN_ADVENTURER(new AchievementBuilder("Eastern Adventurer", 0, true).requirement("Port storylines", 4)),
    EASTERN_EXPLORER(new AchievementBuilder("Eastern Explorer", 0, true).requirement("The Shield region", 1)),
    EAT_TO_LIVE(new AchievementBuilder("Eat to Live", 0, true).requirement("Sardine", 1)),
    EDGEVILLE(new AchievementBuilder("Edgeville", 0, true)),
    EEEAGLE(new AchievementBuilder("Eeeeagle!", 0, true).requirement("Eagle transport routes", 5)),
    ELEMENTAL_KILL_CHAOS_I(new AchievementBuilder("Elemental Kill Chaos I", 0, true).requirement("Chaos Elemental", 5)),
    ELEMENTAL_KILL_CHAOS_II(new AchievementBuilder("Elemental Kill Chaos II", 0, true).requirement("Chaos Elemental", 10)),
    ELEMENTAL_KILL_CHAOS_III(new AchievementBuilder("Elemental Kill Chaos III", 0, true).requirement("Chaos Elemental", 25)),
    ELEMENTAL_KILL_CHAOS_IV(new AchievementBuilder("Elemental Kill Chaos IV", 0, true).requirement("Chaos Elemental", 50)),
    ELEMENTAL_KILL_CHAOS_V(new AchievementBuilder("Elemental Kill Chaos V", 0, true).requirement("Chaos Elemental", 75)),
    ELEMENTAL_KILL_CHAOS_VI(new AchievementBuilder("Elemental Kill Chaos VI", 0, true).requirement("Chaos Elemental", 100)),
    ELLIE(new AchievementBuilder("Ellie", 0, true).requirement("Ellie", 1)),
    ELVEN_TITLES(new AchievementBuilder("Elven Titles", 0, true).requirement("Elf City titles", 8)),
    ENERGY_GENERATOR(new AchievementBuilder("Energy Generator", 0, true).reward("Pale energy", 1).reward("Divination", 1)),
    ENOUGH_OF_THE_CRAZY_WALKING(new AchievementBuilder("Enough of the Crazy Walking", 0, true).requirement("Mad Ramblings", 2)),
    ENRICHMENT_PROGRAMME(new AchievementBuilder("Enrichment Programme", 0, true).reward("Divination", 2)),
    EPI_LOGUEQUE_EXPERIENCE(new AchievementBuilder("Epi Logueque Experience", 0, true).requirement("While Guthix Sleeps", 1)
        .lamp(Player.ALL_SKILLS, 100000, 65).lamp(Player.ALL_SKILLS, 100000, 65).lamp(Player.ALL_SKILLS, 100000, 65)
        .lamp(Player.ALL_SKILLS, 100000, 65)),
    ESSENTIAL_FACILITATOR(new AchievementBuilder("Essential Facilitator", 0, true)),
    EVERYBODY_LOVES_COAL(new AchievementBuilder("Everybody Loves Coal", 0, true).requirement("Mining", 30).reward("Coal", 1)
        .reward("Mining", 50)),
    EXILED(new AchievementBuilder("Exiled", 0, true).requirement("Kalphite King uniques", 8)),
    EXPERIENCE_THE_FATE_OF_THE_GODS(new AchievementBuilder("Experience the Fate of the Gods", 0, true)
        .requirement("Post-Fate of the Gods lamps", 4)),
    EXPLORE_FOR_NESTOR(new AchievementBuilder("Explore for Nestor", 0, true)),
    FACELESS_AND_READY(new AchievementBuilder("Faceless and Ready", 0, true)),
    FALADOR(new AchievementBuilder("Falador", 0, true)),
    FALADOR_SET_TASKS_EASY(new AchievementBuilder("Falador Set Tasks - Easy", 0, true).requirement("The Good Stuff", 1)
        .requirement("Amulet of Weedspeak", 1).requirement("Chain Store", 1).requirement("Sir Mitt", 1).requirement("Family Values", 1)
        .requirement("Sniffing Out the Mole", 1).requirement("Chinchompa Powered!", 1).requirement("Fill Yer Bucket", 1)
        .requirement("Elementary Medicine", 1).requirement("It's Not Wabbit Season", 1).requirement("Stand and Deliver", 1)
        .requirement("Making My Mind Up", 1).requirement("Mudskip the Light Fantastic", 1).requirement("Disarm and Embark", 1)
        .requirement("Going Along with the 'Fro", 1).lamp(Player.ALL_SKILLS, 1000, 30)),
    FALADOR_SET_TASKS_ELITE(new AchievementBuilder("Falador Set Tasks - Elite", 0, true).requirement("When This Cavern's Rockin'...", 1)
        .requirement("You'd Best Come A-cookin'", 1).requirement("Concentration is Key", 1).requirement("I Swear I Heard It Scream", 1)
        .requirement("I've Changed My Mind!", 1).requirement("A String and a Flare", 1).requirement("Altar-ed State", 1)
        .lamp(Player.ALL_SKILLS, 30000, 90).lamp(Player.ALL_SKILLS, 30000, 90).lamp(Player.ALL_SKILLS, 50000, 84)
        .lamp(Player.ALL_SKILLS, 50000, 72)),
    FALADOR_SET_TASKS_HARD(new AchievementBuilder("Falador Set Tasks - Hard", 0, true).requirement("It Matches My Eyes", 1)
        .requirement("Child of Saradomin", 1).requirement("Mass Production", 1).requirement("It Spoiled My View", 1)
        .requirement("The Stonemasons", 1).requirement("I Heard You Like Mudskips", 1).requirement("The Mogre Mash", 1)
        .requirement("Why Oh Wyvern", 1).requirement("Banned For Life", 1).requirement("A Knight in the Darkness", 1)
        .lamp(Player.ALL_SKILLS, 10000, 50)),
    FALADOR_SET_TASKS_MEDIUM(new AchievementBuilder("Falador Set Tasks - Medium", 0, true).requirement("Fruit of the Loom", 1)
        .requirement("Is It Hard to Walk Round?", 1).requirement("Climbing the Walls", 1).requirement("It's Nothing Personal", 1)
        .requirement("Ice the Icy", 1).requirement("Blinded with Science", 1).requirement("They Have Families to Feed", 1)
        .requirement("Stoic Sweetcorn Guardian", 1).requirement("Look Spiffy For Tiffy", 1).requirement("Do They Come in Other Colours", 1)
        .requirement("These Aren't the Coins You're Looking For", 1).requirement("Kitty Litter", 1).lamp(Player.ALL_SKILLS, 5000, 40)),
    FALLEN_ANGEL(new AchievementBuilder("Fallen Angel", 0, true).requirement("Angel of Death uniques", 10)),
    FAMILY_AFFAIR(new AchievementBuilder("Family Affair", 0, true).requirement("Rise of the Six uniques", 10)),
    FAMILY_SPIRIT_TREE(new AchievementBuilder("Family Spirit Tree", 0, true).requirement("Grown spirit trees", 3).reward("Farming", 50000)),
    FAMOUS(new AchievementBuilder("Famous", 0, true).requirement("Morvran Slayer challenge", 1).reward("Slayer", 50000)
        .reward("Slayer points", 45)),
    FARMING_BRAINS(new AchievementBuilder("Farming - Brains", 0, true).requirement("Brains", 1)),
    FARMING_5(new AchievementBuilder("Farming 5", 0, true).requirement("Farming", 5)),
    FARMING_10(new AchievementBuilder("Farming 10", 0, true).requirement("Farming", 10)),
    FARMING_20(new AchievementBuilder("Farming 20", 0, true).requirement("Farming", 20)),
    FARMING_30(new AchievementBuilder("Farming 30", 0, true).requirement("Farming", 30)),
    FARMING_40(new AchievementBuilder("Farming 40", 0, true).requirement("Farming", 40)),
    FARMING_50(new AchievementBuilder("Farming 50", 0, true).requirement("Farming", 50)),
    FARMING_60(new AchievementBuilder("Farming 60", 0, true).requirement("Farming", 60)),
    FARMING_70(new AchievementBuilder("Farming 70", 0, true).requirement("Farming", 70)),
    FARMING_80(new AchievementBuilder("Farming 80", 0, true).requirement("Farming", 80)),
    FARMING_90(new AchievementBuilder("Farming 90", 0, true).requirement("Farming", 90)),
    FARMING_92(new AchievementBuilder("Farming 92", 0, true).requirement("Farming", 92)),
    FARMING_99(new AchievementBuilder("Farming 99", 0, true).requirement("Farming", 99)),
    FAST_AND_FURIOUS_I(new AchievementBuilder("Fast and Furious I", 0, true).requirement("Twin Furies", 5)),
    FAST_AND_FURIOUS_II(new AchievementBuilder("Fast and Furious II", 0, true).requirement("Twin Furies", 10)),
    FAST_AND_FURIOUS_III(new AchievementBuilder("Fast and Furious III", 0, true).requirement("Twin Furies", 25)),
    FAST_AND_FURIOUS_IV(new AchievementBuilder("Fast and Furious IV", 0, true).requirement("Twin Furies", 50)),
    FAST_AND_FURIOUS_V(new AchievementBuilder("Fast and Furious V", 0, true).requirement("Twin Furies", 75)),
    FAST_AND_FURIOUS_VI(new AchievementBuilder("Fast and Furious VI", 0, true).requirement("Twin Furies", 100)),
    FEROCIOUS_UPGRADE(new AchievementBuilder("Ferocious Upgrade", 0, true).requirement("Slayer", 90).requirement("Slayer point", 100)),
    FINAL_BOSS(new AchievementBuilder("Final Boss", 0, true).requirement("Who's the Boss? VI", 1).requirement("General Mayhem VI", 1)
        .requirement("Zilly Way to Die VI", 1).requirement("Three Heads are Deader than One VI", 1).requirement("Mole Removal VI", 1)
        .requirement("Along Came a Spider VI", 1).requirement("Bug Swatter VI", 1).requirement("Vindictive and Vexatious VI", 1)
        .requirement("Fast and Furious VI", 1).requirement("Elemental Kill Chaos VI", 1).requirement("Hardly a Challenge VI", 1)
        .requirement("Barrowed Power VI", 1).requirement("Come and Have Vorago VI", 1).requirement("Nex Pls VI", 1)
        .requirement("Yak and Ruin VI", 1).requirement("Bird is the Word VI", 1).requirement("Kill K'ril VI", 1)
        .requirement("Corporeal Punishment VI", 1).requirement("Loot Pinata VI", 1).requirement("Descension VI", 1)
        .requirement("Dagannoth For Everyone VI", 1).requirement("Telos Where it Hurts VI", 1).requirement("This Helwyr in VI", 1)
        .requirement("Gregorgeous VI", 1).requirement("Living on a Prayer Switch VI", 1).requirement("Something Barrowed VI", 1)
        .requirement("Bug Zapper VI", 1).requirement("Brass Nex VI", 1).requirement("Master of Beatings VI", 1)),
    FINISH_HIM(new AchievementBuilder("Finish Him!", 0, true).encounter(new Encounter(Enemy.VORAGO))),
    FIREMAKING_BERNIE(new AchievementBuilder("Firemaking - Bernie", 0, true).requirement("Bernie", 1)),
    FIREMAKING_5(new AchievementBuilder("Firemaking 5", 0, true).requirement("Firemaking", 5)),
    FIREMAKING_10(new AchievementBuilder("Firemaking 10", 0, true).requirement("Firemaking", 10)),
    FIREMAKING_20(new AchievementBuilder("Firemaking 20", 0, true).requirement("Firemaking", 20)),
    FIREMAKING_30(new AchievementBuilder("Firemaking 30", 0, true).requirement("Firemaking", 30)),
    FIREMAKING_40(new AchievementBuilder("Firemaking 40", 0, true).requirement("Firemaking", 40)),
    FIREMAKING_50(new AchievementBuilder("Firemaking 50", 0, true).requirement("Firemaking", 50)),
    FIREMAKING_60(new AchievementBuilder("Firemaking 60", 0, true).requirement("Firemaking", 60)),
    FIREMAKING_70(new AchievementBuilder("Firemaking 70", 0, true).requirement("Firemaking", 70)),
    FIREMAKING_80(new AchievementBuilder("Firemaking 80", 0, true).requirement("Firemaking", 80)),
    FIREMAKING_90(new AchievementBuilder("Firemaking 90", 0, true).requirement("Firemaking", 90)),
    FIREMAKING_92(new AchievementBuilder("Firemaking 92", 0, true).requirement("Firemaking", 92)),
    FIREMAKING_99(new AchievementBuilder("Firemaking 99", 0, true).requirement("Firemaking", 99)),
    FIRES_ARE_MOSTLY_HARMLESS(new AchievementBuilder("Fires are Mostly Harmless", 0, true)
        .requirement("Fairy Tale III post-quest rewards", 2)),
    FIRST_RULE_OF_FIGHT_CAVES(new AchievementBuilder("First Rule of Fight Caves", 0, true).requirement("TzHaar uniques", 1)),
    FISH_FINGERS(new AchievementBuilder("Fish Fingers", 0, true).requirement("Strength", 35).requirement("Fishing", 55)
        .requirement("Barbarian Fishing Training", 1).reward("Fishing", 80).reward("Raw tuna", 1)),
    FISHING_BUBBLES(new AchievementBuilder("Fishing - Bubbles", 0, true).requirement("Bubbles", 1)),
    FISHING_5(new AchievementBuilder("Fishing 5", 0, true).requirement("Fishing", 5)),
    FISHING_10(new AchievementBuilder("Fishing 10", 0, true).requirement("Fishing", 10)),
    FISHING_20(new AchievementBuilder("Fishing 20", 0, true).requirement("Fishing", 20)),
    FISHING_30(new AchievementBuilder("Fishing 30", 0, true).requirement("Fishing", 30)),
    FISHING_40(new AchievementBuilder("Fishing 40", 0, true).requirement("Fishing", 40)),
    FISHING_50(new AchievementBuilder("Fishing 50", 0, true).requirement("Fishing", 50)),
    FISHING_60(new AchievementBuilder("Fishing 60", 0, true).requirement("Fishing", 60)),
    FISHING_70(new AchievementBuilder("Fishing 70", 0, true).requirement("Fishing", 70)),
    FISHING_80(new AchievementBuilder("Fishing 80", 0, true).requirement("Fishing", 80)),
    FISHING_90(new AchievementBuilder("Fishing 90", 0, true).requirement("Fishing", 90)),
    FISHING_92(new AchievementBuilder("Fishing 92", 0, true).requirement("Fishing", 92)),
    FISHING_99(new AchievementBuilder("Fishing 99", 0, true).requirement("Fishing", 99)),
    FIST_CONTACT(new AchievementBuilder("Fist Contact", 0, true).requirement("Strength", 70)
        .encounter(new Encounter(Enemy.GENERAL_GRAARDOR, Arrays.asList(new Restriction("Main-hand", 0), new Restriction("Off-hand", 0))))),
    FIVE_STAR_GENERAL(new AchievementBuilder("Five-Star General", 0, true).requirement("General Graardor uniques", 18)),
    FLETCHING_FLO(new AchievementBuilder("Fletching - Flo", 0, true).requirement("Flo", 1)),
    FLETCHING_5(new AchievementBuilder("Fletching 5", 0, true).requirement("Fletching", 5)),
    FLETCHING_10(new AchievementBuilder("Fletching 10", 0, true).requirement("Fletching", 10)),
    FLETCHING_20(new AchievementBuilder("Fletching 20", 0, true).requirement("Fletching", 20)),
    FLETCHING_30(new AchievementBuilder("Fletching 30", 0, true).requirement("Fletching", 30)),
    FLETCHING_40(new AchievementBuilder("Fletching 40", 0, true).requirement("Fletching", 40)),
    FLETCHING_50(new AchievementBuilder("Fletching 50", 0, true).requirement("Fletching", 50)),
    FLETCHING_60(new AchievementBuilder("Fletching 60", 0, true).requirement("Fletching", 60)),
    FLETCHING_70(new AchievementBuilder("Fletching 70", 0, true).requirement("Fletching", 70)),
    FLETCHING_80(new AchievementBuilder("Fletching 80", 0, true).requirement("Fletching", 80)),
    FLETCHING_90(new AchievementBuilder("Fletching 90", 0, true).requirement("Fletching", 90)),
    FLETCHING_92(new AchievementBuilder("Fletching 92", 0, true).requirement("Fletching", 92)),
    FLETCHING_99(new AchievementBuilder("Fletching 99", 0, true).requirement("Fletching", 99)),
    FLOOR_IS_LARVAL(new AchievementBuilder("Floor is Larval", 0, true).requirement("Summoning", 60)
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM,
            Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM),
            Arrays.asList(Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM,
                Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM), Arrays.asList(Enemy.GIANT_WORM, Enemy.GIANT_WORM,
                Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM, Enemy.GIANT_WORM,
                Enemy.GIANT_WORM, Enemy.GIANT_WORM), Collections.singletonList(Enemy.QUEEN_BLACK_DRAGON))))),
    FOR_THE_LOVE_OF_MABEL(new AchievementBuilder("For the Love of Mabel", 0, true).requirement("Love Story post-quest rewards", 1)),
    FORCAES_METTLE(new AchievementBuilder("Forcae's Mettle", 0, true).requirement("Forcae's journal page", 10)),
    FREDS_SHEARINGS(new AchievementBuilder("Fred's Shearings", 0, true).requirement("Sheep Shearer", 1)),
    FREMENNIK_PROVINCE(new AchievementBuilder("Fremennik Province", 0, true)),
    FREMENNIK_SET_TASKS_EASY(new AchievementBuilder("Fremennik Set Tasks - Easy", 0, true).requirement("King Conifer", 1)
        .requirement("Bring the Antipoisons", 1).requirement("Why Won't You Die?", 1).requirement("Assaulted Goodies", 1)
        .requirement("Oxymoron Incarnate", 1).requirement("Why Did the Lobster Blush?", 1).requirement("Hunting the Hunter", 1)
        .requirement("Peer of the Pier", 1).requirement("A Familiar Feeling", 1).requirement("Endangered Species", 1)
        .lamp(Player.ALL_SKILLS, 5000, 30)),
    FREMENNIK_SET_TASKS_ELITE(new AchievementBuilder("Fremennik Set Tasks - Elite", 0, true).requirement("Jaws Breaker", 1)
        .requirement("Limber Lumber Jumper", 1).requirement("Astronomical!", 1).requirement("First Stryke", 1)
        .requirement("Leap of Faith", 1).requirement("No Smoke Without Pyre", 1).requirement("This Hasta Work", 1)
        .requirement("Potting With Otto", 1).requirement("Axe'll Grease", 1).lamp(Player.ALL_SKILLS, 40000, 89)
        .lamp(Player.ALL_SKILLS, 30000, 86).lamp(Player.ALL_SKILLS, 30000, 86).lamp(Player.ALL_SKILLS, 30000, 86)
        .lamp(Player.ALL_SKILLS, 30000, 86)),
    FREMENNIK_SET_TASKS_HARD(new AchievementBuilder("Fremennik Set Tasks - Hard", 0, true).requirement("Pyre At Will", 1)
        .requirement("Defeating Deadly Dagannoths", 1).requirement("Dress to Impress", 1).requirement("The Graceful Barbarian", 1)
        .requirement("Runes on the Moon", 1).requirement("Fish Fingers", 1).requirement("Easy As Pie", 1)
        .requirement("How to Maim Your Dragon", 1).requirement("A Periodic Table", 1).lamp(Player.ALL_SKILLS, 15000, 50)),
    FREMENNIK_SET_TASKS_MEDIUM(new AchievementBuilder("Fremennik Set Tasks - Medium", 0, true).requirement("Yak Attack", 1)
        .requirement("Fremennik History 101", 1).requirement("Cool Story, Bro", 1).requirement("Who's a Good Boy?", 1)
        .requirement("Only Takes a Little Vial", 1).requirement("You Know You Want It!", 1).requirement("Fremmental", 1)
        .requirement("Fairy Mountaneering", 1).requirement("You Really Don't Need Any More Shoes", 1).requirement("Big Game Hunter", 1)
        .requirement("Grand Theft Fish", 1).lamp(Player.ALL_SKILLS, 10000, 40)),
    FRIENDLY_NEIGHBOUR(new AchievementBuilder("Friendly Neighbour", 0, true).requirement("Araxxor uniques", 15)),
    FRIENDS_WITH_MAX(new AchievementBuilder("Friends with Max", 0, true).requirement("Agility", 99).requirement("Attack", 99)
        .requirement("Strength", 99).requirement("Defense", 99).requirement("Ranged", 99).requirement("Prayer", 99)
        .requirement("Invention", 99).requirement("Constitution", 99).requirement("Crafting", 99).requirement("Mining", 99)
        .requirement("Smithing", 99).requirement("Fishing", 99).requirement("Cooking", 99).requirement("Firemaking", 99)
        .requirement("Woodcutting", 99).requirement("Runecrafting", 99).requirement("Dungeoneering", 99).requirement("Fletching", 99)
        .requirement("Herblore", 99).requirement("Thieving", 99).requirement("Magic", 99).requirement("Slayer", 99)
        .requirement("Farming", 99).requirement("Construction", 99).requirement("Hunter", 99).requirement("Summoning", 99)
        .requirement("Divination", 99)),
    GAME_OVER(new AchievementBuilder("Game Over", 0, true).requirement("Gregorovic uniques", 8)),
    GENERAL_AWWDOR(new AchievementBuilder("General Awwdor", 0, true).requirement("General Awwdor", 1)),
    GENERAL_DISASTER_I(new AchievementBuilder("General Disaster I", 0, true).requirement("General Graardor (hard)", 5)),
    GENERAL_DISASTER_II(new AchievementBuilder("General Disaster II", 0, true).requirement("General Graardor (hard)", 10)),
    GENERAL_DISASTER_III(new AchievementBuilder("General Disaster III", 0, true).requirement("General Graardor (hard)", 25)),
    GENERAL_DISASTER_IV(new AchievementBuilder("General Disaster IV", 0, true).requirement("General Graardor (hard)", 50)),
    GENERAL_DISASTER_V(new AchievementBuilder("General Disaster V", 0, true).requirement("General Graardor (hard)", 75)),
    GENERAL_DISASTER_VI(new AchievementBuilder("General Disaster VI", 0, true).requirement("General Graardor (hard)", 100)),
    GENERAL_MAYHEM_I(new AchievementBuilder("General Mayhem I", 0, true).requirement("General Graardor", 5)),
    GENERAL_MAYHEM_II(new AchievementBuilder("General Mayhem II", 0, true).requirement("General Graardor", 10)),
    GENERAL_MAYHEM_III(new AchievementBuilder("General Mayhem III", 0, true).requirement("General Graardor", 25)),
    GENERAL_MAYHEM_IV(new AchievementBuilder("General Mayhem IV", 0, true).requirement("General Graardor", 50)),
    GENERAL_MAYHEM_V(new AchievementBuilder("General Mayhem V", 0, true).requirement("General Graardor", 75)),
    GENERAL_MAYHEM_VI(new AchievementBuilder("General Mayhem VI", 0, true).requirement("General Graardor", 100)),
    GIFT_FROM_SLISKE(new AchievementBuilder("Gift from Sliske", 0, true).requirement("Sliske after-quest tasks", 2)),
    GLUTTON_FOR_PUNISHMENT(new AchievementBuilder("Glutton for Punishment", 0, true).requirement("Dreadfowl pouch", 1)
        .requirement("Thorny snail pouch", 1).requirement("Pack pig pouch", 1).requirement("Evil turnip pouch", 1)
        .requirement("War tortoise pouch", 1).requirement("Fruit bat pouch", 1).requirement("Granite lobster pouch", 1)
        .requirement("Bringing Home the Bacon", 1).requirement("Summer's End", 1).requirement("Summoning", 74)),
    GOD_WARS_DUNGEON_TELEPORT(new AchievementBuilder("God Wars Dungeon Teleport", 0, true).requirement("Law rune", 2)
        .requirement("The Mighty Fall", 1).requirement("Fire rune", 2).requirement("Magic", 61).reward("Magic", 68)),
    GOEBIE_RELICS(new AchievementBuilder("Goebie Relics", 0, true).requirement("Stone fragments", 5)),
    GOING_DOWN_WITH_THE_SHIP(new AchievementBuilder("Going Down with the Ship", 0.2, true).requirement("Fishing", 15)),
    GOING_FOR_A_PUNT(new AchievementBuilder("Going for a Punt", 0, true).requirement("Boater", 1).requirement("Woodcutting", 57)
        .reward("Woodcutting", 150)),
    GOING_ON_A_SUMMER_HOLIDAY(new AchievementBuilder("Going on a Summer Holidat", 0, true).requirement("Coins", 30)),
    GONE_FISHING(new AchievementBuilder("Gone Fishing", 0, true).requirement("Fishing", 15)),
    GONG_MAINTENACE_EXPERT(new AchievementBuilder("Gong Maintenance Expert", 0, true)
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.CHARGER, Enemy.CHARGER, Enemy.CORMES),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
            Arrays.asList(Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT, Enemy.AIRUT),
            Arrays.asList(Enemy.TUZ, Enemy.KRAR, Enemy.BEASTMASTER_DURZAG))))),
    GOOD_ENOUGH_FOR_A_GOBLIN(new AchievementBuilder("Good Enough for a Goblin", 0, true).requirement("Summer's End", 1)
        .encounter(new Encounter(Enemy.CORPOREAL_BEAST, Collections.singletonList(new Restriction("Bronze spear", 1))))),
    GOT_A_VYRE_REPUTATION(new AchievementBuilder("Got a Vyre Reputation", 0, true).requirement("Maximum vyre reputation", 1)),
    GRAARDONE(new AchievementBuilder("Graardone", 0, true).requirement("Strength", 70)
        .encounter(new Encounter(Enemy.GENERAL_GRAARDOR, Collections.singletonList(new Restriction("Ticks", 25))))),
    GREAT_GIELINOR_RUN(new AchievementBuilder("Great Gielinor Run", 0.25, true).requirement("The Branches of Darkmeyer", 1)
        .requirement("Regicide", 1)),
    GREG(new AchievementBuilder("Greg", 0, true).requirement("Greg", 1)),
    GREGOREY_I(new AchievementBuilder("Gregore-Y I", 0, true).requirement("Gregorovic (hard)", 5)),
    GREGOREY_II(new AchievementBuilder("Gregore-Y II", 0, true).requirement("Gregorovic (hard)", 10)),
    GREGOREY_III(new AchievementBuilder("Gregore-Y III", 0, true).requirement("Gregorovic (hard)", 25)),
    GREGOREY_IV(new AchievementBuilder("Gregore-Y IV", 0, true).requirement("Gregorovic (hard)", 50)),
    GREGOREY_V(new AchievementBuilder("Gregore-Y V", 0, true).requirement("Gregorovic (hard)", 75)),
    GREGOREY_VI(new AchievementBuilder("Gregore-Y VI", 0, true).requirement("Gregorovic (hard)", 100)),
    GREGORGEOUS_I(new AchievementBuilder("Gregorgeous I", 0, true).requirement("Gregorovic", 5)),
    GREGORGEOUS_II(new AchievementBuilder("Gregorgeous II", 0, true).requirement("Gregorovic", 10)),
    GREGORGEOUS_III(new AchievementBuilder("Gregorgeous III", 0, true).requirement("Gregorovic", 25)),
    GREGORGEOUS_IV(new AchievementBuilder("Gregorgeous IV", 0, true).requirement("Gregorovic", 50)),
    GREGORGEOUS_V(new AchievementBuilder("Gregorgeous V", 0, true).requirement("Gregorovic", 75)),
    GREGORGEOUS_VI(new AchievementBuilder("Gregorgeous VI", 0, true).requirement("Gregorovic", 100)),
    GRINDING_MY_GEARS(new AchievementBuilder("Grinding My Gears", 0, true).requirement("Wheat", 1).requirement("Empty pot", 1)
        .reward("Pot of flour", 1)),
    GRONDABANS_LEGACY(new AchievementBuilder("Grondaban's legacy", 0, true).requirement("Dishonour among Thieves", 1)),
    GUARD_IS_DEAD(new AchievementBuilder("Guard is Dead", 0, true).requirement("Dimension of Disaster: Coin of the Realm", 1)
        .encounter(new Encounter(Enemy.NEW_VARROCK_GUARD)).reward("Zemomark", 80)),
    GUNNING_FOR_JEWELLERY(new AchievementBuilder("Gunning for Jewellery", 0, true).requirement("Dororan's jewellery", 3)),
    GUTHAN_BOBBLEHEAD(new AchievementBuilder("Guthan Bobblehead", 0, true).requirement("Guthan the Bobbled", 1)),
    HAIL_TO_THE_QUEEN(new AchievementBuilder("Hail to the Queen", 0, true)
        .encounter(new Encounter(Arrays.asList(Arrays.asList(Enemy.KALPHITE_GUARDIAN, Enemy.KALPHITE_GUARDIAN,
            Enemy.KALPHITE_QUEEN_PHASE_1), Collections.singletonList(Enemy.KALPHITE_QUEEN_PHASE_2))))),
    HAIL_TO_THE_DUKE_BABY(new AchievementBuilder("Hail to the Duke, Baby", 0, true)),
    HAND_EXCHANGE(new AchievementBuilder("Hand Exchange", 0, true).requirement("Dimension of Disaster: Coin of the Realm", 1)
        .reward("Zemomark", 20)),
    HANDICRAFTS(new AchievementBuilder("Handicrafts", 0, true).requirement("Thread", 1).requirement("Leather", 1).reward("Crafting", 14)
        .reward("Leather gloves", 1)),
    HANG_ON_TO_SOMETHING(new AchievementBuilder("Hang On to Something", 0, true)),
    HAPPY_HOUR(new AchievementBuilder("Happy Hour", 0, true).requirement("Cider", 5)),
    HARD_AS_DAEMONS(new AchievementBuilder("Hard As Daemons", 0, true).requirement("Hard mode floors", 60)),
    HARD_AS_A_ROCK(new AchievementBuilder("Hard as a Rock", 0, true).requirement("Vorago uniques", 11)),
    HARDLY_A_CHALLENGE_I(new AchievementBuilder("Hardly a Challenge I", 0, true).requirement("Har-Aken", 5)),
    HARDLY_A_CHALLENGE_II(new AchievementBuilder("Hardly a Challenge II", 0, true).requirement("Har-Aken", 10)),
    HARDLY_A_CHALLENGE_III(new AchievementBuilder("Hardly a Challenge III", 0, true).requirement("Har-Aken", 25)),
    HARDLY_A_CHALLENGE_IV(new AchievementBuilder("Hardly a Challenge IV", 0, true).requirement("Har-Aken", 50)),
    HARDLY_A_CHALLENGE_V(new AchievementBuilder("Hardly a Challenge V", 0, true).requirement("Har-Aken", 75)),
    HARDLY_A_CHALLENGE_VI(new AchievementBuilder("Hardly a Challenge VI", 0, true).requirement("Har-Aken", 100)),
    HAUL_COMES_TO_TEMPLETON(new AchievementBuilder("Haul Comes to Templeton", 0.05, true).requirement("Dealing with Scabaras", 1)),
    HEAL_QUICKLY(new AchievementBuilder("Heal, Quickly", 0, true).requirement("Rapid Renewal", 1)),
    HEART_TO_HEART(new AchievementBuilder("Heart to Heart", 0, true).requirement("Twin Furies uniques", 9)),
    HEL_IN_A_HANDBASKET_I(new AchievementBuilder("Hel in a Handbasket I", 0, true).requirement("Helwyr (hard)", 5)),
    HEL_IN_A_HANDBASKET_II(new AchievementBuilder("Hel in a Handbasket II", 0, true).requirement("Helwyr (hard)", 10)),
    HEL_IN_A_HANDBASKET_III(new AchievementBuilder("Hel in a Handbasket III", 0, true).requirement("Helwyr (hard)", 25)),
    HEL_IN_A_HANDBASKET_IV(new AchievementBuilder("Hel in a Handbasket IV", 0, true).requirement("Helwyr (hard)", 50)),
    HEL_IN_A_HANDBASKET_V(new AchievementBuilder("Hel in a Handbasket V", 0, true).requirement("Helwyr (hard)", 75)),
    HEL_IN_A_HANDBASKET_VI(new AchievementBuilder("Hel in a Handbasket VI", 0, true).requirement("Helwyr (hard)", 100)),
    HERBIS_FLAX(new AchievementBuilder("Herbi's Flax", 0, true).requirement("Diary of Herbi Flax", 1).reward("Herblore", 335)),
    HERBLORE_HERBERT(new AchievementBuilder("Herblore - Herbert", 0, true).requirement("Herbert", 1)),
    HERBLORE_5(new AchievementBuilder("Herblore 5", 0, true).requirement("Herblore", 5)),
    HERBLORE_10(new AchievementBuilder("Herblore 10", 0, true).requirement("Herblore", 10)),
    HERBLORE_20(new AchievementBuilder("Herblore 20", 0, true).requirement("Herblore", 20)),
    HERBLORE_30(new AchievementBuilder("Herblore 30", 0, true).requirement("Herblore", 30)),
    HERBLORE_40(new AchievementBuilder("Herblore 40", 0, true).requirement("Herblore", 40)),
    HERBLORE_50(new AchievementBuilder("Herblore 50", 0, true).requirement("Herblore", 50)),
    HERBLORE_60(new AchievementBuilder("Herblore 60", 0, true).requirement("Herblore", 60)),
    HERBLORE_70(new AchievementBuilder("Herblore 70", 0, true).requirement("Herblore", 70)),
    HERBLORE_80(new AchievementBuilder("Herblore 80", 0, true).requirement("Herblore", 80)),
    HERBLORE_90(new AchievementBuilder("Herblore 90", 0, true).requirement("Herblore", 90)),
    HERBLORE_92(new AchievementBuilder("Herblore 92", 0, true).requirement("Herblore", 92)),
    HERBLORE_99(new AchievementBuilder("Herblore 99", 0, true).requirement("Herblore", 99)),
    HERE_WAS_A_SCABARAS_MASK(new AchievementBuilder("Here Was a Scabaras Mask", 0.05, true).requirement("Mining", 80)
        .requirement("Diamond in the Rough", 1).reward("Mining", 20000).reward("Scabaras mask", 1).reward("Was", 1)),
    HERE_WE_RAGO_AGAIN_I(new AchievementBuilder("Here We Rago Again I", 0, true).requirement("Vorago (hard)", 5)),
    HERE_WE_RAGO_AGAIN_II(new AchievementBuilder("Here We Rago Again II", 0, true).requirement("Vorago (hard)", 10)),
    HERE_WE_RAGO_AGAIN_III(new AchievementBuilder("Here We Rago Again III", 0, true).requirement("Vorago (hard)", 25)),
    HERE_WE_RAGO_AGAIN_IV(new AchievementBuilder("Here We Rago Again IV", 0, true).requirement("Vorago (hard)", 50)),
    HERE_WE_RAGO_AGAIN_V(new AchievementBuilder("Here We Rago Again V", 0, true).requirement("Vorago (hard)", 75)),
    HERE_WE_RAGO_AGAIN_VI(new AchievementBuilder("Here We Rago Again VI", 0, true).requirement("Vorago (hard)", 100)),
    HERO_OF_THE_GOEBIES(new AchievementBuilder("Hero of the Goebies", 0, true).requirement("All Together Now", 1)
        .requirement("Animal Cruelty", 1).requirement("Better Not Touch", 1).requirement("Cormes and Goes", 1)
        .requirement("Day at the Aquarium", 1).requirement("Day at the Pound", 1).requirement("Gong Maintenance Expert", 1)
        .requirement("Make Friends and Influence People", 1).requirement("Prison Break", 1).requirement("Rewind", 1)),
    HIDE_AND_SEEK(new AchievementBuilder("Hide and Seek", 0, true).requirement("Zombie cowhide", 1)
        .requirement("Dimension of Disaster: Coin of the Realm", 1).reward("Leather", 1).reward("Zemomark", 20)),
    HISTORY_OF_BILRACH(new AchievementBuilder("History of Bilrach", 0, true).requirement("Mysterious chronicle", 30)),
    HONESTLY_ITS_NOT_A_PURSE(new AchievementBuilder("Honestly, It's Not a Purse", 0, true).requirement("Giant pouch", 1)
        .requirement("Pure essence", 1)),
    HOW_MANY_GAMES(new AchievementBuilder("How Many Games?", 0, true).requirement("Profound helmet", 1)
        .requirement("Profound chestplate", 1).requirement("Profound platelegs", 1).requirement("Profound sword", 1)
        .requirement("Profound shield", 1)),
    HOW_TO_SHAME_YOUR_DRAGON(new AchievementBuilder("How to Shame Your Dragon", 0, true).requirement("King Black Dragon uniques", 1)),
    HUNGRY_HUNGRY_REAVERS(new AchievementBuilder("Hungry Hungry Reavers", 0, true).requirement("Frozen key", 1)
        .encounter(new Encounter(Enemy.NEX_ANGEL_OF_DEATH))),
    HUNTER_ACE(new AchievementBuilder("Hunter - Ace", 0, true).requirement("Ace", 1)),
    HUNTER_5(new AchievementBuilder("Hunter 5", 0, true).requirement("Hunter", 5)),
    HUNTER_10(new AchievementBuilder("Hunter 10", 0, true).requirement("Hunter", 10)),
    HUNTER_20(new AchievementBuilder("Hunter 20", 0, true).requirement("Hunter", 20)),
    HUNTER_30(new AchievementBuilder("Hunter 30", 0, true).requirement("Hunter", 30)),
    HUNTER_40(new AchievementBuilder("Hunter 40", 0, true).requirement("Hunter", 40)),
    HUNTER_50(new AchievementBuilder("Hunter 50", 0, true).requirement("Hunter", 50)),
    HUNTER_60(new AchievementBuilder("Hunter 60", 0, true).requirement("Hunter", 60)),
    HUNTER_70(new AchievementBuilder("Hunter 70", 0, true).requirement("Hunter", 70)),
    HUNTER_80(new AchievementBuilder("Hunter 80", 0, true).requirement("Hunter", 80)),
    HUNTER_90(new AchievementBuilder("Hunter 90", 0, true).requirement("Hunter", 90)),
    HUNTER_92(new AchievementBuilder("Hunter 92", 0, true).requirement("Hunter", 92)),
    HUNTER_99(new AchievementBuilder("Hunter 99", 0, true).requirement("Hunter", 99)),
    IM_FOREVER_WASHING_SHADOWS(new AchievementBuilder("I'm Forever Washing Shadows", 0, true).requirement("Blissful shadow core drops", 15)
        .requirement("Truthful shadow core drops", 15).requirement("Manifest shadow core drops", 15).reward("Divination", 50000)),
    I_CAN_SEE_FOR_MILES_AND_MILES(new AchievementBuilder("I Can See For Miles and Miles", 0, true)
        .requirement("Beacon keepers with macaws", 12)),
    I_DIG_THIS_TRANSPORTATION(new AchievementBuilder("I Dig This Transportation", 0, true).requirement("Digsite pendant unlock", 1)),
    I_GOT_THIS(new AchievementBuilder("I Got This", 0, true).requirement("Slayer", 95)
        .encounter(new Encounter(Arrays.asList(Collections.singletonList(Enemy.LEGIO), Collections.singletonList(Enemy.LEGIO),
            Collections.singletonList(Enemy.LEGIO), Collections.singletonList(Enemy.LEGIO), Collections.singletonList(Enemy.LEGIO),
            Collections.singletonList(Enemy.LEGIO))))),
    I_PRESUME_THESE_REWARDS_ARE_MINE_DEATH(new AchievementBuilder("I Presume Thes Rewards Are Mine, Death?", 0, true)
        .requirement("Missing, Presumed Death post-quest rewards", 4)),
    ICE_ICE_CHIMPY(new AchievementBuilder("Ice Ice Chimpy", 0, true).requirement("Chimp ice deliveries", 25)),
    ICTHLARINS_LITTLE_CHEST(new AchievementBuilder("Icthlarin's Little Chest", 0, true).requirement("Icthlarin's Little Helper", 1)
        .reward("Coins", 50)),
    IMPING_AROUND(new AchievementBuilder("Imping Around", 0, true).requirement("Daffyd implings", 16).reward("Hunter", 50000)),
    IMPRESSING_CHAR(new AchievementBuilder("Impressing Char", 0, true).requirement("The Firemaker's Curse", 1).requirement("Firemaking", 91)
        .reward("Firemaking", 7387)),
    IN_THE_SPIRIT_OF_THINGS(new AchievementBuilder("In the Spirit of Things", 0, true).requirement("Prayer", 80)
        .encounter(new Encounter(Enemy.GREGOROVIC))),
    INSANE_FINAL_BOSS(new AchievementBuilder("Insane Final Boss", 0, true).requirement("Final Boss", 1).requirement("Birdstrike VI", 1)
        .requirement("General Disaster", 1).requirement("Gregore-Y VI", 1).requirement("Hel in a Handbasket VI", 1)
        .requirement("Here We Rago Again VI", 1).requirement("Kill K'ril Vol 2 VI", 1).requirement("More Fast More Furious", 1)
        .requirement("Vindictive VI", 1).requirement("Whack a Mole VI", 1).requirement("Zillier Way to Die VI", 1)
        .requirement("Boss pets", 46)),
    INVENTION_MALCOLM(new AchievementBuilder("Invention - Malcolm", 0, true).requirement("Malcolm", 1)),
    INVENTION_5(new AchievementBuilder("Invention 5", 0, true).requirement("Invention", 5)),
    INVENTION_10(new AchievementBuilder("Invention 10", 0, true).requirement("Invention", 10)),
    INVENTION_20(new AchievementBuilder("Invention 20", 0, true).requirement("Invention", 20)),
    INVENTION_30(new AchievementBuilder("Invention 30", 0, true).requirement("Invention", 30)),
    INVENTION_40(new AchievementBuilder("Invention 40", 0, true).requirement("Invention", 40)),
    INVENTION_50(new AchievementBuilder("Invention 50", 0, true).requirement("Invention", 50)),
    INVENTION_60(new AchievementBuilder("Invention 60", 0, true).requirement("Invention", 60)),
    INVENTION_70(new AchievementBuilder("Invention 70", 0, true).requirement("Invention", 70)),
    INVENTION_80(new AchievementBuilder("Invention 80", 0, true).requirement("Invention", 80)),
    INVENTION_90(new AchievementBuilder("Invention 90", 0, true).requirement("Invention", 90)),
    INVENTION_99(new AchievementBuilder("Invention 99", 0, true).requirement("Invention", 99)),
    INVENTION_102(new AchievementBuilder("Invention 102", 0, true).requirement("Invention", 102)),
    INVENTION_110(new AchievementBuilder("Invention 110", 0, true).requirement("Invention", 110)),
    INVENTION_120(new AchievementBuilder("Invention 120", 0, true).requirement("Invention", 120)),
    INVENTION_GIVES_ME_THE_BLUES(new AchievementBuilder("Invention Gives Me the Blues", 0, true).requirement("Dwarven tech tree items", 8)
        .requirement("Cave goblin tech tree items", 8)),
    ITS_NOT_CALLED_SURGING_TOMBS(new AchievementBuilder("It's Not Called Surging Tombs", 0.05, true).requirement("The Jack of Spades", 1)
        .reward("Shifting Tombs", 1)),
    IVAN_IS_FLAILING(new AchievementBuilder("Ivan is Flailing", 0, true).requirement("Vyre corpses", 500)),
    JACK_OF_ALL_BLADES(new AchievementBuilder("Jack of All Blades", 0, true).requirement("Combat skilling pets", 9)),
    JACK_OF_ALL_TRADES(new AchievementBuilder("Jack of All Trades", 0, true).requirement("Non-combat skilling pets", 18)),
    JACK_OF_BLADES(new AchievementBuilder("Jack of Blades", 0, true).requirement("Combat skilling pets", 3)),
    JACK_OF_TRADES(new AchievementBuilder("Jack of Trades", 0, true).requirement("Non-combat skilling pets", 5)),
    JACK_OF_THE_CIRCUS(new AchievementBuilder("Jack of the Circus", 0, true).requirement("Circus clothing", 26)),
    JUST_GIVE_ME_A_SIGN(new AchievementBuilder("Just Give Me a Sign", 0, true).requirement("Divination", 6).requirement("Pale energy", 30)
        .requirement("Sapphire necklace", 1).reward("Sign of the porter I", 1).reward("Divination", 2)),
    KRIL_TINYROTH(new AchievementBuilder("K'ril Tinyroth", 0, true).requirement("K'ril Tinyroth", 1)),
    KRIL_WILL_BE_DONE(new AchievementBuilder("K'ril Will Be Done", 0, true).requirement("Constitution", 70)
        .encounter(new Encounter(Enemy.KRIL_TSUTSAROTH))),
    KRILOW(new AchievementBuilder("K'rilow", 0, true).requirement("Constitution", 70).requirement("Willow shieldbow", 1)
        .encounter(new Encounter(Enemy.KRIL_TSUTSAROTH, Collections.singletonList(new Restriction("Willow shieldbow", 1))))),
    KAIKIS_TUSKS(new AchievementBuilder("Kaiki's Tuska", 0, true).requirement("Kaigi's journal", 1)
        .requirement("Kaigi's journal pages", 4)),
    KALGERION_COMMANDER(new AchievementBuilder("Kal'gerion Commander", 0, true).requirement("Kal'gerion battle commendation", 5)),
    KALGERION_NOTES(new AchievementBuilder("Kal'gerion Notes", 0, true).requirement("Kal'gerion Notes", 5)),
    KALPHITE_GRUBLET_FLYING(new AchievementBuilder("Kalphite Grublet (Flying)", 0, true).requirement("Kalphite Grublet", 1)),
    KALPHITE_GRUBLET(new AchievementBuilder("Kalphite Grublet", 0, true).requirement("Kalphite Grublet", 1)),
    KALPHITE_GRUBLING(new AchievementBuilder("Kalphite Grubling", 0, true).requirement("Kalphite Grubling", 1)),
    KAMI_SPIRITS_OF_THE_ARC(new AchievementBuilder("Kami Spirits of the Arc", 0, true).requirement("Kami", 16).reward("Hunter", 50000)),
    KARAMJA(new AchievementBuilder("Karamja", 0, true)),
    ;
	/* Quests
	COOKS_ASSISTANT("Cook's Assistant", 0.25, new ArrayList<>(), new ArrayList<>(), Arrays.asList(new Reward("Cooking", 300),
			new Reward("Quest Points", 1), new Reward("Coins", 500), new Reward("Sardine", 20)), new ArrayList<>(), true),
	WATERFALL_QUEST("Waterfall Quest", 0.75, Arrays.asList(new Requirement("Air rune", 6), new Requirement("Water rune", 6),
			new Requirement("Earth rune", 6), new Requirement("Rope", 1)), new ArrayList<>(),
			Arrays.asList(new Reward("Quest Points", 1), new Reward("Attack", 13750),
					new Reward("Strength", 13750), new Reward("Gold bar", 2), new Reward("Diamond", 2),
					new Reward("Mithril seeds", 40)), new ArrayList<>(), true),
	CLOCK_TOWER("Clock Tower", 0.25, new ArrayList<>(), new ArrayList<>(), Arrays.asList(new Reward("Quest Points", 1),
			new Reward("Coins", 500)), new ArrayList<>(), true),
	THE_RESTLESS_GHOST("The Restless Ghost", 0.25, new ArrayList<>(), new ArrayList<>(), Arrays.asList(new Reward("Quest Points", 1),
			new Reward("Prayer", 1125)), new ArrayList<>(), true),
	MISSING_PRESUMED_DEATH("Missing, Presumed Death", 1, new ArrayList<>(), Arrays.asList(new Encounter(Arrays.asList(Enemy.WIGHT, Enemy.WIGHT, Enemy.WIGHT,
			Enemy.WIGHT)), new Encounter(Arrays.asList(Enemy.WIGHT_FOOTSOLDIER, Enemy.WIGHT_RANGER, Enemy.WIGHT_RANGER, Enemy.WIGHT_FOOTSOLDIER, Enemy.WIGHT_FOOTSOLDIER,
			Enemy.WIGHT_FOOTSOLDIER, Enemy.WIGHT_FOOTSOLDIER))), Arrays.asList(new Reward("Quest Points", 2),
			new Reward("Prayer", 500), new Reward("Agility", 1000)),
			Collections.singletonList(new Lamp(Arrays.asList("Attack", "Strength", "Defense", "Constitution", "Magic", "Ranged"), 1500))),
	MERLINS_CRYSTAL("Merlin's Crystal", 0.75, new ArrayList<>(), Collections.singletonList(new Encounter(Collections.singletonList(Enemy.SIR_MORDRED))),
			Arrays.asList(new Reward("Quest Points", 6), new Reward("Excalibur", 1),
					new Reward("Merlin's Crystal", 1)), new ArrayList<>(), true),
	HOLY_GRAIL("Holy Grail", 0.5, Arrays.asList(new Requirement("Merlin's Crystal", 1), new Requirement("Attack", 30),
			new Requirement("Excalibur", 1)), Collections.singletonList(new Encounter(Collections.singletonList(Enemy.BLACK_KNIGHT_TITAN))),
			Arrays.asList(new Reward("Quest Points", 2), new Reward("Prayer", 11000),
					new Reward("Defense", 15300)), new ArrayList<>(), true),
	PLAGUE_CITY("Plague City", 0.5, Arrays.asList(new Requirement("Dwellberries", 1), new Requirement("Rope", 1),
			new Requirement("Chocolate dust", 1), new Requirement("Snape grass", 1),
			new Requirement("Bucket of milk", 1)), new ArrayList<>(), Arrays.asList(new Reward("Quest Points", 1),
			new Reward("Mining", 2425), new Reward("Plague City", 1)), new ArrayList<>(), true),
	TREE_GNOME_VILLAGE("Tree Gnome Village", 0.75, Collections.singletonList(new Requirement("Logs", 5)),
			Collections.singletonList(new Encounter(Collections.singletonList(Enemy.KHAZARD_WARLORD))), Arrays.asList(new Reward("Attack", 11450),
			new Reward("Quest Points", 2)), new ArrayList<>(), true),
	HAZEEL_CULT("Hazeel Cult", 0.25, new ArrayList<>(), new ArrayList<>(), Arrays.asList(new Reward("Quest Points", 1), new Reward("Thieving", 1500),
			new Reward("Coins", 2005)), new ArrayList<>(), true),
	DRUIDIC_RITUAL("Druidic Ritual", 0.25, Collections.singletonList(new Requirement("Coins", 1)), new ArrayList<>(),
			Arrays.asList(new Reward("Quest Points", 4), new Reward("Herblore", 250), new Reward("Grimy guam", 15),
					new Reward("Eye of newt", 15)), new ArrayList<>(), true),
	RECRUITMENT_DRIVE("Recruitment Drive", 0.75, Collections.singletonList(new Requirement("Herblore", 3)),
			Collections.singletonList(new Encounter(Collections.singletonList(Enemy.SIR_LEYE))), Arrays.asList(new Reward("Quest Points", 1),
			new Reward("Recruitment Drive", 1)), new ArrayList<>(), true),
	RECRUITMENT_DRIVE_PRAYER_LAMP("Recruitment Drive prayer lamp", 0, true)Arrays.asList(new Requirement("Recruitment Drive", 1), new Requirement("Prayer", 8)),
			new ArrayList<>(), Collections.singletonList(new Reward("Prayer", 1000)), new ArrayList<>(), false),
	RECRUITMENT_DRIVE_HERBLORE_LAMP("Recruitment Drive herblore lamp", 0, true)Arrays.asList(new Requirement("Recruitment Drive", 1),
			new Requirement("Herblore", 8)), new ArrayList<>(), Collections.singletonList(new Reward("Herblore", 1000)), new ArrayList<>(), false),
	RECRUITMENT_DRIVE_AGILITY_LAMP("Recruitment Drive agility lamp", 0, true)Arrays.asList(new Requirement("Recruitment Drive", 1),
			new Requirement("Agility", 8)), new ArrayList<>(), Collections.singletonList(new Reward("Agility", 1000)), new ArrayList<>(), false),
	BUY_A_PLAYER_OWNED_HOUSE("Buy a player-owned house", 0, true)Collections.singletonList(new Requirement("Coins", 1000)),
			new ArrayList(), Collections.singletonList(new Reward("Player-owned house", 1)), new ArrayList<>(), false),
	BUILD_A_PARLOUR("Build a parlour", 0, true)Arrays.asList(new Requirement("Player-owned house", 1), new Requirement("Coins", 1000)),
			new ArrayList(), Collections.singletonList(new Reward("Parlour", 1)), new ArrayList<>(), false),
	STOLEN_HEARTS("Stolen Hearts", 1, new ArrayList<>(), Collections.singletonList(new Encounter(Arrays.asList(Enemy.SKULLS_MERCENARY, Enemy.SKULLS_MERCENARY, Enemy.SKULLS_MERCENARY))),
			Arrays.asList(new Reward("Quest Points", 3), new Reward("Coins", 2500), new Reward("Constitution", 250),
			new Reward("Agility", 250), new Reward("Thieving", 250), new Reward("Stolen Hearts", 1)),
			Collections.singletonList(new Lamp(Arrays.asList("Attack", "Strength", "Defense", "Magic", "Constitution", "Ranged", "Prayer"), 250))),
	DIAMOND_IN_THE_ROUGH("Diamond in the Rough", 1, Collections.singletonList(new Requirement("Stolen Hearts", 1)),
			Arrays.asList(new Encounter(Arrays.asList(Enemy.BANDIT, Enemy.BANDIT, Enemy.BANDIT_KING)), new Encounter(Arrays.asList(Enemy.APEP, Enemy.HERU))),
			Arrays.asList(new Reward("Diamond in the Rough", 1), new Reward("Quest Points", 1), new Reward("Agility", 250),
					new Reward("Thieving", 250), new Reward("Constitution", 250), new Reward("Sapphire", 1),
					new Reward("Emerald", 1), new Reward("Ruby", 1)), Collections.singletonList(new Lamp(Arrays.asList("Attack",
			"Strength", "Defense", "Magic", "Constitution", "Ranged", "Prayer"), 250))),
	THE_JACK_OF_SPADES("The Jack of Spades", 0.5, Collections.singletonList(new Requirement("Diamond in the Rough", 1)),
			new ArrayList(), Arrays.asList(new Reward("The Jack of Spades", 1), new Reward("Quest Points", 1),
			new Reward("Agility", 500), new Reward("Construction", 500), new Reward("Dungeoneering", 500),
			new Reward("Thieving", 500)), new ArrayList<>(), true),
	WITCHS_HOUSE("Witch's House", 0.25, new ArrayList<>(), Collections.singletonList(new Encounter(Arrays.asList(Enemy.WITCHS_EXPERIMENT_1,
			Enemy.WITCHS_EXPERIMENT_2, Enemy.WITCHS_EXPERIMENT_3, Enemy.WITCHS_EXPERIMENT_4))), Arrays.asList(new Reward("Quest Points", 4),
			new Reward("Constitution", 6325)), new ArrayList<>(), true),
	RUNE_MYSTERIES("Rune Mysteries", 1, new ArrayList(), new ArrayList(), Arrays.asList(new Reward("Rune Mysteries", 1),
			new Reward("Magic", 250), new Reward("Runecrafting", 250), new Reward("Quest Points", 1),
			new Reward("Tower mindspike", 1), new Reward("First tower hat", 1), new Reward("Air talisman", 1),
			new Reward("Mind rune", 70)), new ArrayList<>(), true),
	GERTRUDES_CAT("Gertrude's Cat", 0.75, Arrays.asList(new Requirement("Raw sardine", 1), new Requirement("Bucket of milk", 1),
			new Requirement("Coins", 100)), new ArrayList<>(), Arrays.asList(new Reward("Quest Points", 1),
			new Reward("Kitten", 1), new Reward("Chocolate cake", 1), new Reward("Stew", 1),
			new Reward("Gertrude's Cat", 1)), new ArrayList<>(), true),
	GERTRUDES_CAT_LAMP("Gertrude's Cat Lamp", 0, true)Arrays.asList(new Requirement("Gertrude's Cat", 1), new Requirement("Cooking", 14)),
			new ArrayList<>(), Collections.singletonList(new Reward("Cooking", 1525)), new ArrayList<>(), false),;*/

    private String name; //name of the task
    private double time; //est. time taken in hours [not including time to gather items/complete requirements]
    private List<Requirement> reqs; //list of requirements
    private List<Encounter> encounters; //list of combat encounters
    private List<Reward> rewards; //list of static rewards
    private List<Lamp> lamps; //list of lamps
    private boolean display; //if task is a "true" achievement, and should be displayed on the task list

    Achievement(AchievementBuilder builder) {
        this.name = builder.name;
        this.time = builder.time;
        this.reqs = builder.reqs;
        this.encounters = builder.encounters;
        this.rewards = builder.rewards;
        this.lamps = builder.lamps;
        this.display = builder.display;
    }

    private static class AchievementBuilder {

        private String name;
        private double time;
        private List<Requirement> reqs;
        private List<Encounter> encounters;
        private List<Reward> rewards;
        private List<Lamp> lamps;
        private boolean display;

        public AchievementBuilder(String name, double time, boolean display) {
            this.name = name;
            this.time = time;
            this.display = display;
            this.reqs = new ArrayList<>();
            this.encounters = new ArrayList<>();
            this.rewards = new ArrayList<>();
            this.lamps = new ArrayList<>();
        }

        public AchievementBuilder requirement(String qualifier, int quantifier) {
            reqs.add(new Requirement(qualifier, quantifier));
            return this;
        }

        public AchievementBuilder encounter(Encounter encounter) {
            encounters.add(encounter);
            return this;
        }

        public AchievementBuilder reward(String qualifier, int quantifier) {
            rewards.add(new Reward(qualifier, quantifier));
            return this;
        }

        public AchievementBuilder lamp(List<String> choices, int xp, int minLevel) {
            lamps.add(new Lamp(choices, xp, minLevel));
            return this;
        }
    }

    public GoalResults getTimeForRequirements(Player player) {
        double totalTimeForAllReqs = 0;
        Map<String, Double> totalActionsWithTimesForAllReqs = new HashMap<>();
        List<Requirement> recursiveRequirements = new ArrayList<>();
        Map<String, Double> originalMap = player.getXp().entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        List<Weapon> weaponList = new ArrayList<>(player.getWeapons());
        for (Requirement r : reqs) {
            GoalResults resultsForOneRequirement = r.timeAndActionsToMeetRequirement(player);
            for (Entry<String, Double> actionWithTime : resultsForOneRequirement.getActionsWithTimes().entrySet()) {
                if (Achievement.getAchievementByName(actionWithTime.getKey()) == null || !totalActionsWithTimesForAllReqs.containsKey(actionWithTime.getKey())) {
                    totalActionsWithTimesForAllReqs.put(actionWithTime.getKey(), actionWithTime.getValue());
                    totalTimeForAllReqs += actionWithTime.getValue();
                }
            }
            recursiveRequirements.addAll(resultsForOneRequirement.getRequirements());
            if (Player.ALL_SKILLS.contains(r.getQualifier())) {
                player.getXp().put(r.getQualifier(), player.getXp().get(r.getQualifier()) + player.getXpToLevel(r.getQualifier(), r.getQuantifier()));
            }
            if (Weapon.getWeaponByName(r.getQualifier()) != null) {
                player.addWeapon(Weapon.getWeaponByName(r.getQualifier()));
            }
        }
        for (Requirement r : recursiveRequirements) {
            if (Player.ALL_SKILLS.contains(r.getQualifier())) {
                player.getXp().put(r.getQualifier(), player.getXp().get(r.getQualifier()) + player.getXpToLevel(r.getQualifier(), r.getQuantifier()));
            }
        }
        for (Encounter e : encounters) {
            CombatResults meleeCombatResults = e.calculateCombat(player, 27, "Melee");
            CombatResults rangedCombatResults = e.calculateCombat(player, 27, "Ranged");
            CombatResults magicCombatResults = e.calculateCombat(player, 27, "Magic");
            if (meleeCombatResults.getHpLost() > 1000000 && rangedCombatResults.getHpLost() > 1000000 && magicCombatResults.getHpLost() > 1000000) {
                //System.out.println("Time to update the combat simulator");
                totalTimeForAllReqs += 2147000.0;
            }
        }
        player.setXp(originalMap);
        player.setWeapons(weaponList);
        return new GoalResults(totalTimeForAllReqs, recursiveRequirements, totalActionsWithTimesForAllReqs);
    }

    public double getGainFromRewards(Player player) {
        double totalGainFromAllRewards = 0;
        for (Reward r : rewards) {
            totalGainFromAllRewards += r.getGainFromReward(player);
        }
        for (Lamp lamp : lamps) {
            try {
                totalGainFromAllRewards += lamp.getBestReward(player).getGainFromReward(player);
            } catch (NullPointerException e) { //can't access lamp yet
                totalGainFromAllRewards -= 1000000000;
            }
        }
        for (Encounter e : encounters) {
            for (List<Enemy> enemyGroup : e.getEnemyGroups())
                for (Enemy enemy : enemyGroup)
                    totalGainFromAllRewards += player.efficientGoalCompletion("Constitution", (int) enemy.getHpxp()).getTotalTime();
            //totalGainFromAllRewards += player.getActionDatabase().bestEffectiveRate("Combat", player);
        }
        return totalGainFromAllRewards;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    public List<Requirement> getReqs() {
        return reqs;
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public List<Lamp> getLamps() {
        return lamps;
    }

    public boolean isDisplay() {
        return display;
    }

    public static Achievement getAchievementByName(String name) {
        for (Achievement a : values()) {
            if (a.getName().equals(name))
                return a;
        }
        return null;
    }
}