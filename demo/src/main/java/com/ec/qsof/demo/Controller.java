package com.ec.qsof.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/example")
class Controller {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/get")
    public List<Boat> getHelloWord() {
        ResponseEntity<Object[]> responseEntity =
                restTemplate.getForEntity("https://api.spacexdata.com/v3/ships", Object[].class);
        Object[] objects = responseEntity.getBody();
        List<Boat> boatList = this.objToMap(objects).stream()
                .map(boatMap ->new Boat(boatMap.get("ship_id").toString(),((List)boatMap.get("missions")).size()))
                .collect(Collectors.toList());
        boatList.sort(Comparator.comparing(Boat::getMissionsSize));
        return boatList;
    }

    public List<Map> objToMap(Object[] objects) {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Map.class))
                .collect(Collectors.toList());
    }

}
