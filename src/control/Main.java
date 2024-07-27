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
        Path directory = FileSystems.getDefault().getPath("src/resources/directoy");
        List<Path> paths = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory))
            {
                for (Path entry : stream)
                {
                    paths.add(entry);
                }
            } catch (IOException e)
        {
            System.out.println("Exception" +  e.getMessage());
        }
        System.out.println(paths);
    }
}