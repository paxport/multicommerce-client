Multicommerce Java Client
===================

<a href="https://travis-ci.org/paxport/multicommerce-client" target="_blank"><img src="https://api.travis-ci.org/paxport/multicommerce-client.svg?branch=master"/></a>

POJO Client for Paxport's payment card system using Open Feign

work in progress... currently just supports retrieving cards

## Create Client for production system

    MCClient client = new MCClient();
    
## Create Client for test system

    MCClient testClient = new MCClient(true);
    
## Create Credentials

    MCCredentials creds = MCCredentials.of("user","pass");
    
## Pull Back All Cards

    MCCredentials creds = MCCredentials.of(username,password);
    MCClient client = new MCClient();
    List<MCCard> cards = client.doInSession(s -> s.cards(),creds);
    
## Pull Back Lodged Cards Only

    MCCredentials creds = MCCredentials.of(username,password);
    MCClient client = new MCClient();
    List<MCCard> lodgedCards = client.doInSession(s -> s.lodgedCards(),creds);
  
## JCenter Dependency

    <dependency>
      <groupId>com.paxport</groupId>
      <artifactId>multicommerce-client</artifactId>
      <version>0.1.0</version>
    </dependency>

## To Release new version to Bintray

    mvn clean release:prepare -Darguments="-Dmaven.javadoc.skip=true"
    mvn release:perform -Darguments="-Dmaven.javadoc.skip=true"
