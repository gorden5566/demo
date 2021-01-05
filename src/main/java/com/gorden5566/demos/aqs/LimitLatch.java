package com.gorden5566.demos.aqs;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author gorden5566
 * @date 2020/09/09
 */
public class LimitLatch {
    private final Sync sync;
    private final AtomicLong count;
    private volatile long limit;
    private volatile boolean released = false;

    public LimitLatch(long limit) {
        this.limit = limit;
        this.count = new AtomicLong(0);
        this.sync = new Sync();
    }

    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int arg) {
            long newCount = count.incrementAndGet();
            if (!released && newCount > limit) {
                count.decrementAndGet();
                return -1;
            }
            return 1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            count.decrementAndGet();
            return true;
        }
    }

    public long getCount() {
        return count.get();
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public void countUpOrAwait() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    public long countDown() {
        sync.releaseShared(0);
        long count = getCount();
        return count;
    }

    public boolean releaseAll() {
        released = true;
        return sync.releaseShared(0);
    }

    public void reset() {
        count.set(0);
        released = false;
    }

    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    public Collection<Thread> getQueuedThreads() {
        return sync.getQueuedThreads();
    }
}
