package one.cheily.dustgrain.jvm.config;

import one.cheily.dustgrain.core.config.AppConfig;

public class CacheBuilder {
    private CacheConfBuilder headers;


    public CacheBuilder() {}

    public CacheConfBuilder getHeadersB() {
        return headers;
    }

    public AppConfig.CacheConf getHeaders() {
        return headers.build();
    }

    public CacheBuilder modifyHeaders(Modifier<CacheConfBuilder> modifier) {
        if (this.headers == null) {
            this.headers = new CacheConfBuilder();
        }
        modifier.modify(headers);
        return this;
    }

    public CacheBuilder headers(CacheConfBuilder headers) {
        this.headers = headers;
        return this;
    }

    public CacheBuilder headers(AppConfig.CacheConf headers) {
        this.headers = CacheConfBuilder.from(headers);
        return this;
    }

    public AppConfig.Cache build() {
        return new AppConfig.Cache(headers.build());
    }

    public static CacheBuilder from(AppConfig.Cache cache) {
        return new CacheBuilder()
                .headers(cache.getHeaders());
    }
}
