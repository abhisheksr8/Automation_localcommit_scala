package io.prophecy.pipelines.pipelineautomation_release_api_1753991169059

import io.prophecy.libs._
import io.prophecy.pipelines.pipelineautomation_release_api_1753991169059.config._
import io.prophecy.pipelines.pipelineautomation_release_api_1753991169059.functions.UDFs._
import io.prophecy.pipelines.pipelineautomation_release_api_1753991169059.functions.PipelineInitCode._
import io.prophecy.pipelines.pipelineautomation_release_api_1753991169059.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit = {
    val df_Project_Automation_scala_RELEASE_API_1753991169059_dataSet =
      Project_Automation_scala_RELEASE_API_1753991169059_dataSet(context)
    val df_select_customer_details = select_customer_details(
      context,
      df_Project_Automation_scala_RELEASE_API_1753991169059_dataSet
    )
  }

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("Pipeline-Automation_RELEASE_API_1753991169059")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri",
                   "pipelines/Pipeline-Automation_RELEASE_API_1753991169059"
    )
    spark.conf.set("spark.default.parallelism",             "4")
    spark.conf.set("spark.sql.legacy.allowUntypedScalaUDF", "true")
    registerUDFs(spark)
    MetricsCollector.instrument(
      spark,
      "pipelines/Pipeline-Automation_RELEASE_API_1753991169059"
    ) {
      apply(context)
    }
  }

}
