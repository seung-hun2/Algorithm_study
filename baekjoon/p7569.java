package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7569 {
    static int N,M,H,cnt;
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {-1,1,0,0,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static int[][][] box;
    static boolean[][][] visit;
    static Queue<Node> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visit = new boolean[H][N][M];

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++) {
                for (int k = 0; k < M; k++) {
                   if(box[i][j][k] == 1){
                       q.add(new Node(i,j,k));
                   }
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs(){

        while(!q.isEmpty()){
            Node n = q.poll();
            for(int i=0;i<6;i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                int nz = n.z + dz[i];
                if(nx<0 || nx>=M || ny<0 || ny>=N || nz<0 || nz>=H) continue;
                if(box[nz][ny][nx] == 0 && !visit[nz][ny][nx]) {
                    q.add(new Node(nz, ny, nx));
                    box[nz][ny][nx] = box[n.z][n.y][n.x]+1;
                    visit[nz][ny][nx] = true;
                }
            }
        }
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        return -1;
                    }
                    cnt = Math.max(box[i][j][k], cnt);
                }
            }
        }
        return cnt-1;
    }
    public static class Node{
        int x,y,z;
        public Node(int z, int y ,int x){
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
