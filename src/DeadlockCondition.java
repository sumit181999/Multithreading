public class DeadlockCondition {

//    same sequence of lock given to both of thread to achieve deadlock condition.
    public static void main(String[] args) {
        String lock1="Sumit";
        String lock2="Jindal";

        Thread thread1 = new Thread(()->{
            synchronized (lock1){
                try{
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("Thread1");
                }
            }
        },"Thread1");

        Thread thread2 = new Thread(()->{
            synchronized (lock2){
                try{
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("Thread2");
                }
            }
        },"Thread2");
        thread1.start();
        thread2.start();
    }

}
