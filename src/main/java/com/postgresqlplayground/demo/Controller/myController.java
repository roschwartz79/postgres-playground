package com.postgresqlplayground.demo.Controller;

import com.postgresqlplayground.demo.Repository.NamesRepository;
import com.postgresqlplayground.demo.Service.INameService;
import com.postgresqlplayground.demo.model.Names;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@RestController
public class myController {
    // Get the Name service interface bean so we can call on the service to do what we need- query the DB
    @Autowired
    private INameService service;

    @Autowired
    private NamesRepository repository;

    @GetMapping("/getNames")
    @ResponseBody
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

    @PostMapping("/addPerson")
    @ResponseBody
    public String addPerson(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        service.addPerson(new Names(name, email, age));
        return "Name " + name + " saved in the database!";
    }

    // I'm sure there's a better way to do this, but for the purposes of this repo this does the trick!
    @GetMapping("/findPerson")
    public String getPerson(@RequestParam String name){
        List namesList = repository.findByName(name);
        if (namesList.size() == 0){
            return (name + " not found in the database.");
        }
        else{
            return ("Database Entries for " + name + "\n" + Arrays.toString(namesList.toArray()));
        }
    }

    @GetMapping("/getAgeLessThan")
    public String getAgeLessThan(@RequestParam int age){
        List namesList = repository.findByAgeLessThanEqual(age);
        if (namesList.size() == 0){
            return ("Less than " + age + " not found in the database.");
        }
        else{
            return ("Database Entries for ages less than " + age + "\n" + Arrays.toString(namesList.toArray()));
        }
    }

    @PostMapping("deletePerson")
    public String deletePerson(@RequestParam String name, @RequestParam String email, @RequestParam int age){
        service.deletePerson(new Names(name, email, age));
        return "deleted" + name + "from the database.";
    }

}
