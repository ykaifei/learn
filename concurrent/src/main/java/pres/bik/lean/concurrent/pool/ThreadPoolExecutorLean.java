package pres.bik.lean.concurrent.pool;

import java.util.concurrent.*;

/**
 * 线程池参数
 *
 * @author yangkaifei
 * @version 1.0
 * @date 2021/11/28 4:52 下午
 */
public class ThreadPoolExecutorLean {

    /**
     * 核心线程数
     */
    private static int CORE_POOL_SIZE = 2;
    /**
     * 最大线程数
     */
    private static int MAXIMUM_POOL_SIZE = 3;

    /**
     * 存活时间
     */
    private static long KEEP_ALIVE_TIME = 60;

    /**
     * 队列大小
     */
    private static int WORK_QUEUE_SIZE = 2;

    /**
     * 任务存储队列
     */
    private static BlockingQueue<Runnable> WORK_QUEUE = new ArrayBlockingQueue<>(WORK_QUEUE_SIZE);

    /**
     * 抛异常策略
     */
    private static RejectedExecutionHandler HANDLER = new ThreadPoolExecutor.AbortPolicy();
    /**
     * 线程池
     */
    private static ThreadPoolExecutor EXECUTOR_SERVICE = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
            KEEP_ALIVE_TIME, TimeUnit.SECONDS, WORK_QUEUE, Executors.defaultThreadFactory(), HANDLER);

    public static void main(String[] args) {
        run();
    }

    /**
     * 线程池参数了解
     */
    private static void run() {
        int length = MAXIMUM_POOL_SIZE + WORK_QUEUE_SIZE + 2;
        for (int i = 1; i < length; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("睡眠被中断");
            }
            int finalI = i;
            try {
                EXECUTOR_SERVICE.execute(new Thread(() -> {
                    System.out.println("============");
                    System.out.println(String.format("开始执行任务：%s", finalI));
                    System.out.println(String.format("任务%s活跃线程数：%s", finalI, EXECUTOR_SERVICE.getActiveCount()));
                    System.out.println(String.format("任务%s队列中的数量：%s", finalI, EXECUTOR_SERVICE.getQueue().size()));
                    System.out.println("============");
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        System.out.println("睡眠被中断");
                    }
                }));
            } catch (Exception e) {
                System.err.println("执行了异常策略：" + finalI);
            }
        }
        EXECUTOR_SERVICE.shutdown();
    }
}
