/*This object generates Random Weather Test Data based on Random Numbers. It also generates
 * and assigns random weather parameters to the model
 */


package weatherModel

import scala.util.Random
import java.util.Date

object RangeBasedRandomWeatherGenerationModel extends WeatherGenerationModel {
  def generateWeatherParameters(ws: WeatherStation, dt: Date): WeatherParameters = {
   val month= TestDataGenerator.getMonthFromDate(dt)
   val wp = ws.weatherParameters(month)
   val a = Random.nextInt(10)
   val b = if (Random.nextInt(10) > 5)  1 else -1
   val c = Random.nextInt(10)
   val d = if (Random.nextInt(10) > 5)  1 else -1
   val e = Random.nextInt(10)
   val f = if (Random.nextInt(10) > 5)  1 else -1
   val conditions: Array[String] = Array("Partly Cloudy", "Cloudy", "Sunny", "Rainy", "Showers", "Drizzly", "Thunderstorm")
   val g = Random.nextInt(conditions.length-1)
   new WeatherParameters((wp.minWeatherParameters.temperature + wp.maxWeatherParameters.temperature)/2.0 + b * a,
       (wp.minWeatherParameters.pressure + wp.maxWeatherParameters.pressure)/2.0 + c * d,
       (wp.minWeatherParameters.humidity + wp.maxWeatherParameters.humidity)/2.0 + e * f,
       (wp.minWeatherParameters.rain + wp.maxWeatherParameters.rain)/2.0 + e * f,
        conditions(g) )    
  }
}
