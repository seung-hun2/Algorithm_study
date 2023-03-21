package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7562 {
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static int l,cnt;
    static int[][] arr;
    static boolean[][] visit;
    static Queue<Node> q;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int x,y;
        StringTokenizer st;

        for(int i=0;i<n;i++){
            q = new LinkedList<>();
            l = Integer.parseInt(br.readLine());
            arr = new int[l][l];
            visit = new boolean[l][l];
            cnt = 0;

            st = new StringTokenizer(br.readLine()," ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            arr[x][y] = 0;
            q.add(new Node(x,y));

            st = new StringTokenizer(br.readLine()," ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sb.append(bfs(new Node(x,y))).append('\n');
        }
        System.out.println(sb);
    }
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int bfs(Node answer){
        while (!q.isEmpty()){
            Node next = q.poll();
            if(next.x == answer.x && next.y == answer.y) return arr[next.x][next.y];
            if(next.x<0 && next.x>=l && next.y<0 && next.y>=l) visit[next.x][next.y] = true;

            for(int j=0;j<8;j++){
                int nx = next.x + dx[j];
                int ny = next.y + dy[j];

                if(nx<0 || nx>=l || ny<0 || ny>=l) continue;
                if(visit[nx][ny]) continue;
                if(nx == answer.x && ny == answer.y) return arr[next.x][next.y]+1;

                q.add(new Node(nx,ny));
                visit[nx][ny] = true;
                arr[nx][ny] = Math.max(arr[next.x][next.y] + 1, arr[nx][ny]);
            }
        }
        return 0;
    }
}
