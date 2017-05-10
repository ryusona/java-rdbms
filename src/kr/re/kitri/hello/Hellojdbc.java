package kr.re.kitri.hello;

import  kr.re.kitri.hello.service.MyBizService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by danawacomputer on 2017-05-08.
 */
public class Hellojdbc {

    public static void main(String args[]) {

        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9);

        int firstNumber = 3;
        int secondNumber = 5;

        int resultSum = MyBizService.sumIntList(intList);
        double resultAverage = 0;
        try {
            resultAverage = MyBizService.averageIntList(intList);
        } catch (Exception e) {
            System.out.println(e.getMessage()); // service에 있는 내용이 옴
        }

        System.out.printf("총 합은 : %d \n", resultSum);
        System.out.printf("평균값은 : %.1f \n", resultAverage);

    }

}
