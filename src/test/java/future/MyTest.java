package future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyTest {
    public static void main(String[] args)throws Exception{
        FutrueTask task = new FutrueTask();
        ExecutorService t1 = Executors.newFixedThreadPool(1);
        Future<String> result = t1.submit(task);
        System.out.println("异步任务开始执行...");
        System.out.println("主线程其他任务开始执行...");
        Thread.sleep(1000*5);
        System.out.println("主线程其他任务结束...");
        System.out.println(result.get());
        System.out.println("异步任务结束...");
        t1.shutdown();
    }
}
class FutrueTask implements Callable<String>{
    @Override
    public String call() throws Exception {
        Thread.sleep(1000*10);
        return "520";
    }
}