package edu.epam;

/**
 * ABBCCC => AB2C3
 * ABBABBB   => AB2AB3
 */
public class SquashString {

  /**
   * If {@code input} is null or empty, then return it.
   * 
   * @param input - contains only letters [A-Z]
   * @throws IllegalArgumentException if input contains anything besides [A-Z] symbols
   */
  public static String squash(String input) {
    if (input == null || input.isEmpty()) return input;
    if (!input.matches("[A-Z]+")) {
      throw new IllegalArgumentException();
    }

    StringBuilder sb = new StringBuilder();
    char prev = input.charAt(0);
    int counter = 0;

    for (int i = 0; i < input.length(); ++i) {
      char cur = input.charAt(i);
      if (cur == prev) {
        ++counter;
        continue;
      }
      sb.append(prev).append(counter > 1 ? counter : "");
      prev = cur;
      counter = 1;
    }
    sb.append(prev).append(counter > 1 ? counter : "");

    return sb.toString();
  }
}
