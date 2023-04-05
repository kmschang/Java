public abstract class Vehicle {

  private double maxSpeed;
  protected double currentSpeed;

  public Vehicle(double maxSpeed) { this.maxSpeed = maxSpeed; }

  public abstract void accelerate();

  public double getCurrentSpeed() { return this.currentSpeed; }

  public double getMaxSpeed() { return this.maxSpeed; }

  public void pedalToTheMetal() {
    while (this.currentSpeed < this.maxSpeed) {
      accelerate();
    }
  }
}
