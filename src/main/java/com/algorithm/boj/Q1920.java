package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1920 {
    public static void main(String[] args) throws IOException {
        Q1920 q1920 = new Q1920();
        q1920.solve();
    }
    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        Integer[] numbers = Arrays.stream(br.readLine().split(" ")).map(element -> Integer.parseInt(element)).sorted().toArray(Integer[]::new);
        int M = Integer.parseInt(br.readLine());
        Integer[] targetNumbers = Arrays.stream(br.readLine().split(" ")).map(element -> Integer.parseInt(element)).toArray(Integer[]::new);
        for (Integer targetNumber : targetNumbers) {
            if (search(0,numbers.length-1,targetNumber,numbers)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
    private boolean search(int start,int end,int target,Integer[] listToFind) {
        if(start > end) {
            return false;
        }
        int mid = (start + end)/2;
        if(target == listToFind[mid]){
            return true;
        }else if(target < listToFind[mid]){
            return search(start,mid-1,target,listToFind);
        }else{
            return search(mid+1,end,target,listToFind);
        }
    }
}
