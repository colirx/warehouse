package com.causes.warehouse.batch.demo.job;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public abstract class BaseJob {

    protected static JavaSparkContext jsc = null;
    protected static SparkSession spark;

    public void main() {
        setup();
        before();
        start();
        end();
    }

    protected void setup() {
        // 同一时刻内，JVM 中只能存在一个 SparkContext
        if (Objects.isNull(jsc) && Objects.isNull(spark)) {
            synchronized (this) {
                if (Objects.isNull(jsc) && Objects.isNull(spark)) {
                    SparkConf conf = new SparkConf().setAppName("warehouse").setMaster("local[*]")
                            .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
                    // conf.registerKryoClasses();
                    // List<Class<?>> classes = Arrays.asList(Demo.class);
                    // TODO: KRYO 序列化添加 https://tongyi.aliyun.com/qianwen/share?shareId=6a940545-243e-498a-bd86-02b7cef5c330
                    // classes.toArray()
                    Map<String, String> props = buildExtraProps();
                    props.keySet().forEach(key -> conf.set(key, props.get(key)));
                    jsc = new JavaSparkContext(conf);
                    spark = new SparkSession.Builder().sparkContext(jsc.sc()).getOrCreate();
                }
            }
        }
    }

    private Map<String, String> buildExtraProps() {
        return new HashMap<>();
    }

    protected void before() {

    }

    protected Object start() {

        return null;
    }

    protected void end() {
        spark.close();
        jsc.close();
        spark = null;
        jsc = null;
    }
}