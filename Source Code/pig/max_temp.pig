-- max_temp.pig: Finds the maximum temperature by year
records = LOAD '/hadoopexamples/sample_pig.txt' AS (year:chararray, temperature:int, quality:int);

DUMP records;

filtered_records = FILTER records BY temperature != 9999 AND (quality == 0 OR quality == 1 OR quality == 4 OR quality == 5 OR quality == 9);

DUMP filtered_records;

grouped_records = GROUP filtered_records BY year;

DUMP grouped_records;	

max_temp = FOREACH grouped_records GENERATE group, MAX(filtered_records.temperature);

DUMP max_temp;
