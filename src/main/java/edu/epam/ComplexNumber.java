package edu.epam;

/**
 * c = a + bi
 * <p>
 * i = √(-1) i^2 = -1
 * <p>
 * Re(c) = a Im(c) = b
 */
public class ComplexNumber {

  private final double re;
  private final double im;

  public ComplexNumber(double re, double im) {
    this.re = re;
    this.im = im;
  }

  @Override
  public boolean equals(Object obj) {
    if (super.equals(obj)) {
      return true;
    }
    if (obj == null || obj.getClass() != ComplexNumber.class) {
      return false;
    }

    ComplexNumber c = (ComplexNumber) obj;
    return Double.doubleToLongBits(re) == Double.doubleToLongBits(c.re)
        && Double.doubleToLongBits(im) == Double.doubleToLongBits(c.im);
  }

  public double re() {
    return this.re;
  }

  public double im() {
    return im;
  }

  /**
   * r(c) = |c| = √(a²+b²)
   * <p>
   * a² + b² = c² c = √(a²+b²)
   */
  public double radius() {
    return Math.hypot(re, im);
  }

  /**
   * 𝛗(c) = atan2(Re(c), Im(c))
   */
  public double phi() {
    return Math.atan2(re, im);
  }

  /**
   * c = a + bi conj(c) = a - bi
   */
  public ComplexNumber conjugate() {
    return new ComplexNumber(re, -im);
  }

  /**
   * cⁿ = rⁿ(cos(n𝛗) + isin(n𝛗)) Re(cⁿ) = rⁿ cos(n𝛗) Im(cⁿ) = rⁿ sin(n𝛗)
   */
  public ComplexNumber pow(int n) {
    double r = radius(),
        phi = phi();
    return new ComplexNumber(
        Math.pow(r, n) * Math.cos(n * phi),
        Math.pow(r, n) * Math.sin(n * phi)
    );
  }

  /**
   * negate(c) = -c
   */
  public ComplexNumber negate() {
    return new ComplexNumber(-re, -im);
  }

  public static ComplexNumber sum(ComplexNumber a, ComplexNumber b) {
    return new ComplexNumber(a.re + b.re, a.im + b.im);
  }

  public static ComplexNumber sub(ComplexNumber a, ComplexNumber b) {
    return sum(a, b.negate());
  }

  /**
   * c = a + bi z = u + wi c * z = (a + bi)(u + wi) = au + awi + bui + bwi^2 = (au - bw) + (aw + bu)i
   */
  public static ComplexNumber mul(ComplexNumber a, ComplexNumber b) {
    return new ComplexNumber(
        a.re * b.re - a.im * b.im,
        a.re * b.im + a.im * b.re
    );
  }

  /**
   * ln(c) = ln(r) + i𝛗
   */
  public static ComplexNumber ln(ComplexNumber c) {
    double r = c.radius(),
        phi = c.phi();
    return new ComplexNumber(Math.log(r), phi);
  }
}
