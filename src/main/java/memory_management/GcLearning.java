package memory_management;

import java.util.Scanner;

public class GcLearning {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = a%5;
        if (b > 0) {
            a += 5 - b;
        }

        System.out.println(a);
//        long availableBytes = runtime.freeMemory();

//        System.out.println("Available memory: " + availableBytes/1024 + "k");
//
//        for(int i = 0; i < 100; i++) {
//            Customer c;
//            c = new Customer("Arpit");
//        }
//
//
//
//        availableBytes = runtime.freeMemory();
//        System.out.println("Available memory: " + availableBytes/1024 + "k");
//
//        System.gc();
//        availableBytes = runtime.freeMemory();
//        System.out.println("Available memory: " + availableBytes/1024 + "k");



    }
}
