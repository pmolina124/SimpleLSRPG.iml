package Presentation;

import Bussines.CharacterManager;
import Bussines.ConsoleUIManager;
import Bussines.MonsterManager;

/**
 * Presentation.Controller for the user interface, the main entry point for the application's logic, which will talk to the UI and
 * the logic of the program.
 *
 * @author DPOO 21-22 Team
 * @version 1.0
 */
public class Controller {
    private final ConsoleUIManager ui;
    private final MonsterManager monsterManager;
    private final CharacterManager characterManager;

    /**
     * Instantiates a new Controller.
     *
     * @param ui               the ui
     * @param monsterManager   the monster manager
     * @param characterManager the character manager
     */
    public Controller(ConsoleUIManager ui, MonsterManager monsterManager, CharacterManager characterManager) {
        this.ui = ui;
        this.monsterManager = monsterManager;
        this.characterManager = characterManager;
    }

    /**
     * Run.
     */
    public void run() {
        boolean isRunning = true;

        ui.persistancePassed();

        while (isRunning) {
            switch (ui.startMenu()) {
                case CREATE_CHRACTER:
                    break;

                case LIST_CHARACTERS:
                    ui.listCharacter(characterManager.getCharacters());
                    ui.clearBuffer();
                    break;

                case CREATE_ADVENTURE:

                    break;

                case START_ADVENTURE:

                    break;

                case EXIT:
                    ui.showExitMessage();
                    isRunning = false;
                    break;
            }
        }

    }
}
