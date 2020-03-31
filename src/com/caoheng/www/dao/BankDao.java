package com.caoheng.www.dao;

import com.caoheng.www.entity.Bank;

import java.util.List;

public interface BankDao {
    List<Bank> selectAll();
    int delete(Bank bank);
    int update(Bank bank);
    int insert(Bank bank);


}
