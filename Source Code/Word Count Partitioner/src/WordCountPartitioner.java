

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;



public class WordCountPartitioner extends Partitioner<Text,IntWritable> {

	@Override
    public int getPartition(Text key, IntWritable value, int numReduceTasks) {
		
		String name = key.toString();
		
		if (name.equals("This")){	
			return 1;
		} else if (name.equals("is")) {
			return 2;
		} else if (name.equals("a")) {
			return 3;
		} else if (name.equals("wonderful")) {
			return 4;
		} else if (name.equals("hadoop")) {
			return 5;
		} else if (name.equals("class")) {
			return 6;
		}else {
			return 0;
		}		
    }
}

