package com.shankardesigner.ecare.test;

public class Factorial {
    public static void main(String[] args) {
        int i = factorialTest(4);
        System.out.println("Factoraial: " + i);
        int fibonenci = fibonenci(5);
        System.out.println("fibonenci:- " + fibonenci);

        String str1 = new String("FB");
        String str2 = new String("Ea");

        System.out.println(str1.hashCode() + " " + str2.hashCode());
    }

    private static int fibonenci(int n) {
        if ( n == 0 ) {
            return 0;
        }
        else if ( n == 1 ) {
            return 1;
        }
        else {
            return (fibonenci(n - 1) + fibonenci(n - 2));
        }
    }

    private static int factorialTest(int n) {
        if(n == 0) {
            return 1;
        }
        else {
            return n * factorialTest(n - 1);
        }
    }
}
