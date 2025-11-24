package hw_9;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.io.*;
import java.util.*;

public class TextFileAnalyzer {

  @Getter
  @AllArgsConstructor
  @ToString
  public static class AnalysisResult {
    private final long lineCount;  // количество строк в файле
    private final long wordCount; // количество слов в файле
    private final long charCount; // количество символов в файле
  }

  public AnalysisResult analyzeFile(String filePath) throws IOException {
    long lineCount = 0;
    long wordCount = 0;
    long charCount = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;

      while ((line = reader.readLine()) != null) {
        lineCount++;
        charCount += line.length();

        if (!line.trim().isEmpty()) {
          String[] words = line.trim().split("\\s+");
          wordCount += words.length;
        }
      }
    }

    return new AnalysisResult(lineCount, wordCount, charCount);
  }

  public void saveAnalysisResult(AnalysisResult result, String outputPath) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
      writer.write("Результаты анализа файла:\n");
      writer.write("Количество строк: " + result.getLineCount() + "\n");
      writer.write("Количество слов: " + result.getWordCount() + "\n");
      writer.write("Количество символов: " + result.getCharCount() + "\n");
    }
  }
}