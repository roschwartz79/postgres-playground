package com.postgresqlplayground.demo.Service;

import com.postgresqlplayground.demo.Repository.NamesRepository;
import com.postgresqlplayground.demo.model.Names;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// This is the service, we annotate with service so Spring knows that we want to perform an action here.
@Service
public class NameService implements INameService {

    // Get the repo bean, so spring knows what database we want
    @Autowired
    private NamesRepository repository;

    // Now we can actually perform the request, by using the repository and the findAll() function.
    // This will get every entry in the database.
    @Override
    public List findAll(){
        var names = (List<Names>) repository.findAll();
        return names;
    }

    @Override
    public long getCount(){
        return repository.count();
    }
}
