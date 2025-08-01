package io.prophecy.pipelines.pipelineautomation_release_api_1753991169059.config

import io.prophecy.pipelines.pipelineautomation_release_api_1753991169059.config.Context
import pureconfig.ConfigReader.Result
import pureconfig._
import pureconfig.generic.ProductHint
import pureconfig.generic.auto._
import io.prophecy.libs._
object ConfigStore

object ConfigurationFactoryImpl extends ConfigurationFactory[Config] {

  override protected def load(
    fileConfig: ConfigObjectSource
  ): Result[Config] = {
    implicit val confHint: ProductHint[Config] =
      ProductHint[Config](ConfigFieldMapping(CamelCase, CamelCase))
    fileConfig.load[Config]
  }

  def getConfig(args: Array[String]) =
    fromCLI(args,
            "",
            "io/prophecy/pipelines/pipelineautomation_release_api_1753991169059"
    )

}
