package one.cheily.dustgrain.jvm.config;

import one.cheily.dustgrain.core.config.AppConfig;

public class AppInfoBuilder {
    private String name;
    private String version;
    private String author;

    public AppInfoBuilder() {}

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }


    public AppInfoBuilder name(String name) {
        this.name = name;
        return this;
    }

    public AppInfoBuilder version(String version) {
        this.version = version;
        return this;
    }

    public AppInfoBuilder author(String author) {
        this.author = author;
        return this;
    }

    public AppConfig.AppInfo build() {
        return new AppConfig.AppInfo(name, version, author);
    }

    public static AppInfoBuilder from(AppConfig.AppInfo appInfo) {
        return new AppInfoBuilder()
                .name(appInfo.getName())
                .version(appInfo.getVersion())
                .author(appInfo.getAuthor());
    }
}
