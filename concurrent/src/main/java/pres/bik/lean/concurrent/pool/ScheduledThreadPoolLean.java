package pres.bik.lean.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定时线程池
 * @author yangkaifei
 * @version 1.0
 * @date 2021/11/28 7:30 下午
 */
public class ScheduledThreadPoolLean {
    /**
     * 定时线程池
     */
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newScheduledThreadPool(10);

    public static void main(String[] args) {
        EXECUTOR_SERVICE.shutdown();
    }
}
