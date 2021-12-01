package adventofcode2021;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<String> readInputLinesFromFile(String filename) throws IOException, URISyntaxException {
        return Files.lines(Paths.get(ClassLoader.getSystemResource(filename).toURI())).collect(Collectors.toList());
    }
}
