package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        String[] arr = str.split("");
        for(String s : arr){
            left.push(s);
        }

        for(int i=0;i<n;i++){
            String command = br.readLine();
            char c = command.charAt(0);
            // L은 커서 왼쪽 한칸, D 는 커서 오른쪽 한칸, B 커서 왼쪽 문자 삭제, P$ $라는 문자를 커서 왼쪽 추가
            switch (c){
                case 'L':
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case 'D':
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case 'B':
                    if(!left.isEmpty()) left.pop();
                    break;
                case 'P':
                    char t = command.charAt(2);
                    left.push(String.valueOf(t));
                    break;
            }

        }
        while (!left.isEmpty()) right.push(left.pop());
        while (!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);

        // 단순 구현 -> 시간초과
//        for(int i=0;i<n;i++){
//            // L은 커서 왼쪽 한칸, D 는 커서 오른쪽 한칸, B 커서 왼쪽 문자 삭제, P$ $라는 문자를 커서 왼쪽 추가
//            StringTokenizer st = new StringTokenizer(br.readLine()," ");
//            String c = st.nextToken();
//            if(c.equals("L")){
//                if(cursor>0) {
//                    cursor--;
//                }
//            }else if(c.equals("D")){
//                if(cursor != list.size()){
//                    cursor++;
//                }
//            }else if(c.equals("B")){
//                if(cursor!=0){
//                    list.remove(cursor-1);
//                    cursor--;
//                }
//            }else if(c.equals("P")){
//                if(cursor==0){
//                    list.add(0,st.nextToken().charAt(0));
//                }else{
//                    list.add(cursor, st.nextToken().charAt(0));
//                }
//                cursor++;
//            }
//        }
//        for(int i=0;i<list.size();i++){
//            sb.append(list.get(i));
//        }
//        System.out.println(sb);
    }

}
