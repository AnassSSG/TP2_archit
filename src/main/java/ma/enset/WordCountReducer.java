package ma.enset;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class WordCountReducer extends Reducer<Text, IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
         int somme=0;
         Iterator<IntWritable> it= values.iterator();
         while (it.hasNext()){
             somme+=it.next().get();
         }
         context.write(key,new IntWritable(somme));
    }
}
