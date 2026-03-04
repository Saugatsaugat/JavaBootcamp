package com.saugat.bootcamp.service;

import com.saugat.bootcamp.model.Country;
import com.saugat.bootcamp.repository.CountryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends AbstractService<Country, Long> {

    private final CountryRepository repo;

    public CountryService(CountryRepository repository) {
        this.repo = repository;
    }

    @Override
    public JpaRepository<Country, Long> getRepository() {
        return repo;
    }
}
