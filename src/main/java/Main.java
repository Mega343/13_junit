import com.nixsolutions.program.Program;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Program pr = new Program();

        File inputData = new File("src/test/resources/readme.txt");
        File outputData = new File("result.txt");
        pr.robotMove(inputData, outputData);
    }
}
