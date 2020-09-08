# gatling-maven
gatling with maven


## how to run
```bash
(export LOG_LEVEL=DEBUG; export GATLING_CARDSERVICE_URL=https://cards; mvn -B gatling:test -Dgatling.simulationClass=load.HelloSimulation)
```

report is here: 
```
target/gatling/hellosimulation-20200908164439153/index.html
```