package Tree;

public class SegmentTree {

    private static class Node {
        private int value;
        private int startInterval;
        private int endInterval;
        private Node left;
        private Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    public SegmentTree (int[] arr) {
        this.root = constructTree (arr, 0, arr.length - 1 );
    }

    private Node constructTree (int[] arr, int start, int end) {

        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.value = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = (start + end) / 2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        node.value = node.left.value + node.right.value;

        return node;
    }

    public void display () {
        display(root);
    }

    private void display (Node root) {
        String str = "";

        if (root.left != null) {
            str = str + "[" + root.left.startInterval + " - " + root.left.endInterval + "] and Data: " + root.left.value + " + => "; 
        }else {
            str = str + " No left child => ";
        }

        str = str + "[" + root.startInterval + " - " + root.endInterval + "] and Data: " + root.value + " <= "; 

        if (root.right != null) {
            str = str + "[" + root.right.startInterval + " - " + root.right.endInterval + "] and Data: " + root.right.value; 
        }else {
            str = str + " No right child ";
        }

        System.out.println(str + "\n");

        if (root.left != null) {
            display(root.left);
        }

        if (root.right != null) {
            display(root.right);
        }
    }

    public int query (int start, int end) {
        return query(root, start, end);
    }

    private int query (Node root, int start, int end) {
        
        if (root.startInterval >= start && root.endInterval <= end) {
            return root.value;
        }
        if (root.startInterval > end || root.endInterval < start) {
            return 0;
        }

        return this.query(root.left, start, end) + this.query(root.right, start, end);
    }

    public void update (int index, int value) {
        this.root.value = update(root, index, value);
    }

    private int update (Node root, int index, int value) {

        if (index >= root.startInterval && index <= root.endInterval) {
            if (index == root.startInterval && index == root.endInterval) {
                root.value = value;
                return root.value;
            }
            else {
                int leftAns = update(root.left, index, value);
                int rightAns = update(root.right, index, value);
    
                root.value = leftAns + rightAns;
                return root.value;
            }
        }
        return root.value;
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
            System.out.println("|----------> " + root.value + "[" + root.startInterval + "-" + root.endInterval + "]");
        } 
        else {
            System.out.println(root.value + "[" + root.startInterval + "-" + root.endInterval + "]");
        }

        prettyDisplay(root.left, level + 1);
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        SegmentTree tree = new SegmentTree(arr);

        System.out.println(tree.query(2, 7));
        tree.update(2, 7);
        System.out.println(tree.query(2, 7));

        tree.prettyDisplay();


    }


}
