public class SingletonClassUsingSynchronized {
    private static SingletonClassUsingSynchronized singletonClassUsingSynchronized = null;

    public static SingletonClassUsingSynchronized getInstance(){
        synchronized (SingletonClassUsingSynchronized.class) {
            if (singletonClassUsingSynchronized == null) {
                singletonClassUsingSynchronized = new SingletonClassUsingSynchronized();
            }
            return singletonClassUsingSynchronized;
        }
    }

    public static void main(String[] args) {
        Object obj = SingletonClassUsingSynchronized.getInstance();
        System.out.println(obj);
        Object obj2=SingletonClassUsingSynchronized.getInstance();
        System.out.println(obj2);
    }
}
