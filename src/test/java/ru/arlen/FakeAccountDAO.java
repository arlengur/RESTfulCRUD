package ru.arlen;

import ru.arlen.dao.AccountDAO;
import ru.arlen.model.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author satovritti
 */
public class FakeAccountDAO implements AccountDAO {
    private  Map<Long, Account> accMap;

    public FakeAccountDAO(List<String> userDetails) {
        accMap = IntStream.range(0, userDetails.size())
                          .boxed()
                          .map(x -> new Account(x+1, userDetails.get(x)))
                          .collect(Collectors.toMap(Account::getId, j -> j));
    }

    @Override
    public List<Account> getAll() {
        Collection<Account> c = accMap.values();
        List<Account> list = new ArrayList<>();
        list.addAll(c);
        return list;
    }

    @Override
    public Account getById(long id) {
        return accMap.get(id);
    }

    @Override
    public Account add(Account acc) {
        accMap.put(acc.getId(), acc);
        return acc;
    }

    @Override
    public Account update(Account acc) {
        accMap.put(acc.getId(), acc);
        return acc;
    }

    @Override
    public void deleteById(long id) {
        accMap.remove(id);
    }
}
