package com.itheima.dao;

import com.itheima.domain.Account;
import org.springframework.stereotype.Repository;

public interface AccountDao {

    /**
     * 根据账户id查询账户信息,账户信息中包含所属的用户信息
     * @param id
     * @return
     */
    public Account findByIdWithUser(Integer id);
}
