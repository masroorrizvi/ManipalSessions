A = load '/hadoopexamples/test.txt';
dump A;
B = foreach A generate flatten(TOKENIZE((chararray)$0)) as word;
dump B;
C = group B by word;
dump C;
D = foreach C generate COUNT(B), group;
dump D
