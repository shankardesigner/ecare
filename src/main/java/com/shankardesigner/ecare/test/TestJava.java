package com.shankardesigner.ecare.test;

public class TestJava {
    public static void main(String[] args) {
        int fib = fib(5);
        System.out.println(fib);
    }

    private static int fib(int n) {
        if (n <= 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

}
