class Node {
    int data;
    Node left, right;
    int height;

    Node(int value) {
        data = value;
        height = 1;
    }
}

class AVLTree {
    Node root;

    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    Node insert(Node node, int data) {
        if (node == null)
            return (new Node(data));

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else
            return node;

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalanceFactor(node);

        if (balance > 1) {
            if (data < node.left.data) {
                return rotateRight(node);
            } else if (data > node.left.data) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if (balance < -1) {
            if (data > node.right.data) {
                return rotateLeft(node);
            } else if (data < node.right.data) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Preorder traversal of constructed AVL tree:");
        tree.preOrder(tree.root);
    }
}
class Node {
    int data;
    Node left, right;
    int height;

    Node(int value) {
        data = value;
        height = 1;
    }
}

class AVLTree {
    Node root;

    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    Node insert(Node node, int data) {
        if (node == null)
            return (new Node(data));

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else
            return node;

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalanceFactor(node);

        if (balance > 1) {
            if (data < node.left.data) {
                return rotateRight(node);
            } else if (data > node.left.data) {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }

        if (balance < -1) {
            if (data > node.right.data) {
                return rotateLeft(node);
            } else if (data < node.right.data) {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Preorder traversal of constructed AVL tree:");
        tree.preOrder(tree.root);
    }
}
