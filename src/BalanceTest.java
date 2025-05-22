import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceTest {

    @Test
    void loadBalance() {
        Balance balance = new Balance();
        assertTrue(balance.loadBalance());
    }
}