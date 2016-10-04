/*Abstract class for Weather Generation Model. In future, if any other methodology other than
Random Based Weather Generation is used, this abstract class can be used with the new method as well*/

package weatherModel

import java.util.Date

abstract class WeatherGenerationModel {
   def generateWeatherParameters(ws: WeatherStation, dt: Date) : WeatherParameters
}