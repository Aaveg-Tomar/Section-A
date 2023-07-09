public class QueueY {
    static class Queue{
        static int[] arr ;
        static int size ;
        static int rear = -1;

        Queue(int n)
        {
            arr = new int[n];
            size = n;
        }
        public static boolean isEmpty()
        {
            return rear == -1;
        }
        public static void add(int data)
        {
            if(rear == size -1)
            {
                System.out.println("Queue is Full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public static void delete()
        {
            if(rear == -1)
            {
                System.out.println("is Empty");
                return;
            }

            for(int i = 0; i < size-1; i++) {
                arr[i] = arr[i+1];
            }

            rear--;
        }

        public static int peek()
        {
            if(isEmpty())
            {
                return -1;
            }
            return arr[0];

        }


    }

    public static void main(String[] args) {
        Queue q1 = new Queue(5);
        Queue.add(5);
        Queue.add(6);
        Queue.add(7);
        Queue.add(8);
        Queue.add(9);

       q1.delete();
        while (!q1.isEmpty())
        {
            System.out.println(q1.peek());
            q1.delete();

        }

    }
}
