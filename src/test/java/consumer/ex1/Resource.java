package consumer.ex1;

public class Resource {
    private int num = 0;
    private int size =  10;
    public synchronized void remove(){
        if(num > 0){
            num --;
            System.out.println("消费者" + Thread.currentThread().getName() + "消耗一件资源，" + "当前线程池有" + num + "个");
            notifyAll();
        }else{
            try {
                wait();
                System.out.println("消费者" + Thread.currentThread().getName() + "线程进入等待状态");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void add(){
        if(num<size){
            num++;
            System.out.println(Thread.currentThread().getName() + "生产一件资源，当前资源池有"+ num + "个");
            notifyAll();
        }else{
            try {
                wait();
                System.out.println(Thread.currentThread().getName()+"线程进入等待");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
