package com.postgresqlplayground.demo.Repository;

import com.postgresqlplayground.demo.Service.NameService;
import com.postgresqlplayground.demo.model.Names;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// We need to annotate the repository and extend CrudRepo so we get some boilerplate functionality off the rip
@Repository
public interface NamesRepository extends CrudRepository<Names, Long> {
    /** This is the spring data magic I wanted to see in action. It's so abstracted you have to see it to believe it,
     * Disney style. More on the docs, but this is the basic idea. Keywords like "And", "Or", "Like", "GreaterThanEqual"
     * can be used in the method name, which then gets translated into a SQL query through hibernate. Super cool, but tricky.
     *
     * @Link
     */
    List<Names> findByName(String name);
    List<Names> findByAgeLessThanEqual(int age);
}
