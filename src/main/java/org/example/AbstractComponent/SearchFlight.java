package org.example.AbstractComponent;

import java.util.HashMap;

public interface SearchFlight {

    void checkFlightAvailability(String from, String to);

    void checkFlightAvailability2(HashMap<String, String> reservationDetails);
}
