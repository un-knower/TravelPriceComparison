package com.mobin.putDataToHBase;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by hadoop on 3/10/16.
 * ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 Job job = context.getBean("putDataToHBaseJob", Job.class);
 JobRunner jobRunner = context.getBean("putDataToHBaseJobRunner",JobRunner.class);
 */
public class PutDataToHBaseDefault extends Mapper<LongWritable, Text, ImmutableBytesWritable, Put> {

    protected void map(LongWritable key, Text value,
                       Context context)
            throws IOException, InterruptedException {
        String[] values = value.toString().split("\t");
        String rowkey = values[1]+values[2]+values[14];
        Put put = new Put(Bytes.toBytes(rowkey));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("URL"), Bytes.toBytes(values[0]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("SP"), Bytes.toBytes(values[1]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("EP"), Bytes.toBytes(values[2]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("ST"), Bytes.toBytes(values[4]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("ET"), Bytes.toBytes(values[5]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("SIGHTS"), Bytes.toBytes(values[3]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("ALLDATE"), Bytes.toBytes(values[7]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("HOTEL"), Bytes.toBytes(values[6]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("TOTALPRICE"), Bytes.toBytes(values[8]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("TRAFFIC"), Bytes.toBytes(values[9]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("TRAVELTYPE"), Bytes.toBytes(values[10]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("IMAGE"), Bytes.toBytes(values[11]));
        put.addColumn(Bytes.toBytes("INFO"),Bytes.toBytes("SUPPLIER"), Bytes.toBytes(values[12]));

        context.write(new ImmutableBytesWritable(Bytes.toBytes(rowkey)),put);
    }
}