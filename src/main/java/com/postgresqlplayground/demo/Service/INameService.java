package com.postgresqlplayground.demo.Service;

import com.postgresqlplayground.demo.model.Names;
import org.springframework.stereotype.Service;

import java.util.List;

// Interface for our findAll method! We need to actually implement this in order for it to work.
// I'm not totally sure if this is absolutely necessary but it works!
public interface INameService {
    List<Names> findAll();
    long getCount();
}
