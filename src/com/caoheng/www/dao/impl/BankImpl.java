package com.caoheng.www.dao.impl;

import com.caoheng.www.DButils;
import com.caoheng.www.dao.BankDao;
import com.caoheng.www.entity.Bank;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.xml.parsers.DocumentBuilder;
import java.sql.SQLException;
import java.util.List;

public class BankImpl implements BankDao {
    private QueryRunner queryRunner = new QueryRunner(DButils.getDruidDataSource());

    @Override
    public int delete(Bank bank) {
        try {
            return queryRunner.update("delete from bank where name= ?", bank.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int update(Bank bank) {
        try{
            return queryRunner.update("update  bank set money=? where name = ?",bank.getMoney(),bank.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Bank> selectAll() {
        try {
            return queryRunner.query("select * from bank ", new BeanListHandler<Bank>(Bank.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insert(Bank bank) {
        try {
           return queryRunner.update("insert into bank(id, name, money) values(?,?,?)", bank.getId(),bank.getName(),bank.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }
}
