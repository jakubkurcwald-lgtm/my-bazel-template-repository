package example.scala

import com.google.common.base.Joiner
import org.apache.commons.lang3.StringUtils
import scala.jdk.CollectionConverters._

object Greeting {
  def forNames(names: Seq[String]): String =
    s"Hello, ${Joiner.on(", ").join(names.map(name => StringUtils.capitalize(name)).asJava)}!"
}
