# Weather

Process Flow /Model Flow

1. main calls the class TestDataGenerator
2. Class TestDataGenerator loads 
    a) "Reference data" about weather stations from csv file (Referencedata.csv) - This file is saved in src/main/resources folder. 
       This file has actual readings of different weather stations for different months
    b) "Test requests data" - user input file (TestDataRequests.csv) containing the weather station and month details for which the test data has to be generated
        from the model. - This file is also saved in in src/main/resources folder.
3. Data downloaded from step 2 contains min max weather parameters for eg. (for eg. min temperature and max temperature) and location information, which is used for generating test data to test weather model.
4. Using the random generator TestDataGenerator generates test data in terms of weather parameters. The process has been detailed in the class
   RandomWeatherGenerationModel
