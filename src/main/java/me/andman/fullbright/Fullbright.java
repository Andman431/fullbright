package me.andman.fullbright;

import me.andman.fullbright.event.LightmapUpdateCallback;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fullbright implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(Fullbright.class);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Fullbright...");
        LightmapUpdateCallback.EVENT.register(_gamma -> 15F);
    }
}
