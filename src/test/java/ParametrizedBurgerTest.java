import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.stream.Stream;

public class ParametrizedBurgerTest {
    public static Stream<Arguments> burgerData() {
        return Stream.of(
                Arguments.of(new Bun("black bun", 50),
                        new Ingredient(IngredientType.FILLING, "filling cutlet", 10),
                        new Ingredient(IngredientType.SAUCE, "ketchup", 5),
                        50 * 2 + 10 + 5),
                Arguments.of(new Bun("white bun", 60),
                        new Ingredient(IngredientType.FILLING, "filling dinosaur", 12),
                        new Ingredient(IngredientType.SAUCE, "sauce sour cream", 4),
                        60 * 2 + 12 + 4)
        );
    }

    @ParameterizedTest
    @MethodSource("burgerData")
    public void parametrizedBurgerPriceTest(Bun bun, Ingredient ing1, Ingredient ing2, float expectedPrice){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ing1);
        burger.addIngredient(ing2);

        Assertions.assertEquals(expectedPrice, burger.getPrice());
    }
}
