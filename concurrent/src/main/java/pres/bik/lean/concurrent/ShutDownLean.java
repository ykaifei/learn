package pres.bik.lean.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * shutdown
 * @author yangkaifei
 * @version 1.0
 * @date 2021/11/28 9:08 下午
 */
public class ShutDownLean {

    /**
     * 线程池
     */
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            EXECUTOR_SERVICE.execute(new Thread(() -> {
                System.out.println("线程被执行" + finalI);
            }));
        }
        System.out.println("shutdown");
        System.out.println(EXECUTOR_SERVICE.isShutdown());
        EXECUTOR_SERVICE.shutdown();
        System.out.println(EXECUTOR_SERVICE.isShutdown());
        System.out.println("再次提交新的任务");
        System.out.println(EXECUTOR_SERVICE.isTerminated());
        EXECUTOR_SERVICE.execute(new Thread(()->{
            System.out.println("新任务");
        }));
    }
}
