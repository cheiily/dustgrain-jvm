package one.cheily.dustgrain.jvm.config;

@FunctionalInterface
public interface Modifier<T> {
    void modify(T t);
}

