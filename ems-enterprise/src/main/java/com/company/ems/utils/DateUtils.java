package com.company.ems.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

  private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

  public static LocalDate parseDate(String dateStr) {
    return parseDate(dateStr, DEFAULT_PATTERN);
  }

  public static LocalDate parseDate(String dateStr, String pattern) {
    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
      return LocalDate.parse(dateStr, formatter);
    } catch (DateTimeParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String formatDate(LocalDate date) {
    return formatDate(date, DEFAULT_PATTERN);
  }

  public static String formatDate(LocalDate date, String pattern) {
    if (date == null) {
      return "";
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    return date.format(formatter);
  }
}
