package ru.arlen.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.arlen.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author satovritti
 */
public class AccountDAOImpl implements AccountDAO {
    @Autowired
    NamedParameterJdbcTemplate h2Template;

    @Override
    public List<Account> getAll() {
        return h2Template.query("SELECT * FROM ACCOUNTS", new AccountMapper());
    }

    @Override
    public Account getById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return h2Template.queryForObject("SELECT * FROM ACCOUNTS WHERE id=:id", params, new AccountMapper());
    }

    @Override
    public Account add(Account acc) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", acc.getId());
        params.put("accountDetails", acc.getAccountDetails());
        h2Template.update("INSERT INTO ACCOUNTS VALUES (:id, :accountDetails)", params);
        return acc;
    }

    @Override
    public Account update(Account acc) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", acc.getId());
        params.put("accountDetails", acc.getAccountDetails());
        h2Template.update("UPDATE ACCOUNTS SET  accountDetails=:accountDetails WHERE id=:id", params);
        return acc;
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        h2Template.update("DELETE FROM ACCOUNTS WHERE id=:id", params);
    }

    private static final class AccountMapper implements RowMapper<Account> {
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setAccountDetails(rs.getString("accountDetails"));
            return account;
        }
    }
}
