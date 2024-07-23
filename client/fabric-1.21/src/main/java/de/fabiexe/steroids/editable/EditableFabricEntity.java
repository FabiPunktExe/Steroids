package de.fabiexe.steroids.editable;

import de.fabiexe.steroids.math.Vector;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class EditableFabricEntity implements Editable {
    private final @NotNull Entity entity;

    public EditableFabricEntity(@NotNull Entity entity) {
        this.entity = entity;
    }

    @Override
    public @NotNull Vector getPosition() {
        return new Vector(entity.getX(), entity.getY(), entity.getZ());
    }

    @Override
    public void setPosition(@NotNull Vector position) {
        entity.setPos(position.x(), position.y(), position.z());
    }

    @Override
    public @NotNull Vector getRotation() {
        return new Vector(entity.getXRot(), entity.getYRot(), 0);
    }

    @Override
    public boolean isXAxisRotatable() {
        return true;
    }

    @Override
    public void setXRotation(double rotation) {
        entity.setXRot((float) rotation);
    }

    @Override
    public boolean isYAxisRotatable() {
        return true;
    }

    @Override
    public void setYRotation(double rotation) {
        entity.setYRot((float) rotation);
    }

    @Override
    public boolean isZAxisRotatable() {
        // TODO: Display entity rotation
        return false;
    }

    @Override
    public void setZRotation(double rotation) {
        // TODO: Display entity rotation
    }

    @Override
    public @NotNull Vector getSize() {
        return new Vector(1);
    }

    @Override
    public boolean isXAxisResizable() {
        return false;
    }

    @Override
    public void resizeXAxis(double size) {
    }

    @Override
    public boolean isYAxisResizable() {
        return false;
    }

    @Override
    public void resizeYAxis(double size) {
    }

    @Override
    public boolean isZAxisResizable() {
        return false;
    }

    @Override
    public void resizeZAxis(double size) {
    }

    public @NotNull Entity getEntity() {
        return entity;
    }
}
