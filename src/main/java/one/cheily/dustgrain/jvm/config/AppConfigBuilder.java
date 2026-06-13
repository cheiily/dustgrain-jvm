package one.cheily.dustgrain.jvm.config;

import one.cheily.dustgrain.core.config.AppConfig;

import java.util.Arrays;
import java.util.List;

public class AppConfigBuilder {
    private AppInfoBuilder appInfo;
    private CacheBuilder cache;
    private ClientBuilder client;
    private List<AppConfig.GameWiki> cargoQueries;

    public AppConfigBuilder() {}

    public AppConfig.AppInfo getAppInfo() {
        return appInfo.build();
    }

    public AppInfoBuilder getAppInfoB() {
        return appInfo;
    }

    public AppConfig.Cache getCache() {
        return cache.build();
    }

    public CacheBuilder getCacheB() {
        return cache;
    }

    public AppConfig.Client getClient() {
        return client.build();
    }

    public ClientBuilder getClientB() {
        return client;
    }

    public List<AppConfig.GameWiki> getCargoQueries() {
        return cargoQueries;
    }


    public AppConfigBuilder appInfo(AppInfoBuilder appInfo) {
        this.appInfo = appInfo;
        return this;
    }

    public AppConfigBuilder appInfo(AppConfig.AppInfo appInfo) {
        this.appInfo = AppInfoBuilder.from(appInfo);
        return this;
    }

    public AppConfigBuilder modifyAppInfo(Modifier<AppInfoBuilder> modifier) {
        if (appInfo == null) {
            appInfo = new AppInfoBuilder();
        }
        modifier.modify(appInfo);
        return this;
    }

    public AppConfigBuilder cache(CacheBuilder cache) {
        this.cache = cache;
        return this;
    }

    public AppConfigBuilder cache(AppConfig.Cache cache) {
        this.cache = CacheBuilder.from(cache);
        return this;
    }

    public AppConfigBuilder modifyCache(Modifier<CacheBuilder> modifier) {
        if (cache == null) {
            cache = new CacheBuilder();
        }
        modifier.modify(cache);
        return this;
    }

    public AppConfigBuilder client(ClientBuilder client) {
        this.client = client;
        return this;
    }

    public AppConfigBuilder client(AppConfig.Client client) {
        this.client = ClientBuilder.from(client);
        return this;
    }

    public AppConfigBuilder modifyClient(Modifier<ClientBuilder> modifier) {
        if (client == null) {
            client = new ClientBuilder();
        }
        modifier.modify(client);
        return this;
    }

    public AppConfigBuilder cargoQueries(List<AppConfig.GameWiki> cargoQueries) {
        this.cargoQueries = cargoQueries;
        return this;
    }

    public AppConfigBuilder cargoQueries(AppConfig.GameWiki... cargoQueries) {
        this.cargoQueries = Arrays.asList(cargoQueries);
        return this;
    }

    public AppConfigBuilder modifyCargoQueries(Modifier<List<AppConfig.GameWiki>> modifier) {
        if (cargoQueries == null) {
            cargoQueries = List.of();
        }
        modifier.modify(cargoQueries);
        return this;
    }

    public AppConfig build() {
        return new AppConfig(appInfo.build(), cache.build(), client.build(), cargoQueries);
    }

    public static AppConfigBuilder from(AppConfig appConfig) {
        return new AppConfigBuilder()
                .appInfo(appConfig.getAppInfo())
                .cache(appConfig.getCache())
                .client(appConfig.getClient())
                .cargoQueries(appConfig.getCargoQueries());
    }
}
