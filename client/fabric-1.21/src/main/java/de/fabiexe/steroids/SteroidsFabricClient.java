package de.fabiexe.steroids;

import de.fabiexe.steroids.editable.Editable;
import de.fabiexe.steroids.editable.EditableFabricEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.EntityHitResult;
import org.lwjgl.glfw.GLFW;

public class SteroidsFabricClient implements ClientModInitializer {
    public static Editable EDITING_OBJECT = null;
    private final KeyMapping keyBinding =
            new KeyMapping(
                    "key.steroids.toggle_builder_mode",
                    GLFW.GLFW_KEY_J,
                    "categories.steroids.steroids");

    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(keyBinding);
        ClientTickEvents.START_CLIENT_TICK.register(this::onTick);
    }

    private void onTick(Minecraft client) {
        if (keyBinding.consumeClick()) {
            if (client.hitResult instanceof EntityHitResult hitResult && !(EDITING_OBJECT instanceof EditableFabricEntity editable && editable.getEntity() == hitResult.getEntity())) {
                EDITING_OBJECT = new EditableFabricEntity(hitResult.getEntity());
            } else {
                EDITING_OBJECT = null;
            }
        }
    }
}
