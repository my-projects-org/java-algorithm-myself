package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2805 {
    public static void main(String[] args) throws IOException {
        Q2805 q2805 = new Q2805();
        q2805.solve();
    }
    private void solve() throws IOException {
        /**
         * 아이디어
         * 가장 위에서 부터 조금씩 내려볼까?
         * 개 오래 걸릴듯
         * 가장 위랑 가장 아래중 한가운데에서 시작해가지고 왔다리 갔다리 해보자
         * 자료구조
         * 알고리즘
         * 시간복잡도
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(" ");
        String numberOfTree = nAndM[0];
        Integer needLength = Integer.parseInt(nAndM[1]);
        Integer[] treeSizes = Arrays.stream(br.readLine().split(" ")).map(element -> Integer.parseInt(element)).sorted((o1, o2) -> o2-o1).toArray(Integer[]::new);
        System.out.println(divideTree(0,treeSizes[0],needLength,treeSizes));
    }
    private int divideTree(int start, int end, int target, Integer[] treeSizes){
        if(start>=end){
            return -1;
        }
        int nowDivide = (start + end)/2;
        long expectTreeHeight = 0;
        for (Integer treeSize : treeSizes) {
            long tmp = treeSize - nowDivide;
            if(tmp>=0){
                expectTreeHeight += tmp;
            }
        }
        if(expectTreeHeight == target){
            return nowDivide;
        }else if(expectTreeHeight<target){ // 타켓보다 짧으면 더 낮춰야 한다.
            return divideTree(start, nowDivide,target,treeSizes);
        }else{//타겟보다 길다.
            int result = divideTree(nowDivide + 1, end, target, treeSizes);
            if(result == -1){
                return nowDivide;
            }else{
                return result;
            }
        }
    }
}
