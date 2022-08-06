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
localhost:8081
```

### Stop Flink

```bash
cd <path-to-your-flink-folder>
./bin/stop-cluster.sh
```

## Build

```bash
./build.sh
```

## Run

```bash
./run.sh
```

## Enjoy it~

