import java.util.Arrays;

public class Stack {
    private int[] array;
    private int stackTop;
    Object lock1;
    public Stack(int capacity){
        array=new int[capacity];
        Arrays.fill(array, Integer.MIN_VALUE);
        stackTop=-1;
        lock1=new Object();
    }
    public boolean push(int element){
        synchronized (lock1) {
            if (isFull()) {
                return false;
            }
            ++stackTop;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            array[stackTop] = element;
            return true;
        }
    }
    public int pop(){
        synchronized(lock1) {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int obj = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stackTop--;
            return obj;
        }
    }
    public boolean isEmpty(){
        return stackTop<0;
    }
    public boolean isFull(){
        return stackTop>=array.length;
    }

    public static void main(String[] args) {
//         Testing race condition. You can see that you will get the ArrayIndexOutOfBoundsException.
//        To resolve the race condition use synchronized keyword.
        Stack stack = new Stack(4);
        new Thread(()->{
            for(int i=0;i<4;i++){
                System.out.println("Pushing "+stack.push(i));
            }
        },"Pusher").start();

        new Thread(()->{
            for(int i=0;i<4;i++){
                System.out.println("Popping "+stack.pop());
            }
        },"Popper").start();
    }
}
