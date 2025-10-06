package com.company.ems.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

  private static final String UPLOAD_DIR = "uploads/";

  public static String saveFile(MultipartFile file) {
    try {
      if (file.isEmpty()) {
        return null;
      }
      String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
      Path filepath = Paths.get(UPLOAD_DIR, filename);
      if (!Files.exists(filepath.getParent())) {
        Files.createDirectories(filepath.getParent());
      }
      Files.write(filepath, file.getBytes());
      return filename;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static boolean deleteFile(String filename) {
    try {
      Path filepath = Paths.get(UPLOAD_DIR, filename);
      return Files.deleteIfExists(filepath);
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }
}
