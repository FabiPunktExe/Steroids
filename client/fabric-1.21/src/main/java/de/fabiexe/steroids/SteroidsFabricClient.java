package de.fabiexe.steroids;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class SteroidsFabricClient implements ClientModInitializer {
    public static boolean BUILDER_MODE = false;
    private final KeyMapping keyBinding =
            new KeyMapping(
                    "key.steroids.toggle_builder_mode",
                    GLFW.GLFW_KEY_J,
                    "categories.steroids.steroids");

    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(keyBinding);
        ClientTickEvents.START_CLIENT_TICK.register(this::tick);
    }

    private void tick(Minecraft client) {
        if (keyBinding.consumeClick()) {
            BUILDER_MODE = !BUILDER_MODE;
        }
    }
}
