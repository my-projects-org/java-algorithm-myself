package com.algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.Math.abs;
import static java.lang.Math.log;

public class Q1114 {
    PriorityQueue<Integer> logs = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        Q1114 q1114 = new Q1114();
        q1114.solve(new InputStreamReader(System.in));
    }
    public void solve(InputStreamReader inputStreamReader) throws IOException {
        /**
         * 통나무의 길이 : L
         * K개의 위치에서만 자를 수 있다.(위치는주어짐, 왼쪽에서 얼마나 떨어져 있는지)
         * 통나무를 자를 수 있는 횟수는 최대 C 번
         * 가장긴 조각의 길이 + 처음 자르는 위치를 출력(여러개가 있을 수 있다면 처음 자르력는 위치가 가까운것을 출력)
         * |---------------------------------| <- 통나무(ㅣ)
         * ^가장 왼쪽
         *
         * 가장 긴 조각을 작게 만들고 그 길이를 구하자!
         * dp 로 풀 수 있는가? 없을듯?
         *
         * 아이디어
         * 완전탐색을 한다면?
         * 자르기를 할때, 중간에 가깝게 자르면, 가장 긴 조각이 가작 작아질 것 같다.
         * 그다음 자르기를 할때는 도막들 중 가장 긴 도막을 선택해서 자른다.
         * 만약 자를 수 있는 위치가, 가운데로부터 같다면, 왼쪽에 있는 것을 선택한다.
         *
         * 필요한 데이터
         * 통나무를 나나내야 함. 배열 + index 로 나타낼 수 있을듯
         * 9 2 1의 경우
         * 자를 수 있는 위치 = 4, 5듯
         * [true, true, true, true, true, true, true, true, true]
         * 통나무를 Integer의 List로 하는게 더 나을
         * index는 통나무 번호
         */
        BufferedReader br = new BufferedReader(inputStreamReader);
        Integer[] firstLine = Arrays.stream(br.readLine().split(" ")).map(element -> Integer.parseInt(element)).toArray(Integer[]::new);
        Integer[] cutterblePoints = Arrays.stream(br.readLine().split(" ")).map(element -> Integer.parseInt(element)).toArray(Integer[]::new);

        Integer logLength = firstLine[0];
        Integer numberOfCutterblePoint = firstLine[1];
        Integer numberOfCuttingTrial = firstLine[2];
        logs.add(logLength);
        divideLogsToEnd(cutterblePoints,numberOfCuttingTrial);
    }

    private void divideLogsToEnd( Integer[] cutterblePoint, int numberOfCuttingTrial){
        Integer[] sortedCutterblePoint = Arrays.stream(cutterblePoint).sorted().toArray(Integer[]::new);
        int firstPoint = 0;
        for (int i = 0; i < numberOfCuttingTrial; i++) {
            logs = divideLogs(cutterblePoint);
            if(i == 0){
                for (Integer integer : sortedCutterblePoint) {
                    if(logs.contains(integer)){
                        firstPoint = integer;
                        break;
                    }
                }
            }
        }
        for (Integer integer : sortedCutterblePoint) {
            if(logs.contains(integer)){
                firstPoint = integer;
                break;
            }
        }
        System.out.print(logs.poll());
        System.out.print(" ");
        System.out.print(firstPoint);


    }
    private PriorityQueue<Integer> divideLogs( Integer[] cutterblePoint) {
        Integer longestLog = logs.poll();
        int midleOfLongestLog = longestLog/2;
        cutterblePoint = Arrays.stream(cutterblePoint).filter(element -> element <= longestLog).toArray(Integer[]::new);
        int minDifferenceMidAndCutterblePoint =  10001;
        int targetCutterblePoint = 0;
        for (Integer currPoint : cutterblePoint) {
            int differenceMidAndPoint = abs(currPoint - midleOfLongestLog);
            if(differenceMidAndPoint<minDifferenceMidAndCutterblePoint){
                minDifferenceMidAndCutterblePoint = differenceMidAndPoint;
                targetCutterblePoint = currPoint;
            }
        }
        logs.add(targetCutterblePoint);
        logs.add(longestLog - targetCutterblePoint);
        return logs;
    }
}
