package logic;


import com.google.common.collect.ImmutableMap;
import com.google.gson.annotations.Expose;
import data.databases.AchievementDatabase;
import data.databases.ActionDatabase;
import data.databases.ArmourDatabase;
import data.databases.FamiliarDatabase;
import data.databases.ItemDatabase;
import data.databases.WeaponDatabase;
import data.dataobjects.Achievement;
import data.dataobjects.Action;
import data.dataobjects.Armour;
import data.dataobjects.Enemy;
import data.dataobjects.Familiar;
import data.dataobjects.Item;
import data.dataobjects.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {

    //Ordered by Jagex ID
    public static final LinkedHashSet<String> ALL_SKILLS = new LinkedHashSet<>(Arrays.asList("Attack", "Defence", "Strength", "Constitution",
        "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining",
        "Herblore", "Agility", "Thieving", "Slayer", "Farming", "Runecrafting", "Hunter", "Construction", "Summoning",
        "Dungeoneering", "Divination", "Invention", "Archaeology"));

    public static final LinkedHashSet<String> PORTS_SKILLS = new LinkedHashSet<>(Arrays.asList("Agility", "Construction", "Cooking",
        "Divination", "Dungeoneering", "Fishing", "Herblore", "Hunter", "Prayer", "Runecrafting", "Slayer", "Thieving"));

    private static final HashSet<String> COMBAT_STYLES = new HashSet<>(Arrays.asList("Melee", "Ranged", "Magic"));

    private static final int[] XP_TO_LEVELS = {0, 83, 174, 276, 388, 512, 650, 801, 969, 1154, 1358, 1584, 1833, 2107, 2411, 2746, 3115, 3523,
        3973, 4470, 5018, 5624, 6291, 7028, 7842, 8740, 9730, 10824, 12031, 13363, 14833, 16456, 18247, 20224, 22406, 24815, 27473, 30408, 33648,
        37224, 41171, 45529, 50339, 55649, 61512, 67983, 75127, 83014, 91721, 101333, 111945, 123660, 136954, 150872, 166636, 184040, 203254, 224466,
        247886, 273742, 302288, 333804, 368599, 407015, 449428, 496254, 547953, 605032, 668051, 737627, 814445, 899257, 992895, 1086278, 1210421,
        1336443, 1475581, 1629200, 1798808, 1986068, 2192818, 2421087, 2673114, 2951373, 3258594, 3597792, 3972294, 4385776, 4842295, 5346332, 5902831,
        6517253, 7195629, 7944614, 8771558, 9684577, 10692629, 11805606, 13034431, 14391160, 15889109, 17542976, 19368992, 21385073, 23611006, 26068632,
        28782069, 31777943, 35085654, 38737661, 42769801, 47221641, 52136869, 57563718, 63555443, 70170840, 77474828, 85539082, 94442737, 104273167};

    private static final int[] XP_TO_LEVELS_ELITE = {0, 830, 1861, 2902, 3980, 5126, 6390, 7787, 9400, 11275, 13605, 16372, 19656, 23546, 28138, 33520, 39809, 47109,
        55535, 64802, 77190, 90811, 106221, 123573, 143025, 164742, 188893, 215651, 245196, 277713, 316311, 358547, 404634, 454796, 509259, 568254, 632019, 700797, 774834,
        854383, 946227, 1044569, 1149696, 1261903, 1381488, 1508756, 1644015, 1787581, 1939773, 2100917, 2283490, 2476369, 2679907, 2894505, 3120508, 3358307, 3608290, 3870846,
        4146374, 4435275, 4758122, 5096111, 5449685, 5819299, 6205407, 6608473, 7028964, 7467354, 7924122, 8399751, 8925664, 9472665, 10041285, 10632061, 11245538,
        11882262, 12542789, 13227679, 13937496, 14672812, 15478994, 16313404, 17176661, 18069395, 18992239, 19945833, 20930821, 21947856, 22997593, 24080695, 25259906,
        26475754, 27728955, 29020233, 30350318, 31719944, 33129852, 34580790, 36073511, 37608773, 39270442, 40978509, 42733789, 44537107, 46389292, 48291180,
        50243611, 52247435, 54303504, 56412678, 58575823, 60793812, 63067521, 65397835, 67785643, 70231841, 72737330, 75303019, 77929820, 80618654, 83370445, 86186124,
        89066630, 92012904, 95025896, 98106559, 101255855, 104474750, 107764216, 111125230, 114558777, 118065845, 121647430, 125304532, 129038159, 132849323, 136739041,
        140708338, 144758242, 148889790, 153104021, 157401983, 161784728, 166253312, 170808801, 175452262, 180184770, 185007406, 189921255, 194927409};

    @Expose private String name;
    @Expose private int status; //0 = mainscape, 1 = ironman, 2 = HCIM
    @Expose private Map<String, Double> xp = new HashMap<>();
    @Expose private Map<String, Integer> qualities = new HashMap<>();
    @Expose private Map<String, Long> bank = new HashMap<>();
    @Expose private LinkedHashSet<Weapon> weapons = new LinkedHashSet<>();
    @Expose private LinkedHashSet<Armour> armour = new LinkedHashSet<>();

    private long bankValue = 0;

    private List<Requirement> currentTargets = new ArrayList<>();
    private List<QualifierAction> lockedActions = new ArrayList<>();
    private double actionMinimum = 1000000000.0;

    private Map<Requirement, GoalResults> previousEfficiencyResults = new HashMap<>();
    private Map<Requirement, Double> previousImpossibleResults = new HashMap<>();
    private Map<Achievement, GoalResults> achievementResults = new HashMap<>();

    //should only be used when loading a profile
    public Player(String name) {
        this.name = name;
    }

    public Player(String name, String status) {
        this.name = name;
        if (status.equals("Mainscape"))
            this.status = 0;
        else if (status.equals("Ironman"))
            this.status = 1;
        else if (status.equals("Hardcore"))
            this.status = 2;
        xp = setInitialXP();
        //While these aren't obtained strictly at startup, they can be obtained for free in 30 seconds.
        weapons.add(WeaponDatabase.getWeaponDatabase().getWeapons().get("Bronze sword"));
        weapons.add(WeaponDatabase.getWeaponDatabase().getWeapons().get("Bronze off hand sword"));
        weapons.add(WeaponDatabase.getWeaponDatabase().getWeapons().get("Chargebow"));
        weapons.add(WeaponDatabase.getWeaponDatabase().getWeapons().get("Staff"));
    }

    public Map<String, Double> getXp() {
        return xp;
    }

    public Map<String, Long> getBank() {
        return bank;
    }

    public long getBankValue() {
        return bankValue;
    }

    public Map<String, Integer> getQualities() {
        return qualities;
    }

    public Set<Weapon> getWeapons() {
        return weapons;
    }

    public Set<Armour> getArmour() {
        return armour;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Map<Achievement, GoalResults> getAchievementResults() {
        return achievementResults;
    }

    public void setWeapons(LinkedHashSet<Weapon> newWeapons) {
        weapons = newWeapons;
    }

    public void setArmour(LinkedHashSet<Armour> newArmour) {
        armour = newArmour;
    }

    public void setXp(Map<String, Double> newXp) {
        xp = newXp;
    }

    public void setBank(Map<String, Long> bank) {
        this.bank = bank;
    }

    public void setQualities(Map<String, Integer> qualities) {
        this.qualities = qualities;
    }

    private Map<String, Double> setInitialXP() {
        Map<String, Double> initialXP = new HashMap<>();
        for (String skill : Player.ALL_SKILLS) {
            initialXP.put(skill, 0.0);
        }
        initialXP.put("Constitution", 1154.0);
        return initialXP;
    }

    public int getLevel(String skill) {
        double skillXp = xp.get(skill);
        if (skill.equals("Invention")) {
            for (int i = 1; i < XP_TO_LEVELS_ELITE.length; i++) {
                if (skillXp < XP_TO_LEVELS_ELITE[i]) {
                    return i;
                }
                if (i == 120) {
                    return 120;
                }
            }
        } else {
            for (int i = 1; i < XP_TO_LEVELS.length; i++) {
                if (skillXp < XP_TO_LEVELS[i]) {
                    return i;
                }
                if (i == 99 && !(skill.equals("Dungeoneering") || skill.equals("Slayer"))) {
                    return 99;
                }
            }
        }
        return 120;
    }

    public int getVirtualLevel(String skill) {
        double skillXp = xp.get(skill);
        if (skill.equals("Invention")) {
            for (int i = 1; i < XP_TO_LEVELS_ELITE.length; i++) {
                if (skillXp < XP_TO_LEVELS_ELITE[i]) {
                    return i;
                }
            }
            return 150;
        } else {
            for (int i = 1; i < XP_TO_LEVELS.length; i++) {
                if (skillXp < XP_TO_LEVELS[i]) {
                    return i;
                }
            }
            return 120;
        }
    }

    public double calcCombatLevel() {
        return (13 * Math.max(getLevel("Attack") + getLevel("Strength"), Math.max(getLevel("Ranged") * 2, getLevel("Magic") * 2)) / 10.0 +
            getLevel("Defence") + getLevel("Constitution") + getLevel("Prayer") / 2.0 + getLevel("Summoning") / 2.0) / 4.0;
    }

    public int getXpToLevel(String skill, int level) {
        if (skill.equals("Invention")) {
            return Math.max(0, XP_TO_LEVELS_ELITE[level - 1] - xp.get(skill).intValue());
        } else {
            return Math.max(0, XP_TO_LEVELS[level - 1] - xp.get(skill).intValue());
        }
    }

    public Map<String, Double> nextGear(String combatStyle) {
        if (!COMBAT_STYLES.contains(combatStyle)) {
            throw new IllegalArgumentException(String.format("Combat style provided was %s. Must be Melee, Ranged, or Magic.", combatStyle));
        }
        double minTimeToGear = 1000000000.0;
        String minGear = null;
        int nextSummonReq = 100;
        String nextFamiliar = null;
        for (Familiar familiar : FamiliarDatabase.getFamiliarDatabase().getFamiliars()) {
            if (familiar.getSummonReq() > getLevel("Summoning") && familiar.getSummonReq() < nextSummonReq) {
                nextSummonReq = familiar.getSummonReq();
                nextFamiliar = familiar.getName();
            }
        }
        if (nextFamiliar != null) {
            double familiarTime = new Requirement("Summoning", nextSummonReq).timeAndActionsToMeetRequirement(this).getTotalTime();
            if (minTimeToGear > familiarTime) {
                minTimeToGear = familiarTime;
                minGear = nextFamiliar;
            }
        }
        List<String> skills = new ArrayList<>();
        if (combatStyle.equals("Melee")) {
            skills = Arrays.asList("Attack", "Strength", "Defence", "Constitution");
        }
        if (combatStyle.equals("Ranged")) {
            skills = Arrays.asList("Ranged", "Defence", "Constitution");
        }
        if (combatStyle.equals("Magic")) {
            skills = Arrays.asList("Magic", "Defence", "Constitution");
        }
        for (String skill : skills) {
            if (getLevel(skill) < 99) {
                int targetLevel = Math.min(99, getLevel(skill) + 10);
                double skillTime = new Requirement(skill, targetLevel).timeAndActionsToMeetRequirement(this).getTotalTime();
                if (minTimeToGear > skillTime) {
                    minTimeToGear = skillTime;
                    minGear = skill;
                }
            }
        }
        if (getLevel("Herblore") < 96) {
            double herbTime = new Requirement("Herblore", 96).timeAndActionsToMeetRequirement(this).getTotalTime();
            if (minTimeToGear > herbTime) {
                minTimeToGear = herbTime;
                minGear = "Herblore";
            }
        }
        for (Weapon weapon : WeaponDatabase.getWeaponDatabase().getWeapons().values().stream().filter(w -> w.getWeaponClass().equals(combatStyle)).collect(Collectors.toList())) {
            if (!weapons.contains(weapon) && !checkIfHaveBetterWeapon(weapon)) {
                double weaponTime = 0;
                if (ItemDatabase.getItemDatabase().getItems().get(weapon.getName()) != null) {
                    weaponTime += efficientGoalCompletion("Coins", ItemDatabase.getItemDatabase().getItems().get(weapon.getName()).coinValue(this)).getTotalTime();
                }
                else {
                    //Getting time to untradeable gear that aren't already owned is unsupported
                    weaponTime += 1000000000.0;
                }
                //if the time to get the weapon is already too big, don't bother getting all the req times
                if (weaponTime < minTimeToGear) {
                    for (Requirement weaponReq : weapon.getReqs()) {
                        weaponTime += weaponReq.timeAndActionsToMeetRequirement(this).getTotalTime();
                    }
                    if (minTimeToGear > weaponTime) {
                        minTimeToGear = weaponTime;
                        minGear = weapon.getName();
                    }
                }
                else {
                    continue;
                }
            }
        }
        for (Armour armourPiece : ArmourDatabase.getArmourDatabase().getArmours().values().stream().filter(a -> a.getType().equals(combatStyle) || a.getType().equals("All")).collect(Collectors.toList())) {
            if (!armour.contains(armourPiece) && !checkIfHaveBetterArmour(armourPiece)) {
                double armourTime = 0;
                if (ItemDatabase.getItemDatabase().getItems().get(armourPiece.getName()) != null) {
                    armourTime += efficientGoalCompletion("Coins", ItemDatabase.getItemDatabase().getItems().get(armourPiece.getName()).coinValue(this)).getTotalTime();
                }
                else {
                    //Getting time to untradeable gear that aren't already owned is unsupported
                    armourTime += 1000000000.0;
                }
                //if the time to get the armour is already too big, don't bother getting all the req times
                if (armourTime < minTimeToGear) {
                    for (Requirement armourReq : armourPiece.getReqs()) {
                        armourTime += armourReq.timeAndActionsToMeetRequirement(this).getTotalTime();
                    }
                    if (minTimeToGear > armourTime) {
                        minTimeToGear = armourTime;
                        minGear = armourPiece.getName();
                    }
                } else {
                    continue;
                }
            }
        }
        if (minGear != null) {
            return ImmutableMap.of(minGear, minTimeToGear);
        }
        return null;
    }

    public void addWeapon(Weapon newWeapon) {
        weapons.add(newWeapon);
        List<Weapon> weaponsToRemove = new ArrayList<>();
        for (Weapon weapon : weapons) {
            if (checkIfHaveBetterWeapon(weapon)) {
                weaponsToRemove.add(weapon);
            }
        }
        weapons.removeAll(weaponsToRemove);
    }

    public void addWeaponAndMoveToBank(Weapon newWeapon) {
        weapons.add(newWeapon);
        List<Weapon> weaponsToRemove = new ArrayList<>();
        for (Weapon weapon : weapons) {
            if (checkIfHaveBetterWeapon(weapon)) {
                weaponsToRemove.add(weapon);
            }
        }
        weapons.removeAll(weaponsToRemove);
        for (Weapon weapon : weaponsToRemove) {
            if (ItemDatabase.getItemDatabase().getItems().get(weapon.getName()) != null) {
                bank.put(weapon.getName(), 1L);
            }
        }
    }

    public void addArmour(Armour newArmour) {
        armour.add(newArmour);
        List<Armour> armoursToRemove = new ArrayList<>();
        for (Armour armour : armour) {
            if (checkIfHaveBetterArmour(armour)) {
                armoursToRemove.add(armour);
            }
        }
        armour.removeAll(armoursToRemove);
    }

    public void addArmourAndMoveToBank(Armour newArmour) {
        armour.add(newArmour);
        List<Armour> armoursToRemove = new ArrayList<>();
        for (Armour armour : armour) {
            if (checkIfHaveBetterArmour(armour)) {
                armoursToRemove.add(armour);
            }
        }
        armour.removeAll(armoursToRemove);
        for (Armour armour : armoursToRemove) {
            if (ItemDatabase.getItemDatabase().getItems().get(armour.getName()) != null) {
                bank.put(armour.getName(), 1L);
            }
        }
    }

    private boolean checkIfHaveBetterWeapon(Weapon weapon) {
        for (Weapon ownedWeapon : weapons) {
            if (!weapon.equals(ownedWeapon) && weapon.getWeaponClass().equals(ownedWeapon.getWeaponClass()) && weapon.getSlot().equals(ownedWeapon.getSlot()) &&
                weapon.effectiveDamage() <= ownedWeapon.effectiveDamage()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfHaveBetterArmour(Armour newArmour) {
        for (Armour ownedArmour : armour) {
            if (!ownedArmour.equals(newArmour) && (newArmour.getType().equals(ownedArmour.getType()) || ownedArmour.getType().equals("All")) && newArmour.getSlot().equals(ownedArmour.getSlot()) &&
                newArmour.getReduc() <= ownedArmour.getReduc() && newArmour.getBonus() <= ownedArmour.getBonus()) {
                return true;
            }
        }
        return false;
    }

    public void addGearToPlayer(String gear) {
        Weapon weapon = WeaponDatabase.getWeaponDatabase().getWeapons().get(gear);
        Armour armour = ArmourDatabase.getArmourDatabase().getArmours().get(gear);
        Familiar familiar = Familiar.getFamiliarByName(gear);
        if (weapon != null) {
            for (Requirement requirement : weapon.getReqs()) {
                getXp().put(requirement.getQualifier(), getXp().get(requirement.getQualifier()) + getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
            }
            addWeapon(weapon);
        }
        else if (armour != null) {
            for (Requirement requirement : armour.getReqs()) {
                getXp().put(requirement.getQualifier(), getXp().get(requirement.getQualifier()) + getXpToLevel(requirement.getQualifier(), requirement.getQuantifier()));
            }
            addArmour(armour);
        }
        else if (familiar != null) {
            getXp().put("Summoning", getXp().get("Summoning") + getXpToLevel("Summoning", familiar.getSummonReq()));
        }
        else if (Player.ALL_SKILLS.contains(gear)) {
            if (gear.equals("Herblore")) {
                getXp().put(gear, getXp().get(gear) + getXpToLevel(gear, 96));
            } else {
                getXp().put(gear, getXp().get(gear) + getXpToLevel(gear, Math.min(99, getLevel(gear) + 10)));
            }
        }
        else {
            throw new RuntimeException(String.format("Attempted to equip gear that does not exist: %s. Please raise a T99 issue.", gear));
        }
    }

    public void resetPlayer() {
        StoredCombatCalcs.getCalculatedCombats().clear();
        StoredCombatCalcs.getSuccessfulCombats().clear();
        previousEfficiencyResults.clear();
        previousImpossibleResults.clear();
        ActionDatabase.reset();
        setBankValue();
        ActionDatabase.getActionDatabase(this);
    }

    public Map<String,Double> calcOneAchievement(Achievement achievement) {
        HashMap<String, Double> achievementCalcResults = new HashMap<>();
        if (!qualities.containsKey(achievement.getName())) {
            if (achievement.getTime() < 0 && achievement.getReqs().stream().allMatch(r -> r.meetsRequirement(this))) {
                qualities.put(achievement.getName(), 1);
            }
            else {
                System.out.print(achievement.getName() + "\t");
                long taskTime = System.nanoTime();
                GoalResults actionsAndTime = achievement.getTimeForRequirements(this);
                achievementResults.put(achievement, actionsAndTime);
                achievementCalcResults.put(achievement.getName(), actionsAndTime.getTotalTime() - achievement.getGainFromRewards(this));
                System.out.println((System.nanoTime() - taskTime) / 1000000000.0);
            }
        }
        return achievementCalcResults;
    }

    public void completeTask(String taskName, boolean parent) {
        Achievement task = AchievementDatabase.getAchievementDatabase().getAchievements().get(taskName);
        GoalResults calcedResults = achievementResults.get(task);
        Map<String, Double> calcedActions = calcedResults.getActionsWithTimes();
        List<Requirement> combatRequirements = new ArrayList<>();
        for (Requirement requirement : calcedResults.getListofAllRequirements()) {
            if (requirement.getQualifier().equals("Strength") || requirement.getQualifier().equals("Attack") || requirement.getQualifier().equals("Defence") ||
                requirement.getQualifier().equals("Ranged") || requirement.getQualifier().equals("Magic")) {
                combatRequirements.add(requirement);
            }
        }
        while (calcedActions.size() > 0) {
            List<String> actionsToRemove = new ArrayList<>();
            for (Entry<String, Double> action : calcedActions.entrySet()) {
                if (AchievementDatabase.getAchievementDatabase().getAchievements().get(action.getKey()) != null) {
                    actionsToRemove.add(action.getKey());
                    if (!action.getKey().equals(taskName) && !qualities.containsKey(action.getKey())) {
                        completeTask(action.getKey(), false);
                    }
                }
                else if (parent) {
                    if (action.getKey().equals("") || action.getKey().equals("Time spent on scripted fights")) {
                        actionsToRemove.add(action.getKey());
                    }
                    else {
                        Action actionWithGraph = Action.getActionByName(action.getKey(), this);
                        int steps = (int)Math.ceil(action.getValue()*actionWithGraph.getActionsPerHour());
                        int totalInputCoins = 0;
                        for (Entry<String, Integer> input : actionWithGraph.getInputs().entrySet()) {
                            if (ItemDatabase.getItemDatabase().getItems().get(input.getKey()) != null) {
                                long inputItems = (long) input.getValue() * ItemDatabase.getItemDatabase().getItems().get(input.getKey()).coinValue(this) * steps;
                                totalInputCoins += (int) (inputItems / actionWithGraph.getActionsPerHour());
                            }
                        }
                        for (Requirement requirement : actionWithGraph.getReqs()) {
                            if (ItemDatabase.getItemDatabase().getItems().get(requirement.getQualifier()) != null &&
                                WeaponDatabase.getWeaponDatabase().getWeapons().get(requirement.getQualifier()) == null &&
                                ArmourDatabase.getArmourDatabase().getArmours().get(requirement.getQualifier()) == null &&
                                bankValue < requirement.getQuantifier() * ItemDatabase.getItemDatabase().getItems().get(requirement.getQualifier()).coinValue(this)) {
                                totalInputCoins -= requirement.getQuantifier() * ItemDatabase.getItemDatabase().getItems().get(requirement.getQualifier()).coinValue(this);
                            }
                        }
                        for (Entry<String, Integer> output : actionWithGraph.getOutputs().entrySet()) {
                            if (ItemDatabase.getItemDatabase().getItems().get(output.getKey()) != null) {
                                long outputItems = (long) output.getValue() * ItemDatabase.getItemDatabase().getItems().get(output.getKey()).coinValue(this) * steps;
                                totalInputCoins -= (int) (outputItems / actionWithGraph.getActionsPerHour());
                            }
                        }
                        setBankValue();
                        if (bankValue >= totalInputCoins) {
                            performAction(actionWithGraph, action.getValue(), combatRequirements);
                            setBankValue();
                            actionsToRemove.add(action.getKey());
                        }
                    }
                }
                else {
                    actionsToRemove.add(action.getKey());
                }
            }
            for (String action : actionsToRemove) {
                calcedActions.remove(action);
            }
        }
        if (parent) {
            for (Requirement requirement : calcedResults.getListofAllRequirements()) {
                if (WeaponDatabase.getWeaponDatabase().getWeapons().get(requirement.getQualifier()) != null
                    && !checkIfHaveBetterWeapon(WeaponDatabase.getWeaponDatabase().getWeapons().get(requirement.getQualifier()))) {
                    boolean canUse = true;
                    for (Requirement gearReq : WeaponDatabase.getWeaponDatabase().getWeapons().get(requirement.getQualifier()).getReqs()) {
                        if (!gearReq.meetsRequirement(this)) {
                            canUse = false;
                            break;
                        }
                    }
                    if (canUse) {
                        addWeaponAndMoveToBank(WeaponDatabase.getWeaponDatabase().getWeapons().get(requirement.getQualifier()));
                    }
                } else if (ArmourDatabase.getArmourDatabase().getArmours().get(requirement.getQualifier()) != null
                    && !checkIfHaveBetterArmour(ArmourDatabase.getArmourDatabase().getArmours().get(requirement.getQualifier()))) {
                    boolean canUse = true;
                    for (Requirement gearReq : ArmourDatabase.getArmourDatabase().getArmours().get(requirement.getQualifier()).getReqs()) {
                        if (!gearReq.meetsRequirement(this)) {
                            canUse = false;
                            break;
                        }
                    }
                    if (canUse) {
                        addArmourAndMoveToBank(ArmourDatabase.getArmourDatabase().getArmours().get(requirement.getQualifier()));
                    }
                }
                if (ItemDatabase.getItemDatabase().getItems().get(requirement.getQualifier()) != null) {
                    updateBank(requirement.getQualifier(), requirement.getQuantifier());
                }
            }
        }
        for (Encounter e : task.getEncounters()) {
            CombatResults meleeCombatResults;
            CombatResults rangedCombatResults;
            CombatResults magicCombatResults;
            meleeCombatResults = e.calculateCombat(this, new CombatParameters(28, "Melee", false, 0, false));
            rangedCombatResults = e.calculateCombat(this, new CombatParameters(28, "Ranged", false, 0, false));
            magicCombatResults = e.calculateCombat(this, new CombatParameters(28, "Magic", false, 0, false));
            for (List<Enemy> enemyGroup : e.getEnemyGroups()) {
                for (Enemy enemy : enemyGroup) {
                    this.getXp().put("Constitution", this.getXp().get("Constitution") + enemy.getHpxp());
                    if (rangedCombatResults.getHpLost() < meleeCombatResults.getHpLost() && rangedCombatResults.getHpLost() < magicCombatResults.getHpLost()) {
                        this.getXp().put("Ranged", this.getXp().get("Ranged") + enemy.getCbxp());
                    }
                    else if (meleeCombatResults.getHpLost() < magicCombatResults.getHpLost()) {
                        if (getLevel("Attack") <= getLevel("Strength")) {
                            this.getXp().put("Attack", this.getXp().get("Attack") + enemy.getCbxp());
                        }
                        else {
                            this.getXp().put("Strength", this.getXp().get("Strength") + enemy.getCbxp());
                        }
                    }
                    else {
                        this.getXp().put("Magic", this.getXp().get("Magic") + enemy.getCbxp());
                    }
                }
            }
        }
        ArrayList<Reward> rewards = new ArrayList<>(task.getRewards());
        for (Reward reward : rewards) {
            if (ALL_SKILLS.contains(reward.getQualifier())) {
                xp.put(reward.getQualifier(), xp.get(reward.getQualifier()) + reward.getQuantifier());
            } else if (ArmourDatabase.getArmourDatabase().getArmours().get(reward.getQualifier()) != null) {
                armour.add(ArmourDatabase.getArmourDatabase().getArmours().get(reward.getQualifier()));
            } else if (ItemDatabase.getItemDatabase().getItems().get(reward.getQualifier()) != null) {
                if (bank.containsKey(reward.getQualifier()))
                    bank.put(reward.getQualifier(), bank.get(reward.getQualifier()) + reward.getQuantifier());
                else
                    bank.put(reward.getQualifier(), Long.valueOf(reward.getQuantifier()));
            } else {
                if (qualities.containsKey(reward.getQualifier()))
                    qualities.put(reward.getQualifier(), qualities.get(reward.getQualifier()) + reward.getQuantifier());
                else
                    qualities.put(reward.getQualifier(), reward.getQuantifier());
            }
        }
        for (Lamp lamp : task.getLamps()) {
            Reward reward = lamp.getBestReward(this);
            xp.put(reward.getQualifier(), xp.get(reward.getQualifier()) + reward.getQuantifier());
        }
    }

    public void completeTasks(List<String> tasks) {
        for (String taskName : tasks) {
            Achievement task = AchievementDatabase.getAchievementDatabase().getAchievements().get(taskName);
            GoalResults calcedResults = achievementResults.get(task);
            for (Requirement requirement : calcedResults.getListofAllRequirements()) {
                if (AchievementDatabase.getAchievementDatabase().getAchievements().get(requirement.getQualifier()) != null) {
                    qualities.put(requirement.getQualifier(), 1);
                }
            }
        }
    }

    public GoalResults efficientGoalCompletion(String qualifier, int quantifier) {
        //Rounding coins to the next thousand for the sake of time
        if (qualifier.equals("Coins") && quantifier+bankValue < 2147483000) {
            quantifier = ((quantifier + 999)/1000)*1000;
        }
        //Because lambdas are picky jerks that must have a final variable or else they throw a tantrum
        int quantifierWithCoinRounding = quantifier;
        Requirement generatedRequirement = new Requirement(qualifier, quantifier);
        if (previousEfficiencyResults.get(generatedRequirement) != null) {
            return previousEfficiencyResults.get(generatedRequirement);
        }
        if (previousImpossibleResults.entrySet().stream().anyMatch(ir -> ir.getKey().getQualifier().equals(qualifier) && ir.getKey().getQuantifier() <= quantifierWithCoinRounding && ir.getValue() >= actionMinimum)) {
            return new GoalResults(1000000000.0, ImmutableMap.of("Impossible", 1000000000.0));
        }
        //Basically, this if you're trying to make 15000 coins to get 3000 coins. By definition, you won't need to do this, so this should not be done
        if (currentTargets.stream().anyMatch(r -> r.getQualifier().equals(qualifier) && r.getQuantifier() <= quantifierWithCoinRounding)) {
            return new GoalResults(1000000000.0, ImmutableMap.of("Impossible", 1000000000.0));
        }
        //This is NOT the same as meets requirement--this is NO requirement. Adding a meets requirement check here instead would create a whole lot of problems
        if (quantifier == 0) {
            return new GoalResults(0, ImmutableMap.of("", 0.0));
        }
        currentTargets.add(generatedRequirement);
        if (qualifier.equals("Quest points")) {
            Map <String, Double> questTotalActions = new HashMap<>();
            Map<Achievement, Double> questPointMap = new LinkedHashMap<>();
            for (Achievement achievement : achievementResults.keySet()) {
                List<Reward> questPointReward = achievement.getRewards().stream().filter(a -> a.getQualifier().equals("Quest points")).collect(Collectors.toList());
                if (questPointReward.size() > 0) {
                    questPointMap.put(achievement, achievementResults.get(achievement).getTotalTime()/questPointReward.get(0).getQuantifier());
                }
                questPointMap = questPointMap.entrySet().stream().sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
                    .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                    ));
            }
            int questpoints = 0;
            if (qualities.containsKey("Quest points")) {
                questpoints = qualities.get("Quest points");
            }
            while (questpoints < quantifier && questPointMap.size() > 0) {
                Achievement quest = questPointMap.keySet().iterator().next();
                GoalResults oneQuestResults = achievementResults.get(quest);
                for (Entry<String, Double> actionEntry : oneQuestResults.getActionsWithTimes().entrySet()) {
                    if (questTotalActions.containsKey(actionEntry.getKey())) {
                        questTotalActions.put(actionEntry.getKey(), Math.max(questTotalActions.get(actionEntry.getKey()), actionEntry.getValue()));
                    }
                    else {
                        questTotalActions.put(actionEntry.getKey(), actionEntry.getValue());
                    }
                }
                questpoints += quest.getRewards().stream().filter(a -> a.getQualifier().equals("Quest points")).collect(Collectors.toList()).get(0).getQuantifier();
                questPointMap.remove(quest);
            }
            if (questpoints < quantifier) {
                return new GoalResults(1000000000.0, ImmutableMap.of("Impossible", 1000000000.0));
            }
            double questTotalTime = questTotalActions.values().stream().mapToDouble(d -> d).sum();
            GoalResults result = new GoalResults(questTotalTime, questTotalActions);
            if (result.getTotalTime() < 1000000.0) {
                previousEfficiencyResults.put(generatedRequirement, result);
            }
            currentTargets.remove(generatedRequirement);
            return result;
        } else if (qualifier.equals("Combat")) {
            int targetLevel = (int) Math.floor(quantifier / 1.4);
            GoalResults attack = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Attack", targetLevel));
            GoalResults strength = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Strength", targetLevel));
            GoalResults meleeDefence = this.efficientGoalCompletion("mCombat", this.getXpToLevel("Defence", targetLevel));
            GoalResults rangedDefence = this.efficientGoalCompletion("rCombat", this.getXpToLevel("Defence", targetLevel));
            GoalResults magicDefence = this.efficientGoalCompletion("aCombat", this.getXpToLevel("Defence", targetLevel));
            GoalResults trueDefence;
            if (meleeDefence.getTotalTime() < Math.min(rangedDefence.getTotalTime(), magicDefence.getTotalTime())) {
                trueDefence = meleeDefence;
            } else if (rangedDefence.getTotalTime() < magicDefence.getTotalTime()) {
                trueDefence = rangedDefence;
            } else {
                trueDefence = magicDefence;
            }
            GoalResults ranged = this.efficientGoalCompletion("rCombat", this.getXpToLevel("Ranged", targetLevel));
            GoalResults magic = this.efficientGoalCompletion("aCombat", this.getXpToLevel("Magic", targetLevel));
            GoalResults hp = this.efficientGoalCompletion("Constitution", this.getXpToLevel("Constitution", targetLevel));
            GoalResults prayer = this.efficientGoalCompletion("Prayer", this.getXpToLevel("Prayer", targetLevel));
            GoalResults summ = this.efficientGoalCompletion("Summoning", this.getXpToLevel("Summoning", targetLevel));
            Map<String, Double> meleeMap = new HashMap<>();
            Map<String, Double> rangedMap = new HashMap<>();
            Map<String, Double> magicMap = new HashMap<>();
            meleeMap.put(attack.getActionsWithTimes().keySet().iterator().next(), attack.getTotalTime());
            if (meleeMap.keySet().contains(strength.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(strength.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(strength.getActionsWithTimes().keySet().iterator().next()) + strength.getTotalTime());
            else
                meleeMap.put(strength.getActionsWithTimes().keySet().iterator().next(), strength.getTotalTime());
            if (meleeMap.keySet().contains(trueDefence.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(trueDefence.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(trueDefence.getActionsWithTimes().keySet().iterator().next()) + trueDefence.getTotalTime());
            else
                meleeMap.put(trueDefence.getActionsWithTimes().keySet().iterator().next(), trueDefence.getTotalTime());
            if (meleeMap.keySet().contains(prayer.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(prayer.getActionsWithTimes().keySet().iterator().next()) + prayer.getTotalTime());
            else
                meleeMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), prayer.getTotalTime());
            if (meleeMap.keySet().contains(summ.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(summ.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(summ.getActionsWithTimes().keySet().iterator().next()) + summ.getTotalTime());
            else
                meleeMap.put(summ.getActionsWithTimes().keySet().iterator().next(), summ.getTotalTime());
            if (meleeMap.keySet().contains(hp.getActionsWithTimes().keySet().iterator().next()))
                meleeMap.put(hp.getActionsWithTimes().keySet().iterator().next(), meleeMap.get(hp.getActionsWithTimes().keySet().iterator().next()) + hp.getTotalTime());
            else
                meleeMap.put(hp.getActionsWithTimes().keySet().iterator().next(), hp.getTotalTime());
            rangedMap.put(ranged.getActionsWithTimes().keySet().iterator().next(), ranged.getTotalTime());
            if (rangedMap.keySet().contains(trueDefence.getActionsWithTimes().keySet().iterator().next()))
                rangedMap.put(trueDefence.getActionsWithTimes().keySet().iterator().next(), rangedMap.get(trueDefence.getActionsWithTimes().keySet().iterator().next()) + trueDefence.getTotalTime());
            else
                rangedMap.put(trueDefence.getActionsWithTimes().keySet().iterator().next(), trueDefence.getTotalTime());
            if (rangedMap.keySet().contains(prayer.getActionsWithTimes().keySet().iterator().next()))
                rangedMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), rangedMap.get(prayer.getActionsWithTimes().keySet().iterator().next()) + prayer.getTotalTime());
            else
                rangedMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), prayer.getTotalTime());
            if (rangedMap.keySet().contains(summ.getActionsWithTimes().keySet().iterator().next()))
                rangedMap.put(summ.getActionsWithTimes().keySet().iterator().next(), rangedMap.get(summ.getActionsWithTimes().keySet().iterator().next()) + summ.getTotalTime());
            else
                rangedMap.put(summ.getActionsWithTimes().keySet().iterator().next(), summ.getTotalTime());
            if (rangedMap.keySet().contains(hp.getActionsWithTimes().keySet().iterator().next()))
                rangedMap.put(hp.getActionsWithTimes().keySet().iterator().next(), rangedMap.get(hp.getActionsWithTimes().keySet().iterator().next()) + hp.getTotalTime());
            else
                rangedMap.put(hp.getActionsWithTimes().keySet().iterator().next(), hp.getTotalTime());
            magicMap.put(magic.getActionsWithTimes().keySet().iterator().next(), magic.getTotalTime());
            if (magicMap.keySet().contains(trueDefence.getActionsWithTimes().keySet().iterator().next()))
                magicMap.put(trueDefence.getActionsWithTimes().keySet().iterator().next(), magicMap.get(trueDefence.getActionsWithTimes().keySet().iterator().next()) + trueDefence.getTotalTime());
            else
                magicMap.put(trueDefence.getActionsWithTimes().keySet().iterator().next(), trueDefence.getTotalTime());
            if (magicMap.keySet().contains(prayer.getActionsWithTimes().keySet().iterator().next()))
                magicMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), magicMap.get(prayer.getActionsWithTimes().keySet().iterator().next()) + prayer.getTotalTime());
            else
                magicMap.put(prayer.getActionsWithTimes().keySet().iterator().next(), prayer.getTotalTime());
            if (magicMap.keySet().contains(summ.getActionsWithTimes().keySet().iterator().next()))
                magicMap.put(summ.getActionsWithTimes().keySet().iterator().next(), magicMap.get(summ.getActionsWithTimes().keySet().iterator().next()) + summ.getTotalTime());
            else
                magicMap.put(summ.getActionsWithTimes().keySet().iterator().next(), summ.getTotalTime());
            if (magicMap.keySet().contains(hp.getActionsWithTimes().keySet().iterator().next()))
                magicMap.put(hp.getActionsWithTimes().keySet().iterator().next(), magicMap.get(hp.getActionsWithTimes().keySet().iterator().next()) + hp.getTotalTime());
            else
                magicMap.put(hp.getActionsWithTimes().keySet().iterator().next(), hp.getTotalTime());
            List<Requirement> requirements = new ArrayList<>();
            requirements.add(new Requirement("Defence", targetLevel));
            requirements.add(new Requirement("Constitution", targetLevel));
            requirements.add(new Requirement("Prayer", targetLevel));
            requirements.add(new Requirement("Summoning", targetLevel));
            if (attack.getTotalTime() + strength.getTotalTime() < ranged.getTotalTime() && attack.getTotalTime() + strength.getTotalTime() < magic.getTotalTime()) {
                requirements.add(new Requirement("Attack", targetLevel));
                requirements.add(new Requirement("Strength", targetLevel));
                GoalResults result = new GoalResults(attack.getTotalTime() + strength.getTotalTime() + trueDefence.getTotalTime() + prayer.getTotalTime() + summ.getTotalTime() + hp.getTotalTime(),
                    meleeMap, requirements);
                if (result.getTotalTime() < 1000000.0) {
                    previousEfficiencyResults.put(generatedRequirement, result);
                }
                currentTargets.remove(generatedRequirement);
                return result;
            } else if (ranged.getTotalTime() < magic.getTotalTime()) {
                requirements.add(new Requirement("Ranged", targetLevel));
                GoalResults result = new GoalResults(ranged.getTotalTime() + trueDefence.getTotalTime() + prayer.getTotalTime() + summ.getTotalTime() + hp.getTotalTime(), rangedMap, requirements);
                if (result.getTotalTime() < 1000000.0) {
                    previousEfficiencyResults.put(generatedRequirement, result);
                }
                currentTargets.remove(generatedRequirement);
                return result;
            } else {
                requirements.add(new Requirement("Magic", targetLevel));
                GoalResults result = new GoalResults(magic.getTotalTime() + trueDefence.getTotalTime() + prayer.getTotalTime() + summ.getTotalTime() + hp.getTotalTime(), magicMap, requirements);
                if (result.getTotalTime() < 1000000.0) {
                    previousEfficiencyResults.put(generatedRequirement, result);
                }
                currentTargets.remove(generatedRequirement);
                return result;
            }
        }
        double initialMin = actionMinimum;
        double minimum = actionMinimum;
        boolean successful = false;
        Map<String, Double> efficiency = new HashMap<>();
        for (Action action : ActionDatabase.getActionDatabase(this).getDatabase()) {
            boolean validAction = false;
            double coinGain = 0;
            for (Map.Entry<String, Integer> output : action.getOutputs().entrySet()) {
                Item item = ItemDatabase.getItemDatabase().getItems().get(output.getKey());
                if (item != null) {
                    coinGain += output.getValue()*item.coinValue(this);
                }
            }
            long inputLoss = 0;
            for (Map.Entry<String, Integer> input : action.getInputs().entrySet()) {
                Item item = ItemDatabase.getItemDatabase().getItems().get(input.getKey());
                if (item != null) {
                    inputLoss += (long)input.getValue()*item.coinValue(this);
                }
            }
            coinGain -= inputLoss;
            if (qualifier.equals("Coins")) {
                if (coinGain > quantifier/minimum) {
                    validAction = true;
                }
            }
            else if (action.getOutputs().containsKey(qualifier) && action.getOutputs().get(qualifier)*actionMinimum > quantifier) {
                validAction = true;
            }
            if (lockedActions.stream().anyMatch(la -> la.getQualifier().equals(qualifier) && la.getAction().equals(action.getName()))) {
                validAction = false;
            }
            if (validAction) {
                for (Requirement r : action.getReqs()) {
                    if (ALL_SKILLS.contains(r.getQualifier())) {
                        if (currentTargets.stream().anyMatch(targ -> targ.getQualifier().equals(r.getQualifier()) && getXpToLevel(r.getQualifier(), r.getQuantifier()) >= targ.getQuantifier())) {
                            validAction = false;
                            break;
                        } else if (currentTargets.stream().anyMatch(targ -> targ.getQualifier().equals(r.getQualifier()) && r.getQuantifier() > targ.getQuantifier())) {
                            validAction = false;
                            break;
                        }
                    }
                }
            }
            if (validAction && ALL_SKILLS.contains(qualifier) && action.getReqs().stream().anyMatch(r -> r.getQualifier().equals(qualifier) && getXpToLevel(qualifier, r.getQuantifier()) >= quantifierWithCoinRounding)) {
                validAction = false;
            }
            if (validAction) {
                QualifierAction qualifierAction = new QualifierAction(qualifier, action.getName());
                lockedActions.add(qualifierAction);
                double effectiveTimeThisAction = 0.0;
                Map<String, Long> initialBank = new HashMap<>(bank);
                Map<String, Double> efficiencyThisAction = new HashMap<>();
                int trueQuantifier = quantifier;
                //Items first, then others. This is so that when the others are calculated, they use the items gained in their calculations
                for (Requirement requirement : action.getReqs()) {
                    if (ItemDatabase.getItemDatabase().getItems().get(requirement.getQualifier()) != null) {
                        GoalResults reqResults = requirement.timeAndActionsToMeetRequirement(this);
                        effectiveTimeThisAction += reqResults.getTotalTime();
                        addItemsToMap(efficiencyThisAction, reqResults.getActionsWithTimes());
                        bank.put(requirement.getQualifier(), Long.valueOf(requirement.getQuantifier()));
                        setBankValue();
                    }
                }
                for (Requirement requirement : action.getReqs()) {
                    if (ItemDatabase.getItemDatabase().getItems().get(requirement.getQualifier()) == null) {
                        GoalResults reqResults = requirement.timeAndActionsToMeetRequirement(this);
                        effectiveTimeThisAction += reqResults.getTotalTime();
                        addItemsToMap(efficiencyThisAction, reqResults.getActionsWithTimes());
                        if (requirement.getQualifier().equals(qualifier) && ALL_SKILLS.contains(qualifier) && !requirement.meetsRequirement(this)) {
                            trueQuantifier = quantifier - getXpToLevel(qualifier, requirement.getQuantifier());
                        }
                    }
                }
                if (effectiveTimeThisAction > minimum) {
                    bank = initialBank;
                    setBankValue();
                    lockedActions.remove(qualifierAction);
                    continue;
                }
                double timeToReachGoal;
                if (qualifier.equals("Coins")) {
                    timeToReachGoal = trueQuantifier/(coinGain*1.0);
                } else {
                    timeToReachGoal = (trueQuantifier*1.0)/action.getOutputs().get(qualifier);
                }
                timeToReachGoal = Math.ceil(timeToReachGoal*Math.max(120,action.getActionsPerHour()))/Math.max(120,action.getActionsPerHour());
                effectiveTimeThisAction += timeToReachGoal;
                addItemsToMap(efficiencyThisAction, ImmutableMap.of(action.getName(), timeToReachGoal));
                long minInputsLong = 0;
                for (Entry<String, Integer> input : action.getInputs().entrySet()) {
                    Item item = ItemDatabase.getItemDatabase().getItems().get(input.getKey());
                    if (item != null) {
                        int inputsUsed = (int)Math.ceil((input.getValue()*1.0)/action.getActionsPerHour());
                        minInputsLong += (long)inputsUsed*item.coinValue(this);
                    }
                }
                int minInputs;
                if (minInputsLong > Integer.MAX_VALUE) {
                    GoalResults coinResults = efficientGoalCompletion("Coins", Integer.MAX_VALUE);
                    effectiveTimeThisAction += coinResults.getTotalTime();
                    addItemsToMap(efficiencyThisAction, coinResults.getActionsWithTimes());
                    minInputs = (int)(minInputsLong - Integer.MAX_VALUE);
                } else {
                    minInputs = (int)minInputsLong;
                }
                if (coinGain >= 0) {
                    if (minInputs > bankValue) {
                        GoalResults coinResults = efficientGoalCompletion("Coins", (int) (minInputs - bankValue));
                        effectiveTimeThisAction += coinResults.getTotalTime();
                        addItemsToMap(efficiencyThisAction, coinResults.getActionsWithTimes());
                    }
                } else if (Math.max(minInputs, (int)(Math.ceil(coinGain*timeToReachGoal*-1))) > bankValue){
                    GoalResults coinResults = efficientGoalCompletion("Coins", (int)(Math.max(minInputs, (int)(Math.ceil(coinGain*timeToReachGoal*-1))) - bankValue));
                    effectiveTimeThisAction += coinResults.getTotalTime();
                    addItemsToMap(efficiencyThisAction, coinResults.getActionsWithTimes());
                }
                for (Entry<String, Integer> input : action.getInputs().entrySet()) {
                    GoalResults timeToInput = null;
                    if (ItemDatabase.getItemDatabase().getItems().get(input.getKey()) == null) {
                        timeToInput = efficientGoalCompletion(input.getKey(), (int)Math.ceil(input.getValue()*timeToReachGoal));
                    }
                    if (timeToInput != null) {
                        effectiveTimeThisAction += timeToInput.getTotalTime();
                        addItemsToMap(efficiencyThisAction, timeToInput.getActionsWithTimes());
                    }
                }
                if (effectiveTimeThisAction < minimum) {
                    minimum = effectiveTimeThisAction;
                    actionMinimum = effectiveTimeThisAction;
                    successful = true;
                    efficiency = efficiencyThisAction;
                }
                bank = initialBank;
                setBankValue();
                lockedActions.remove(qualifierAction);
            }
        }
        if (!successful) {
            minimum = 1000000000.0;
            efficiency.put(qualifier, minimum);
        }
        GoalResults result = new GoalResults(minimum, efficiency);
        if (minimum < 1000000.0) {
            previousEfficiencyResults.put(generatedRequirement, result);
        } else {
            if (previousImpossibleResults.get(generatedRequirement) != null) {
                previousImpossibleResults.put(generatedRequirement, Math.max(initialMin, previousImpossibleResults.get(generatedRequirement)));
            } else {
                previousImpossibleResults.put(generatedRequirement, initialMin);
            }
        }
        currentTargets.remove(generatedRequirement);
        actionMinimum = initialMin;
        return result;
    }

    private void addItemsToMap(Map<String, Double> a, Map<String, Double> b) {
        for (String item : b.keySet()) {
            if (a.containsKey(item)) {
                a.put(item, a.get(item) + b.get(item));
            } else {
                a.put(item, b.get(item));
            }
        }
    }

    public void setBankValue() {
        long bankVal = 0;
        for (Map.Entry<String, Long> entry : bank.entrySet()) {
            bankVal += ((long) ItemDatabase.getItemDatabase().getItems().get(entry.getKey()).coinValue(this)) * entry.getValue();
        }
        bankValue = bankVal;
    }

    private void performAction(Action action, double time, List<Requirement> combatRequirements) {
        int steps = (int)Math.ceil(time*action.getActionsPerHour());
        for (Requirement requirement : action.getReqs()) {
            if (WeaponDatabase.getWeaponDatabase().getWeapons().get(requirement.getQualifier()) != null
                && !checkIfHaveBetterWeapon(WeaponDatabase.getWeaponDatabase().getWeapons().get(requirement.getQualifier()))) {
                boolean canUse = true;
                for (Requirement gearReq : WeaponDatabase.getWeaponDatabase().getWeapons().get(requirement.getQualifier()).getReqs()) {
                    if (!gearReq.meetsRequirement(this)) {
                        canUse = false;
                        break;
                    }
                }
                if (canUse) {
                    addWeaponAndMoveToBank(WeaponDatabase.getWeaponDatabase().getWeapons().get(requirement.getQualifier()));
                }
            } else if (ArmourDatabase.getArmourDatabase().getArmours().get(requirement.getQualifier()) != null
                && !checkIfHaveBetterArmour(ArmourDatabase.getArmourDatabase().getArmours().get(requirement.getQualifier()))) {
                boolean canUse = true;
                for (Requirement gearReq : ArmourDatabase.getArmourDatabase().getArmours().get(requirement.getQualifier()).getReqs()) {
                    if (!gearReq.meetsRequirement(this)) {
                        canUse = false;
                        break;
                    }
                }
                if (canUse) {
                    addArmourAndMoveToBank(ArmourDatabase.getArmourDatabase().getArmours().get(requirement.getQualifier()));
                }
            } else if (ItemDatabase.getItemDatabase().getItems().get(requirement.getQualifier()) != null) {
                updateBank(requirement.getQualifier(), requirement.getQuantifier());
                if (bank.containsKey(requirement.getQualifier())) {
                    bank.put(requirement.getQualifier(), bank.get(requirement.getQualifier()) + requirement.getQuantifier());
                    setBankValue();
                }
                else {
                    bank.put(requirement.getQualifier(), Long.valueOf(requirement.getQuantifier()));
                    setBankValue();
                }
            }
        }
        for (Entry<String, Integer> output : action.getOutputs().entrySet()) {
            long outputItems = (long)output.getValue()*steps;
            int totalXp = (int)(outputItems/action.getActionsPerHour());
            if (output.getKey().equals("aCombat")) {
                for (Requirement combatReq : combatRequirements) {
                    if (combatReq.getQualifier().equals("Defence")) {
                        if (totalXp > getXpToLevel("Defence", combatReq.getQuantifier())) {
                            totalXp -= getXpToLevel("Defence", combatReq.getQuantifier());
                            xp.put("Defence", xp.get("Defence") + getXpToLevel("Defence", combatReq.getQuantifier()));
                        } else {
                            xp.put("Defence", xp.get("Defence") + totalXp);
                            totalXp = 0;
                        }
                    } else if (combatReq.getQualifier().equals("Magic")) {
                        if (totalXp > getXpToLevel("Magic", combatReq.getQuantifier())) {
                            totalXp -= getXpToLevel("Magic", combatReq.getQuantifier());
                            xp.put("Magic", xp.get("Magic") + getXpToLevel("Magic", combatReq.getQuantifier()));
                        } else {
                            xp.put("Magic", xp.get("Magic") + totalXp);
                            totalXp = 0;
                        }
                    }
                }
                double diff = xp.get("Magic") - xp.get("Defence");
                if (diff > totalXp) {
                    xp.put("Defence", xp.get("Defence") + totalXp);
                } else if (diff < -1*totalXp) {
                    xp.put("Magic", xp.get("Magic") + totalXp);
                } else {
                    xp.put("Defence", xp.get("Defence") + (totalXp + diff)/2);
                    xp.put("Magic", xp.get("Magic") + (totalXp - diff)/2);
                }
            } else if (output.getKey().equals("rCombat")) {
                for (Requirement combatReq : combatRequirements) {
                    if (combatReq.getQualifier().equals("Defence")) {
                        if (totalXp > getXpToLevel("Defence", combatReq.getQuantifier())) {
                            totalXp -= getXpToLevel("Defence", combatReq.getQuantifier());
                            xp.put("Defence", xp.get("Defence") + getXpToLevel("Defence", combatReq.getQuantifier()));
                        } else {
                            xp.put("Defence", xp.get("Defence") + totalXp);
                            totalXp = 0;
                        }
                    } else if (combatReq.getQualifier().equals("Ranged")) {
                        if (totalXp > getXpToLevel("Ranged", combatReq.getQuantifier())) {
                            totalXp -= getXpToLevel("Ranged", combatReq.getQuantifier());
                            xp.put("Ranged", xp.get("Ranged") + getXpToLevel("Ranged", combatReq.getQuantifier()));
                        } else {
                            xp.put("Ranged", xp.get("Ranged") + totalXp);
                            totalXp = 0;
                        }
                    }
                }
                double diff = xp.get("Ranged") - xp.get("Defence");
                if (diff > totalXp) {
                    xp.put("Defence", xp.get("Defence") + totalXp);
                } else if (diff < -1*totalXp) {
                    xp.put("Ranged", xp.get("Ranged") + totalXp);
                } else {
                    xp.put("Defence", xp.get("Defence") + (totalXp + diff)/2);
                    xp.put("Ranged", xp.get("Ranged") + (totalXp - diff)/2);
                }
            } else if (output.getKey().equals("mCombat")) {
                for (Requirement combatReq : combatRequirements) {
                    if (combatReq.getQualifier().equals("Defence")) {
                        if (totalXp > getXpToLevel("Defence", combatReq.getQuantifier())) {
                            totalXp -= getXpToLevel("Defence", combatReq.getQuantifier());
                            xp.put("Defence", xp.get("Defence") + getXpToLevel("Defence", combatReq.getQuantifier()));
                        } else {
                            xp.put("Defence", xp.get("Defence") + totalXp);
                            totalXp = 0;
                        }
                    } else if (combatReq.getQualifier().equals("Attack")) {
                        if (totalXp > getXpToLevel("Attack", combatReq.getQuantifier())) {
                            totalXp -= getXpToLevel("Attack", combatReq.getQuantifier());
                            xp.put("Attack", xp.get("Attack") + getXpToLevel("Attack", combatReq.getQuantifier()));
                        } else {
                            xp.put("Attack", xp.get("Attack") + totalXp);
                            totalXp = 0;
                        }
                    } else if (combatReq.getQualifier().equals("Strength")) {
                        if (totalXp > getXpToLevel("Strength", combatReq.getQuantifier())) {
                            totalXp -= getXpToLevel("Strength", combatReq.getQuantifier());
                            xp.put("Strength", xp.get("Strength") + getXpToLevel("Strength", combatReq.getQuantifier()));
                        } else {
                            xp.put("Strength", xp.get("Strength") + totalXp);
                            totalXp = 0;
                        }
                    }
                }
                double max = Math.max(xp.get("Attack"), Math.max(xp.get("Strength"), xp.get("Defence")));
                double attGain = max-xp.get("Attack");
                double strGain = max-xp.get("Strength");
                double defGain = max-xp.get("Defence");
                if (totalXp >= attGain+strGain+defGain) {
                    xp.put("Attack", xp.get("Attack") + attGain);
                    xp.put("Strength", xp.get("Strength") + strGain);
                    xp.put("Defence", xp.get("Defence") + defGain);
                    totalXp -= (attGain + strGain + defGain);
                    xp.put("Attack", xp.get("Attack") + totalXp/3);
                    xp.put("Strength", xp.get("Strength") + totalXp/3);
                    xp.put("Defence", xp.get("Defence") + totalXp/3);
                } else {
                    if (defGain >= totalXp) {
                        xp.put("Defence", xp.get("Defence") + totalXp);
                        totalXp = 0;
                    } else {
                        totalXp -= defGain;
                        xp.put("Defence", xp.get("Defence") + defGain);
                    }
                    if (attGain >= totalXp) {
                        xp.put("Attack", xp.get("Attack") + totalXp);
                        totalXp = 0;
                    } else {
                        totalXp -= attGain;
                        xp.put("Attack", xp.get("Attack") + attGain);
                    }
                    xp.put("Strength", xp.get("Strength") + totalXp);
                }
            }
            else if (ALL_SKILLS.contains(output.getKey())) {
                xp.put(output.getKey(), xp.get(output.getKey()) + (int)(outputItems/action.getActionsPerHour()));
            }
            else if (ItemDatabase.getItemDatabase().getItems().get(output.getKey()) != null && (int)(outputItems/action.getActionsPerHour()) > 0) {
                if (bank.containsKey(output.getKey())) {
                    bank.put(output.getKey(), bank.get(output.getKey()) + (int)(outputItems / action.getActionsPerHour()));
                } else {
                    bank.put(output.getKey(), (outputItems / action.getActionsPerHour()));
                }
                setBankValue();
            }
            else {
                qualities.put(output.getKey(), (int)(outputItems/action.getActionsPerHour()));
            }
        }
        for (Entry<String, Integer> input : action.getInputs().entrySet()) {
            if (ItemDatabase.getItemDatabase().getItems().get(input.getKey()) != null) {
                long inputItems = (long)input.getValue() * steps;
                updateBank(input.getKey(), (int)(inputItems / action.getActionsPerHour()));
            }
        }
    }

    private void updateBank(String item, int quantity) {
        if (!item.equals("Coins") && bank.containsKey(item)) {
            if (bank.get(item) > quantity) {
                bank.put(item, (bank.get(item) - quantity));
            } else if (bank.containsKey("Coins") && bank.get("Coins") >= (quantity-bank.get(item))
                *ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this)) {
                bank.put("Coins", bank.get("Coins")-(quantity-bank.get(item))
                    *ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this));
                bank.remove(item);
            } else {
                List<String> entriesToRemove = new ArrayList<>();
                for (Entry<String, Long> bankEntry : bank.entrySet()) {
                    if (!bankEntry.getKey().equals("Coins") && !bankEntry.getKey().equals(item)) {
                        if (bank.get("Coins") != null) {
                            bank.put("Coins", bank.get("Coins") + ItemDatabase.getItemDatabase().getItems().get(bankEntry.getKey()).coinValue(this) * bankEntry.getValue());
                        }
                        else {
                            bank.put("Coins", ItemDatabase.getItemDatabase().getItems().get(bankEntry.getKey()).coinValue(this) * bankEntry.getValue());
                        }
                        entriesToRemove.add(bankEntry.getKey());
                    }
                    if (bank.get("Coins") >= (quantity-bank.get(item))*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this)) {
                        break;
                    }
                }
                for (String removal : entriesToRemove) {
                    bank.remove(removal);
                }
                bank.put("Coins", bank.get("Coins")-(quantity-bank.get(item))
                    *ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this));
                bank.remove(item);
            }
        } else if (bank.containsKey("Coins") && bank.get("Coins") >= quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this)) {
                bank.put("Coins", bank.get("Coins")-quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this));
        } else if (bankValue > quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this)) {
            List<String> entriesToRemove = new ArrayList<>();
            long coinsToAdd = 0;
            for (Entry<String, Long> bankEntry : bank.entrySet()) {
                if (!bankEntry.getKey().equals("Coins")) {
                    coinsToAdd += ItemDatabase.getItemDatabase().getItems().get(bankEntry.getKey()).coinValue(this) * bankEntry.getValue();
                    entriesToRemove.add(bankEntry.getKey());
                }
                if (bank.get("Coins") != null) {
                    if (bank.get("Coins") + coinsToAdd >= quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this)) {
                        break;
                    }
                } else {
                    if (coinsToAdd >= quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this)) {
                        break;
                    }
                }
            }
            for (String removal : entriesToRemove) {
                bank.remove(removal);
            }
            if (bank.get("Coins") != null) {
                bank.put("Coins", bank.get("Coins")+coinsToAdd-quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this));
            } else {
                bank.put("Coins", coinsToAdd-quantity*ItemDatabase.getItemDatabase().getItems().get(item).coinValue(this));
            }
        }
        setBankValue();
    }

    private class QualifierAction {

        private String qualifier;
        private String action;

        QualifierAction(String qualifier, String action) {
            this.qualifier = qualifier;
            this.action = action;
        }

        String getQualifier() {
            return qualifier;
        }

        String getAction() {
            return action;
        }
    }
}
