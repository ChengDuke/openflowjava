#!/bin/bash

mvn clean install -Dcheckstyle.skip=true -DskipTests -Dmaven.javadoc.skip=true
