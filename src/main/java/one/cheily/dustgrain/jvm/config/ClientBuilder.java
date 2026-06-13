package one.cheily.dustgrain.jvm.config;

import one.cheily.dustgrain.core.config.AppConfig;

import java.net.URL;

public class ClientBuilder {
    private URL url;
    private long timeout;
    private String userAgent;

    public ClientBuilder() {}

    public URL getUrl() {
        return url;
    }

    public long getTimeout() {
        return timeout;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public ClientBuilder url(URL url) {
        this.url = url;
        return this;
    }

    public ClientBuilder timeout(long timeout) {
        this.timeout = timeout;
        return this;
    }

    public ClientBuilder userAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public AppConfig.Client build() {
        return new AppConfig.Client(url, timeout, userAgent);
    }

    public static ClientBuilder from(AppConfig.Client client) {
        return new ClientBuilder()
                .url(client.getUrl())
                .timeout(client.getTimeout())
                .userAgent(client.getUserAgent());
    }
}
