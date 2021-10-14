#!/bin/sh

# @echo off
# Usage ant [target]

# SETLOCAL

# Goto the directory for this script - note: it may not be the same as pwd if this script is called from other directory.
#cd -P -- "$(dirname -- $(readlink -f ""$0""))"

echo "...run setup, workspace:${WORKSPACE}, FLEXSDK_HOME:${FLEXSDK_HOME}"

# sleep 2

# remove maven cache for teranet jars 
# rm -Rf /centralbuild/apps/tex/.m2/repository/ca
# remove cache files for onland-ui module
rm -Rf ${WORKSPACE}/onland-ui/node_modules/*

#. ${WORKSPACE}/setEnv.sh

cd ${WORKSPACE}/setup

# setup csp project, customize unity, install local dependency jars
${MAVEN_HOME}/bin/mvn --settings ${MVN_SETTING} compile package -DJBOSS_HOME=${JBOSS_HOME} -DJAVA_HOME=${JAVA_HOME} -DMAVEN_HOME=${MAVEN_HOME} -DFLEXSDK_HOME=${FLEXSDK_HOME} -DUSER_HOME=${HOME} -Dmaven.repo.local=${APP_BUILD_HOME}/.m2/repository
if [ ! $? = 0 ]; then
  echo "Failure in "setup" task. Exiting now."
  exit 1
fi