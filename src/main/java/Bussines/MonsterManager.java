package Bussines;

import Persistance.MonsterJsonDAO;

/**
 * The type Monster manager.
 */
public class MonsterManager {
    private final MonsterJsonDAO monsterJsonDAO;

    /**
     * Instantiates a new Monster manager.
     *
     * @param monsterJsonDAO the monster json dao
     */
    public MonsterManager(MonsterJsonDAO monsterJsonDAO) {
        this.monsterJsonDAO = monsterJsonDAO;
    }

}
