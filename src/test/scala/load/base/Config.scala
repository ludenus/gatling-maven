package load.base

import com.typesafe.config.{ConfigBeanFactory, ConfigFactory}

import scala.beans.BeanProperty

trait Config {
  val config = ConfigBeanFactory.create(ConfigFactory.load(), classOf[TestConfig]);
}

class TestConfig {
  @BeanProperty var loadProfile: LoadProfile = null
  @BeanProperty var cardservice: Cardservice = null

  override def toString = s"TestConfig(loadProfile=$loadProfile, cardservice=$cardservice)"
}

class LoadProfile {
  @BeanProperty var waitSeconds = 1
  @BeanProperty var rampUsers = 10
  @BeanProperty var rampSeconds = 10
  @BeanProperty var maxDurationSeconds = 20
  @BeanProperty var expectedResponseTimeMsec = 4000

  override def toString = s"LoadProfile(waitSeconds=$waitSeconds, rampUsers=$rampUsers, rampSeconds=$rampSeconds, maxDurationSeconds=$maxDurationSeconds, expectedResponseTimeMsec=$expectedResponseTimeMsec)"
}

class Cardservice {
  @BeanProperty var url = "http://cardservice:8080"

  override def toString = s"Cardservice(url=$url)"
}