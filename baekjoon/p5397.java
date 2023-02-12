package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                switch (c){
                    case '<':
                        if(!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if(!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if(!left.isEmpty()) left.remove(left.size()-1);
                        break;
                    default:
                        left.push(String.valueOf(c));
                        break;
                }

            }
            while(!left.isEmpty()) right.push(left.pop());
            while(!right.isEmpty()) sb.append(right.pop());
//            for(int j=0;j<left.size();j++){
//                sb.append(left.get(j));
//            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
