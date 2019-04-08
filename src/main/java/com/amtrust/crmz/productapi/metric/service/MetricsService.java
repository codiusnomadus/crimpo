package com.amtrust.crmz.productapi.metric.service;

import io.micrometer.core.instrument.Metrics;

import java.util.concurrent.TimeUnit;

public class MetricsService {
    public synchronized static void incrementCounter(String counterName, String... tags){
        Metrics.counter(counterName, tags).increment();
    }

    public synchronized static void incrementCounter(String counterName, double value, String... tags){
        Metrics.counter(counterName, tags).increment(value);
    }

    public synchronized static void observeTime(String timerName, long duration, String... tags){
        Metrics.timer(timerName, tags).record(duration, TimeUnit.MILLISECONDS);
    }
}
