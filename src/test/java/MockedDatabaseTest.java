import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MockedDatabaseTest {
    @Mock
    private Database database;

    @Test
    public void testWithMockedDatabase(){
        List<Bun> buns = Arrays.asList(
                new Bun("white bun", 50),
                new Bun("black bun", 150)
        );

        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient(IngredientType.SAUCE, "ketchup", 50),
                new Ingredient(IngredientType.FILLING, "meat", 150)
        );

        Mockito.when(database.availableBuns()).thenReturn(buns);
        Mockito.when(database.availableIngredients()).thenReturn(ingredients);

        List<Bun> resultBuns = database.availableBuns();
        List<Ingredient> resultIngredients = database.availableIngredients();
        Mockito.verify(database, Mockito.times(1)).availableBuns();
        Mockito.verify(database, Mockito.times(1)).availableIngredients();

        Assertions.assertEquals(2, resultBuns.size());
        Assertions.assertEquals("white bun", resultBuns.get(0).getName());

        Assertions.assertEquals(2, resultIngredients.size());
        Assertions.assertEquals("ketchup", resultIngredients.get(0).getName());
    }
}
