package org.example.DataLoads;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DataProvider {

    public  List<HashMap<String, String>> getJsonData(String path) throws IOException {
       //jackson converts json to json string by apache common io
       String jsonContentInString = FileUtils.readFileToString(
               new File(path), "UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        //jackson converts json string to List of hashmap os string,string
        /***********************************************************
         * SAmple for reference
         *         HashMap<String, String> reservationDetails = new HashMap<>();
         *         reservationDetails.put("from", "MAA");
         *         reservationDetails.put("to", "HYD");
         *         reservationDetails.put("to2", "BLR");
         *
         *         HashMap<String, String> reservationDetails2 = new HashMap<>();
         *         reservationDetails2.put("from", "BLR");
         *         reservationDetails2.put("to", "MAA");
         *         reservationDetails2.put("to2", "CBE");
         *
         *         List<HashMap<String,String>> llist = new ArrayList();
         *         llist.add(reservationDetails);
         *         llist.add(reservationDetails2);
         */
        List<HashMap<String, String>> reservationDetails = mapper.readValue(jsonContentInString, new TypeReference<List<HashMap<String,String>>>(){});
        return reservationDetails;
    }
}

/********************************************************
 * 1. TypeReference in Jackson
 * TypeReference is used when deserializing generic types like List<Map<String, String>> or Map<String, Object>.
 *
 * ✅ Example: Deserialize JSON into List<Map<String, String>>
 * java
 * ObjectMapper mapper = new ObjectMapper();
 * String json = "[{\"from\":\"MAA\",\"to\":\"HYD\"}, {\"from\":\"BLR\",\"to\":\"CBE\"}]";
 *
 * List<Map<String, String>> list = mapper.readValue(json, new TypeReference<List<Map<String, String>>>() {})
 *
 2. Marshalling in Java
 Marshalling means converting a Java object into a format like JSON or XML.

 ✅ Example: Marshalling to JSON
 java
 ObjectMapper mapper = new ObjectMapper();

 Map<String, String> reservation = new HashMap<>();
 reservation.put("from", "MAA");
 reservation.put("to", "HYD");

 String json = mapper.writeValueAsString(reservation);
 System.out.println(json); // {"from":"MAA","to":"HYD"}

 Unmarshalling is the reverse — converting JSON/XML into Java objects.

 ✅ Example: Unmarshalling from JSON
 java
 String json = "{\"from\":\"MAA\",\"to\":\"HYD\"}";
 Map<String, String> reservation = mapper.readValue(json, new TypeReference<Map<String, String>>() {}) */