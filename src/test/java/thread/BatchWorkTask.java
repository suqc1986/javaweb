package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BatchWorkTask {

    public static void main(String[] args){
        PageManager pm = new PageManager();
        ExecutorService service = null;
        try {
            service = Executors.newCachedThreadPool();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int i=0;i<3;i++){
            service.execute(new CustomizeTask(pm));
        }
        service.shutdown();
    }
}

class CustomizeTask implements Runnable{
    PageManager pm;

    public CustomizeTask(PageManager pm){
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            int page = pm.getPage();
            if(page >= 20 )
                break;
            System.out.println(Thread.currentThread().getName()+"--->page="+page);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PageManager{
    int page = 1;

    public synchronized int getPage() {
        return page++;
    }
}