#!/bin/zsh

# junitPath = "/opt/java/jdk-9.0.4/lib/junit-4.9.jar";

java -cp .:/opt/java/jdk-9.0.4/lib/junit-4.9.jar org.junit.runner.JUnitCore WordLadderTest;
