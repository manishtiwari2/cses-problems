import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] freq = new int[26];
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().trim();
        n = str.length();
        for (char ch : str.toCharArray()) {
            freq[ch - 'a']++;
        }

        generate("");
        System.out.println(result.size());

        for (String s : result) {
            System.out.println(s);
        }
    }

    static void generate(String current) {

        if (current.length() == n) {
            result.add(current);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[i]--;

                generate(current + (char) ('a' + i));
                freq[i]++;
            }
        }
    }
}