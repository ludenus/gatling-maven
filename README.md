# gatling-maven
gatling with maven


## how to run

to run with basic Gatling log
```bash
export LOG_LEVEL=INFO 
```

to run with detailed HTTP log
```bash
export LOG_LEVEL=TRACE 
```

to control test parameters
```bash
export GATLING_RAMP_USERS=10
export GATLING_RAMP_SECONDS=20
export GATLING_MAX_DURATION_SECONDS=100
```

run all simulations sequentially
```bash
export GATLING_CARDSERVICE_URL=https://cards; mvn -B verify
```

run only one simulation
```bash
export GATLING_CARDSERVICE_URL=https://cards; mvn -B  gatling:test -Dgatling.simulationClass=load.HelloSimulation
```

find reports under: 
```
target/gatling/
```