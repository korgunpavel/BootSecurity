package com.korgun.springcourse.SecurityApp.services;

import com.korgun.springcourse.SecurityApp.models.Person;
import com.korgun.springcourse.SecurityApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> loadUserByUsername(String username) {
        return peopleRepository.findByUsername(username);
    }
}
