A = load '/hadoopmorningbatch/file1.txt';
B = FOREACH A GENERATE flatten(TOKENIZE((chararray) $0)) as word;
C = GROUP B by word;
D = FOREACH C GENERATE COUNT(B), group;
DUMP B;

