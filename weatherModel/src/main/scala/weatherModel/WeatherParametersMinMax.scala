/**
 * Generates different objects for imported test reference data (min and max temperature) parameters
 */

package weatherModel


class WeatherParametersMinMax (var minWp: WeatherParameters, var maxWp: WeatherParameters) {
  override def toString(): String = {
    "Min: " + minWp + "\n:" + "Max: " + maxWp 
  }
  def minWeatherParameters = {  minWp }
  def maxWeatherParameters = {  maxWp }
 }