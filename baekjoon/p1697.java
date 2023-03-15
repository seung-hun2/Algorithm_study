package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1697 {
    static int now, des, cnt = 0;
    static int[] arr = new int[100001];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        now = Integer.parseInt(st.nextToken());
        des = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 100001; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
;
        queue.add(now);
        arr[now] = 0;
        bfs();
        System.out.println(arr[des]);

    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int first = queue.peek();
            queue.poll();
            cnt = arr[first]+1;

            int m = first - 1;
            int p = first + 1;
            int mul = first * 2;

            if(m>=0 && arr[m] > cnt){
                arr[m] = cnt;
                queue.add(m);
            }
            if(p<=100000 && arr[p] > cnt ){
                arr[p] = cnt;
                queue.add(p);
            }
            if(mul<=100000 && arr[mul] > cnt ){
                arr[mul] = cnt;
                queue.add(mul);
            }

            if(m == des || p == des || mul == des) break;
        }
    }
}
