package com.garyfrancodev.ExpenseManagerDomain.account;

import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTests {
    private static final UUID ID = UUID.randomUUID();
    private static final UUID USER_ID = UUID.randomUUID();
    private Account account;

    @Test
    void testAccountCreation(){
        assertDoesNotThrow(() -> {
            account = new Account("BCP", "banco",60.00, UUID.randomUUID());
        });

        assertNotNull(account.getId());
        assertNotEquals(account.getId(), account.getUserId());
        assertNotNull(account);
    }

    @Test
    void testAccountCreationWithId() {
        assertDoesNotThrow(() -> {
            account = new Account("BCP", "banco", 60.00, USER_ID, ID);
        });

        assertNotNull(account.getId());
        assertNotNull(account);
        assertEquals(ID, account.getId());
    }
}
