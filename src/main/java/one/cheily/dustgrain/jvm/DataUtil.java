package one.cheily.dustgrain.jvm;

import one.cheily.dustgrain.core.domain.DataGrain;
import one.cheily.dustgrain.core.domain.DataSpike;

import java.util.Optional;

public class DataUtil {
    public static Optional<DataGrain> optGrain(DataSpike spike, String name) {
        return Optional.ofNullable(spike.getGrain(name));
    }

    public static String onlyEntryOf(DataGrain grain) {
        if (grain.getContents().isEmpty()) return null;
        else return grain.getContents().getFirst();
    }
}
