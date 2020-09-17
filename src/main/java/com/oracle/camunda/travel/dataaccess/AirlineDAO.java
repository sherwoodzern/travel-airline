package com.oracle.camunda.travel.dataaccess;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Date;
import com.oracle.camunda.travel.model.Airline;

public class AirlineDAO {

    @PersistenceContext(unitName="airlineService")
    private EntityManager entityManager;

    @Transactional
    public List<Airline> getAllAirlines() {

        return entityManager
            .createNamedQuery("findAllAirlines", Airline.class)
            .getResultList();
    }

    @Transactional
    public Airline getAirline(String city, Date departure) {

        return entityManager
            .createNamedQuery("findAirline", Airline.class)
            .setParameter("departureCity", city)
            .setParameter("departureDate", departure)
            .getSingleResult();
    }
    
    @Transactional
    public Airline reserveAirline(Airline airline) {

        return entityManager
            .createNamedQuery("reserveAirline", Airline.class)
            .setParameter("airlineId", airline.getAirlineId())
            .setParameter("seats", airline.getSeats())
            .getSingleResult();

    }

    public Airline getMockAirline() {
        Airline al = new Airline();
        al.setAirlineId(1);
        al.setArrivalCity("SFO");
        al.setDepartureCity("MCO");
        al.setName("Delta");
        al.setDepartureDate(new Date());
        al.setSeats(5);
        return al; 
    }

    public Airline reserveMockAirline(Airline airline) {
        return airline;
    }
}