package utilFunctions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJsonSchema {
    static String readFile(String filename) throws IOException {
        String path = "resources/test-data/JSON-schema/" + filename;
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}


