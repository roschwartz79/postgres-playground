package com.postgresqlplayground.demo.Controller;

import com.postgresqlplayground.demo.Service.INameService;
import com.postgresqlplayground.demo.model.Names;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class myController {
    // Get the Name service interface bean so we can call on the service to do what we need- query the DB
    @Autowired
    private INameService service;

    @GetMapping("/getNames")
    public String getPeople(){
        // Get the list using the findAll method in the service that we implemented
        var names = (List<Names>) service.findAll();
        return names.toString();
    }

    @GetMapping("/getCount")
    public long getCount(){
        // Getting the count of items in the DB!
        var count = service.getCount();
        return count;
    }

}
