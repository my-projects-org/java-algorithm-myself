package com.algorithm.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

public class Q138476 {

    /**
     * k  == 1상자에 담으려는 귤의 갯수
     * tangerine == 가지고 있는 귤
     * <p>
     * 최소가 되게 한다.
     * 1.무식하게 풀기
     * 다 넣어보기,
     * <p>
     * 2. DP로 풀리는가? 부분문제로 나눈다면?
     * ->
     * 3. 그리디로 풀리는가?
     * <p>
     * 4. 구현 문제인가? <= 채택
     * 파싱해서 Map 으로 만들고 가장 많이 있는거 순으로 정렬하고, 위에서 부터 빼먹기?
     * n 으로 Map 화
     * nlogn 으로 소팅
     * 빼먹기
     * 1 ≤ k ≤ tangerine의 길이 ≤ 100,000
     * 1 ≤ tangerine의 원소 ≤ 10,000,000
     * 10^7
     * nlogn 까지 가능
     */

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i : tangerine) { //O(n)
            Integer numberOfI = myMap.get(i);
            if (Objects.isNull(numberOfI)) {
                myMap.put(i, 1);
            } else {
                myMap.put(i, numberOfI + 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entryList = myMap.entrySet().stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());
        for (int i = 0; i < entryList.size(); i++) {
            k -= entryList.get(i).getValue();
            if (k <= 0) {
                return i + 1;
            }
        }
        return -1;
    }

}
