package one.cheily.dustgrain.jvm.safe;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;

@Slf4j
public class Invoke {
    public static <T> T orNull(ThrowingAnySupplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Throwable e) {
            logException(e);
            return null;
        }
    }

    public static <T, E extends Throwable> T orNull(ThrowingSupplier<T, E> supplier, Class<E> exceptionClass) {
        try {
            return supplier.get();
        } catch (Throwable e) {
            if (exceptionClass.isInstance(e)) {
                logException(e);
                return null;
            }
            throw new RuntimeException(e);
        }
    }

    public static <T> T orDefault(ThrowingAnySupplier<T> supplier, T defaultValue) {
        try {
            return supplier.get();
        } catch (Throwable e) {
            logException(e);
            return defaultValue;
        }
    }

    public static <T, E extends Throwable> T orDefault(ThrowingSupplier<T, E> supplier, Class<E> exceptionClass, T defaultValue) {
        try {
            return supplier.get();
        } catch (Throwable e) {
            if (exceptionClass.isInstance(e)) {
                logException(e);
                return defaultValue;
            }
            throw new RuntimeException(e);
        }
    }


    private static void logException(Throwable e) {
        log.warn("Safe invocation caught exception: {}", e.getMessage(), e);
    }
}
