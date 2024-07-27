package control;

import java.nio.file.Path;
import java.util.List;

public interface IFilePathsExtractor
{
    List<Path> extractFilePaths();
    int getFileCount();
    int getDirCount();
}
