package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        Deque<int[]> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            int num = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty() && deque.getLast()[0]>num) deque.pollLast();
            deque.add(new int[]{num,i});
            if(deque.getFirst()[1]< i-L+1) deque.pollFirst();
            sb.append(deque.getFirst()[0]).append(" ");
        }
        System.out.println(sb);

        /**
         * 시간 초과
         */
//        Deque<Integer> deque = new ArrayDeque<>();
//        List<Integer> al = new ArrayList<>();
//        for(int i=1;i<=N;i++){
//            int num = Integer.parseInt(st.nextToken());
//            if(al.size()!=0){
//                if(deque.size()==L || i-al.get(0)>=L ) {
//                    deque.pollFirst();
//                    al.remove(0);
//                }
//            }
//
//            while(true) {
//                if (deque.size() !=0 && deque.getLast() > num) {
//                    deque.pollLast();
//                    al.remove(al.size()-1);
//                }else{
//                    break;
//                }
//            }
//            deque.add(num);
//            al.add(i);
//
//            sb.append(deque.getFirst()).append(" ");
//        }
//        System.out.println(sb);

    }
}
