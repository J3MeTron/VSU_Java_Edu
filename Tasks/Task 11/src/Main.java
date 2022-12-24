import util.UniversalUtils;

import java.util.*;

public class Main {
    public static final String START_TEXT = "Task 11(14). Petrov Artem group 1.1 Исправить текст, убрав подряд идущие одинаковые слова, разделанные одним или несколькими пробелами\n\n";

    public static void startProgram() {
        UniversalUtils.print(START_TEXT);
    }

    public static void main(String[] args) throws Exception {
        startProgram();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(str, "\s");
        List<String> list = new LinkedList<String>();
        String lastBuf = null;
        while (st.hasMoreTokens()) {
            String buf = st.nextToken();
            if (!list.contains(buf) || buf != lastBuf) {
                list.add(buf);
            }
            lastBuf = buf;
        }
        for (String i : list) System.out.print(i + " ");
    }
}