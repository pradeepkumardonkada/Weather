
/** Class with all the weather parameters defined.
 *  
 */

package weatherModel

class WeatherParameters (var temperature: Double, // In °C
  var pressure: Double,  // in hPa
  var humidity: Double,  // as a Percentage - not a fraction
  var rain: Double,    //  in mm
  var conditions: String) {
  override def toString(): String = {
    conditions + "|" + temperature + "|" + pressure + "|" + humidity //Generates data in required output format
  }  
}