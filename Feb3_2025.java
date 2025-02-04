// Exception handling is the process of responding to the occurrence, during computation, of exceptions – anomalous or exceptional conditions requiring special processing – often changing the normal flow of program execution. (Wikipedia)

// Java has built-in mechanism to handle exceptions. Using the try statement we can test a block of code for errors. The catch block contains the code that says what to do if exception occurs.

// This problem will test your knowledge on try-catch block.

// You will be given two integers
// and as input, you have to compute . If and are not bit signed integers or if

// is zero, exception will occur and you have to report it. Read sample Input/Output to know what to report in case of exceptions.

// Sample Input 0:

// 10
// 3

// Sample Output 0:

// 3

// Sample Input 1:

// 10
// Hello

// Sample Output 1:

// java.util.InputMismatchException


import java.io.*; import java.util.*; import java.text.*; import java.math.*; import java.util.regex.*;

public class Feb3_2025{

public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    //STDIN la Standard Input duoc truyen vao tu Scanner(System.in)
    //STDOUT la Standard Output duoc goi ra tu System.out.print()



    Scanner sc = new Scanner(System.in);
    // Try catch luon tu gia tri x,y duoc truyen vao moi lan qua ban phim
    try{
    int x = sc.nextInt();
    int y = sc.nextInt();
    int a = x/y;

    System.out.println(a);
    }

    catch(InputMismatchException e){
        System.out.println("java.util.InputMismatchException");
    }
    catch(ArithmeticException e){
        System.out.println("java.lang.ArithmeticException: / by zero");
    }

}

}