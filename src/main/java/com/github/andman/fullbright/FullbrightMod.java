package com.github.andman.fullbright;

import com.github.andman.fullbright.config.Configuration;
import com.github.andman.fullbright.event.GammaCallback;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for Fullbright.
 *
 * @author Andman
 */
public class FullbrightMod implements ClientModInitializer {
    static final Logger LOGGER = LoggerFactory.getLogger("fullbright");
    Configuration config;

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing fullbright...");

        // registering config as json
        AutoConfig.register(Configuration.class, GsonConfigSerializer::new);
        // loading config
        config = AutoConfig.getConfigHolder(Configuration.class).getConfig();

        // setting up the gamma event listener
        GammaCallback.EVENT.register(gamma -> {
            // checking if mod is enabled
            if (config.toggled) {
                // modifying gamma to the config value, which we loaded previously
                gamma = config.gamma;
                return gamma;
            }

            // if mod is not enabled, we want to use the default minecraft value
            return MinecraftClient.getInstance()
                    .options.getGamma().getValue().floatValue();
        });
    }

}
