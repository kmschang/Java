import java.math.BigInteger;

class Rational extends Number implements Comparable<Rational> {
  // Data fields for numerator and denominator
  private BigInteger numerator = BigInteger.ZERO;
  private BigInteger denominator = BigInteger.ONE;

  public Rational() {}

  public Rational(BigInteger numerator, BigInteger denominator) {
    if (denominator.compareTo(BigInteger.ZERO) > 0) // checks if denominator is larger than 0
    {
      this.numerator = numerator;
      this.denominator = denominator;
    } else if (denominator.compareTo(BigInteger.ZERO) < 0) // checks if denominator is negative
    {
      numerator = numerator.negate();
      denominator = denominator.negate();
      this.numerator = numerator;
      this.denominator = denominator;
    }
    BigInteger gcd;
    // gcd of numerator and denominator
    gcd = this.numerator.gcd(this.denominator);
    this.numerator = this.numerator.divide(gcd);
    this.denominator = this.denominator.divide(gcd);
  }
  /**
   * This method converts the rational number to a string.
   */
  @Override
  public String toString() {
    return (this.numerator + "/" + this.denominator);
  }

  public Rational add(Rational num) {
    Rational reNum = new Rational();
    BigInteger numerator1 = this.numerator;
    BigInteger denominator1 = this.denominator;
    BigInteger numerator2 = num.numerator;
    BigInteger denominator2 = num.denominator;
    reNum.numerator = numerator1.multiply(denominator2).add(numerator2.multiply(denominator1));
    reNum.denominator = denominator1.multiply(denominator2);
    return reNum;
  }

  public Rational subtract(Rational num) {
    Rational reNum = new Rational();
    BigInteger numerator1 = this.numerator;
    BigInteger denominator1 = this.denominator;
    BigInteger numerator2 = num.numerator;
    BigInteger denominator2 = num.denominator;
    reNum.numerator = numerator1.multiply(denominator2).subtract(numerator2.multiply(denominator1));
    reNum.denominator = denominator1.multiply(denominator2);
    return reNum;
  }

  public Rational multiply(Rational num) {
    Rational reNum = new Rational();
    BigInteger numerator1 = this.numerator;
    BigInteger denominator1 = this.denominator;
    BigInteger numerator2 = num.numerator;
    BigInteger denominator2 = num.denominator;
    reNum.numerator = numerator1.multiply(numerator2);
    reNum.denominator = denominator1.multiply(denominator2);
    return reNum;
  }

  public Rational divide(Rational num) {
    Rational reNum = new Rational();
    BigInteger numerator1 = this.numerator;
    BigInteger denominator1 = this.denominator;
    BigInteger numerator2 = num.numerator;
    BigInteger denominator2 = num.denominator;
    reNum.numerator = numerator1.multiply(denominator2);
    reNum.denominator = denominator1.multiply(numerator2);
    return reNum;
  }

  @Override
  public long longValue() {
    return (long)(numerator.doubleValue() / denominator.doubleValue());
  }

  @Override
  public float floatValue() {
    return numerator.floatValue() / denominator.floatValue();
  }

  @Override
  public double doubleValue() {
    return numerator.doubleValue() / denominator.doubleValue();
  }

  @Override
  public int compareTo(Rational o) {
    return Double.compare(doubleValue(), o.doubleValue());
  }

  @Override
  public int intValue() {
    return (int)(numerator.doubleValue() / denominator.doubleValue());
  }
}
