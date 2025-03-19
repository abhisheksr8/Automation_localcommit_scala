package io.prophecy.pipelines.automation_localcommit_scala_pipeline

import io.prophecy.libs._
import io.prophecy.pipelines.automation_localcommit_scala_pipeline.config._
import io.prophecy.pipelines.automation_localcommit_scala_pipeline.functions.UDFs._
import io.prophecy.pipelines.automation_localcommit_scala_pipeline.functions.PipelineInitCode._
import io.prophecy.pipelines.automation_localcommit_scala_pipeline.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_test_dataset = test_dataset(context)
    val df_reformat_config_column =
      reformat_config_column(context, df_test_dataset)
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Automation_localcommit_scala_Pipeline")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Automation_localcommit_scala_Pipeline"
    )
    spark.conf.set("spark.default.parallelism",             "4")
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")
    registerUDFs(spark)
    MetricsCollector.instrument(
      spark,
      "pipelines/Automation_localcommit_scala_Pipeline"
    ) {
      apply(context)
    }
  }

}
