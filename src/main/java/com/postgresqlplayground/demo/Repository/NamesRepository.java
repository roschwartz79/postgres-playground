package com.postgresqlplayground.demo.Repository;

import com.postgresqlplayground.demo.model.Names;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// We need to annotate the repository and extend CrudRepo so we get some boilerplate functionality off the rip
@Repository
public interface NamesRepository extends CrudRepository<Names, Long> {

}
