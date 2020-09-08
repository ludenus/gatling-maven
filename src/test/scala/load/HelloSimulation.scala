package load

import io.gatling.core.Predef._
import load.base._

class HelloSimulation extends Simulation with Log with Config {

  val scn = scenario("hello").forever {
    exec(
      ApiAuth.hello
    )
  }

  val load = scn.inject(rampUsers(2) during (2))

  setUp(load)
    .protocols(ApiAuth.protocol)
    .maxDuration(config.loadProfile.maxDurationSeconds)
    .assertions(
    forAll.failedRequests.count.is(0),
    forAll.responseTime.percentile4.lte(config.loadProfile.expectedResponseTimeMsec)
  )

}