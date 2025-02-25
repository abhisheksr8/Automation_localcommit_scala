package io.prophecy.pipelines.pipelineautomation_release_api_1739141078786

import io.prophecy.libs._
import io.prophecy.pipelines.pipelineautomation_release_api_1739141078786.config._
import io.prophecy.pipelines.pipelineautomation_release_api_1739141078786.functions.UDFs._
import io.prophecy.pipelines.pipelineautomation_release_api_1739141078786.functions.PipelineInitCode._
import io.prophecy.pipelines.pipelineautomation_release_api_1739141078786.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_Project_Automation_scala_RELEASE_API_1739141078786_dataSet =
      Project_Automation_scala_RELEASE_API_1739141078786_dataSet(context)
    val df_customer_details_selection = customer_details_selection(
      context,
      df_Project_Automation_scala_RELEASE_API_1739141078786_dataSet
    )
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Pipeline-Automation_RELEASE_API_1739141078786")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Pipeline-Automation_RELEASE_API_1739141078786"
    )
    spark.conf.set("spark.default.parallelism",             "4")
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")
    registerUDFs(spark)
    MetricsCollector.instrument(
      spark,
      "pipelines/Pipeline-Automation_RELEASE_API_1739141078786"
    ) {
      apply(context)
    }
  }

}
