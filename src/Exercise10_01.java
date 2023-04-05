public class Exercise10_01 {

  public int hour = 1;
  public int minute = 1;
  public int second = 1;

  Exercise10_01() {
    int time = (int)System.currentTimeMillis();
    setTime(time);
  }

  Exercise10_01(int millis) { setTime(millis); }

  Exercise10_01(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public void setTime(int mili) {
    this.hour = ((mili / (1000 * 60 * 60)) % 24);
    this.minute = ((mili / (1000 * 60)) % 60);
    this.second = (int)((mili / 1000) % 60);
  }

  public int getHour() { return hour; }
  public int getMinute() { return minute; }
  public int getSecond() { return second; }

  public static void main(String[] args) {

    Exercise10_01 time1 = new Exercise10_01();
    Exercise10_01 time2 = new Exercise10_01(555550000);
    Exercise10_01 time3 = new Exercise10_01(5, 23, 55);

    System.out.println(time1.hour + ":" + time1.minute + ":" + time1.second);
    System.out.println(time2.hour + ":" + time2.minute + ":" + time2.second);
    System.out.println(time3.hour + ":" + time3.minute + ":" + time3.second);
  }
}
