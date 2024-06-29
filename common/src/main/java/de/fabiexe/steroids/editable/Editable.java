package de.fabiexe.steroids.editable;

import de.fabiexe.steroids.math.Vector;
import org.jetbrains.annotations.NotNull;

public interface Editable {
    /**
     * Get the position of the object.
     * @return The position of the object.
     */
    @NotNull
    Vector getPosition();

    void setPosition(@NotNull Vector position);

    /**
     * Get the rotation of the object.
     * @return The rotation of the object.
     */
    @NotNull
    Vector getRotation();

    /**
     * Check if the object is rotatable around the x-axis.
     * @return true if the object is rotatable around the x-axis, otherwise false.
     */
    boolean isXAxisRotatable();

    /**
     * Set the rotation of the object around the x-axis.
     * @param rotation The rotation of the object around the x-axis.
     */
    void setXRotation(double rotation);

    /**
     * Check if the object is rotatable around the y-axis.
     * @return true if the object is rotatable around the y-axis, otherwise false.
     */
    boolean isYAxisRotatable();

    /**
     * Set the rotation of the object around the y-axis.
     * @param rotation The rotation of the object around the y-axis.
     */
    void setYRotation(double rotation);

    /**
     * Check if the object is rotatable around the z-axis.
     * @return true if the object is rotatable around the z-axis, otherwise false.
     */
    boolean isZAxisRotatable();

    /**
     * Set the rotation of the object around the z-axis.
     * @param rotation The rotation of the object around the z-axis.
     */
    void setZRotation(double rotation);

    /**
     * Get the size of the object.
     * @return The size of the object.
     */
    @NotNull
    Vector getSize();

    /**
     * Check if the object is resizable along the x-axis.
     * @return true if the object is resizable along the x-axis, otherwise false.
     */
    boolean isXAxisResizable();

    /**
     * Resize the object along the x-axis.
     * @param size The new size of the object along the x-axis.
     */
    void resizeXAxis(double size);

    /**
     * Check if the object is resizable along the y-axis.
     * @return true if the object is resizable along the y-axis, otherwise false.
     */
    boolean isYAxisResizable();

    /**
     * Resize the object along the y-axis.
     * @param size The new size of the object along the y-axis.
     */
    void resizeYAxis(double size);

    /**
     * Check if the object is resizable along the z-axis.
     * @return true if the object is resizable along the z-axis, otherwise false.
     */
    boolean isZAxisResizable();

    /**
     * Resize the object along the z-axis.
     * @param size The new size of the object along the z-axis.
     */
    void resizeZAxis(double size);
}
