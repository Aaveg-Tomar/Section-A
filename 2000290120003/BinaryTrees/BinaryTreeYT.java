package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeYT {
    static class Node{
        int data;
        Node left ;
        Node right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int indx = -1;
        public static Node buildTree(int[] nodes)
        {
            indx++;
            if(nodes[indx] == -1)
            {
                return null;
            }

            Node newNode = new Node(nodes[indx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);


            return newNode;

        }
    }

    public static void preOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root)
    {
        if(root == null)
        {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + ", ");
        inOrder(root.right);
    }

    static void levelOrder(Node root)
    {
        if(root == null)
        {
            return;
        }

        Queue<Node> q1 = new LinkedList<>();
        q1.add(root);
        q1.add(null);

        while (!q1.isEmpty())
        {
            Node currNode = q1.remove();
            if(currNode == null)
            {
                System.out.println();

                if (q1.isEmpty())
                {
                    break;
                }
                else {
                    q1.add(null);
                }
            }
            else{
                System.out.print(currNode.data + ", ");
                if(currNode.left != null)
                {
                    q1.add(currNode.left);
                }
                if(currNode.right != null)
                {
                    q1.add(currNode.right);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nodes = {1 , 2, 4 , -1 , -1 ,  5 , -1 ,-1, 3 , -1 , 6 , -1 , -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);

        System.out.print("PreOrder Traversal => " );
        preOrder(root);
        System.out.println();
        System.out.print("InOrder Traversal => ");
        inOrder(root);
        System.out.println();
        System.out.print("LevelOrder Traversal => ");
        levelOrder(root);
        System.out.println();
    }
}
