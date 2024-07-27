package control;

import java.nio.file.Path;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        IFilePathsExtractor dir = new Directory("src/resources/directoy");
        List<Path> paths = dir.extractFilePaths();
        System.out.println(paths);
        IFileMerger fileOutput = new FileOutput("src/resources/result187.txt");
        fileOutput.mergeFiles(paths);
        System.out.println(dir.getFileCount() + ": files");
        System.out.println(dir.getDirCount() + ": dirs");
    }
}