package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1005 {
    Integer[] cache = new Integer[1001];
    Integer[] buildTime;

    public static void main(String[] args) throws IOException {
        Q1005 q1005 = new Q1005();
        q1005.solve();
    }

    public void solve() throws IOException {
        //매게임 시작시 건물을 짓는 순서가 주어진다. 각 건물은 완성될때 까지 delay가 존재한다.
        //위상정렬 문제?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] nAndK = br.readLine().split(" ");
            int N = Integer.parseInt(nAndK[0]);// 건물 갯수
            boolean[][] graph = new boolean[N + 1][N + 1];
            boolean[][] graphReverse = new boolean[N + 1][N + 1];

            int K = Integer.parseInt(nAndK[1]);// 규칙 수
            Arrays.fill(cache, null);
            buildTime = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).toArray(Integer[]::new);
            for (int j = 0; j < K; j++) {//build 의존성 그래프로 그릴 수 있을듯
                String[] startAndEnd = br.readLine().split(" ");
                int start = Integer.parseInt(startAndEnd[0]);
                int end = Integer.parseInt(startAndEnd[1]);
//                graph[start][end] = true;
                graphReverse[end][start] = true; // 해당 노드가 의존하는 노드를 가르킴
            }
            int nodeNumberForWin = Integer.parseInt(br.readLine());
            int result = dp(nodeNumberForWin, graphReverse, cache);
            System.out.println(result);
            //거꾸로 해서 이 건물 부터 시작해야 할 듯
            //이건물을 짓기 위해 필요한 건물 -> 그 건물을 짓기 위해 필요한 건물 -> 그 건물을 짓기 위해 필요한 건물
            // .... 아무것도 가르키지 않는 건물
            //그중 최소
        }
    }

    private int dp(int targetNumber, boolean[][] graphReverse, Integer[] cache) {//해당 건물을 깃는데 걸리는 최소 시간
        if (cache[targetNumber] != null) {
            return cache[targetNumber];
        } else {

            List<Integer> tmp = new ArrayList();
            for (int i = 0; i < graphReverse[targetNumber].length; i++) {
                if (graphReverse[targetNumber][i]) {
                    tmp.add(dp(i, graphReverse, cache));
                }
            }
            try{
                Integer max = Collections.max(tmp);
                return max + buildTime[targetNumber - 1];
            } catch (NoSuchElementException e){
                cache[targetNumber] = buildTime[targetNumber -1];
                return cache[targetNumber];
            }

        }
        // 해당 건물을 짓는데 필요한 건물들을 알아야함
        // 이 건물이 의존하고 있는 건물 이 없다면 바로 return

//        int numberOfNeedNode = Arrays.stream(graphReverse[targetNumber]).filter(element -> element == true).toArray().length;


    }
}
