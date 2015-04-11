register '/home/cloudera/hadoopmorningbatch/pig/piggybank-0.12.1.jar'
pigdata = load '/hadoopmorningbatch/input/pig/xmlinput.txt' using org.apache.pig.piggybank.storage.XMLLoader('name') as (doc:chararray);

values = foreach pigdata GENERATE FLATTEN(REGEX_EXTRACT_ALL(doc,'<name>(.*)</name>')) AS (name:chararray);

dump values;
