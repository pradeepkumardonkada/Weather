
//Class that takes latitude, longitude and altitude as inputs and returns Location as output

package weatherModel

/**
 * @GeoCoordinate This class latitude, longitude and altitude as input returns Location from the reference data
 * For any location that is not present in the reference data "Unknown" is returned as the location
 */

class GeoCoordinate (latitude: Double, longitude: Double, altitude: Double) {
  private var unknown: Boolean = false
  
  override def toString() : String = {
    if (!unknown) {
      return "" + latitude + "," + longitude + "," + altitude
    }
    return "Location unknown"
  }
  
  def setUnknown = {
    unknown = true
  }
}