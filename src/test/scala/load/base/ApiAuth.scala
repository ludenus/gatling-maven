package load.base

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object ApiAuth extends Object with Log with Config {

  log.info("{}", config)

  val protocol = http
    .baseUrl(config.cardservice.url)
    .userAgentHeader("Gatling Performance Test")

  val hello = exec(
      http("get nonce")
        .post("/auth/hello")
        .check(
          status.is(200),
          jsonPath("$.nonce").exists,
          responseTimeInMillis.lte(config.loadProfile.expectedResponseTimeMsec)
        )
    )

}
