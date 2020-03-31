package com.caoheng.www.service.impl;

import com.caoheng.www.DButils;
import com.caoheng.www.dao.impl.BankImpl;
import com.caoheng.www.dao.impl.RegisterImpl;
import com.caoheng.www.entity.Bank;
import com.caoheng.www.entity.Register;
import com.caoheng.www.service.Service;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

public class ServiceImpl implements Service {
    private RegisterImpl register = new RegisterImpl();
    private BankImpl bankImpl = new BankImpl();
    private QueryRunner queryRunner = new QueryRunner(DButils.getDruidDataSource());

    @Override
    public List<Register> check() {
        return register.check();
    }

    @Override
    public Bank select(String name) {
        try {
            return queryRunner.query("select * from bank where name=?", new BeanHandler<Bank>(Bank.class), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public int delete(String name) {
        return bankImpl.delete(select(name));

    }

    @Override
    public int insert(Integer id, String name, Double money) {
       Bank bank = new Bank(id, name, money);
       return bankImpl.insert(bank);
    }

    public int update(Integer id, String name, Double money) {
        Bank bank = new Bank(id, name, money);
        return bankImpl.update(bank);
    }

    public List<Bank> selectAll() {
        return bankImpl.selectAll();
    }
}
