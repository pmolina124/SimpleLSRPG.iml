package Persistance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;

/**
 * The type Adventures json dao.
 */
public class AdventuresJsonDAO {
    // String that contains the name of the file
    private final String path = "monster.json";
    private final FileReader fr;

    /**
     * Constructor that will open the file
     *
     * @throws FileNotFoundException if something goes wrong when opening the file
     */
    public AdventuresJsonDAO() throws FileNotFoundException {
        URL resource = ClassLoader.getSystemClassLoader().getResource(path);
        fr = new FileReader(resource.getFile());
    }


}
