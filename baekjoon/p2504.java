package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        int ans = 0, sum=1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                sum *= 2;
                s.push(str.charAt(i));
            } else if (str.charAt(i) == '[') {
                sum *= 3;
                s.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (s.isEmpty() || s.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                if (s.peek() == '(') {
                    if (str.charAt(i-1) == '(')
                        ans += sum;
                    sum /= 2;
                    s.pop();
                }
            } else {
                if (s.isEmpty() || s.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                if (s.peek() == '[') {
                    if (str.charAt(i-1) == '[')
                        ans += sum;
                    sum /= 3;
                    s.pop();
                }
            }
        }

        if (!s.isEmpty())
            System.out.println(0);
        else
            System.out.println(ans);

    }
}
