package com.zbrain.service;

import com.zbrain.entity.Email;
import com.zbrain.repo.EmailRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@CommonsLog
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Transactional
    public void save(Email email) {
        emailRepository.save(email);
    }

    @Transactional(readOnly = true)
    public boolean isEmailExist(String email){
        if(emailRepository.findByEmail(email) != null){
            return true;
        } else {
            return false;
        }
    }

}
