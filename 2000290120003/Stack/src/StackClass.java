public class StackClass {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head;
        public static void push(int data)
        {
            Node newNode = new Node(data);

            newNode.next = head;
            head = newNode;
        }

        public static boolean isEmpty()
        {
            return head == null;
        }

        public static void pop()
        {
            if(isEmpty())
            {
                return;
            }
            head = head.next;
        }

        public static int peek()
        {
            if(isEmpty())
            {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String args[]) {
        Stack stack = new Stack();
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        Stack.push(4);

        while(!Stack.isEmpty()) {
            System.out.println(Stack.peek());
            Stack.pop();
        }
    }
}
