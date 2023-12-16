package HW8;

public class FileData {

    private String name;
    private String path;
    private byte size;

    public FileData(String path, String name, byte size) {
        this.name = name;
        this.path = path;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public long getSize() {
        return size;
    }

    public String toString() {
        return "{path: \"" + this.path + "\", file name: " + this.getName() + "\", size: " + this.getSize() + "}";
    }
}
