package com.causes.warehouse.batch.demo.controller;

import com.causes.warehouse.batch.demo.job.ETLJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("batch/job")
public class BatchJobController {

    @Autowired
    private ETLJob etlJob;

    @GetMapping("demo")
    public void demo() {
        etlJob.main();
    }
}