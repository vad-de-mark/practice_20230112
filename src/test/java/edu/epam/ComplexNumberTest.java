package edu.epam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComplexNumberTest {


  private ComplexNumber c = new ComplexNumber(3d, 4d);

  @Test
  void im() {
    assertEquals(4d, c.im());
  }

  @Test
  void re() {
    assertEquals(3d, c.re());
  }

  @Test
  void radius() {
    assertEquals(5d, c.radius());
  }

  @Test
  void phi() {
    assertEquals(0.6435011087932844, c.phi());
  }

  @Test
  void conjugate() {
    assertEquals(new ComplexNumber(3d, -4d), c.conjugate());
  }

  @Test
  void negate() {
    assertEquals(new ComplexNumber(-3d, -4d), c.negate());
  }

  @Test
  void pow() {
    assertEquals(new ComplexNumber(-3116.0, -236.9999999999994), c.pow(5));
  }

  @Test
  void sum() {
    assertEquals(new ComplexNumber(7d, 1d), ComplexNumber.sum(
        c, new ComplexNumber(4d, -3d)
    ));
  }

  @Test
  void sub() {
    assertEquals(new ComplexNumber(-1d, 7d), ComplexNumber.sub(
        c, new ComplexNumber(4d, -3d)
    ));
  }

  @Test
  void mul() {
    assertEquals(new ComplexNumber(24d, 7d), ComplexNumber.mul(
        c, new ComplexNumber(4d, -3d)
    ));
  }

  @Test
  void ln() {
    assertEquals(new ComplexNumber(1.6094379124341003, 0.6435011087932844), ComplexNumber.ln(c));
  }
}