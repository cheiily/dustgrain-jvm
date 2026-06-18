package one.cheily.dustgrain.jvm;

import one.cheily.dustgrain.core.Application;
import one.cheily.dustgrain.core.config.AppConfig;
import one.cheily.dustgrain.core.config.AppProfile;
import one.cheily.dustgrain.core.domain.DataGrain;
import one.cheily.dustgrain.core.domain.DataHeader;
import one.cheily.dustgrain.core.domain.DataSpike;
import one.cheily.dustgrain.core.fetching.ImageDataResponse;
import one.cheily.dustgrain.core.fetching.TableDataRequest;

import java.util.List;
import java.util.Map;

public class DustgrainHandle {
    private static boolean isInitialized = false;

    public DustgrainHandle() {
        if (isInitialized)
            return;

        Application.INSTANCE.initialize(AppProfile.LIB);
        isInitialized = true;
    }

    public DustgrainHandle(AppProfile profile, AppConfig config) {
        if (isInitialized)
            return;

        Application.INSTANCE.initialize(profile, config);
        isInitialized = true;
    }

    public void reinitialize() {
        isInitialized = true;
        Application.INSTANCE.initialize(AppProfile.LIB);
    }

    public void reinitialize(AppProfile profile, AppConfig config) {
        isInitialized = true;
        Application.INSTANCE.initialize(profile, config);
    }

    public Application getApplication() {
        return Application.INSTANCE;
    }

    public void initializeForGame(String gameName) {
        var module = Application.INSTANCE.getGameModules().getOrLoadModuleBlocking(gameName);
        Application.INSTANCE.getGameModules().initializeModuleBlocking(gameName);

        if (module == null)
            return;

        Application.INSTANCE.getDataHeaderCache().loadAllBlocking(
                module.getTables().toArray(new String[0])
        );
    }


    // --- raw fetch api ---
    public List<String> getTableList() {
         return Application.INSTANCE.getDataFetchService().getTableListBlocking();
    }

    public List<DataHeader> getTableHeaders(String tableName) {
        return Application.INSTANCE.getDataHeaderCache().getOrLoadBlocking(tableName);
    }

    public List<Map<String, String>> getTableData(TableDataRequest query) {
        return Application.INSTANCE.getDataFetchService().getTableDataBlocking(query);
    }

    public ImageDataResponse.ImageUrlQuery.ImagePage.ImageInfo getImageInfo(String imageName) {
        return Application.INSTANCE.getDataFetchService().getImageInfoBlocking(imageName);
    }

    public String getImageUrl(String imageName) {
        return Application.INSTANCE.getDataFetchService().getImageUrlBlocking(imageName);
    }
    // --- raw fetch api ---

    // --- common fetch api ---
    public List<String> listCharacters(String game) {
        return Application.INSTANCE.getGameModules().listCharactersBlocking(game);
    }

    public List<DataGrain> getAllCharacterData(String game, String character) {
        return Application.INSTANCE.getGameModules().getAllCharacterDataBlocking(game, character);
    }

    public List<DataSpike> listMoves(String game, String character) {
        return Application.INSTANCE.getGameModules().listMovesBlocking(game, character);
    }

    public List<DataSpike> getAllMoveDataByName(String game, String character, String move) {
        return Application.INSTANCE.getGameModules().getAllMoveDataByNameBlocking(game, character, move);
    }

    public List<DataSpike> getAllMoveDataByInput(String game, String character, String input) {
        return Application.INSTANCE.getGameModules().getAllMoveDataByInputBlocking(game, character, input);
    }

    public List<DataSpike> getAllMoveDataByCustomQuery(String game, String where) {
        return Application.INSTANCE.getGameModules().getAllMoveDataByCustomQueryBlocking(game, where);
    }

    public List<DataSpike> listMovesByCustomQuery(String game, String where) {
        return Application.INSTANCE.getGameModules().listMovesByCustomQueryBlocking(game, where);
    }

    public List<String> listCharactersByCustomQuery(String game, String where) {
        return Application.INSTANCE.getGameModules().listCharactersByCustomQueryBlocking(game, where);
    }

    public List<DataGrain> getAllCharacterDataByCustomQuery(String game, String where) {
        return Application.INSTANCE.getGameModules().getAllCharacterDataByCustomQueryBlocking(game, where);
    }
    // --- common fetch api ---

    public void clearCache() {
        Application.INSTANCE.getDataHeaderCache().clear();
        Application.INSTANCE.getGameModules().clear();
    }
}
