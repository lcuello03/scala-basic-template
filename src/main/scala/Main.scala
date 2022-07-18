import com.snowflake.snowpark._
import com.snowflake.snowpark.functions._
object Main extends App {
  // If you just want to use Scala (without Snowpark) you can start right with the following line of code
  println("Hello, World!")

  // If you want to use Snowpark, you can use this code to build a connection and run a basic query
  // This session is configured to use the current active connection (which you can modify using the SQL Tools extension)
  val configs = Map (
    "URL" -> s"https://${sys.env("SNOW_ACCOUNT")}.snowflakecomputing.com:443",
    "USER" -> sys.env("SNOW_USER"),
    "PASSWORD" -> sys.env("SNOW_PASSWORD"),
    "ROLE" -> sys.env("SNOW_ROLE"),
    "WAREHOUSE" -> sys.env("SNOW_WAREHOUSE"),
    "DB" -> sys.env("SNOW_DATABASE"),
    "SCHEMA" -> sys.env.getOrElse("SNOW_SCHEMA", "")
  )
  val session = Session.builder.configs(configs).create
  session.sql("SELECT 'Hello World!'").show()
}