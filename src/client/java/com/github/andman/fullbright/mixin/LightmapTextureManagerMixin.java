package com.github.andman.fullbright.mixin;

import com.github.andman.fullbright.event.GammaCallback;
import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {
    @Redirect(method = "update", at = @At(value = "INVOKE", target = "Ljava/lang/Double;floatValue()F", ordinal = 1))
    private float fullbright$fireGammaEvent(Double d) {
        return GammaCallback.EVENT.invoker().onGammaChange(d.floatValue());
    }
}
