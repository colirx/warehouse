package com.causes.warehouse.batch.demo.job;

import com.alibaba.fastjson2.JSON;
import com.causes.warehouse.batch.demo.pojo.Demo;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ETLJob extends BaseJob {

    @Override
    protected Object start() {
        Demo demo = new Demo("1", "name", "age");
        JavaRDD<Demo> rdd = jsc.parallelize(Collections.singletonList(demo));
        Dataset<Row> ds = spark.createDataFrame(rdd.rdd(), Demo.class);
        ds.show();
        String s = JSON.toJSONString(ds);
        return s;
    }
}