package Bussines;

import java.util.ArrayList;

/**
 * The type Monster.
 */
public class Monster {
    private String name;
    private String challenge;
    private int experience;
    private int hitPoints;
    private String damageDice;
    private String damageType;

    private Monster[] monsters;

    /**
     * Method that gets the name of all the participants
     *
     * @return returns an ArrayList containing the name of all the participants of the event
     */
    public ArrayList<String> getMonsters() {
        ArrayList<String> list = new ArrayList<>();
        for (Monster monster : this.monsters) {
            list.add(monster.getName());
        }
        return list;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }
}
