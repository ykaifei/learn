package pres.bik.lean.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FixedThreadPool
 * @author yangkaifei
 * @version 1.0
 * @date 2021/11/28 6:35 下午
 */
public class FixedThreadPoolLean {
    /**
     * 线程数
     */
    private static final int THREAD_NUMBER = 2;
    /**
     * 线程池
     */
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(THREAD_NUMBER);

    public static void main(String[] args) {
        while (true) {
            EXECUTOR_SERVICE.execute(new Thread(() -> {
                System.out.println("任务开始执行");
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }));
        }
    }
}
