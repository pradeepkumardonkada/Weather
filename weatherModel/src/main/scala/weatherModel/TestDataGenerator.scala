package weatherModel

import java.util.Date
import java.util.Calendar
import java.text.SimpleDateFormat
import scala.util.Random
//import weatherModel.GeoCoordinate

object TestDataGenerator {
  val referenceMap = scala.collection.mutable.HashMap.empty[String, WeatherStation]

  def importReferenceData {
    var relPath = new java.io.File(".").getAbsolutePath();
    relPath = relPath.substring(0,relPath.length()-2)
    var referenceFiletoImport =  relPath + "/src/main/resources/testdata.csv"

    val bufferedSource = io.Source.fromFile(referenceFiletoImport)

    for (line <- bufferedSource.getLines().drop(1)) {

      val inputFields = line.split(",").map(_.trim)
      val name = inputFields(0)
      val minWp = new WeatherParameters(inputFields(1).toDouble,
        inputFields(3).toDouble,
        inputFields(5).toDouble,
        inputFields(6).toDouble,
        inputFields(7))
      val maxWp = new WeatherParameters(inputFields(2).toDouble,
        inputFields(4).toDouble,
        inputFields(5).toDouble,
        inputFields(6).toDouble,
        inputFields(7))

      val month = inputFields(8).toInt
      val IATACode = inputFields(9)
      var ws: WeatherStation = referenceMap.getOrElse(IATACode, new WeatherStation(name, IATACode, 
          //new GeoCoordinate(inputFields(10).toDouble, inputFields(11).toDouble, inputFields(12).toDouble)))
          new GeoCoordinate(Random.nextDouble() * 180, Random.nextDouble() * 180, Random.nextInt())))
      if (!referenceMap.contains(IATACode)) {
        referenceMap += IATACode -> ws
      }
      val wpMinMax = new WeatherParametersMinMax(minWp, maxWp)
      ws.addWeatherParametersForMonth(month, wpMinMax)
    }
  }

  def generateTestData(model: WeatherGenerationModel) = {
    var testRequestsFiletoImport = new java.io.File(".").getAbsolutePath() + "/src/main/resources/DataRequests.csv"
    val bufferedSource = io.Source.fromFile(testRequestsFiletoImport)

    for (line <- bufferedSource.getLines().drop(1)) {
      val testRequestsArray = line.split(",").map(_.trim)
      val weatherStationRequested = testRequestsArray(0)
      val dateRequested = getDateFromString(testRequestsArray(1))

      //println(s"$weatherStationRequested, $dateRequested")

      val ws = referenceMap.getOrElse(weatherStationRequested, referenceMap.head._2)
      if (!ws.getIATACode.equals(weatherStationRequested)) {
        ws.getGeoCoordinate.setUnknown;
      }
      val wp = model.generateWeatherParameters(ws, dateRequested)

      // println(weatherStationRequested + " " + testRequestsArray(1) + "T" + getRandomTime + " " + wp )
      println(weatherStationRequested + "|" + ws.getGeoCoordinate.toString() + "|" + convertDateToString(dateRequested) + "|" + wp)

    }
  }

  def getMonthFromDateString(dateStr: String): Int = {
    var cal = Calendar.getInstance()
    cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr))
    cal.get(Calendar.MONTH) + 1
  }

  def getMonthFromDate(dt: Date): Int = {
    var cal = Calendar.getInstance()
    cal.setTime(dt)
    cal.get(Calendar.MONTH) + 1
  }
  
  def getDateFromString(dateStr: String): Date = {
    var cal = Calendar.getInstance()
    addRandomTime(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr))
  }
  
  def convertDateToString(dateStr: Date): String = {
    val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    format.format(dateStr);
  }

  def addRandomTime(date: Date): Date = {
    var cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.SECOND, Random.nextInt(86399));
    cal.getTime();   
  }

}
   