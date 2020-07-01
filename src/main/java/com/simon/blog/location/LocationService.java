package com.simon.blog.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// JPA
@Service
public class LocationService {

    @Autowired
    public LocationRepository LocationRepository;

    public List<Location> getAllLocations() {
        List<Location> Locations = new ArrayList<>();
        LocationRepository.findAll()
                .forEach(Locations::add);
        return Locations;
    }

    public void addLocation(Location Location) {
        LocationRepository.save(Location);
    }

    public Optional<Location> getLocation(String id) {
        return LocationRepository.findById(id);
    }

    public void deleteLocation(String id) {
        LocationRepository.deleteById(id);
    }

    public void updateLocation(String id, Location Location) {
        LocationRepository.save(Location);
    }
}

// method 2
//@Service
//public class LocationService {
//    Location location1 = new Location("l1", "Boston");
//    Location location2 = new Location("l2", "Toronto");
//    Location location3 = new Location("l3", "Mobile");
//
//    private List<Location> locations = new ArrayList<>(
//            Arrays.asList(location1, location2, location3));
//
//    public List<Location> getAllLocations() {
//        return locations;
//    }
//
//    public Location getLocation(String id) {
//        Location location = locations.stream()
//                .filter(t -> id.equals(t.getId()))
//                .findFirst()
//                .orElse(null);
//
//        return location;
//    }
//
//    public void addLocation(Location location){
//        locations.add(location);
//    }
//
//    public void deleteLocation(String id) {
//        locations.removeIf(t -> t.getId().equals(id));
//    }
//
//    public void updateLocation(String id, Location location) {
//        for(int i = 0; i < locations.size(); i++) {
//            Location l = locations.get(i);
//            if (l.getId().equals(id)) {
//                locations.set(i, location);
//            }
//        }
//    }
//}
