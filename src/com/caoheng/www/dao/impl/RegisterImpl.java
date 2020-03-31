package com.caoheng.www.dao.impl;

import com.caoheng.www.DButils;
import com.caoheng.www.dao.RegisterDao;
import com.caoheng.www.entity.Register;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RegisterImpl implements RegisterDao {
    private QueryRunner queryRunner = new QueryRunner(DButils.getDruidDataSource());
    @Override
    public List<Register> check() {
        try {
           List<Register> list = queryRunner.query("select * from register " , new BeanListHandler<Register>(Register.class));
           return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
