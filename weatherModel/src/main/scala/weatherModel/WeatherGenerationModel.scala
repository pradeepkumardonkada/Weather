package weatherModel

import java.util.Date

abstract class WeatherGenerationModel {
   def generateWeatherParameters(ws: WeatherStation, dt: Date) : WeatherParameters
}