package guava;

import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import com.google.common.cache.*;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class TestGuava {
    @Test
    public void test4() throws Exception{
        // 缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
        LoadingCache<Integer, Car> carCache
                // CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
                = CacheBuilder.newBuilder()
                // 设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(8)
                // 设置写缓存后18秒钟过期
                .expireAfterWrite(18, TimeUnit.SECONDS)
                // 设置缓存容器的初始容量为10
                .initialCapacity(2)
                // 设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(2)
                // 设置要统计缓存的命中率
                .recordStats()
                // 设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(
                                notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                })
                // build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(new CacheLoader<Integer, Car>() {
                    @Override
                    public Car load(Integer key) throws Exception {
                        System.out.println("load car " + key);
                        Car car = new Car();
                        car.setId(key);
                        car.setName("name " + key);
                        return car;
                    }
                });
        System.out.println("cache stats:");
        // 最后打印缓存的命中率等 情况
        System.out.println(carCache.stats().toString());

        Car car = carCache.get(1);
        System.out.println(car);
        car = carCache.get(1);
        System.out.println(car);
        car = carCache.get(1);
        System.out.println(car);

        car = carCache.get(2);
        System.out.println(car);

        car = carCache.get(3);
        System.out.println(car);

        System.out.println("cache stats:");
        // 最后打印缓存的命中率等 情况
        System.out.println(carCache.stats().toString());
    }
    @Test
    public void test3(){
        final Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopwatch.stop();
        long nanos = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(nanos);
    }

    @Test
    public void test2(){
        //new Car(null);
        new Car("bmw").drive(0);
    }
    class Car{
        private Integer id;
        private String name;

        public Car(){}

        public Car(String name){
             this.name = checkNotNull(name);
         }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void drive(double speed){
             checkArgument(speed > 0.0,"speed (%s) must be positive",speed);
         }
    }
    @Test
    public void test1(){
        System.out.println(Joiner.on(' ').join(1, 2, 3));

        StringBuilder sb = new StringBuilder("result:");
        Joiner.on(" ").appendTo(sb, 1, 2, 3);
        System.out.println(sb);//result:1 2 3

        System.out.println(Joiner.on(' ').skipNulls().join(1, null, 3));//1 3
        System.out.println(Joiner.on(' ').useForNull("None").join(1, null, 3));//1 None 3

        System.out.println(Joiner.on("#").withKeyValueSeparator("=").join(ImmutableMap.of(1, 2, 3, 4)));//1=2#3=4

        System.out.println(Arrays.toString(",a,,b,".split(",")));
    }
}
