package ru.arlen.dao;

import ru.arlen.model.Account;

import java.util.List;

/**
 * @author satovritti
 */
public interface AccountDAO {
    List<Account> getAll();

    Account getById(long id);

    Account add(Account acc);

    Account update(Account acc);

    void deleteById(long id);


}
