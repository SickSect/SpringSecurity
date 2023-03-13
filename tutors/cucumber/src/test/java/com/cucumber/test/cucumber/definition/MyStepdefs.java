package com.cucumber.test.cucumber.definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.math.BigDecimal;

public class MyStepdefs {

    private static BigDecimal cash = new BigDecimal(12000);
    @Given("user have {int} rub")
    public void userHaveRub(int arg0) {
        Assert.assertEquals(0, cash.compareTo(new BigDecimal(arg0)));
    }

    @When("user take {int} rub")
    public void userTakeRub(int arg0) {
        cash = cash.subtract(new BigDecimal(arg0));
    }
}
