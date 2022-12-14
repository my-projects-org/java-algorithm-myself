package com.algorithm.programmers.level1;

import java.util.*;

public class Q142086 {
    public int[] solution(String s){
        return Solution.solution(s);
    }
}

class Solution {
    public static int[] solution(String s) {
        var charArray = s.toCharArray();
        int[] answer = new int[charArray.length];
        HashMap<Character, Integer> cache = new HashMap<>();
        for(int i = 0; i< charArray.length;i++){
            if(Objects.isNull(cache.get(charArray[i]))){
                cache.put(charArray[i],i);
                answer[i] = -1;
            }else{
                answer[i]=i-cache.get(charArray[i]);
                cache.put(charArray[i],i);

            }
        }
        return answer;
    }
}