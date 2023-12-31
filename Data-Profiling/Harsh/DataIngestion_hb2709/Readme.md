# Data Cleaning and Profiling
By Harsh Bansal - hb2709
## Project Overview

This project utilizes Hadoop MapReduce to perform data filtering, frequency analysis, and volume analysis on the "Automated Traffic Volume Counts" dataset from the Department of Transportation in New York City.

## File Structure

- **data_filter.java:** Java program for filtering and cleaning the dataset.
- **data_filter_mapper.java:** Mapper class for the data filtering job.

- **freq.java:** Java program for frequency analysis.
- **freq_mapper.java:** Mapper class for the frequency analysis job.
- **freq_reducer.java:** Reducer class for the frequency analysis job.

- **stat.java:** Java program for volume analysis.
- **stat_mapper.java:** Mapper class for the volume analysis job.

- **stat_reducer.java:** Reducer class for the volume analysis job.

## Instructions

My dataset is stored under *project/atvc*

### Data Filtering

1. Compile and run the data filtering job:

   ```bash
   javac -classpath `hadoop classpath` data_filter.java data_filter_mapper.java
   jar cvf data_filter.jar data_filter.class data_filter_mapper.class data_filter_mapper\$1.class
   hadoop jar data_filter.jar data_filter <input_file_path> <output_path>
   ```

2. Compile and run the frequency analysis job

   ```bash
   javac -classpath `hadoop classpath` freq.java freq_mapper.java freq_reducer.java
   jar cvf freq.jar freq freq.class freq_mapper.class freq_reducer.class
   hadoop jar freq.jar freq <input_file_paths(files generated by data_filtering job)> <output_path>
   ```

3. Compile and run the volume analysis job

   ```bash
   javac -classpath `hadoop classpath` stat.java stat_mapper.java stat_reducer.java
   jar cvf stat.jar stat.class stat_mapper.class stat_reducer.class
   hadoop jar stat.jar stat <input_file_paths(files generated by data_filtering job)> <output_path>
   ```

For me I ran the following commands:
```bash
javac -classpath `hadoop classpath` data_filter.java data_filter_mapper.java
jar cvf data_filter.jar data_filter.class data_filter_mapper.class data_filter_mapper\$1.class
hadoop jar data_filter.jar data_filter project/atvc project/data_filter_output

javac -classpath `hadoop classpath` freq.java freq_mapper.java freq_reducer.java
jar cvf freq.jar freq freq.class freq_mapper.class freq_reducer.class
hadoop jar freq.jar freq project/data_filter_output/part* project/freq_analysis

javac -classpath `hadoop classpath` stat.java stat_mapper.java stat_reducer.java
jar cvf stat.jar stat.class stat_mapper.class stat_reducer.class
hadoop jar stat.jar stat project/data_filter_output/part* project/vol_analysis
```
### Note

Adjust the classpaths and filepaths according to the setup.