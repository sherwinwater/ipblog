package com.simon.blog.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/locations")
//    public List<Location> getAllLocations() {
//        return locationService.getAllLocations();
//    }
    public String getAllLocations(Model model) {
        List<Location> locations = locationService.getAllLocations();
        model.addAttribute("locations",locations);
        return "locations";
    }

    @RequestMapping(value = "/locations/{id}")
    public Optional<Location> getLocation(@PathVariable String id) {
        return locationService.getLocation(id);
    }

    @PostMapping("/locations")
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.DELETE)
    public void deleteLocation(@PathVariable String id) {
        locationService.deleteLocation(id);
    }

    @RequestMapping(value = "/locations/{id}", method = RequestMethod.PUT)
    public void updateLocation(@RequestBody Location location, @PathVariable String id) {
        locationService.updateLocation(id, location);
    }

}
