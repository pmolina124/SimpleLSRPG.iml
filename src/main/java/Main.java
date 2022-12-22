import Bussines.CharacterManager;
import Bussines.ConsoleUIManager;
import Bussines.MonsterManager;
import Persistance.CharacterJsonDAO;
import Persistance.MonsterJsonDAO;
import Presentation.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws FileNotFoundException the file not found exception
     */
    public static void main(String[] args) throws FileNotFoundException {
        try {
            MonsterJsonDAO monsterJsonDAO = new MonsterJsonDAO();
            MonsterManager monsterManager = new MonsterManager(monsterJsonDAO);

            try {
                CharacterJsonDAO characterJsonDAO = new CharacterJsonDAO();
                CharacterManager characterManager = new CharacterManager(characterJsonDAO);

                ConsoleUIManager ui = new ConsoleUIManager();
                Controller controller = new Controller(ui, monsterManager, characterManager);

                controller.run();
            } catch (IOException e0) {
                System.out.print("Error: the characters.json file can't be accessed.\n");
            }
        } catch (IOException e1) {
            System.out.print("Error: the monster.json file can't be accessed.\n");
        }

    }
}
