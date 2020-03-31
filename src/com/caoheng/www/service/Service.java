package com.caoheng.www.service;

import com.caoheng.www.entity.Bank;
import com.caoheng.www.entity.Register;

import java.util.List;

public interface Service {
    List<Register> check();
    Bank select(String name);
    List<Bank> selectAll();
    int delete(String name);
    int update(Integer id,String name, Double money);
    int insert(Integer id, String name, Double money);

}
