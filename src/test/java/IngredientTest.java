import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "Ketchup", 20.0f);
    Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "Meat", 60.0f);
    @Test
    public void ingredientConstructorTest(){
        Assertions.assertNotNull(ingredient1, "Объект ingredient не был создан");
    }
    @Test
    public void ingredientGetTypeTest(){
        Assertions.assertEquals(IngredientType.SAUCE, ingredient1.getType());
        Assertions.assertEquals(IngredientType.FILLING, ingredient2.getType());
    }
    @Test
    public void ingredientGetNameTest(){
        Assertions.assertEquals("Ketchup", ingredient1.getName());
    }
    @Test
    public void ingredientGetPriceTest(){
        Assertions.assertEquals(20.0f, ingredient1.getPrice());
    }
}
