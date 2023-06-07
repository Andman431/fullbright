package com.github.andman.fullbright;

import com.github.andman.fullbright.event.GammaCallback;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client-Sided/Main class for Fullbright.
 *
 * @author Andman
 */
public class FullbrightClient implements ClientModInitializer {
    static final Logger LOGGER = LoggerFactory.getLogger("fullbright");

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing fullbright...");

        // setting up the gamma event listener
        GammaCallback.EVENT.register(gamma -> {
            // modifying gamma to the config value, which we loaded previously
            gamma = 15f;
            return gamma;
        });
    }

}
