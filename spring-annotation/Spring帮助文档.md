
### Spring 已经实现的线程池
**SimpleAsyncTaskExecutor**：不是真的线程池，这个类不重用线程，默认每次调用都会创建一个新的线程。

**SyncTaskExecutor**：这个类没有实现异步调用，只是一个同步操作。只适用于不需要多线程的地方。

**ConcurrentTaskExecutor**：Executor的适配类，不推荐使用。如果ThreadPoolTaskExecutor不满足要求时，才用考虑使用这个类。

**SimpleThreadPoolTaskExecutor**：是Quartz的SimpleThreadPool的类。线程池同时被quartz和非quartz使用，才需要使用此类。

**ThreadPoolTaskExecutor** ：最常使用，推荐。其实质是对java.util.concurrent.ThreadPoolExecutor的包装。