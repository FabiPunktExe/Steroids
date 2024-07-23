package de.fabiexe.steroids.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import de.fabiexe.steroids.SteroidsFabricClient;
import de.fabiexe.steroids.editable.EditableFabricEntity;
import de.fabiexe.steroids.render.Gizmo;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin<T extends Entity> {
    @Inject(method = "render", at = @At("HEAD"))
    public void render(
            T entity,
            float f,
            float g,
            PoseStack poseStack,
            MultiBufferSource multiBufferSource,
            int i,
            CallbackInfo ci) {
        if (SteroidsFabricClient.EDITING_OBJECT instanceof EditableFabricEntity editable && editable.getEntity() == entity) {
            // Render Gizmo
            new Gizmo(entity).render(poseStack);
        }
    }
}
