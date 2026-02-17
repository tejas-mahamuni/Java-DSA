package Tree;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node (int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {
    private Node root;

    private void populate (Scanner scanner) {
        System.out.print("Enter value of root Node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate (Scanner scanner, Node root) {
        System.out.print("Do you want to enter left of " + root.data + ": ");
        boolean left = scanner.nextBoolean();

        if (left) {
            System.out.print("Enter value of left child of " + root.data + ": ");
            int value = scanner.nextInt();
            root.left = new Node(value);
            populate(scanner, root.left);
        }

        System.out.print("Do you want to enter right of " + root.data + ": ");
        boolean right = scanner.nextBoolean();

        if (right) {
            System.out.print("Enter value of right child of " + root.data + ": ");
            int value = scanner.nextInt();
            root.right = new Node(value);
            populate(scanner, root.right);
        }
    }

    private void display () {
        display(root, "");
    }

    private void display (Node root, String indent) {
        if (root == null) {
            return;
        }

        System.out.println(indent + root.data);
        display(root.left, indent + "\t");
        display(root.right, indent + "\t");
    }

    public static void main(String[] tejas) {
        Scanner scanner = new Scanner(System.in);

        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();
    }
}