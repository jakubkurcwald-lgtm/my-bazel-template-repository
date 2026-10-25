package example.jvm;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

public final class Greeting {
  private Greeting() {}

  public static String forNames(String... names) {
    return String.join(
        ", ",
        ImmutableList.copyOf(names).stream().map(StringUtils::capitalize).toList());
  }
}
