package control;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Directory implements IFilePathsExtractor
{
    private Path directory;

    public Directory (String directoryPath)
    {
        directory = FileSystems.getDefault().getPath(directoryPath);
    }

    public List<Path> extractFilePaths()
    {
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
        return paths;
    }
}
