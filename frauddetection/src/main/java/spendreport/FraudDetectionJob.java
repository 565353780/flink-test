/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package spendreport;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.walkthrough.common.sink.AlertSink;
import org.apache.flink.walkthrough.common.entity.Alert;
import org.apache.flink.walkthrough.common.entity.Transaction;
import org.apache.flink.walkthrough.common.source.TransactionSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Skeleton code for the datastream walkthrough
 */
public class FraudDetectionJob {
  public static void main(String[] args) throws Exception {
    System.out.println("main in");
    System.out.println("start create env");

    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    System.out.println("finish create env");

    DataStream<Transaction> transactions = env
      .addSource(new TransactionSource())
      .name("transactions");

    System.out.println("create transactions");
    System.out.println(transactions);

    DataStream<Alert> alerts = transactions
      .keyBy(Transaction::getAccountId)
      .process(new FraudDetector())
      .name("fraud-detector");

    System.out.println("create alerts");
    System.out.println(alerts);

    alerts
      .addSink(new AlertSink())
      .name("send-alerts");

    System.out.println("add sink for alerts");
    System.out.println(alerts);

    System.out.println("start execute Fraud Detection");
    // env.execute("Fraud Detection");
    System.out.println("finish execute Fraud Detection");

    System.out.println("main out");
  }
}

