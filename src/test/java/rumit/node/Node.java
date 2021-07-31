package rumit.node;

public class Node {

    /**
     *      Java code to Find maximum (or minimum) in
     *      Binary Tree
     *      A binary tree node
     */
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    class BinaryTree {
        Node root;
        // Returns the max value in a binary tree
        public static int findMaxInTheNode(Node node){
            if (node == null)
                return Integer.MIN_VALUE;
            int res = node.data;
            int lres = findMaxInTheNode(node.left);
            int rres = findMaxInTheNode(node.right);
            if (lres > res)
                res = lres;
            if (rres > res)
                res = rres;
            return res;
        }

        /* Driver code */
        public static void main(String args[]) {
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(2);
            tree.root.left = new Node(7);
            tree.root.right = new Node(5);
            tree.root.left.right = new Node(6);
            tree.root.left.right.left = new Node(1);
            tree.root.left.right.right = new Node(11);
            tree.root.right.right = new Node(9);
            tree.root.right.right.left = new Node(4);
            // Function call
            System.out.println("Maximum element is " + tree.findMaxInTheNode(tree.root));
        }
    }

