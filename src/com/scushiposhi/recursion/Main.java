package com.scushiposhi.recursion;

public class Main {

    public static void main(String[] args) {
        // Factorial -> n!=n*(n-1)!
        // Factorial -> n!=n*(n-1)*(n-2)*...*2*1
        // 4!=4*3*2*1=4*3!

        System.out.println(iterativeFactorial(4));
        System.out.println(recursiveFactorial(4));
    }

    public static int recursiveFactorial(int num){
        // recursive -> I need a break condition otherwise I'll get StackOverflowException
        if(num==0)
            return 1;

        return num*(recursiveFactorial(num-1));
    }
    public static int iterativeFactorial(int num) {
        if (num == 0)
            return 1;

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial*=i;
        }
        return factorial;
    }
}
