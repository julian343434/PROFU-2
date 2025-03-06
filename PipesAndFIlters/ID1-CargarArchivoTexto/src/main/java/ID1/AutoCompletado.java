package ID1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AutoCompletado implements IAutoCompletado{
    @Override
    public String autoComplete(String input) throws IOException {
        File file = new File(input);
        if (!file.exists()) {
            file = file.getParentFile();
        }
        if (file == null || !file.isDirectory()) {
            return input;
        }
        String[] files = file.list();
        if (files == null) {
            return input;
        }
        return Arrays.stream(files)
                .filter(name -> name.startsWith(input))
                .collect(Collectors.joining(" "));
    }
}
