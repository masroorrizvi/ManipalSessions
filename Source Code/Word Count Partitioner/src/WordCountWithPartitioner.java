import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountWithPartitioner {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage: WordCountWithPartitioner <input path> <output path>");
      System.exit(-1);
    }
    
	//Job Related Configurations
	Configuration conf = new Configuration();
	Job job = new Job(conf, "My Word Count Partitioner");
	job.setJarByClass(WordCountWithPartitioner.class);

    
    // Specify the number of reducer to 6
    job.setNumReduceTasks(7);
    
    // Set the partitioner
    job.setPartitionerClass(WordCountPartitioner.class);
    
    //Set the location to read input file and files
    FileInputFormat.setInputPaths(job, new Path(args[0]));
   
    
    //Provide paths to pick the output file for the job, and delete it if already present
	Path outputPath = new Path(args[1]);
	FileOutputFormat.setOutputPath(job, outputPath);
	outputPath.getFileSystem(conf).delete(outputPath, true);

    
    //Set the mapper and reducer.
    job.setMapperClass(WordCountMapper.class);
    job.setReducerClass(WordCountReducer.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
