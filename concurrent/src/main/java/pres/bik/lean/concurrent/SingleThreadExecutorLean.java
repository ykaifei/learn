package pres.bik.lean.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangkaifei
 * @version 1.0
 * @date 2021/11/28 7:00 下午
 */
public class SingleThreadExecutorLean {
    /**
     * 线程池
     */
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();

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
