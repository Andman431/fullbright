package com.github.andman.fullbright.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

/**
 * @author Andman
 */
public interface GammaCallback {
    Event<GammaCallback> EVENT = EventFactory.createArrayBacked(GammaCallback.class,
            listeners -> _gamma -> {
        float gamma = _gamma;
        for (GammaCallback event : listeners) {
            gamma = event.onGammaChange(gamma);
        }

        return gamma;
    });

    float onGammaChange(float gamma);
}
