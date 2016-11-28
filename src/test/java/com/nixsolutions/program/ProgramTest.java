package com.nixsolutions.program;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

public class ProgramTest {

    private Program program;
    private File inputData;

    @Before
    public void setUp() throws Exception {
        program = new Program();
        inputData = new File("src/test/resources/readme.txt");
    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void shouldWriteRouteToFile() throws Exception {
        //given
        String expectedResult = "0 0" + System.lineSeparator() +
                "0 1" + System.lineSeparator() +
                "0 2" + System.lineSeparator() +
                "1 2" + System.lineSeparator() +
                "1 3" + System.lineSeparator() +
                "1 2" + System.lineSeparator() +
                "1 1" + System.lineSeparator() +
                "1 0" + System.lineSeparator();
        File createdFile = folder.newFile("result.txt");

        //when
        program.robotMove(inputData, createdFile);

        //then
        String actualResult = readFile(createdFile);
        assertEquals(expectedResult, actualResult);
    }

    private String readFile(File fileName) throws IOException {
        Path path = fileName.toPath();
        byte[] data = Files.readAllBytes(path);
        return new String(data, StandardCharsets.UTF_8);
    }
}
