package com.github.andman.fullbright.mixin;

import com.github.andman.fullbright.event.GammaCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// optifine patch
@Pseudo
@Mixin(targets = "net.optifine.LightMap")
public class LightMapMixin {
    @Inject(method = "updateLightmap", at = @At("HEAD"), cancellable = true)
    public void fullbright$fireGammaEvent(ClientWorld world, float torchFlickerX, int[] lmColors, boolean nightVision, CallbackInfoReturnable<Boolean> ci) {
        float gamma = GammaCallback.EVENT.invoker().onGammaChange(MinecraftClient.getInstance().options.getGamma().getValue().floatValue());
        if (gamma > 1)
            ci.setReturnValue(false);
    }
}
