package test;

import BST.find.distance.DistanceBetweenTwoNodes;
import BST.find.distance.Node;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestLogic {

    @Test
    public void testFindDistanceBetween2Nodes() throws NullPointerException{
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(7);
        root.left.right.right = new Node(9);
        root.right.right = new Node(1);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(6);
        assertEquals(new DistanceBetweenTwoNodes().findDistance(root, 7, 1), 2);//
        assertEquals(new DistanceBetweenTwoNodes().findDistance(root,9, 1), 3);//+1+1-1+1+1
        assertEquals(new DistanceBetweenTwoNodes().findDistance(root,2, 3), 0);//-1+1
    }
}
