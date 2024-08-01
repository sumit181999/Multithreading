import java.util.LinkedList;
import java.util.Queue;

//Producer Consumer Problem
public class BlockingQueue {
    private Queue<Integer>queue;
    private int capacity;

    public BlockingQueue(int cap){
        queue=new LinkedList<>();
        this.capacity=cap;
    }
    public int addItem(int item){
        synchronized (queue){
            while(queue.size()==capacity){
                try {
                    queue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            queue.add(item);
            queue.notifyAll();
            return item;
        }
    }
    public int removeItem() throws InterruptedException {
        synchronized (queue){
            while(queue.size()==0){
//                we can give exception at method level. It will works same as above method.
                try {
                    queue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            int elemenet = queue.poll();
            queue.notifyAll();
            return elemenet;
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue(3);
        new Thread(()->{
           for(int i=0;i<3;i++){
               System.out.println("Pushing "+blockingQueue.addItem(i));
           }
        },"Pusher").start();

        new Thread(()->{
            for(int i=0;i<3;i++){
//            you hae to surround this with try catch because we are calling the method which has throws exception in method signature.
                try {
                    System.out.println("Popping "+blockingQueue.removeItem());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Pusher").start();
    }
}
