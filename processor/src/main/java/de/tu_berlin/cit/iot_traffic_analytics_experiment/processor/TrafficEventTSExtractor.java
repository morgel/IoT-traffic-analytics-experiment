package de.tu_berlin.cit.iot_traffic_analytics_experiment.processor;

import de.tu_berlin.cit.iot_traffic_analytics_experiment.common.iot_traffic.TrafficEvent;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;
import org.apache.flink.streaming.api.windowing.time.Time;

public class TrafficEventTSExtractor extends BoundedOutOfOrdernessTimestampExtractor<TrafficEvent> {

    public TrafficEventTSExtractor(int maxEventDelay) {
        super(Time.seconds(maxEventDelay));
    }

    @Override
    public long extractTimestamp(TrafficEvent trafficEvent) {
        return trafficEvent.getTimestamp().toInstant().toEpochMilli();
    }
}
