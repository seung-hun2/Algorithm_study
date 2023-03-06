package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4179 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] arr;
    static boolean[][] visited;
    static int cnt;
    static int R,C;
    static Node node;
    static Node fire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[C][R];
        int[][] fire = new int[C][R];
        visited = new boolean[C][R];

        Node node1 = null;
        Node node2 = null;
        for(int i=0;i<C;i++){
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) == 'J') {
                    arr[i][j] = 1;
                    node1 = new Node(i,j);
                }
                if(str.charAt(j) == 'F') {
                    fire[i][j] = 1;
                    node2 = new Node(i,j);
                }
                if(str.charAt(j) == '#') {
                    arr[i][j] = -1;
                    fire[i][j] = -1;
                }
                if(str.charAt(j) == '.') {
                    fire[i][j] = 0;
                    arr[i][j] = 0;
                }

            }
        }

        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.add(node1);



        System.out.println(cnt);
    }//
    public static class Node{
        int x,y;
        public Node(int y,int x){
            this.x = x;
            this.y = y;
        }
    }

}
