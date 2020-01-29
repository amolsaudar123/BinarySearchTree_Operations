package BST.find.distance;

public class DistanceBetweenTwoNodes
{
    public int findDistance(Node root, int n1, int n2)
    {
        int leftNodeToRootNode = getPathLength(root, n1, "leftNodeToRootNode") - 2;
        int rightNodeToRootNode = getPathLength(root, n2,"rightNodeToRootNode") - 2;
        int lcaData = new Node().findLCA(root, n1, n2).data;
        int lcaDistance = getPathLength(root, lcaData,"lcaDistance") - 1;
        return (leftNodeToRootNode + rightNodeToRootNode) - 2 * lcaDistance;
    }

    public int getPathLength(Node root, int n1, String callingFrom)
    {
        if (root != null)
        {

            int x = 0;

            if(callingFrom.equals("rightNodeToRootNode"))
            {
                if ((root.data == n1) || (x = getPathLength(root.left,
                        n1,"rightNodeToRootNode")) > 0  || (x = getPathLength(root.right,
                        n1,"rightNodeToRootNode")) > 0)
                {
                    return x + 1;
                }
            }
            if(!callingFrom.equals("rightNodeToRootNode"))
            {

                if ((root.data == n1) || (x = getPathLength(root.left,
                        n1,"leftNodeToRootNode")) > 0  || (x = getPathLength(root.right,
                        n1,"leftNodeToRootNode")) > 0)
                {
                    return x + 1;
                }
            }

            return 0;
        }
        return 0;
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(7);
        root.left.right.right = new Node(9);
        root.right.right = new Node(1);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(6);

       /// DistanceBetweenTwoNodes binaryTreeTest = new DistanceBetweenTwoNodes();
        System.out.println("Distance between Node 7 and 1 is : " +
                new DistanceBetweenTwoNodes().findDistance(root,7, 1));
    }

}
