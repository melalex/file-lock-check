package com.file.lock;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CheckApplication {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final String EXPORT_PATH = "export";
    private static final String FILE_NAME = "check";

    public static void main(String[] args) {
        final File file = resolveExportFile();

        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), DEFAULT_ENCODING)) {
            new DataMarshaller().marshal(writer, getData());
        } catch (final IOException e) {
            System.err.println(
                    String.format("Could not create output stream writer to file '%s' with encoding '%s'",
                            file.getAbsolutePath(), DEFAULT_ENCODING));
        }
    }

    private static void createFolder(final Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (final IOException exp) {
                System.err.println("Can not create folder: " + path.toString());
            }
        }
    }

    private static File resolveExportFile() {
        final Path folderPath = Paths.get(EXPORT_PATH);
        createFolder(folderPath);

        return folderPath.resolve(FILE_NAME).toFile();
    }

    private static List<Entity> getData() {
        return Arrays.asList(
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val"),
                new Entity("val", "val", "val")
        );
    }
}
