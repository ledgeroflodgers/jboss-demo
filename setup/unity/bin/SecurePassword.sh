# SecurePassword.sh <EPFpassword> -s <source.txt> -o <encrypted.txt>
#export JAVA_HOME="/apps/foundation/jdks/jdk1.7.0_21"
#export UNITY_HOME=/apps/foundation/csp/unity

. /apps/foundation/csp/scripts/setEnv.sh

MODULE_HOME="${CSP_HOME}/server/csp/modules"

export BATCH_CLASSPATH="$UNITY_HOME/unity.ear/lib/*:$UNITY_HOME/unity.ear/*:${MODULE_HOME}/entrust/8.0.0/enttoolkit.jar"
export BATCH_OPTIONS="-Dlog4j.configuration=file:$UNITY_HOME/conf/log4j.properties"
${JAVA_HOME}/bin/java -cp ${BATCH_CLASSPATH} ${BATCH_OPTIONS} ca.teranet.unity.core.CredentialSecurer -k /apps/foundation/csp/security/CspProd.epf -p $1 $2 $3 $4 $5 $6
