package com.shankardesigner.ecare.test.permutationandcombination;

public class PermutationAndCombination {
    private static int calculateFactorial(int n) {
        if( n == 0 || n == 1 ) return 1;
        int fact = n * calculateFactorial(n - 1);
        return fact;
    };

    private static int combination(int n, int r) {
        int permutation = calculateFactorial(n) / (calculateFactorial(n-r) * calculateFactorial(r));
        return permutation;
    }

    private static int permutation(int n, int r) {
        return calculateFactorial(n) / calculateFactorial(n-r);
    }

    public static void main(String[] args) {
        System.out.println("combination:- " + combination(6,4));
        System.out.println("permutation:- " + permutation(6,4));
    }
}
