package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2206 {
    static class Position{
        int y;
        int x;
        int dis;
        int wall;
        public Position(int y,int x,int dis,int wall){
            this.y = y;
            this.x = x;
            this.dis = dis;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] visit = new int[n][m];
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j) - 48;
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        int answer = Integer.MAX_VALUE;

        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0,0,1,0));
        while(!q.isEmpty()){
            Position p = q.poll();
            if(p.y == n-1 && p.x == m-1){
                answer = p.dis;
                break;
            }
            for(int i=0;i<4;i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny<0 || ny>=n || nx<0 || nx>=m)
                    continue;
                if(visit[ny][nx] <= p.wall)
                    continue;
                if(map[ny][nx] == 0){
                    visit[ny][nx] = p.wall;
                    q.add(new Position(ny,nx,p.dis+1,p.wall));
                }else{
                    if(p.wall==0){
                        visit[ny][nx] = 1;
                        q.add(new Position(ny,nx,p.dis+1,p.wall+1));
                    }
                }
            }
        }
        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }
}
