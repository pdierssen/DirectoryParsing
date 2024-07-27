package control;

import java.io.File;
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
    private List<Path> filePathList;

    public Directory (String directoryPath)
    {
        directory = FileSystems.getDefault().getPath(directoryPath);
        filePathList = new ArrayList<>();
    }

    private void listFilePathsFromDirectory(Path directory)
    {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory))
        {
            for (Path entry : stream)
            {
                if (entry.toFile().isDirectory())
                {
                    listFilePathsFromDirectory(entry);
                }
                else
                {
                    filePathList.add(entry);
                }
            }
        } catch (IOException e)
        {
            System.out.println("Exception" +  e.getMessage());
        }

    }

    @Override
    public List<Path> extractFilePaths()
    {
        filePathList.clear();
        listFilePathsFromDirectory(directory);
        return filePathList;
    }
}
