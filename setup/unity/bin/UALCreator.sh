#UALCreator.sh <EPP password>

. /apps/foundation/csp/scripts/setEnv.sh

#export UNITY_HOME=/apps/foundation/csp/unity
#export JAVA_HOME="/apps/foundation/jdks/jdk1.7.0_21"

MODULE_HOME="${CSP_HOME}/server/csp/modules"

export BATCH_CLASSPATH=$UNITY_HOME/unity.ear/lib/usecurity.jar:${MODULE_HOME}/entrust/8.0.0/enttoolkit.jar

$JAVA_HOME/bin/java -cp $BATCH_CLASSPATH -Djava.library.path=${MODULE_HOME}/entrust/8.0.0/lib/linux-x86_64 ca.teranet.unity.security.entrust.ServerLoginCredentialCreator /apps/foundation/csp/security/entrust.ini /apps/foundation/csp/security/CspInt.epf /apps/foundation/csp/security/CspInt.ual $1
