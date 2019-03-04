#!/bin/bash

/opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 &
sleep 10

/opt/jboss/wildfly/bin/jboss-cli.sh --connect << EOF
data-source add \
    --name=MySqlDS \
    --jndi-name=java:/MySqlDS \
    --driver-name=mysql-connector-java-8.0.15.jar \
    --driver-class=com.mysql.cj.jdbc.Driver \
    --connection-url=jdbc:mysql://172.17.0.3:3306/corp \
    --user-name=netapp \
    --password=ontap
EOF

/opt/jboss/wildfly/bin/jboss-cli.sh --connect --command=":shutdown"