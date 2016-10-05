
/** @Author: Pradeep Kumar Donkada
 * Program : Random number based test data generator for testing weather models
 * 
 * @notes: The files ReferenceData.csv (Reference Data that used as input to the model) and
 *            TestDataRequests.csv (user input file for generating test data) are placed in the resources folder
 *            within the main folder.
 */

package weatherModel
import java.io.File
object WS{
  def main(args: Array[String]){

    if (args.length == 0) {
      println("Please provide the path where ReferenceData and TestDataRequst files are located as the first argument")
    }
    var f: File = new File(args(0))
    if (!f.exists || !f.isDirectory()) {
        println("The path provided doesn't exist or is not a FileFolder")
        return
    }
    var inputFile = "";
    inputFile = "ReferenceData.csv"      
    if (!new java.io.File(args(0) + "/" +  inputFile).exists) {
        println("File " + inputFile + " is not found")
        return
    }
      inputFile = "TestDataRequests.csv"
    if (!new java.io.File(args(0) + "/" +  inputFile).exists) {
        println("File " + inputFile + " is not found")
        return
    }
    
    TestDataGenerator.importReferenceData(args(0))

   /*
    * WeatherGenerationModel to be used in this test data generation is RangeBasedRandom. However in the future if other
    * WeatherGenerationModels become available, they can be used here to generate the test data with those models.
    */
    TestDataGenerator.generateTestData(args(0), RangeBasedRandomWeatherGenerationModel)
  
  }
 }

