package com.algorithm.programmers.level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q43165 {
    public Q43165(){

    };
    public int solution(int[] numbers, int target) {
        int answer = 0;
        return bfs(numbers,target);
    }
    private int bfs(int[] numbers,int target){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        for (Integer integer : numbers) {
            Queue<Integer> tmp = new ArrayDeque<>();
            for (Integer parentValue : queue) {
                tmp.add(parentValue + integer);
                tmp.add(parentValue - integer);
            }
            queue = tmp;
        }
        return queue.stream().filter(element -> element == target).toArray().length;
    }
}
