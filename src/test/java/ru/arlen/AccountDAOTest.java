package ru.arlen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.arlen.dao.AccountDAO;
import ru.arlen.model.Account;

import static org.junit.Assert.assertEquals;

/**
 * @author satovritti
 */
@ContextConfiguration(classes = {TestContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountDAOTest {
    @Autowired
    AccountDAO accountDAO;

    @Test
    public void getByIdTest() {
        assertEquals("user1", accountDAO.getById(1).getAccountDetails());
    }

    @Test
    public void addTest() {
        Account account = new Account(4, "user4");
        accountDAO.add(account);
        assertEquals(account.getAccountDetails(), accountDAO.getById(account.getId()).getAccountDetails());
    }

    @Test
    public void updateTest() {
        Account account = new Account(4, "user5");
        accountDAO.update(account);
        assertEquals(account.getAccountDetails(), accountDAO.getById(account.getId()).getAccountDetails());
    }

    @Test
    public void deleteTest() {
        accountDAO.deleteById(4);
        assertEquals(3, accountDAO.getAll().size());
    }
}
