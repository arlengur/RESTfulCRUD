package ru.arlen;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.arlen.dao.AccountDAO;
import ru.arlen.model.Account;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author satovritti
 */
@ContextConfiguration(classes = {TestContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FakeAccountDAOTest {

    private AccountDAO accountDAO;
    private String user1;

    @Before
    public void init(){
        int DETAILS_LENGTH = 44;
        user1 = RandomStringUtils.randomAlphanumeric(DETAILS_LENGTH);
        String user2 = RandomStringUtils.randomAlphanumeric(DETAILS_LENGTH);
        String user3 = RandomStringUtils.randomAlphanumeric(DETAILS_LENGTH);
        accountDAO = new FakeAccountDAO(Arrays.asList(user1, user2, user3));
    }

    @Test
    public void getByIdTest() {
        assertEquals(user1, accountDAO.getById(1).getAccountDetails());
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
