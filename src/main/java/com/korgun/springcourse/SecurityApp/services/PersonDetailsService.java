package com.korgun.springcourse.SecurityApp.services;

import com.korgun.springcourse.SecurityApp.models.Person;
import com.korgun.springcourse.SecurityApp.repositories.PeopleRepository;
import com.korgun.springcourse.SecurityApp.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> personOptional = peopleRepository.findByUsername(username);

        if(personOptional.isEmpty()){
            throw new UsernameNotFoundException("Wrong username");
        }

        return new PersonDetails(personOptional.get());
    }
}
