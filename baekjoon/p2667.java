package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class p2667 {
    static int n;
    static int[][] arr;
    static Queue<Node> q;
    static ArrayList<Integer> answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        visit = new int[n][n];
        answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        for (int num : answer) {
            System.out.println(num);
        }
    }
    static void bfs(int x, int y){
        q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        int l_cnt = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    l_cnt++;
                }
            }
        }

        answer.add(l_cnt);
    }
    public static class Node{
        int x,y;
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}