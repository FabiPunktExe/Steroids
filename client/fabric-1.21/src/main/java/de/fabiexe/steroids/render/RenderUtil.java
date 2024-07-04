package de.fabiexe.steroids.render;

import com.mojang.blaze3d.vertex.*;
import de.fabiexe.steroids.math.Vector;
import java.util.Objects;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class RenderUtil {
    /**
     * Render a line between two points.
     *
     * @param pose The pose of the current pose stack.
     * @param pos1 The first point.
     * @param pos2 The second point.
     * @param color1 The color of the first point.
     * @param color2 The color of the second point.
     */
    public static void renderLine(
            @NotNull PoseStack.Pose pose,
            @NotNull Vector pos1,
            @NotNull Vector pos2,
            int color1,
            int color2) {
        BufferBuilder buffer =
                Tesselator.getInstance()
                        .begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR);
        float x1 = (float) pos1.x();
        float x2 = (float) pos2.x();
        float y1 = (float) pos1.y();
        float y2 = (float) pos2.y();
        float z1 = (float) pos1.z();
        float z2 = (float) pos2.z();
        buffer.addVertex(pose, x1, y1, z1).setColor(color1);
        buffer.addVertex(pose, x2, y2, z2).setColor(color2);
        BufferUploader.drawWithShader(Objects.requireNonNull(buffer.build()));
    }

    /**
     * Render a triangle fan between a tip and a base.
     *
     * @param pose The pose of the current pose stack.
     * @param tip The tip of the triangle fan.
     * @param base The base of the triangle fan.
     * @param baseRadius The radius of the base.
     * @param triangles The number of triangles.
     * @param tipColor The color of the tip.
     * @param baseColor The color of the base.
     * @param invert Whether to invert the triangle fan.
     * @param direction The direction of the triangle fan. 0 for x, 1 for y, 2 for z.
     */
    public static void renderTriangleFan(
            @NotNull PoseStack.Pose pose,
            @NotNull Vector tip,
            @NotNull Vector base,
            float baseRadius,
            int triangles,
            int tipColor,
            int baseColor,
            boolean invert,
            int direction) {
        BufferBuilder buffer =
                Tesselator.getInstance()
                        .begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
        buffer.addVertex(pose, (float) tip.x(), (float) tip.y(), (float) tip.z())
                .setColor(tipColor);

        for (int i = 0; i <= triangles; i++) {
            float angle = (invert ? -2 : 2) * (float) (Math.PI * i / triangles);
            float x;
            float y;
            float z;
            if (direction == 0) {
                x = (float) base.x();
                y = (float) (base.y() + baseRadius * Mth.cos(angle));
                z = (float) (base.z() + baseRadius * Mth.sin(angle));
            } else if (direction == 1) {
                x = (float) (base.x() + baseRadius * Mth.cos(angle));
                y = (float) base.y();
                z = (float) (base.z() + baseRadius * Mth.sin(angle));
            } else {
                x = (float) (base.x() + baseRadius * Mth.cos(angle));
                y = (float) (base.y() + baseRadius * Mth.sin(angle));
                z = (float) base.z();
            }
            buffer.addVertex(pose, x, y, z).setColor(baseColor);
        }
        BufferUploader.drawWithShader(Objects.requireNonNull(buffer.build()));
    }

    /**
     * Render a cone between a tip and a base.
     *
     * @param pose The pose of the current pose stack.
     * @param tip The tip of the cone.
     * @param base The base of the cone.
     * @param baseRadius The radius of the base.
     * @param triangles The number of triangles.
     * @param tipColor The color of the tip.
     * @param baseColor The color of the base.
     * @param direction The direction of the cone. 0 for x, 1 for y, 2 for z.
     */
    public static void renderCone(
            @NotNull PoseStack.Pose pose,
            @NotNull Vector tip,
            @NotNull Vector base,
            float baseRadius,
            int triangles,
            int tipColor,
            int baseColor,
            int direction) {
        renderTriangleFan(
                pose, tip, base, baseRadius, triangles, tipColor, baseColor, true, direction);
        renderTriangleFan(
                pose, base, base, baseRadius, triangles, baseColor, baseColor, false, direction);
    }
}
