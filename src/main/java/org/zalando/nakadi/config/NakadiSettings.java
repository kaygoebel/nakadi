package org.zalando.nakadi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.zalando.nakadi.domain.ResourceAuthorizationAttribute;
import org.zalando.nakadi.plugin.api.authz.AuthorizationAttribute;

@Component
public class NakadiSettings {

    private final int maxTopicPartitionCount;
    private final int defaultTopicPartitionCount;
    private final int defaultTopicReplicaFactor;
    private final long defaultTopicRetentionMs;
    private final long defaultTopicRotationMs;
    private final long defaultCommitTimeoutSeconds;
    private final long kafkaPollTimeoutMs;
    private final long kafkaSendTimeoutMs;
    private final long timelineWaitTimeoutMs;
    private final long eventMaxBytes;
    private final int maxSubscriptionPartitions;
    private final AuthorizationAttribute defaultAdmin;

    @Autowired
    public NakadiSettings(@Value("${nakadi.topic.max.partitionNum}") final int maxTopicPartitionCount,
                          @Value("${nakadi.topic.default.partitionNum}") final int defaultTopicPartitionCount,
                          @Value("${nakadi.topic.default.replicaFactor}") final int defaultTopicReplicaFactor,
                          @Value("${nakadi.topic.default.retentionMs}") final long defaultTopicRetentionMs,
                          @Value("${nakadi.topic.default.rotationMs}") final long defaultTopicRotationMs,
                          @Value("${nakadi.stream.default.commitTimeout}") final long defaultCommitTimeoutSeconds,
                          @Value("${nakadi.kafka.poll.timeoutMs}") final long kafkaPollTimeoutMs,
                          @Value("${nakadi.kafka.send.timeoutMs}") final long kafkaSendTimeoutMs,
                          @Value("${nakadi.timeline.wait.timeoutMs}") final long timelineWaitTimeoutMs,
                          @Value("${nakadi.event.max.bytes}") final long eventMaxBytes,
                          @Value("${nakadi.subscription.maxPartitions}") final int maxSubscriptionPartitions,
                          @Value("${nakadi.admin.default.dataType}") final String defaultAdminDataType,
                          @Value("${nakadi.admin.default.value}") final String defaultAdminValue) {
        this.maxTopicPartitionCount = maxTopicPartitionCount;
        this.defaultTopicPartitionCount = defaultTopicPartitionCount;
        this.defaultTopicReplicaFactor = defaultTopicReplicaFactor;
        this.defaultTopicRetentionMs = defaultTopicRetentionMs;
        this.defaultTopicRotationMs = defaultTopicRotationMs;
        this.defaultCommitTimeoutSeconds = defaultCommitTimeoutSeconds;
        this.kafkaPollTimeoutMs = kafkaPollTimeoutMs;
        this.kafkaSendTimeoutMs = kafkaSendTimeoutMs;
        this.eventMaxBytes = eventMaxBytes;
        this.timelineWaitTimeoutMs = timelineWaitTimeoutMs;
        this.maxSubscriptionPartitions = maxSubscriptionPartitions;
        this.defaultAdmin = new ResourceAuthorizationAttribute(defaultAdminDataType, defaultAdminValue);
    }

    public int getDefaultTopicPartitionCount() {
        return defaultTopicPartitionCount;
    }

    public int getMaxTopicPartitionCount() {
        return maxTopicPartitionCount;
    }

    public int getDefaultTopicReplicaFactor() {
        return defaultTopicReplicaFactor;
    }

    public long getDefaultTopicRetentionMs() {
        return defaultTopicRetentionMs;
    }

    public long getDefaultTopicRotationMs() {
        return defaultTopicRotationMs;
    }

    public long getDefaultCommitTimeoutSeconds() {
        return defaultCommitTimeoutSeconds;
    }

    public long getKafkaPollTimeoutMs() {
        return kafkaPollTimeoutMs;
    }

    public long getKafkaSendTimeoutMs() {
        return kafkaSendTimeoutMs;
    }

    public long getEventMaxBytes() {
        return eventMaxBytes;
    }

    public long getTimelineWaitTimeoutMs() {
        return timelineWaitTimeoutMs;
    }

    public int getMaxSubscriptionPartitions() {
        return maxSubscriptionPartitions;
    }

    public AuthorizationAttribute getDefaultAdmin() {
        return defaultAdmin;
    }
}
