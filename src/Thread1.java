// Extending thread class
//public class Thread1 extends Thread{
//
//    public Thread1(String name){
//        super(name);
//    }
//
//    @Override
//    public void run(){
//        for(int i=0;i<3;i++){
//            System.out.println("Thread: "+Thread.currentThread()+" i");
//        }
//    }
//}

public  class Thread1  implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            System.out.println("Thread: "+Thread.currentThread()+" "+i);
        }
    }
}
