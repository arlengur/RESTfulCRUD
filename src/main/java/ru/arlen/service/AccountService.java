package ru.arlen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.arlen.dao.AccountDAO;
import ru.arlen.model.Account;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author satovritti
 */
@Component
@Path("/accounts")
public class AccountService {

    @Autowired
    AccountDAO accountDAO;

    // URI:
    // /contextPath/servletPath/accounts
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public List<Account> getAccounts_JSON() {
        return accountDAO.getAll();
    }

    // URI:
    // /contextPath/servletPath/accounts/{accId}
    @GET
    @Path("/{accId}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Account getAccount(@PathParam("accId") long accId) {
        return accountDAO.getById(accId);
    }

    // URI:
    // /contextPath/servletPath/accounts
    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    public Account addAccount(Account acc) {
        return accountDAO.add(acc);
    }

    // URI:
    // /contextPath/servletPath/accounts
    @PUT
    @Produces({ MediaType.APPLICATION_JSON })
    public Account updateAccount(Account acc) {
        return accountDAO.update(acc);
    }

    // URI:
    // /contextPath/servletPath/accounts/{accId}
    @DELETE
    @Path("/{accId}")
    @Produces({ MediaType.APPLICATION_JSON })
    public void deleteAccount(@PathParam("accId") long accId) {
        accountDAO.deleteById(accId);
    }
}
