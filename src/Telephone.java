public class Telephone {

  String number = "";
  static int quantity = 0;
  static double total = 0.0;

  public static String makeFullNumber(String number, int areaCode) {
    return areaCode + "-" + number;
  }
}
