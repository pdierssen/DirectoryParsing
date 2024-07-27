package control;

import java.nio.file.Path;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Directory dir = new Directory("src/resources/directoy");
        List<Path> paths = dir.extractFilePaths();
        System.out.println(paths);
        FileOutput fileOutput = new FileOutput("src/resources/result187.txt");
        fileOutput.mergeFiles(paths);
        System.out.println(dir.filecount + ": files");
        System.out.println(dir.dircount + ": dirs");
    }
}