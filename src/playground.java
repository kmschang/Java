// Playground

class playground {
  public static void main(String[] args) { System.out.println("Hello World"); }
}

interface eddible {
  public abstract String howToEat();
}

class Animal {
  public void message() { System.out.println("This is an animal"); }
}

class Chicken extends Animal implements eddible {
  public void message() { System.out.println("This is a chicken"); }

  @Override
  public String howToEat() {
    return "Fry it";
  }
}

class Tiger extends Animal {
  public void message() { System.out.println("This is a tiger"); }
}
