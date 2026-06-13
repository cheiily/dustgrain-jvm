package one.cheily.dustgrain.jvm.safe;

@FunctionalInterface
public interface ThrowingAnySupplier<T> extends ThrowingSupplier<T, Throwable> {
    public T get() throws Throwable;
}
