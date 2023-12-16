package HW8;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileNavigator {

    private Map<String, List<FileData>> fileMap = new HashMap<>();

    public void add(String filePath, FileData fileData) {
        if (filePath != fileData.getPath()) {
            throw new IllegalArgumentException("File path should be equals to file path  FileData object");
        }
        fileMap.computeIfAbsent(fileData.getPath(), f -> new ArrayList<>()).add(fileData);
    }

    public List<FileData> find(String path) {
        return fileMap.get(path);
    }

    public List<FileData> filterBySize(Byte size) {
        return
                fileMap.values().stream().flatMap(List::stream).filter(f -> f.getSize() < size).collect(Collectors.toList());
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        return fileMap.values().stream().flatMap(List::stream).sorted(Comparator.comparingLong(FileData::getSize)).collect(Collectors.toList());
    }

    public String toString() {
        return fileMap.toString();
    }
}
