package Tree;

public class AVLTree {
    
    private static class  Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        Node (int value) {
            this.value = value;
            this.height = 0;
        }
    }

    private Node root; 

    public AVLTree () {
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

        return rotate(root);
    } 

    public Node rotate(Node root) {

        // left heavy case
        if (getHeight(root.left) - getHeight(root.right) > 1) {
            // left left rotation
            if (getHeight(root.left.left) >= getHeight(root.left.right)) {
                return rightRotate(root);
            }
            // left right rotation
            if (getHeight(root.left.left) <= getHeight(root.left.right)) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }

        // right heavy case
        if (getHeight(root.left) - getHeight(root.right) < -1) {
            // right right rotation
            if (getHeight(root.right.left) <= getHeight(root.right.right) ) {
                return leftRotate(root);
            }
            // right left rotation
            if (getHeight(root.right.left) >= getHeight(root.right.right) ) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        return root;
    }

    public Node rightRotate (Node parent) {
        Node child = parent.left;
        Node temp = child.right;
        child.right = parent;
        parent.left = temp;

        parent.height = Math.max(getHeight(parent.left), getHeight(parent.right)) + 1;
        child.height = Math.max(getHeight(child.left), getHeight(child.right)) + 1;

        return child;
        
    }

    public Node leftRotate (Node parent) {
        Node child = parent.right;
        Node temp = child.left;

        child.left = parent;
        parent.right = temp;

        parent.height = Math.max(getHeight(parent.left), getHeight(parent.right)) + 1;
        child.height = Math.max(getHeight(child.left), getHeight(child.right)) + 1;

        return child;
    }

    private int getHeight(Node root) {
        return (root == null) ? -1 : root.height;
    }

    public boolean balanced () {
        return balanced(root);
    }

    private boolean balanced(Node root) {
        if (root == null) return true;

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
        AVLTree tree = new AVLTree();
        
        for (int i=1; i<=50; i++) {
            tree.insert(i);
        }

        tree.prettyDisplay();

        System.out.println(tree.getHeight(tree.root));
        
    }

}
