package one.cheily.dustgrain.jvm.config;

import one.cheily.dustgrain.core.cache.CacheMode;
import one.cheily.dustgrain.core.config.AppConfig;

public class CacheConfBuilder {
    private int version;
    private long maxAgeSeconds;
    private CacheMode mode;

    public CacheConfBuilder() {}

    public int getVersion() {
        return version;
    }

    public long getMaxAgeSeconds() {
        return maxAgeSeconds;
    }

    public CacheMode getMode() {
        return mode;
    }

    public CacheConfBuilder version(int version) {
        this.version = version;
        return this;
    }

    public CacheConfBuilder maxAgeSeconds(long maxAgeSeconds) {
        this.maxAgeSeconds = maxAgeSeconds;
        return this;
    }

    public CacheConfBuilder mode(CacheMode mode) {
        this.mode = mode;
        return this;
    }

    public AppConfig.CacheConf build() {
        return new AppConfig.CacheConf(version, maxAgeSeconds, mode);
    }

    public static CacheConfBuilder from(AppConfig.CacheConf cacheConf) {
        return new CacheConfBuilder()
                .version(cacheConf.getVersion())
                .maxAgeSeconds(cacheConf.getMaxAgeSeconds())
                .mode(cacheConf.getMode());
    }
}
