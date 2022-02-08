import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_2529 {

    static char operator[];
    static int number[];
    static int length;
    static String max = "", min = "";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(br.readLine());
        operator = new char[length];
        number = new int[length + 1];
        StringTokenizer stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            operator[i] = stz.nextToken().charAt(0);
        }
        getMax(0);
        number = new int[length + 1];
        getMin(0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void getMax(int index) {
        if (!max.equals("")) {
            return;
        }

        for (int i = 9; i >= 0; i--) {
            number[index] = i;
            if (index == 0 || isValid(index, true)) {
                getMax(index + 1);
            }
        }
    }

    public static void print() {
        for (int n : number) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void getMin(int index) {
        if (!min.equals("")) {
            return;
        }

        for (int i = 0; i <= 9; i++) {
            number[index] = i;
            if (index == 0 || isValid(index, false)) {
                getMin(index + 1);
            }
        }
    }

    public static boolean isValid(int index, boolean isMax) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= index; i++) {
            int num = number[i];
            if (set.contains(num)) {
                return false;
            } else {
                set.add(num);
            }
        }

        for (int i = 0; i < index; i++) {
            char oper = operator[i];
            int num1 = number[i];
            int num2 = number[i + 1];
            if (oper == '>' && num1 > num2) {
            } else if (oper == '<' && num1 < num2) {
            } else {
                return false;
            }
        }

        if (index == length) {
            if ((isMax && max.equals("")) || (!isMax && min.equals(""))) {
                String s = "";
                for (int n : number) {
                    s = s + Integer.toString(n);
                }
                if (isMax) {
                    max = s;
                } else {
                    min = s;
                }
            }
        }
        return true;
    }
}
