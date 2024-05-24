# 数仓

数据仓库项目

## 依赖版本

**MinIO**

对象存储采用 MinIO

**Spark**

Spark 版本采用 3.1.2

**Hive**

Hive 版本采用 [3.1.3](https://dlcdn.apache.org/hive/hive-3.1.3/)，另需要与 MinIO 的连接 jars

```text
aws-java-sdk-1.12.363.jar
aws-java-sdk-api-gateway-1.12.363.jar
aws-java-sdk-bundle-1.12.363.jar
aws-java-sdk-core-1.12.363.jar
aws-java-sdk-s3-1.12.363.jar
aws-lambda-java-core-1.2.2.jar
hadoop-aws-3.2.2.jar

com.amazonaws.services.s3-1.0.0.jar
```
