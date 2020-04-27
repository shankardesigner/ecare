package com.shankardesigner.ecare.test.lcm;

public class LCM {
    private static long lcm(long no1, long no2) {
        long lcmNumber;
        lcmNumber = (no1 * no2) / greateastCommonDivisor(no1, no2);
        return lcmNumber;
    };

    private static long greateastCommonDivisor(long no1, long no2) {
        if(no2 == 0) return  no1;
        long l = greateastCommonDivisor(no2, no1 % no2);
        //System.out.println("greateastCommonDivisor:- " + l);
        return l;

    };

    public static void main(String[] args) {
        System.out.println(greateastCommonDivisor(10,5));
        System.out.println(lcm(8,5));
    }
}
