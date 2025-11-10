package hw_9;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class FileProcessor {

  public List<Path> splitFile(String sourcePath, String outputDir, int partSize) throws IOException {
    List<Path> partPaths = new ArrayList<>();
    Path source = Paths.get(sourcePath);
    String originalName = source.getFileName().toString();

    Files.createDirectories(Paths.get(outputDir));

    try (FileChannel sourceChannel = FileChannel.open(source, StandardOpenOption.READ)) {
      ByteBuffer buffer = ByteBuffer.allocate(partSize);
      int partCounter = 1;

      while (sourceChannel.read(buffer) > 0) {
        buffer.flip();
        String partFileName = originalName + ".part" + partCounter;
        Path partPath = Paths.get(outputDir, partFileName);

        try (FileChannel partChannel = FileChannel.open(partPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
          partChannel.write(buffer);
        }

        partPaths.add(partPath);
        partCounter++;
        buffer.clear();
      }
    }
    return partPaths;
  }

  public void mergeFiles(List<Path> partPaths, String outputPath) throws IOException {
    Path output = Paths.get(outputPath);

    for (Path part : partPaths) {
      if (!Files.exists(part)) {throw new IOException("Часть не найдена: " + part);}
    }

    partPaths.sort(Comparator.comparing(path -> {
      String name = path.getFileName().toString();
      return Integer.parseInt(name.substring(name.lastIndexOf(".part") + 5));
    }));

    try (FileChannel outputChannel = FileChannel.open(output,
      StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {

      for (Path partPath : partPaths) {
        try (FileChannel partChannel = FileChannel.open(partPath, StandardOpenOption.READ)) {
          ByteBuffer buffer = ByteBuffer.allocate(8192);
          while (partChannel.read(buffer) > 0) {
            buffer.flip();
            outputChannel.write(buffer);
            buffer.compact();
          }
        }
      }
    }
  }
}