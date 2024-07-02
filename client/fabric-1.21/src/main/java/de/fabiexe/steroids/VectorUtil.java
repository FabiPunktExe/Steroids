package de.fabiexe.steroids;

import de.fabiexe.steroids.math.Vector;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class VectorUtil {
    public static @NotNull Vector vec3dToVector(@NotNull Vec3 vec3d) {
        return new Vector(vec3d.x, vec3d.y, vec3d.z);
    }
}
