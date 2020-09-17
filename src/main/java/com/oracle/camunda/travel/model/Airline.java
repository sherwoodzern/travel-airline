package com.oracle.camunda.travel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.json.JsonObject;
import javax.json.Json;

@Entity
@Table (name="Airline")
@NamedQuery (name="findAllAirlines",
            query="Select h from Airline h")
@NamedQuery (name="findAirline", 
            query="Select h from Airline h where h.departureCity = :city and h.departureDate = :departureDate")
@NamedQuery (name="reserveAirline",
            query="Update Airline h set h.seats = :seats where h.airlineId = :airlineId")
@SequenceGenerator(name="HOTEL_ID_SEQ", initialValue = 100, allocationSize = 10)
public class Airline {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AIRLINE_ID_SEQ")
    @Column (
        name="AIRLINEID",
        insertable = true,
        nullable = false,
        updatable = true 
    )
    private int airlineId;

    @Column (
        name="NAME",
        insertable = true,
        nullable = false,
        updatable = true 
    )
    private String name;

    @Column (
        name="DEPARTUREDATE",
        insertable = true, 
        nullable = false, 
        updatable = true 
    )
    private Date departureDate;

    @Column (
        name="SEATS",
        insertable = true, 
        nullable = false, 
        updatable = true 
    )
    private int seats;

    @Column (
        name="DEPARTURECITY",
        insertable = true, 
        nullable = false, 
        updatable = true 
    )
    private String departureCity; 

    @Column (
        name="ARRIVALCITY",
        insertable = true, 
        nullable = false, 
        updatable = true 
    )
    private String arrivalCity; 

    
    

    /**
     * @return int return the airlineId
     */
    public int getAirlineId() {
        return airlineId;
    }

    /**
     * @param airlineId the airlineId to set
     */
    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Date return the departureDate
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return int return the seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * @return String return the departureCity
     */
    public String getDepartureCity() {
        return departureCity;
    }

    /**
     * @param departureCity the departureCity to set
     */
    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    /**
     * @return String return the arrivalCity
     */
    public String getArrivalCity() {
        return arrivalCity;
    }

    /**
     * @param arrivalCity the arrivalCity to set
     */
    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String asJson() {
        DateFormat dtFormat = new SimpleDateFormat("MM-dd-yyyy");
        String departureDateStr = dtFormat.format(getDepartureDate());
        JsonObject json = Json.createObjectBuilder()
            .add("AirlineId", getAirlineId())
            .add("Name", getName())
            .add("DepartureDate", departureDateStr)
            .add("DepartureCity", getDepartureCity())
            .add("ArrivalCity", getArrivalCity())
            .build();
        
        return json.toString();
    }

}