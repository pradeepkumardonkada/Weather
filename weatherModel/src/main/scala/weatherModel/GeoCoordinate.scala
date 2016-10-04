

package weatherModel

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