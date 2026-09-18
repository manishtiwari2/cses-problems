import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String[] ans = generate(n);

        for (String s : ans) {
            System.out.println(s);
        }
    }

    static String[] generate(int n) {
        if (n == 1) {
            return new String[]{"0", "1"};
        }

        String[] prev = generate(n - 1);
        String[] result = new String[1 << n];

        int index = 0;
        for (String s : prev) {
            result[index++] = "0" + s;
        }
        for (int i = prev.length - 1; i >= 0; i--) {
            result[index++] = "1" + prev[i];
        }
        return result;
    }
}