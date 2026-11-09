
package lw04.unguided;

import java.util.Scanner;

public class Main {

    static void selectionSort(int[] cards, int passes) {

        int n = cards.length;

        for (int fill = 0; fill < passes; fill++) {
            int posMin = fill;

            for (int next = fill + 1; next < n; next++) {
                if (cards[next] < cards[posMin]) {
                    posMin = next;
                }
            }
            
            int temp = cards[posMin];
            cards[posMin] = cards[fill];
            cards[fill] = temp;
        }
    }

    static int cariKartu(int[] cards, int target) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        int n = sc.nextInt();
        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        sc.close();

        selectionSort(cards, 2);

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(cards[i]);
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int indexFound = cariKartu(cards, targets[i]);

            if (indexFound != -1) {
                System.out.println(targets[i] + ": FOUND at index " + indexFound);
            } else {
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }
    }
}
