package BST.find.distance;

public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node() {
        this.data = 0;
        this.left = null;
        this.right = null;
    }

    public Node findLCA(Node root, int n1, int n2)
    {

        if (root != null)
        {

            if (root.data == n1 || root.data == n2)
            {
                return root;
            }
            Node left = findLCA(root.left, n1, n2);
            Node right = findLCA(root.right, n1, n2);

            if (left != null && right != null)
            {
                return root;
            }
            if (left != null)
            {
                return left;
            }
            if (right != null)
            {
                return right;
            }
        }
        return null;
    }
}
