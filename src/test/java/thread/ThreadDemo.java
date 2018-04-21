package thread;

public class ThreadDemo {
    public static void main(String[] args){
        UpdateService us = new UpdateService();
        Thread t1 = new UpdateThread(us);
        Thread t2 = new UpdateThread(us);
        Thread t3 = new UpdateThread(us);
        t1.start();
        t2.start();
        t3.start();
    }
}

class UpdateThread extends Thread{
    UpdateService us;
    public UpdateThread(UpdateService us){
        this.us = us;
    }
    @Override
    public void run() {
        while(true){
            int page = us.getPage();
            if(page > 10)break;
            System.out.println(Thread.currentThread().getName()+"----> page:"+page);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class UpdateService{
    private int page = 1;
    public synchronized   int getPage(){
        return page++;
    }
}