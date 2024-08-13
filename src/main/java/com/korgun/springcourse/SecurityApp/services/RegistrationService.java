package com.korgun.springcourse.SecurityApp.services;

import com.korgun.springcourse.SecurityApp.models.Person;
import com.korgun.springcourse.SecurityApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RegistrationService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationService(BCryptPasswordEncoder passwordEncoder, PeopleRepository peopleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void register(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        peopleRepository.save(person);
    }
}
