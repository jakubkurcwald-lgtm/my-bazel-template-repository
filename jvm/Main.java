package example.jvm;

public final class Main {
  private Main() {}

  public static void main(String[] args) {
    String[] names = args.length == 0 ? new String[] {"world"} : args;
    System.out.println("Hello, " + Greeting.forNames(names) + "!");
  }
}
