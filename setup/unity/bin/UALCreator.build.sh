#UALCreator.sh <UNITY_HOME> <EPF password>
set -x

UNITY_HOME=$1
EPF_PASSWORD=$2

BATCH_CLASSPATH=$UNITY_HOME/usecurity.jar:$UNITY_HOME/tools/enttoolkit.jar
JAVA_HOME=/centralbuild/tools/jdks/jdk1.6.0_22

$JAVA_HOME/bin/java -d32 -cp $BATCH_CLASSPATH -Djava.library.path=$UNITY_HOME/tools ca.teranet.unity.security.entrust.ServerLoginCredentialCreator /apps/foundation/csp/security/entrust.ini /apps/foundation/csp/security/CspInt.epf /apps/foundation/csp/security/CspInt.ual "${EPF_PASSWORD}" 
$JAVA_HOME/bin/java -d32 -cp $BATCH_CLASSPATH -Djava.library.path=$UNITY_HOME/tools ca.teranet.unity.security.entrust.ServerLoginCredentialCreator /apps/foundation/csp/security/entrust.ini /apps/foundation/csp/security/MOFData.epf /apps/foundation/csp/security/MOFData.ual ARgtTL76 