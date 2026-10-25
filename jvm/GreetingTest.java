package example.jvm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public final class GreetingTest {
  @Test
  public void capitalizesAndJoinsNames() {
    assertEquals("Bazel, World", Greeting.forNames("bazel", "world"));
  }
}
