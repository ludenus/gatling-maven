package load.base

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object ApiAuth extends Object with Log with Config {

  val protocol = http
    .baseUrl(config.cardservice.url)
    .maxConnectionsPerHost(config.loadProfile.rampUsers)
    .userAgentHeader("Gatling Performance Test")

  val hello = exec(
      http("hello")
        .post("/auth/hello")
        .check(
          status.is(200),
          jsonPath("$.nonce").exists,
          responseTimeInMillis.lte(config.loadProfile.expectedResponseTimeMsec)
        )
    )

}
