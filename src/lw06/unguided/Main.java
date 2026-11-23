package lw06.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree tree = new BinarySearchTree();

        String firstLine = read.nextLine();
        String[] numbers = firstLine.split(" ");

        for (int i = 0; i < numbers.length; i++) {
            int data = Integer.parseInt(numbers[i]);
            tree.insert(data);
        }

        int target = read.nextInt();

        System.out.print("Preorder : ");
        tree.preOrder();
        System.out.print("Inorder : ");
        tree.inOrder();
        System.out.print("Postorder : ");
        tree.postOrder();

        System.out.println("Search " + target + " : " + tree.search(target));

        System.out.println("Minimum : " + tree.findMin());
        System.out.println("Maximum : " + tree.findMax());

        read.close();
    }
}