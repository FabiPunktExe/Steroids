package de.fabiexe.steroids.math;

import org.jetbrains.annotations.NotNull;

/** Represents a 3-dimensional vector. */
public class Vector {
    private final double x;
    private final double y;
    private final double z;

    /** Create a new vector with all components as 0. */
    public Vector() {
        this(0);
    }

    /**
     * Create a new vector with all components as the same value.
     *
     * @param xyz The value of all components.
     */
    public Vector(double xyz) {
        this(xyz, xyz, xyz);
    }

    /**
     * Create a new vector with the specified components.
     *
     * @param x The x-component.
     * @param y The y-component.
     * @param z The z-component.
     */
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Get the x-component of this vector.
     *
     * @return The x-component.
     */
    public double x() {
        return x;
    }

    /**
     * Get the x-component of this vector, rounded to the nearest integer.
     *
     * @return The x-component.
     */
    public int blockX() {
        return (int) Math.floor(x);
    }

    /**
     * Create a new vector with the x-component set to the specified value.
     *
     * @param x The new x-component.
     * @return The new vector.
     */
    public @NotNull Vector x(double x) {
        return new Vector(x, y, z);
    }

    /**
     * Get the y-component of this vector.
     *
     * @return The y-component.
     */
    public double y() {
        return y;
    }

    /**
     * Get the y-component of this vector, rounded to the nearest integer.
     *
     * @return The y-component.
     */
    public int blockY() {
        return (int) Math.floor(y);
    }

    /**
     * Create a new vector with the y-component set to the specified value.
     *
     * @param y The new y-component.
     * @return The new vector.
     */
    public @NotNull Vector y(double y) {
        return new Vector(x, y, z);
    }

    /**
     * Get the z-component of this vector.
     *
     * @return The z-component.
     */
    public double z() {
        return z;
    }

    /**
     * Get the z-component of this vector, rounded to the nearest integer.
     *
     * @return The z-component.
     */
    public int blockZ() {
        return (int) Math.floor(z);
    }

    /**
     * Create a new vector with the z-component set to the specified value.
     *
     * @param z The new z-component.
     * @return The new vector.
     */
    public @NotNull Vector z(double z) {
        return new Vector(x, y, z);
    }

    /**
     * Add the specified values to the components of this vector.
     *
     * @param x The value to add to the x-component.
     * @param y The value to add to the y-component.
     * @param z The value to add to the z-component.
     * @return The new vector.
     */
    public @NotNull Vector add(double x, double y, double z) {
        return new Vector(this.x + x, this.y + y, this.z + z);
    }

    /**
     * Add the components of the specified vector to the components of this vector.
     *
     * @param other The vector to add.
     * @return The new vector.
     */
    public @NotNull Vector add(@NotNull Vector other) {
        return add(other.x, other.y, other.z);
    }

    /**
     * Subtract the specified values from the components of this vector.
     *
     * @param x The value to subtract from the x-component.
     * @param y The value to subtract from the y-component.
     * @param z The value to subtract from the z-component.
     * @return The new vector.
     */
    public @NotNull Vector subtract(double x, double y, double z) {
        return new Vector(this.x - x, this.y - y, this.z - z);
    }

    /**
     * Subtract the components of the specified vector from the components of this vector.
     *
     * @param other The vector to subtract.
     * @return The new vector.
     */
    public @NotNull Vector subtract(@NotNull Vector other) {
        return subtract(other.x, other.y, other.z);
    }

    /**
     * Multiply the components of this vector by the specified factor.
     *
     * @param factor The factor to multiply by.
     * @return The new vector.
     */
    public @NotNull Vector multiply(double factor) {
        return new Vector(x * factor, y * factor, z * factor);
    }

    /**
     * Divide the components of this vector by the specified divisor.
     *
     * @param divisor The divisor to divide by.
     * @return The new vector.
     */
    public @NotNull Vector divide(double divisor) {
        return new Vector(x / divisor, y / divisor, z / divisor);
    }

    /**
     * Calculate the distance between this vector and another vector.
     *
     * @param other The other vector.
     * @return The distance between the two vectors.
     */
    public double distance(@NotNull Vector other) {
        double dx = x - other.x;
        double dy = y - other.y;
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    /**
     * Get the block position of this vector.
     *
     * @return The block position.
     */
    public @NotNull Vector blockVector() {
        return new Vector(blockX(), blockY(), blockZ());
    }

    /**
     * Creates a copy of this vector.
     *
     * @return A new vector with the same values as this vector.
     */
    @Override
    public @NotNull Vector clone() {
        return new Vector(x, y, z);
    }

    /**
     * Check if this vector is equal to another object.
     *
     * @param obj The object to compare to.
     * @return Whether the object is equal to this vector.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vector vector)) return false;
        return x == vector.x && y == vector.y && z == vector.z;
    }
}
