package Tree;


public class BinarySearchTree {
    
    private static class Node {
        int value;
        int height;
        Node left;
        Node right;
    
        Node (int value) {
            this.value = value;
            this.height = 0;
        }
    }

    private Node root;

    public BinarySearchTree () {
        root = null;
    }

    public void populate (int[] nums) {
        for (int i=0; i<nums.length; i++) {
            this.insert(nums[i]);
        }
    }
    public void insert (int value) {
        root = insert(root, value);
    }

    private Node insert (Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (root.value > value) {
            root.left = insert(root.left, value);
        }

        if (root.value < value) {
            root.right = insert(root.right, value);
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;

        return root;
    }

    public void populateSorted (int[] nums) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted (int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);

        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    private int getHeight (Node node) {
        return (node == null) ? -1 : node.height;
    }

    public boolean balanced () {
        return balanced(root);
    }

    private boolean balanced (Node root) {
        if (root == null) {
            return true;
        }

        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && balanced(root.left) && balanced(root.right);
    }

    public void display () {
        display(root, "Root Node: ");
    }

    private void display (Node root, String details) {

        if (root == null) {
            return;
        }
        System.out.println(details + root.value);

        display(root.left, "Left child of " + root.value + ": ");
        display(root.right, "Right child of " + root.value + ": ");
    }

    public void prettyDisplay () {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay (Node root, int level) {
        if (root == null) {
            return;
        }

        prettyDisplay(root.right, level + 1);
        
        if (level != 0) {
            for (int i=0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|----------> " + root.value);
        } 
        else {
            System.out.println(root.value);
        }

        prettyDisplay(root.left, level + 1);
    }

    public static void main(String[] args) {
        
        BinarySearchTree tree = new BinarySearchTree();

        int[] nums ={1,2,3,4,5,6,7,8,9,10};

        tree.populateSorted(nums);
        tree.display();
        tree.prettyDisplay();
    }
}
