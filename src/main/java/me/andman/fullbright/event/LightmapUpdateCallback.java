package me.andman.fullbright.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

@FunctionalInterface
public interface LightmapUpdateCallback {
    Event<LightmapUpdateCallback> EVENT = EventFactory.createArrayBacked(LightmapUpdateCallback.class, listeners -> _gamma -> {
        float gamma = _gamma;
        for (var listener : listeners) {
            gamma = listener.onUpdate(gamma);
        }

        return gamma;
    });

    /**
     * Called when updating the light map.
     * @param gamma the passed along gamma value
     * @return the gamma value
     */
    float onUpdate(float gamma);
}