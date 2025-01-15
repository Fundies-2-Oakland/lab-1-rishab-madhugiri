public class Vector3D {
    Double x, y, z;

    public Vector3D(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return String.format("%.2f, %.2f, %.2f", x, y, z);
    }

    public Double getMagnitude() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public Vector3D normalize() {
        Double magn = this.getMagnitude();
        return new Vector3D(x / magn, y / magn, z / magn);
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.x, y + other.y, z + other.z);
    }

    public Vector3D multiply(Double multiplier) {
        return new Vector3D(x * multiplier, y * multiplier, z * multiplier);
    }

    public Double dotProduct(Vector3D other) {
        return (x * other.x) + (y * other.y) + (z * other.z);
    }

    public Double angleBetween(Vector3D other) {
        return Math.acos((this.dotProduct(other)) / (this.getMagnitude() * other.getMagnitude()));
    }

    public Vector3D crossProduct(Vector3D other) {
        Double thisX = x;
        Double thisY = y;
        Double thisZ = z;
        Double otherX = other.x;
        Double otherY = other.y;
        Double otherZ = other.z;
        Double newX = (thisY * otherZ) - (thisZ * otherY);
        Double newY = (thisZ * otherX) - (thisX * otherZ);
        Double newZ = (thisX * otherY) - (thisY * otherZ);
        return new Vector3D(newX, newY, newZ);
    }
}
