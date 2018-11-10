package logic;

import data.databases.AbilityDatabase;
import data.databases.ActionDatabase;
import data.dataobjects.Ability;
import data.dataobjects.Enemy;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Encounter implements Serializable {

    private static final int TICKS_PER_HOUR = 6000;

    private List<List<Enemy>> enemyGroups;
    private List<Restriction> restrictions;
    private int partySize;
    private boolean safespot;

    public Encounter(List<List<String>> enemyGroups, List<Restriction> restrictions) {
        this.enemyGroups = new ArrayList<>();
        for (List<String> enemyGroup : enemyGroups) {
            this.enemyGroups.add(enemyGroup.stream().map(a -> Enemy.getEnemyByName(a)).collect(Collectors.toList()));
        }
        this.restrictions = restrictions;
        this.partySize = 1;
        this.safespot = false;
    }

    public Encounter(List<List<String>> enemyGroups, List<Restriction> restrictions, boolean safespot) {
        this.enemyGroups = new ArrayList<>();
        for (List<String> enemyGroup : enemyGroups) {
            this.enemyGroups.add(enemyGroup.stream().map(a -> Enemy.getEnemyByName(a)).collect(Collectors.toList()));
        }
        this.restrictions = restrictions;
        this.partySize = 1;
        this.safespot = safespot;
    }

    public Encounter(List<List<String>> enemyGroups) {
        this.enemyGroups = new ArrayList<>();
        for (List<String> enemyGroup : enemyGroups) {
            this.enemyGroups.add(enemyGroup.stream().map(a -> Enemy.getEnemyByName(a)).collect(Collectors.toList()));
        }
        this.restrictions = new ArrayList<>();
        this.partySize = 1;
        this.safespot = false;
    }

    public Encounter(List<List<String>> enemyGroups, int partySize) {
        this.enemyGroups = new ArrayList<>();
        for (List<String> enemyGroup : enemyGroups) {
            this.enemyGroups.add(enemyGroup.stream().map(a -> Enemy.getEnemyByName(a)).collect(Collectors.toList()));
        }
        this.restrictions = new ArrayList<>();
        this.partySize = partySize;
        this.safespot = false;
    }

    public Encounter(String enemy, List<Restriction> restrictions) {
        this.enemyGroups = Collections.singletonList(Collections.singletonList(Enemy.getEnemyByName(enemy)));
        this.restrictions = restrictions;
        this.partySize = 1;
        this.safespot = false;
    }

    public Encounter(String enemy) {
        this.enemyGroups = Collections.singletonList(Collections.singletonList(Enemy.getEnemyByName(enemy)));
        this.restrictions = new ArrayList<>();
        this.partySize = 1;
        this.safespot = false;
    }

    public List<List<Enemy>> getEnemyGroups() {
        return enemyGroups;
    }

    public List<Restriction> getRestrictions() {
        return restrictions;
    }

    public int getPartySize() {
        return partySize;
    }

    public boolean isSafespot() {
        return safespot;
    }

    public CombatResults calculateCombat(Player p, CombatParameters parameters) {
        CombatResults results = null;
        double minHpLost = 1000000001;
        int maxKills = 0;
        for (Loadout loadout : p.generateLoadouts(parameters.getCombatStyle())) {
            CombatResults previousResults = StoredCombatCalcs.getCalculatedCombats().get(new CombatScenario(this, loadout, new HashMap<>(p.getXp()), parameters));
            if (previousResults != null) {
                if (previousResults.getKills() > maxKills || (previousResults.getKills() == maxKills && previousResults.getHpLost() < minHpLost)) {
                    results = previousResults;
                    minHpLost = previousResults.getHpLost();
                    maxKills = previousResults.getKills();
                }
                continue;
            }
            p.setTotalEncounters(p.getTotalEncounters() + 1);
            double myLp = p.getLevel("Constitution") * 100 + loadout.totalLp();
            int maxLpHealedPerFood = p.getLevel("Constitution") * 25;
            if (p.getLevel("Constitution") == 99) {
                maxLpHealedPerFood = 99999;
            }
            double prayerPoints = p.getLevel("Prayer")*10;
            int ticks = -1;
            double hpLost = 0;
            int invenUsed = 0;
            int inventorySize = parameters.getInvenSpaces() + loadout.getFamiliar().getInvenSpaces();
            String damageSkill;
            String accuracySkill;
            int myMeleeAffinity;
            int myRangedAffinity;
            int myMagicAffinity;
            if (parameters.getCombatStyle().equals("Melee")) {
                accuracySkill = "Attack";
                damageSkill = "Strength";
                myMeleeAffinity = 55;
                myRangedAffinity = 45;
                myMagicAffinity = 65;
            } else if (parameters.getCombatStyle().equals("Ranged")) {
                accuracySkill = damageSkill = "Ranged";
                myMeleeAffinity = 65;
                myRangedAffinity = 55;
                myMagicAffinity = 45;
            } else {
                accuracySkill = damageSkill = "Magic";
                myMeleeAffinity = 45;
                myRangedAffinity = 65;
                myMagicAffinity = 55;
            }
            double myDamage;
            if (loadout.getMainWep().getAtkspd() == 4) {
                myDamage = 2.5 * p.getLevel(damageSkill) + loadout.getMainWep().getDamage() + loadout.getMainWep().getMaxAmmo();
            }
            else if (loadout.getMainWep().getAtkspd() == 5) {
                myDamage = 2.5 * p.getLevel(damageSkill) + (loadout.getMainWep().getDamage() + loadout.getMainWep().getMaxAmmo())*192.0/245.0;
            }
            else if (loadout.getMainWep().getAtkspd() == 6) {
                myDamage = 2.5 * p.getLevel(damageSkill) + (loadout.getMainWep().getDamage() + loadout.getMainWep().getMaxAmmo())*96.0/149.0;
            }
            else {
                System.out.println("What the heck kind of weapon do you have?");
                throw new RuntimeException("Error: Weapon has invalid attack speed. Must be 4, 5, or 6");
            }
            if (loadout.getMainWep().getSlot().equals("Two-handed")) {
                myDamage += loadout.totalBonus()*1.5;
            }
            else {
                myDamage += loadout.totalBonus();
            }
            double myArmour = (0.0008 * Math.pow(p.getLevel("Defence"), 3) + 4 * p.getLevel("Defence") + 40) + loadout.totalArmour();
            Map<Ability, Integer> cooldowns = new HashMap<>();
            for (Ability ability : AbilityDatabase.getAbilityDatabase().getAbilities()) {
                if (ability.canUse(loadout.getMainWep(), p))
                    cooldowns.put(ability, 0);
            }
            cooldowns.put(new Ability("Auto-attack", loadout.getMainWep().getWeaponClass(), "Any", "Auto", loadout.getMainWep().getAtkspd(),
                (loadout.getMainWep().getDamage()+ loadout.getMainWep().getMaxAmmo())*0.5/myDamage, new ArrayList<>()), 0);
            int adren = 0;
            int foodCooldown = 0;
            int kills = 0;
            double nextDrop = 0.0;
            boolean stackableUsed = false;
            while (ticks < TICKS_PER_HOUR) {
                for (List<Enemy> enemyGroup : enemyGroups) {
                    for (Enemy enemy : enemyGroup) {
                        int monsterTicks = -1;
                        //System.out.println("Began fighting: " + enemy.getName());
                        int affinity;
                        if (loadout.getMainWep().getStyle().equals(enemy.getWeakness())) {
                            affinity = enemy.getAffweakness();
                        } else if (parameters.getCombatStyle().equals("Melee")) {
                            affinity = enemy.getAffmelee();
                        } else if (parameters.getCombatStyle().equals("Ranged")) {
                            affinity = enemy.getAffranged();
                        } else {
                            affinity = enemy.getAffmage();
                        }
                        double myAccuracy = (0.0008 * Math.pow(p.getLevel(accuracySkill), 3) + 4 * p.getLevel(accuracySkill) + 40) + loadout.getMainWep().getAccuracy();
                        double enemyArmour = (0.0008 * Math.pow(enemy.getDef(), 3) + 4 * enemy.getDef() + 40) + enemy.getArmor();
                        double myHitChance = Math.min(1, (affinity * myAccuracy) / (enemyArmour * 100.0));
                        int enemyAttackStyles = 0;
                        double enemyMeleeDamage = 0;
                        double enemyRangedDamage = 0;
                        double enemyMagicDamage = 0;
                        if (enemy.getAccmelee() > 0) {
                            enemyAttackStyles++;
                            enemyMeleeDamage = Math.min(1, (myMeleeAffinity * (enemy.getAccmelee() + (0.0008 * Math.pow(enemy.getAttack(), 3) + 4 * enemy.getAttack() + 40))
                                / myArmour) / 100) * enemy.getMaxhitmelee() / 2.0;
                        }
                        if (enemy.getAccranged() > 0) {
                            enemyAttackStyles++;
                            enemyRangedDamage = Math.min(1, (myRangedAffinity * (enemy.getAccranged() + (0.0008 * Math.pow(enemy.getRanged(), 3) + 4 * enemy.getRanged() + 40))
                                / myArmour) / 100) * enemy.getMaxhitranged() / 2.0;
                        }
                        if (enemy.getAccmage() > 0) {
                            enemyAttackStyles++;
                            enemyMagicDamage = Math.min(1, (myMagicAffinity * (enemy.getAccmage() + (0.0008 * Math.pow(enemy.getMagic(), 3) + 4 * enemy.getMagic() + 40))
                                / myArmour) / 100) * enemy.getMaxhitmagic() / 2.0;
                        }
                        double enemyLp = enemy.getLp() / partySize;
                        while (myLp > 0 && enemyLp > 0) {
                            ticks++;
                            monsterTicks++;
                            Ability abilityUsedThisTick = null;
                            double maxDamage = 0;
                            if (myLp < Math.max(enemy.getMaxhitmagic(), Math.max(enemy.getMaxhitmelee(), enemy.getMaxhitranged())) && invenUsed < inventorySize) {
                                if (foodCooldown <= 0) {
                                    myLp += maxLpHealedPerFood;
                                    invenUsed++;
                                    adren = Math.max(0, adren - 10);
                                    foodCooldown = 3;
                                    for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet()) {
                                        if (abilityWithCooldown.getValue() < 3)
                                            cooldowns.put(abilityWithCooldown.getKey(), 3);
                                    }
                                    //System.out.println("Tick " + ticks + ": Ate food number " + invenUsed);
                                }
                            } else {
                                for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet()) {
                                    if (abilityWithCooldown.getValue() <= 0 && (abilityWithCooldown.getKey().getType().equals("Auto")
                                        || abilityWithCooldown.getKey().getType().equals("Basic")
                                        || (abilityWithCooldown.getKey().getType().equals("Threshold") && adren >= 50)
                                        || (abilityWithCooldown.getKey().getType().equals("Ultimate") && adren == 100))) {
                                        if (abilityUsedThisTick == null || abilityWithCooldown.getKey().getExpectedDamage() > maxDamage
                                            || (abilityWithCooldown.getKey().getExpectedDamage() == maxDamage && abilityWithCooldown.getKey().getCooldown() > abilityUsedThisTick.getCooldown())) {
                                            abilityUsedThisTick = abilityWithCooldown.getKey();
                                            maxDamage = abilityWithCooldown.getKey().getExpectedDamage();
                                        }
                                    }
                                }
                            }
                            if (abilityUsedThisTick != null) {
                                enemyLp -= myHitChance * myDamage * maxDamage;
                                //System.out.println("Tick " + ticks + ": Used " + abilityUsedThisTick.getName() + ", Enemy has " + enemyLp + " LP left");
                                cooldowns.put(abilityUsedThisTick, abilityUsedThisTick.getCooldown());
                                if (!abilityUsedThisTick.getType().equals("Auto")) {
                                    for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet()) {
                                        if (abilityWithCooldown.getValue() < 3)
                                            cooldowns.put(abilityWithCooldown.getKey(), 3);
                                        foodCooldown = 3;
                                    }
                                }
                                switch (abilityUsedThisTick.getType()) {
                                    case "Auto":
                                        adren += 2;
                                        break;
                                    case "Basic":
                                        adren += 8;
                                        break;
                                    case "Threshold":
                                        adren -= 15;
                                        break;
                                    case "Ultimate":
                                        adren = 0;
                                        break;
                                    default:
                                        throw new RuntimeException(String.format("Invalid type of ability: must be Auto, Basic, Threshold, or Ultimate, was %s", abilityUsedThisTick.getType()));
                                }
                                adren = Math.min(100, adren);
                            }
                            for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet())
                                cooldowns.put(abilityWithCooldown.getKey(), abilityWithCooldown.getValue() - 1);
                            foodCooldown--;
                            if (monsterTicks % (enemy.getAtkspd() * partySize) == 0 && monsterTicks != 0) {
                                double enemyDamage;
                                if (loadout.getPrayer().getName().equals("Protect from Magic") && prayerPoints > 0) {
                                    enemyDamage = (enemyMeleeDamage + enemyRangedDamage + enemyMagicDamage * 0.5) / enemyAttackStyles;
                                } else {
                                    enemyDamage = (enemyMeleeDamage + enemyRangedDamage + enemyMagicDamage) / enemyAttackStyles;
                                }
                                myLp -= enemyDamage * (1 - loadout.totalReduc());
                                hpLost += enemyDamage * (1 - loadout.totalReduc());
                                //System.out.println("Tick " + ticks + ": LP Remaining: " + myLp);
                            }
                            if (prayerPoints > 0) {
                                prayerPoints = Math.max(0, (prayerPoints - loadout.getPrayer().getDrainPerTick()) * (1 - loadout.totalPrayBonus() / 100.0));
                            }
                        }
                    }
                    //hide in safespot and heal w/regen between enemy groups/waves
                    if (myLp > 0 && safespot) {
                        myLp += (p.getLevel("Constitution") * adren) / 5;
                        adren = 0;
                        //System.out.println("LP Remaining after Regenerate: " + myLp);
                    }
                }
                if (myLp > 0 && ticks < TICKS_PER_HOUR) {
                    kills++;
                    nextDrop += parameters.getDroprate();
                    if (nextDrop > 1.0) {
                        //System.out.println(String.format("Tick %d: Spending 5 ticks to pick up a drop", ticks));
                        nextDrop--;
                        ticks+=5;
                        foodCooldown-=5;
                        for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet())
                            cooldowns.put(abilityWithCooldown.getKey(), abilityWithCooldown.getValue() - 5);
                        if (!parameters.isStackable() || !stackableUsed) {
                            stackableUsed = true;
                            invenUsed++;
                        }
                    }
                    int minCooldown = cooldowns.values().stream().mapToInt(a -> a).min().orElseThrow(RuntimeException::new);
                    if (minCooldown > 0) {
                        ticks += minCooldown;
                        foodCooldown-=minCooldown;
                        for (Map.Entry<Ability, Integer> abilityWithCooldown : cooldowns.entrySet())
                            cooldowns.put(abilityWithCooldown.getKey(), abilityWithCooldown.getValue() - minCooldown);
                    }
                    //System.out.println("Total kills so far: " + kills);
                }
                if (!parameters.isMultikill() || myLp <= 0) {
                    break;
                }
            }
            if (myLp <= 0 && kills == 0) {
                hpLost = 1000000000;
            }
            CombatResults loadoutResults = new CombatResults(hpLost, kills, Math.min(ticks, TICKS_PER_HOUR), loadout);
            StoredCombatCalcs.getCalculatedCombats().put(new CombatScenario(this, loadout, new HashMap<>(p.getXp()), parameters), loadoutResults);
            if (kills > maxKills || (kills == maxKills && hpLost < minHpLost)) {
                results = loadoutResults;
                minHpLost = hpLost;
                maxKills = kills;
            }
        }
        return results;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Encounter)) {
            return false;
        }
        Encounter encounter = (Encounter) obj;
        return enemyGroups.equals(encounter.getEnemyGroups()) && restrictions.equals(encounter.getRestrictions()) && partySize == encounter.getPartySize() && safespot == encounter.isSafespot();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + enemyGroups.hashCode();
        result = 31*result + restrictions.hashCode();
        result = 31*result + partySize;
        result = 31*result + (safespot ? 1 : 0);
        return result;
    }
}
