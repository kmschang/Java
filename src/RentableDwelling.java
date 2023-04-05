public abstract class RentableDwelling {

  private double rentPerUnit;

  public RentableDwelling(double rentPerUnit) {
    this.rentPerUnit = rentPerUnit;
  }

  public double getRentPerUnit() { return rentPerUnit; }

  public abstract double getRentalIncome();
}

class ApartmentHouse extends RentableDwelling {

  int numberOfApartments;

  ApartmentHouse(double rentPerUnit, int numberOfApartments) {
    super(rentPerUnit);
    this.numberOfApartments = numberOfApartments;
  }

  public double getRentalIncome() {
    return this.numberOfApartments * getRentPerUnit();
  }
}
