package dprating;

import java.io.*;
import java.util.*;

public class LocalStorage
{
    private static final String FILE_NAME = "dp_rating_data.txt";

    public static void saveRecord(String lotNum, String testerName, String fabricName,
                                  String weave, String finishType, float rating, String date)
    {
        try
        {
            FileWriter fw = new FileWriter(FILE_NAME, true);
            fw.write(lotNum + "|" + testerName + "|" + fabricName + "|" + weave + "|" + finishType + "|" + rating + "|" + date + "\n");
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println("LocalStorage save error: " + e);
        }
    }

    public static String[][] loadHistory()
    {
        List<String[]> records = new ArrayList<>();
        try
        {
            File file = new File(FILE_NAME);
            if (!file.exists()) return new String[0][0];

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split("\\|");
                if (parts.length >= 7)
                {
                    records.add(new String[]{parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]});
                }
            }
            br.close();
        }
        catch (Exception e)
        {
            System.out.println("LocalStorage load error: " + e);
        }

        String[][] result = new String[records.size()][7];
        for (int i = 0; i < records.size(); i++)
        {
            result[i] = records.get(i);
        }
        return result;
    }
}