#!/bin/sh

#userdir
APP_HOME=$(cd $(dirname $0); cd ..; pwd -P)
echo APP_HOME:$APP_HOME

if test -z "${JAVA_M}"
then
    echo "JAVA_M is not set. default value is -Xms3072m -Xmx3072m."
    JAVA_M="-Xms3072m -Xmx3072m"
else
    JAVA_M="${JAVA_M}"
fi

appName="soc-warning"
pid=`ps -ef | grep "appName=$appName" | grep -v "grep" | awk '{print $2}'`
if [[ "$pid" = "" ]]
then
    # 没启动
    echo "$appName is not running"
else
    echo "$appName is running"
    for id in $pid
    do
        kill -9 $id
        echo "stop $appName-[$id] success"
    done
fi

curl -s "http://pfinder-master.jd.com/access/script" -o /tmp/pfinder.sh ; source /tmp/pfinder.sh || :
nohup java ${PFINDER_AGENT:-} $JAVA_OPS $JAVA_M -Dfile.encoding=UTF-8 -Dfastjson.parser.safeMode=true -DappName=$appName -cp $APP_HOME/conf/:$APP_HOME/lib/* zy.code.demo.parent.DemoParentApplication >/dev/null 2>&1 &
