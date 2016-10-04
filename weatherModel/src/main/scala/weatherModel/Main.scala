
/* Author: Pradeep Kumar Donkada
 * Program : Random number based test data generator for testing weather models
 * 
 * Summary of the model and model flow
 * ----------------------------------
 
1. Main() calls TestDataGenerator class
2.  Test generator loads reference data about weather stations
3.  Weather stations contain min-max weather parameters and location information
4. Test data generator generates test data in terms of weather parameters. 
5. Test data generator uses weather generation models and for this example I came up 
    with a simple range based random weather generation model. It generates weather 
    parameters within the constraints of min and max parameters 
    loaded as reference data.
  
  Input and Output Data
  ----------------------
  
  1. This model imports various weather parameters from a csv file as reference data
     (The path to the Reference csv file is in Line 22 of TestDatGenerator.scala class)
  
  2. This model assumes request for generating test data is entered in csv file. 
     (The path to the Reference csv file is in Line 57 of TestDatGenerator.scala class)
  
 */


//Main Class that imports Weather Data and generates output

package weatherModel

object WS{
  def main(args: Array[String]){
    TestDataGenerator.importReferenceData
    TestDataGenerator.generateTestData(RangeBasedRandomWeatherGenerationModel)
   }
}