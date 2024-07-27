package control;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        Directory dir = new Directory("src/resources/directoy");
        List<Path> paths = dir.extractFilePaths();
        System.out.println(paths);
    }
}