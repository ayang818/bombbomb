package executor;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

/**
 * @ClassName ExecutorPool
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/11/7 20:20
 **/
public class ExecutorPool {
    private static ExecutorService executorService = new ThreadPoolExecutor(10, 20, 5L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), new CustomizeThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void execute(Runnable runnable) {
        executorService.execute(runnable);
    }
}


class CustomizeThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(@NotNull Runnable r) {
        return new Thread(r, "CustomizeThreadFactory created thread");
    }
}