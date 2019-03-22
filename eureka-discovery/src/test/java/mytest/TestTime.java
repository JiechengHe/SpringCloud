package mytest;

import com.netflix.discovery.TimedSupervisorTask;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author hejiecheng
 */
public class TestTime {

    @Test
    public void testTimedSupervisorTask() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        ThreadPoolExecutor myExecutor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.SECONDS, new SynchronousQueue());
        scheduledExecutorService.schedule(
                new TimedSupervisorTask(
                    "test-time-supervisor-task",
                        scheduledExecutorService,
                        myExecutor,
                        5,
                        TimeUnit.SECONDS,
                        2,
                        new Job()
                ),
                10,
                TimeUnit.SECONDS
        );
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        ThreadPoolExecutor myExecutor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.SECONDS, new SynchronousQueue());
        scheduledExecutorService.schedule(
                new TimedSupervisorTask(
                        "test-time-supervisor-task",
                        scheduledExecutorService,
                        myExecutor,
                        5,
                        TimeUnit.SECONDS,
                        10,
                        new Job()
                ),
                3,
                TimeUnit.SECONDS
        );
    }

    public static class Job implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

}
