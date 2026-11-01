package lw04.prelab;

import java.util.Scanner;

public class Main {
    static void insertionSort(int[] a, int passes) {
        for (int i = 1; i <= passes && i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            
            while (j >= 0 && a[j] < key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
    static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = sc.nextInt();
        int[] branches = new int[n];
        for (int i = 0; i < n; i++) {
            branches[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        insertionSort(branches, 3);

        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(branches[i]);
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int idx = linearSearch(branches, targets[i]);
            if (idx != -1) {
                System.out.println(targets[i] + ": FOUND at index " + idx);
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }
    }
}
