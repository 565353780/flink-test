# Flink Test

## Install

```bash
sudo apt install maven openjdk-11-jdk
```

## Flink

### Install

and download flink for scala

```bash
https://flink.apache.org/zh/downloads.html
```

### Start Flink

```bash
cd <path-to-your-flink-folder>
./bin/start-cluster.sh
```

### Test Flink

```bash
./bin/flink run examples/streaming/WordCount.jar
```

and see out data

```bash
tail log/flink-*-taskexecutor-*.out
```

### WebUI for Flink

```bash
localhost:8881
```

### Stop Flink

```bash
cd <path-to-your-flink-folder>
./bin/stop-cluster.sh
```

## Generate package

```bash
mvn archetype:generate \
    -DarchetypeGroupId=org.apache.flink \
    -DarchetypeArtifactId=flink-walkthrough-datastream-java \
    -DarchetypeVersion=1.15.1 \
    -DgroupId=frauddetection \
    -DartifactId=frauddetection \
    -Dversion=0.1 \
    -Dpackage=spendreport \
    -DinteractiveMode=false
```

## Run

### Run Demo

```bash

```

## Enjoy it~

