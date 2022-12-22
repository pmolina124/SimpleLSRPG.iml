package Persistance;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

/**
 * The type Monster json dao.
 */
public class MonsterJsonDAO {
    // String that contains the name of the filejs
    private final String path = "src/main/resources/monster.json";
    private Reader reader;

    /**
     * Constructor that will open the file
     *
     * @throws IOException the io exception
     */
    public MonsterJsonDAO  () throws IOException {
        Gson gson = new Gson();
        reader = Files.newBufferedReader(Paths.get(path));
    }
}
