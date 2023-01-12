package edu.epam;

/**
 * c = a + bi
 * 
 * i = √(-1)
 * i^2 = -1
 * 
 * Re(c) = a
 * Im(c) = b
 */
public class ComplexNumber {
  
  public ComplexNumber(double re, double im) {
    throw new UnsupportedOperationException();
  }

  public double re() {
    throw new UnsupportedOperationException();
  }

  public double im() {
    throw new UnsupportedOperationException();
  }

  /**
   * r(c) = |c| = √(a²+b²)
   * 
   * a² + b² = c²
   * c = √(a²+b²)
   */
  public double radius() {
    throw new UnsupportedOperationException();
  }

  /**
   * 𝛗(c) = atan2(Re(c), Im(c))
   */
  public double phi() {
    throw new UnsupportedOperationException();
  }

  /**
   * c = a + bi
   * conj(c) = a - bi
   */
  public ComplexNumber conjugate() {
    throw new UnsupportedOperationException();
  }

  /**
   * cⁿ = rⁿ(cos(n𝛗) + isin(n𝛗))
   * Re(cⁿ) = rⁿ cos(n𝛗)
   * Im(cⁿ) = rⁿ sin(n𝛗)
   */
  public ComplexNumber pow(int n) {
    throw new UnsupportedOperationException();
  }

  /**
   * negate(c) = -c
   */
  public ComplexNumber negate() {
    throw new UnsupportedOperationException();
  }

  public static ComplexNumber sum(ComplexNumber a, ComplexNumber b) {
    throw new UnsupportedOperationException();
  }

  public static ComplexNumber sub(ComplexNumber a, ComplexNumber b) {
    throw new UnsupportedOperationException();
  }

  /**
   * c = a + bi
   * z = u + wi
   * c * z = (a + bi)(u + wi) = au + awi + bui + bwi^2
   *   = (au - bw) + (aw + bu)i
   */
  public static ComplexNumber mul(ComplexNumber a, ComplexNumber b) {
    throw new UnsupportedOperationException();
  }

  /**
   * ln(c) = ln(r) + i𝛗
   */
  public static ComplexNumber ln(ComplexNumber c) {
    throw new UnsupportedOperationException();
  }
}
