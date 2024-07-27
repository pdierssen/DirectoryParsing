package control;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Directory dir = new Directory("src/resources/directoy");
        File result = new File("src/resources/result12.txt");
        List<Path> paths = dir.extractFilePaths();
        System.out.println(paths);
        FileOutput fileOutput = new FileOutput("src/resources/result187.txt");
        fileOutput.mergeFiles(paths);
    }
}