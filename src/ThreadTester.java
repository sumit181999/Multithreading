public class ThreadTester {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main is starting");
//        Thread thread = new Thread(new Thread1(),"Thread1");
//        if we set it to Daemon thread then its JVM choice whether to run this thread or not.
//        thread.setDaemon(true);
//        thread.start();
//        this method will do nothing as it is not setting the Runnable target value.
//        new Thread().run();

//        creating thread with lambda method
//        Thread thread2=new Thread(()->{
//            for(int i=0;i<3;i++){
//                System.out.println("Thread: "+Thread.currentThread()+"  "+i);
//            }
//        },"Thread2");
//        thread2.start();

//        Join Concept
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread());
        }, "Our Thread");
        thread.start();
        thread.join();
        System.out.println("main is exiting");

    }
}
