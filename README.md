Multicommerce Java Client
===================

POJO Client for Paxport's payment card system using Open Feign

work in progress...

## To Release new version to Bintray

    mvn clean release:prepare -Darguments="-Dmaven.javadoc.skip=true"
    mvn release:perform -Darguments="-Dmaven.javadoc.skip=true"