package edu.epam;

import java.util.Arrays;

public class SudokuValidator {

  /**
   * Checks if {@code field} is a valid sudoku field.
   * 
   * If field either:
   *  - is null
   *  - is not 9x9 matrix
   *  - contains duplicate on any row
   *  - contains duplicate on any column
   *  - contains duplicate in any 3x3 sudoku block
   *  - contains an integer value out of the [1-9] range
   * then this field is invalid.
   */
  public static boolean isValid(Integer[][] field) {
    if (field == null) {
      return false;
    }
    
    {
      // sizes
      boolean sizeCheck = field.length == 9;
      for (int i = 0; i < 9; ++i) {
        sizeCheck &= field[i].length == 9; // a &= b   ===   a = a && b
      }
      if (!sizeCheck) {
        return false;
      }
    }
    
    boolean[] digits = new boolean[9];

    {
      // rows
      for (int row = 0; row < 9; ++row) {
        Arrays.fill(digits, false);
        for (int column = 0; column < 9; ++column) {
          if (!isValidCell(field[row][column], digits)) {
            return false;
          }
        }
      }
    }
    
    {
      // columns
      for (int column = 0; column < 9; ++column) {
        Arrays.fill(digits, false);
        for (int row = 0; row < 9; ++row) {
          if (!isValidCell(field[row][column], digits)) {
            return false;
          }
        }
      }
    }

    {
      // blocks
      for (int startBlockRow = 0; startBlockRow < 9; startBlockRow += 3) {
        for (int startBlockCol = 0; startBlockCol < 9; startBlockCol += 3) {
          Arrays.fill(digits, false);
          for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 3; ++column) {
              if (!isValidCell(field[startBlockRow + row][startBlockCol + column], digits)) {
                return false;
              }
            }
          }
        }
      }
    }

    return true;
  }
  
  private static boolean isValidCell(Integer cell, boolean[] digits) {
    if (cell == null) {
      return true;
    }
    if (cell < 1 || cell > 9) {
      return false;
    }
    if (digits[cell - 1]) {
      return false;
    }
    digits[cell - 1] = true;
    return true;
  }
}
