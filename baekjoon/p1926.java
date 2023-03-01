package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1926 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] arr;
    static int n,m,count,large;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count=0;
        large=0;
        bfs();
        System.out.println(count);
        System.out.println(large);

    }
    static void bfs(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0 || visited[i][j]) continue;
                visited[i][j] = true;
                count++;
                Queue<Node> queue = new LinkedList<>();
                queue.add(new Node(i,j));
                int area=0;
                while (!queue.isEmpty()){
                    area++;
                    Node cur = queue.poll();
                    for(int k=0;k<4;k++){
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if(nx<0 || nx>m-1 || ny<0 || ny>n-1 || visited[ny][nx] || arr[ny][nx] != 1) continue;
                        queue.add(new Node(ny,nx));
                        visited[ny][nx] = true;

                    }
                    large = Math.max(area,large);
                }
            }
        }
    }
    static class Node{
        int x,y;
        public Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
}

