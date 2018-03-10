package com.jebill.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jebill.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {

}
