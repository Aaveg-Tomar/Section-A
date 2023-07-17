package BinarySearchTree;

public class BinarySearchT {
   static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static Node insert(Node root , int val)
    {
        if(root == null)
        {
            root = new Node(val);
            return root;
        }

        if(root.data > val)
        {
            root.left = insert(root.left , val);
        }
        else{
            root.right = insert(root.right , val);
        }
        return root;
    }

    public static void inorder(Node root)
    {
        if(root == null)
        {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + ", ");
        inorder(root.right);
    }

    public static boolean search(Node root , int key)
    {
        if(root == null)
        {
            return false;
        }
        if(root.data > key)
        {
            return search(root.left , key);
        }
        else if (root.data ==  key)
        {
            return true;
        }
        else
        {
           return search(root.right , key);
        }
    }

    public  static Node delete(Node root ,int val)
    {
        if(root == null)
        {
            return null;
        }

        if(root.data > val)
        {
            root.left = delete(root.left , val);
        }
        else  if(root.data < val)
        {
            root.right = delete(root.right , val);
        }
        else{
            // root.data == val;

            //case 1 delete leaf node
            if(root.left == null && root.right == null)
            {
                return null;
            }

            // case 2 node has only one child
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            // case 3 node have two children
            Node Is  = inOrderScuccessor(root.right);
            root.data = Is.data;
            root.right = delete(root.right , val);
        }

        return root;
    }

    private static Node inOrderScuccessor(Node root) {
       while (root.left != null)
       {
           root = root.left;
       }
       return root;
    }



    public static void main(String[] args) {
        int[] arr = {5 , 7 , 1 , 3 , 8};
        Node root = null;

        for (int j : arr) {
            root = insert(root, j);
        }
        inorder(root);
        System.out.println(search(root  , 3));
        delete(root , 5);
        System.out.println(root.data);
    }


}
