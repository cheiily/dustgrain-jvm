package one.cheily.dustgrain.jvm.safe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Invoke {
    public static <T> T orNull(ThrowingAnySupplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Throwable e) {
            log.warn("Safe invocation caught exception: {}", e.getMessage(), e);
            return null;
        }
    }

    public static <T, E extends Throwable> T orNull(ThrowingSupplier<T, E> supplier, Class<E> exceptionClass) {
        try {
            return supplier.get();
        } catch (Throwable e) {
            if (exceptionClass.isInstance(e)) {
                log.warn("Safe invocation caught exception: {}", e.getMessage(), e);
                return null;
            }
            throw new RuntimeException(e);
        }
    }
}
