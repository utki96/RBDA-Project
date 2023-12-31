import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.io.NullWritable;

public class Filter {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: Filter <input path> <output path>");
            System.exit(-1);
        }
        

        Job job = Job.getInstance();
        job.setJarByClass(Filter.class);
        job.setJobName("Word Count");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(FilterMapper.class);
        job.setReducerClass(FilterReducer.class);
        job.setNumReduceTasks(1);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
