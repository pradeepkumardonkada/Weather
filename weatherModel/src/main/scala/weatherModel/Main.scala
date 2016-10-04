package weatherModel

object WS{
  def main(args: Array[String]){
    TestDataGenerator.importReferenceData
    TestDataGenerator.generateTestData(RangeBasedRandomWeatherGenerationModel)
   }
}