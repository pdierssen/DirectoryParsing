package control;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Directory
{
    private Path directory;

    public Directory (String directoryPath)
    {
        directory = FileSystems.getDefault().getPath(directoryPath);
    }
}
