package edu.hw6;

import edu.hw6.Task1.DiskMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    public static final String DISK_MAP_DATA_PATH = "src/test/java/edu/hw6/diskMapData.txt";

    void createDiskMapData() {
        try (PrintWriter writer = new PrintWriter(DISK_MAP_DATA_PATH)){
            writer.println("name:Denis");
            writer.println("female:Utev");
            writer.println("language:Java");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("тест чтения данных из файла")
    void testLoadFile() {
        createDiskMapData();
        DiskMap diskMap = new DiskMap(DISK_MAP_DATA_PATH);
        assertThat(diskMap.get("name")).isEqualTo("Denis");
        assertThat(diskMap.get("female")).isEqualTo("Utev");
        assertThat(diskMap.get("language")).isEqualTo("Java");
    }

    @Test
    @DisplayName("тест отсутствия файла")
    void testNoFile() {
        DiskMap diskMap = new DiskMap("C:\\test.txt");
        assertThat(diskMap.isEmpty()).isEqualTo(true);
    }

    @Test
    @DisplayName("тест добавления данных")
    void testPutMethod() {
        createDiskMapData();
        DiskMap diskMap = new DiskMap(DISK_MAP_DATA_PATH);
        diskMap.put("newKey", "newValue");
        assertThat(diskMap.get("newKey")).isEqualTo("newValue");

        DiskMap diskMap2 = new DiskMap(DISK_MAP_DATA_PATH);
        assertThat(diskMap2.get("newKey")).isEqualTo("newValue");
    }

    @Test
    @DisplayName("тест удаления данных")
    void testRemoveMethod() {
        createDiskMapData();
        DiskMap diskMap = new DiskMap(DISK_MAP_DATA_PATH);
        diskMap.remove("female");
        assertThat(diskMap.containsKey("female")).isEqualTo(false);

        DiskMap diskMap2 = new DiskMap(DISK_MAP_DATA_PATH);
        assertThat(diskMap2.containsKey("female")).isEqualTo(false);
        assertThat(diskMap2.containsKey("name")).isEqualTo(true);
        assertThat(diskMap2.containsValue("Utev")).isEqualTo(false);
    }

    @Test
    @DisplayName("тест стирания всех данных")
    void testClearDiskMap() {
        createDiskMapData();
        DiskMap diskMap = new DiskMap(DISK_MAP_DATA_PATH);
        diskMap.clear();

        DiskMap diskMap2 = new DiskMap(DISK_MAP_DATA_PATH);
        diskMap2.put("name", "Denis");
        assertThat(diskMap2.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("тест добавления кучи данных")
    void testPutAllToDiskMap() {
        createDiskMapData();
        HashMap<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        DiskMap diskMap = new DiskMap(DISK_MAP_DATA_PATH);
        diskMap.putAll(map);
        assertThat(diskMap.size()).isEqualTo(6);
        assertThat(diskMap.get("k2")).isEqualTo("v2");
    }

    @Test
    @DisplayName("тест пересечения ключей")
    void testIntersectionKeys() {
        createDiskMapData();
        DiskMap diskMap = new DiskMap(DISK_MAP_DATA_PATH);
        diskMap.put("name", "Denis2");
        assertThat(diskMap.size()).isEqualTo(3);
        assertThat(diskMap.get("name")).isEqualTo("Denis2");
    }
}
