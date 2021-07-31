package tddBankAccount.bankTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import tddBankAccount.bank.Money;

class MoneyTest {

    /*
    @Test
    void createMoneyFromInvalidAmountString() {
        // Arrange
        String invalidAmount = "invalid";

        // Assert
        assertThatThrownBy(() -> new Money(invalidAmount))
                .isInstanceOf(NumberFormatException.class);
    }
    */

    /*
    @Test
    void createMoneyFromNegativeAmountString() {
        // Arrange
        String negativeAmount = "-1";

        // Assert

        assertThatThrownBy(() -> new Money(negativeAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The amount cannot be negative.");
    }
    */

    @Test
    void createMoneyFromPositiveAmountString() {
        // Arrange
        String positiveAmount = "1";

        // Act
        Money validMoney = new Money(positiveAmount);

        // Assert
        Assert.assertTrue(validMoney != null);
        //assertThat(validMoney).isNotNull();
    }
}