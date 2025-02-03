package com.hostel.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hostel.entity.Contact;

public interface ContactRepo extends JpaRepository<Contact, Long> {

}
