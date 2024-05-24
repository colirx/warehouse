package com.causes.warehouse.batch.demo.job;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class DemoJob {
    protected static JavaSparkContext jsc = null;
    protected static SparkSession spark;

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("warehouse").setMaster("local[*]");
        jsc = new JavaSparkContext(conf);
        spark = new SparkSession.Builder().sparkContext(jsc.sc()).getOrCreate();
        spark.sql("SELECT 1, now()").show();
    }
}
