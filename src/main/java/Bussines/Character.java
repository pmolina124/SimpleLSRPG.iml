package Bussines;

import java.util.ArrayList;

/**
 * The type Character.
 */
public class Character {
    private String name;
    private String player;
    private String level;
    private int xp;
    private int body;
    private int mind;
    private int spirit;
    private String CharacterClass;

    /**
     * Instantiates a new Character.
     */
    public Character() {}

    /**
     * Gets name.
     *
     * @return the name
     */
//GETTERS
    public String getName() {
        return name;
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public String getPlayer() {
        return player;
    }

    /**
     * Gets xp.
     *
     * @return the xp
     */
    public int getXp() {
        return xp;
    }

    /**
     * Gets mind.
     *
     * @return the mind
     */
    public int getMind() {
        return mind;
    }

    /**
     * Gets spirit.
     *
     * @return the spirit
     */
    public int getSpirit() {
        return spirit;
    }

    /**
     * Gets character class.
     *
     * @return the character class
     */
    public String getCharacterClass() {
        return CharacterClass;
    }

    /**
     * Gets body.
     *
     * @return the body
     */
    public int getBody() {return body;}

    /**
     * Gets level.
     *
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
//SETTERS
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets player.
     *
     * @param player the player
     */
    public void setPlayer(String player) {
        this.player = player;
    }

    /**
     * Sets xp.
     *
     * @param xp the xp
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * Sets mind.
     *
     * @param mind the mind
     */
    public void setMind(int mind) {
        this.mind = mind;
    }

    /**
     * Sets spirit.
     *
     * @param spirit the spirit
     */
    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    /**
     * Sets character class.
     *
     * @param characterClass the character class
     */
    public void setCharacterClass(String characterClass) {
        this.CharacterClass = characterClass;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(int body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return getName() + "-" + getPlayer() + "-" + getCharacterClass() + "-" + getLevel() + "-" + getXp() + "-" + getBody() + "-" + getMind() + "-" + getSpirit();
    }
}
