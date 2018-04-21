package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        //ExecutorService service = Executors.newFixedThreadPool(5);
        //ExecutorService service = Executors.newSingleThreadExecutor();
        //ExecutorService service = Executors.newScheduledThreadPool();
        for(int i=0;i<5;i++){
            service.execute(new DoSomeThing());
            System.out.println("************* a" + i + " *************");
        }
        service.shutdown();
    }
}
class DoSomeThing implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
    }
}
