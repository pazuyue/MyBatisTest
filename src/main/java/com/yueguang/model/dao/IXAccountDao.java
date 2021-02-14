package com.yueguang.model.dao;

import com.yueguang.model.Account;

import java.util.List;

public interface IXAccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();
}
