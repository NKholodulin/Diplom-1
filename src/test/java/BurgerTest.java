import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import praktikum.*;

public class BurgerTest {
    @Test
    public void burgerMoveAndRemoveIngredientTest(){
        Bun bun = new Bun("Bulka", 10.0f);
        Ingredient ing1 = new Ingredient(IngredientType.SAUCE, "Ketchup", 15.0f);
        Ingredient ing2 = new Ingredient(IngredientType.FILLING, "Meat", 50.0f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ing1);
        burger.addIngredient(ing2);

        String[] lines = burger.getReceipt().split("\n");
        Assertions.assertEquals("= sauce Ketchup =", lines[1].trim());
        Assertions.assertEquals("= filling Meat =", lines[2].trim());

        burger.moveIngredient(0,1);
        lines = burger.getReceipt().split("\n");
        Assertions.assertEquals("= filling Meat =", lines[1].trim());
        Assertions.assertEquals("= sauce Ketchup =", lines[2].trim());

        burger.removeIngredient(1);
        lines = burger.getReceipt().split("\n");
        Assertions.assertEquals("= filling Meat =", lines[1].trim());
        Assertions.assertEquals("(==== Bulka ====)", lines[2].trim());
    }
}
