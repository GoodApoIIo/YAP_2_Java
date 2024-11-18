package ru.rybyakowa.geometry;

import java.util.Objects;

public class Point3D extends Point {
    private final double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public String toString() {
        return String.format("(%f, %f, %f)", getX(), getY(), z);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Point3D point3D = (Point3D) o;
        return Double.compare(point3D.z, z) == 0;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }
}