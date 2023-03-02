package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576 {
    static int n,m,nx,ny;
    static int[][] arr,dist;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        dist = new int[m][n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) queue.add(new Node(i,j));
                if(arr[i][j] == 0) dist[i][j] = -1;
            }
        }
        while(!queue.isEmpty()){
            Node node1 = queue.poll();
            Node node = new Node(node1.y,node1.x);
            for(int i=0;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
                if(dist[ny][nx] >= 0) continue;
                dist[ny][nx] = dist[node.y][node.x] + 1;
                queue.add(new Node(ny,nx));
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dist[i][j] == -1){
                    System.out.println(-1);
                    return ;
                }
                ans = Math.max(ans, dist[i][j]);
            }
        }
        System.out.println(ans);
    }
    static class Node{
        int x,y;
        public Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
}
