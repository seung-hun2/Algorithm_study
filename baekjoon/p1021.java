package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        int count=0;
        for(int i=1;i<=n;i++){
            deque.offer(i);
        }

        int[] seq = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++){
            int target_idx=deque.indexOf(seq[i]);
            int half_idx;

            if(deque.size()%2 == 0){
                half_idx = deque.size()/2-1;
            }else{
                half_idx = deque.size()/2;
            }

            if(target_idx <= half_idx){
                for(int j=0;j<target_idx;j++){
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            }else{
                for(int j=0;j< deque.size()-target_idx;j++){
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);

    }
}
