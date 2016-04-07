#!/bin/sh


rm -rf felix-cache/ 
java -cp sbin/bcprov-jdk16-140.jar:sbin/felix.jar:sbin/protobuf-java-3.0.0-alpha-3.1.jar -DofwConf=etc/ofw.properties -Dlogback.configurationFile=etc/logback.xml org.apache.felix.main.Main
