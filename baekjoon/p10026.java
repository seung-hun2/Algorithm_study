package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p10026 {
    static int n,cnt=0;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visit = new boolean[n][n];
        StringBuilder sb = new StringBuilder();


        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = str.charAt(j);
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    bfs(i,j);
                }
            }
        }
        sb.append(cnt);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visit[i][j] = false;
                if(arr[i][j] == 'R'){
                    arr[i][j] = 'G';
                }
            }
        }

        cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j]){
                    bfs(i,j);
                }
            }
        }
        sb.append(" ").append(cnt);
        System.out.println(sb);

    }
    static void bfs(int x,int y){
        q.add(new Node(x,y));
        visit[x][y] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visit[nx][ny] || arr[nx][ny] != arr[x][y]) continue;
                q.add(new Node(nx,ny));
                visit[nx][ny] = true;
            }
        }
        cnt++;

    }
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
