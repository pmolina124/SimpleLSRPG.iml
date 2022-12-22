package Persistance;

import Bussines.Character;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * The type Character json dao.
 */
public class CharacterJsonDAO {
    // String that contains the name of the file
    private final String path = "src/main/resources/characters.json";
    private Reader reader;
    private Writer writer;
    private List<Character> characters;

    /**
     * Constructor that will open the file
     *
     * @throws IOException if something goes wrong when opening the file
     */
    public CharacterJsonDAO() throws IOException {
        reader = Files.newBufferedReader(Paths.get(path));
        //En esta función pasamos la información del *.json a la memória RAM.
        loadInfoCharacters(reader);
        reader.close();
    }

    /**
     * Gets list character.
     *
     * @return the list character
     */
    public List<Character> getListCharacter() {
            return characters;
    }

    //public List<Character> setListCharacter() {
        //try {
            // writer = new FileWriter("character.json", false);
            // String content = charactercharacters;
            //writer.write(content);
            //writer.close();
            //System.out.println("================================\n"
            //        + "File successfully overwritten.");
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

    //}
    private void loadInfoCharacters(Reader reader){
        Gson gson = new Gson();
        // convert JSON array to list of users
        characters = new Gson().fromJson(reader, new TypeToken<List<Character>>() {}.getType());
    }
}
