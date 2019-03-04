FROM jboss/wildfly:15.0.0.Final
EXPOSE 8080:8080
EXPOSE 9990:9990

ADD add_datasource.sh /opt/jboss/wildfly/customization/
RUN /opt/jboss/wildfly/bin/add-user.sh netapp ontap --silent
ADD mysql-connector-java-8.0.15.jar /opt/jboss/wildfly/standalone/deployments
RUN sh /opt/jboss/wildfly/customization/add_datasource.sh
ADD ms.war /opt/jboss/wildfly/standalone/deployments
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
