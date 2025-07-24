import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngedientTest {
    @Test
    public void ingredientConstructorAndGetterTest(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 20.0f);
        Assertions.assertEquals(IngredientType.SAUCE, ingredient.getType());
        Assertions.assertEquals("Ketchup", ingredient.getName());
        Assertions.assertEquals(20.0f, ingredient.getPrice());
    }
}
