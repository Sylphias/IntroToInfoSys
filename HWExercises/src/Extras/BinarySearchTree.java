package Extras;

/**
 * Created by Ilya on 20/10/16.
 */
public class BinarySearchTree {
    public static Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(char id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (id == current.data) {
                return;
            } else {
                if (id <= current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
}
