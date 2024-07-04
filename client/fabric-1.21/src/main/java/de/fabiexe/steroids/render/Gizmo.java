package de.fabiexe.steroids.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import de.fabiexe.steroids.math.Vector;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class Gizmo {
    private static final int xColor = 0xFFFF0000;
    private static final int yColor = 0xFF00FF00;
    private static final int zColor = 0xFF0000FF;
    private final @NotNull Entity entity;

    public Gizmo(@NotNull Entity entity) {
        this.entity = entity;
    }

    public void render(PoseStack poseStack) {
        poseStack.pushPose();
        Camera camera = Minecraft.getInstance().gameRenderer.getMainCamera();
        // poseStack.translate(entity.position().x + 0.5 - camera.getPosition().x,
        // entity.position().y + 0.5 - camera.getPosition().y, entity.position().z + 0.5 -
        // camera.getPosition().z);
        float distance = (float) camera.getPosition().distanceTo(entity.position());
        poseStack.scale(distance, distance, distance);
        renderMovement(poseStack, 0.5f, 5, 0.05f, 0.15f, 8);
        poseStack.popPose();
    }

    private void renderMovement(
            PoseStack poseStack,
            float baseLength,
            float lineWidth,
            float coneRadius,
            float coneLength,
            int coneTriangles) {
        PoseStack.Pose pose = poseStack.last();
        RenderSystem.setShader(GameRenderer::getRendertypeLinesShader);
        RenderSystem.lineWidth(lineWidth);
        RenderUtil.renderLine(pose, new Vector(), new Vector(baseLength, 0, 0), xColor, xColor);
        RenderUtil.renderLine(pose, new Vector(), new Vector(-baseLength, 0, 0), xColor, xColor);
        RenderUtil.renderCone(
                pose,
                new Vector(baseLength + coneLength, 0, 0),
                new Vector(baseLength, 0, 0),
                coneRadius,
                coneTriangles,
                xColor,
                xColor,
                0);
        RenderUtil.renderCone(
                pose,
                new Vector(-baseLength - coneLength, 0, 0),
                new Vector(-baseLength, 0, 0),
                coneRadius,
                coneTriangles,
                xColor,
                xColor,
                0);
        RenderUtil.renderLine(pose, new Vector(), new Vector(0, baseLength, 0), yColor, yColor);
        RenderUtil.renderLine(pose, new Vector(), new Vector(0, -baseLength, 0), yColor, yColor);
        RenderUtil.renderCone(
                pose,
                new Vector(0, baseLength + coneLength, 0),
                new Vector(0, baseLength, 0),
                coneRadius,
                coneTriangles,
                yColor,
                yColor,
                1);
        RenderUtil.renderCone(
                pose,
                new Vector(0, -baseLength - coneLength, 0),
                new Vector(0, -baseLength, 0),
                coneRadius,
                coneTriangles,
                yColor,
                yColor,
                1);
        RenderUtil.renderLine(pose, new Vector(), new Vector(0, 0, baseLength), zColor, zColor);
        RenderUtil.renderLine(pose, new Vector(), new Vector(0, 0, -baseLength), zColor, zColor);
        RenderUtil.renderCone(
                pose,
                new Vector(0, 0, baseLength + coneLength),
                new Vector(0, 0, baseLength),
                coneRadius,
                coneTriangles,
                zColor,
                zColor,
                2);
        RenderUtil.renderCone(
                pose,
                new Vector(0, 0, -baseLength - coneLength),
                new Vector(0, 0, -baseLength),
                coneRadius,
                coneTriangles,
                zColor,
                zColor,
                2);
    }
}
