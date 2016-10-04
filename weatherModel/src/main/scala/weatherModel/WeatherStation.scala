
package weatherModel

class WeatherStation (private var name: String, private var IATACode: String, private var geoCoordinate: GeoCoordinate) {
  
//  var name: String = nam
//  var IATACode: String = iata
//  var geoCoordinate =  location 
  
  var weatherParameters: Array[WeatherParametersMinMax] = new Array[WeatherParametersMinMax](13)
  
  def addWeatherParametersForMonth(month: Int, wp: WeatherParametersMinMax) {
    weatherParameters(month) = wp
  }
  
  
  
  override def toString(): String = {
    var str: String = ""
    for(i <- 1 to 12) {
        if (weatherParameters(i) != null) {
          str = str.concat(monthLabels(i) + ":" + weatherParameters(i).toString() + "\n")
        }
    }
    "-------------------" + name + "----------------------------\n"  +
    str
  }

  def getName = { name }
  def getIATACode = { IATACode }
  def getGeoCoordinate = { geoCoordinate }

  
  def monthLabels(x: Int): String = x match {
    case 1 => "Jan"
    case 2 => "Feb"
    case 3 => "Mar"
    case 4 => "Apr"
    case 5 => "May"
    case 6 => "Jun"
    case 7 => "Jul"
    case 8 => "Aug"
    case 9 => "Sep"
    case 10 => "Oct"
    case 11 => "Nov"
    case 12 => "Dec"
    case _ => "many"
  }
 
}







