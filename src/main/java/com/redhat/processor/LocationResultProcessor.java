package com.redhat.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.redhat.dto.Location;
import com.redhat.dto.LocationLocation;

@Component("locationResultProcessor")
public class LocationResultProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		List<Location> locations = new ArrayList<>();
		List<Map<String, Object>> body = exchange.getIn().getBody(List.class);
		for (Map<String, Object> item : body) {
			Location location = new Location();
			location.setId(Integer.valueOf(String.valueOf(item.get("ID"))));
			location.setName(String.valueOf(item.get("NAME")));
			location.setStatus(String.valueOf(item.get("STATUS")));
			location.setType(String.valueOf(item.get("LOCATION_TYPE")));
			
			LocationLocation latlong = new LocationLocation();
			latlong.setLat(Double.parseDouble(String.valueOf(item.get("LAT"))));
			latlong.setLng(Double.parseDouble(String.valueOf(item.get("LNG"))));
			
			location.setLocation(latlong);
			
			locations.add(location);
		}
		exchange.getOut().setBody(locations);
	}

}
