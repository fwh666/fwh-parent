import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/12 2:05 下午
 */
public class ThreadTest {
    /**
     * 线程创建
     * 生命周期：https://www.cnblogs.com/langjunnan/p/6444718.html
     *
     * @param
     * @return void
     * @author fwh [2021/1/12 && 2:12 下午]
     */
    public void createThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final String name = Thread.currentThread().getName();
                System.out.println("线程名：" + name);
            }
        });
        thread.start();
    }

    @Test
    public void threadTest() {
        for (int i = 0; i < 10; i++) {
            createThread();
        }
    }

    /**
     * 线程池创建
     * 网址：https://tech.meituan.com/2020/04/02/java-pooling-pratice-in-meituan.html
     * https://www.cnblogs.com/dolphin0520/p/3932921.html
     * https://blog.csdn.net/cyantide/article/details/50880211
     *
     * @param
     * @return void
     * @author fwh [2021/1/12 && 2:13 下午]
     */
    @Test
    public void createThreadPool() {
//        final ExecutorService executorService = Executors.newSingleThreadExecutor();
//        final ExecutorService executorService = Executors.newFixedThreadPool(1);
//        final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        final ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名：" + Thread.currentThread().getName());
            }
        });
    }

    /**
     * CountDownLatch
     * <p>
     * 网址：https://www.jianshu.com/p/7c7a5df5bda6?ref=myread
     * https://www.cnblogs.com/dolphin0520/p/3920397.html
     *
     * @param
     * @return void
     * @author fwh [2021/1/12 && 2:28 下午]
     */
    @Test
    public void countDownLatch() {

    }

    /**
     * CyclicBarrier
     * 网址：https://www.cnblogs.com/200911/p/6060195.html
     * 区别：https://www.iteye.com/blog/aaron-han-1591755
     *
     * @param
     * @return void
     * @author fwh [2021/1/12 && 2:29 下午]
     */
    @Test
    public void cyclicBarrier() {

    }

    /**
     * Semaphore
     * 网址：https://my.oschina.net/cloudcoder/blog/362974
     * https://www.cnblogs.com/200911/p/6060359.html
     *
     * @param
     * @return void
     * @author fwh [2021/1/12 && 2:29 下午]
     */
    @Test
    public void semaphore() {

    }

    /**
     * Exchanger
     * 网址：https://www.iteye.com/blog/lixuanbin-2166772
     *
     * @param
     * @return void
     * @author fwh [2021/1/12 && 2:30 下午]
     */
    @Test
    public void exchanger() {

    }

    /**
     * ThreadLocal
     * 网址：https://www.cnblogs.com/dolphin0520/p/3920407.html
     *
     * @param
     * @return void
     * @author fwh [2021/1/12 && 2:31 下午]
     */
    @Test
    public void threadLocal() {

    }

}
