package com.example.demohazelcastcache.services;

import com.example.demohazelcastcache.model.Person;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "persons")
public class PersonServices {

    private List<Person> persons;

    @PostConstruct
    private void init(){
        this.persons = new ArrayList<>();
        this.persons.add(new Person("Furkan", "Keskinkilic"));
        this.persons.add(new Person("Yagiz", "Mugulkoc"));
        this.persons.add(new Person("Ebru", "Ekinci"));
        this.persons.add(new Person("Seda", "Ozhan"));
    }
    //Cache if name is equals to 'Furkan' then not call to this method return form the memory cached
    @Cacheable(condition = "#name.equals('Furkan')")
    public Optional<Person> findByName(String name){
        System.out.println("Searcing person with name: " + name);
        return  this.persons.stream().filter(p -> p.getName().equals(name)).findAny();
    }

    //Clear
    @CacheEvict(allEntries = true)
    public void clearCache() {

    }


}
