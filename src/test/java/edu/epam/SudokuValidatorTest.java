package edu.epam;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SudokuValidatorTest {

  @Test
  void positive() {
    Integer[][] field = {
        {   5,    3, null,    null,    7, null,    null, null, null},
        {   6, null, null,       1,    9,    5,    null, null, null},
        {null,    9,    8,    null, null, null,    null,    6, null},
        
        {   8, null, null,    null,    6, null,    null, null,    3},
        {   4, null, null,       8, null,    3,    null, null,    1},
        {   7, null, null,    null,    2, null,    null, null,    6},
        
        {null,    6, null,    null, null, null,       2,    8, null},
        {null, null, null,       4,    1,    9,    null, null,    5},
        {null, null, null,    null,    8, null,    null,    7,    9}
    };
    assertTrue(SudokuValidator.isValid(field));
  }

  @Test
  void negative() {
    Integer[][] field = {
        {   8,    3, null,    null,    7, null,    null, null, null},
        {   6, null, null,       1,    9,    5,    null, null, null},
        {null,    9,    8,    null, null, null,    null,    6, null},
        
        {   8, null, null,    null,    6, null,    null, null,    3},
        {   4, null, null,       8, null,    3,    null, null,    1},
        {   7, null, null,    null,    2, null,    null, null,    6},
        
        {null,    6, null,    null, null, null,       2,    8, null},
        {null, null, null,       4,    1,    9,    null, null,    5},
        {null, null, null,    null,    8, null,    null,    7,    9}
    };
    assertFalse(SudokuValidator.isValid(field));
  }

  @Test
  void negativeBlock() {
    Integer[][] field = {
        {   1, null, null,    null, null, null,    null, null, null},
        {null,    2, null,    null, null, null,    null, null, null},
        {null, null,    3,    null, null, null,    null, null, null},

        {null, null, null,       4, null, null,    null, null, null},
        {null, null, null,    null,    5, null,    null, null, null},
        {null, null, null,    null, null,    6,    null, null, null},
                                                   
        {null, null, null,    null, null, null,       7, null, null},
        {null, null, null,    null, null, null,    null,    8,    7},
        {null, null, null,    null, null, null,    null, null,    9},
    };
    assertFalse(SudokuValidator.isValid(field));
  }
  
  @Test
  void invalidSizes() {
    Integer[][] field = {
        {   1, null, null,    null, null, null,    null, null, null},
        {null,    1, null,    null, null, null,    null, null, null},
        {null, null,    1,    null, null, null,    null, null, null},

        {null, null, null,       1, null, null,    null, null, null},
        {null, null, null,    null,    1, null},
        {null, null, null,    null, null,    1,    null, null, null},

        {null, null, null,    null, null, null,       1, null, null},
        {null, null, null,    null, null, null,    null,    1, null},
        {null, null, null,    null, null, null,    null, null,    1},
    };
    assertFalse(SudokuValidator.isValid(field));
  }
  
  @Test
  void nullCheck() {
    assertFalse(SudokuValidator.isValid(null));
  }
}