REGISTER '/home/cloudera/hadoopmorningbatch/pig/custompigudf.jar';

A = load '/hadoopmorningbatch/input/pig/custompiginput.txt' using PigStorage (',') as (FName:	chararray, LName: chararray, MobileNo: chararray, City: chararray, Profession: chararray);

B = FOREACH A GENERATE CustomPigUDF(FName), CustomPigUDF(LName), MobileNo, CustomPigUDF(City), CustomPigUDF(Profession);	 

dump B; 
