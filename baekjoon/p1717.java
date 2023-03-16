package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1717 {
    static int[] value;
    static int num1, num2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        value = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            value[i] = i;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int check = Integer.parseInt(st.nextToken());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            if (check == 0) {
                value[find(num2)] = find(num1);

            } else {
                if (find(value[num1]) == find(value[num2])) sb.append("YES").append('\n');
                else sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);

    }

    static int find(int x) {
        if (value[x] == x) return x;
        return value[x] = find(value[x]);
    }
}
