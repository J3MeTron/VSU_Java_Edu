package util;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListUtils {
    public static void ListIntToFile(ArrayList<Integer> numbers, String filePath){
        Writer writer = null;
        try {
            writer = new FileWriter(filePath);
            for (int i = 0; i < numbers.size(); i++) {
                writer.write(String.valueOf(numbers.get(i)));
//                тут мог бы быть пробел если надо в одну строку
                writer.write(", ");
            }
            writer.flush();
        } catch (Exception e) {
            Logger.getLogger(ListUtils.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                }
            }
        }
    }
    public static int[] ListToArray(List<Integer> list){
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
        return array;
    }

}
