package com.nphase.service;


import com.nphase.entity.DiscountConfiguration;
import com.nphase.entity.Product;
import com.nphase.entity.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartServiceTest {

    @Test
    public void calculatesPriceWitCategoryDiscount()  {
        DiscountConfiguration drinksConfiguration = new DiscountConfiguration(3, BigDecimal.valueOf(0.1));
        DiscountConfiguration foodConfiguration = new DiscountConfiguration(3, BigDecimal.valueOf(0.2));
        Map<String, DiscountConfiguration> discountConfigurationMap = new HashMap<>();
        discountConfigurationMap.put("drinks", drinksConfiguration);
        discountConfigurationMap.put("food", foodConfiguration);
        ShoppingCartService service = new ShoppingCartService(discountConfigurationMap);
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.3), 2, "drinks"),
                new Product("Coffee", BigDecimal.valueOf(3.5), 2, "drinks"),
        new Product("Coffee", BigDecimal.valueOf(8), 2, "food")
        ));
        BigDecimal result = service.calculateTotalPrice(cart);
        Assertions.assertEquals(result, BigDecimal.valueOf(31.84));
    }
}