package control;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class FileOutput implements IFileMerger
{
    private BufferedWriter bufferedWriter;

    public FileOutput (String fileName)
    {
        FileWriter fileWriter;
        File result = new File(fileName);
        try
        {
            fileWriter = new FileWriter(result);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e)
        {
            System.out.println("err" + e.getMessage());
        }
    }

    @Override public void mergeFiles(List<Path> list)
    {
        list.forEach(path ->
        {
            try {
                FileReader fileReader = new FileReader(path.toFile());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = bufferedReader.readLine();
                while (line != null)
                {
                    //System.out.println(line);
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    line = bufferedReader.readLine();
                    bufferedWriter.flush();
                }
                bufferedReader.close();
            } catch (FileNotFoundException e)
            {
                System.out.println("Error" + e.getMessage());
            } catch (IOException e)
            {
                System.out.println("IOErrror" + e.getMessage());
            }
        });
        try
        {
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e)
        {
            System.out.println("probelm with closing" + e.getMessage());
        }
    }
}
