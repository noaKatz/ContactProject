package com.example.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.beans.Contact;


public interface ContactReposetory extends JpaRepository<Contact, Integer> {


}
