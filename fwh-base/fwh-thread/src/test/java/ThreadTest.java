import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

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
     * 实现原理网址：https://www.jianshu.com/p/7c7a5df5bda6?ref=myread
     * <p>
     * 解释：CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
     * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
     * <p>
     * Java并发编程：CountDownLatch、CyclicBarrier和Semaphore使用
     * 网址：https://www.cnblogs.com/dolphin0520/p/3920397.html
     *
     * @param
     * @return void
     * @author fwh [2021/1/12 && 2:28 下午]
     */
    @Test
    public void countDownLatch() {
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            final int finalI = i + 1;
            new Thread(() -> {
                System.out.println("thread " + finalI + " start");
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(10000) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread " + finalI + " finish");
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadNum + " thread finish");
    }

    /**
     * CyclicBarrier
     * 实现原理网址：https://www.cnblogs.com/200911/p/6060195.html
     * <p>
     * 解释：字面意思回环栅栏，通过它可以实现让一组线程等待至某个状态之后再全部同时执行。
     * 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了。
     * CyclicBarrier 字面意思是可循环（Cyclic）使用的屏障（Barrier）。
     * 它要做的事情是让一组线程到达一个屏障（同步点）时被阻塞，直到最后一个线程到达屏障时候，屏障才会开门。所有被屏障拦截的线程才会运行。
     * <p>
     * <p>
     * CyclicBarrier和CountDownLatch的区别：https://www.iteye.com/blog/aaron-han-1591755
     * 1.CountDownLatch减计数，CyclicBarrier加计数。
     * 2.CountDownLatch是一次性的，CyclicBarrier可以重用。
     * <p>
     * 1. 有五个人，一个裁判。这五个人同时跑，裁判开始计时，五个人都到终点了，裁判喊停，然后统计这五个人从开始跑到最后一个撞线用了多长时间。
     * CountDownLatch强调的是一个线程（或多个）需要等待另外的n个线程干完某件事情之后才能继续执行。
     * 上述例子，main线程是裁判，5个AWorker是跑步的。运动员先准备，裁判喊跑，运动员才开始跑（这是第一次同步，对应begin）。
     * 5个人谁跑到终点了，countdown一下，直到5个人全部到达，裁判喊停（这是第二次同步，对应end），然后算时间。
     * <p>
     * 2. 继续，还是这五个人（这五个人真无聊..），这次没裁判。规定五个人只要都跑到终点了，大家可以喝啤酒。
     * 但是，只要有一个人没到终点，就不能喝。 这里也没有要求大家要同时起跑(当然也可以，加latch)。
     * <p>
     * CyclicBarrier强调的是n个线程，大家相互等待，只要有一个没完成，所有人都得等着。正如上例，只有5个人全部跑到终点，大家才能开喝，否则只能全等着。
     *
     * @param
     * @return void
     * @author fwh [2021/1/12 && 2:29 下午]
     */
    @Test
    public void cyclicBarrier() {
    }

//    public static void main(String[] args) {
//        int N = 4;
//        CyclicBarrier barrier = new CyclicBarrier(N);
//        for (int i = 0; i < N; i++) {
//            new Writer(barrier).start();
//        }
//    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(3000);      //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }

    /**
     * Semaphore
     * 使用网址：https://my.oschina.net/cloudcoder/blog/362974
     * 底层原理实现网址：https://www.cnblogs.com/200911/p/6060359.html
     * Semaphore（信号量）是用来控制同时访问特定资源的线程数量，它通过协调各个线程，保证合理的使用公共资源。
     * 线程可以通过acquire()方法来获取信号量的许可，当信号量中没有可用的许可的时候，线程阻塞，直到有可用的许可为止。线程可以通过release()方法释放它持有
     * 的信号量的许可。
     * <p>
     * 解释：Semaphore翻译成字面意思为 信号量，
     * Semaphore可以控同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
     *
     * @param
     * @return void
     * @author fwh [2021/1/12 && 2:29 下午]
     */
    @Test
    public void semaphore() {
    }

    public static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semaphore = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 50; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semaphore.acquire();
                        System.out.println("Accessing: " + NO);
                        Thread.sleep((long) (Math.random() * 5000));
                        // 访问完后，释放
                        semaphore.release();
                        //availablePermits()指的是当前信号灯库中有多少个可以被使用
                        System.out.println("剩余-----------------" + semaphore.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
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
