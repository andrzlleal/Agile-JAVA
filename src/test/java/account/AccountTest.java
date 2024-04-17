package account;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    protected void setUp() {
        Account account = new Account();
    }
    @Test
    public void testTransactions() {
        Account account = new Account();
        account.credit(new BigDecimal("0.10"));
        account.credit(new BigDecimal("11.00"));
        account.credit(new BigDecimal("2.99"));
        assertEquals(new BigDecimal("4.70"), account.transactionAverage());
    }
//    @Test
//    public void testWithdraw() throws Exception {
//        account.credit(new BigDecimal("100.00"));
//        account.withdraw(new BigDecimal("40.00"));
//        assertEquals(new BigDecimal("60.00"), account.getBalance());
//    }
//    @Test
//    public void testWithdrawInsufficientFunds() {
//        account.credit(new BigDecimal("100.00"));
//        account.withdraw(new BigDecimal("140.00"));
//        assertEquals(new BigDecimal("100.00"), account.getBalance());
//    }
}
