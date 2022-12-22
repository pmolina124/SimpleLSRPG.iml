package Bussines;

import Persistance.CharacterJsonDAO;

import java.util.List;

/**
 * The type Character manager.
 */
public class CharacterManager {
    private final CharacterJsonDAO characterJsonDAO;

    /**
     * Instantiates a new Character manager.
     *
     * @param characterJsonDAO the character json dao
     */
    public CharacterManager(CharacterJsonDAO characterJsonDAO) {
        this.characterJsonDAO = characterJsonDAO;
    }

    /**
     * Method that gets the name of all the participants of the event
     *
     * @return returns an ArrayList containing the names of the participants of the event
     */
//public ArrayList<Character> listClassCharacter() {return CharacterJsonDAO.getCharacters();}
    public List<Character> getCharacters() {
        return characterJsonDAO.getListCharacter();
    }
}
