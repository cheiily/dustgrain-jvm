package one.cheily.dustgrain.jvm.safe;

@FunctionalInterface
public interface ThrowingSupplier<T, E extends Throwable>  {
    public T get() throws E;
}

