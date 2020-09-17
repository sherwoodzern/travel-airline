
package com.oracle.camunda.travel;



import javax.inject.Inject;


public class AirlineResource {

    // private static final JsonBuilderFactory JSON =
    // Json.createBuilderFactory(Collections.emptyMap());

    
    @Inject
    public AirlineResource() {

    }


    public static void main(String... args) {

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        System.out.printf("Creating the client\n");
        AirlineScheduler scheduler = new AirlineScheduler();
        while (true) {
            scheduler.scheduleFlight();
        }
        
    }


    
}
