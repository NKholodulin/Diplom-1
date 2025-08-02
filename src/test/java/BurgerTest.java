import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.*;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ing1;
    @Mock
    private Ingredient ing2;

    @BeforeEach
    public void PreReq(){
        Mockito.when(bun.getName()).thenReturn("Bulka");
        Mockito.when(bun.getPrice()).thenReturn(10.0f);

        Mockito.when(ing1.getName()).thenReturn("Ketchup");
        Mockito.when(ing1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ing1.getPrice()).thenReturn(15.0f);

        Mockito.when(ing2.getName()).thenReturn("Meat");
        Mockito.when(ing2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ing2.getPrice()).thenReturn(50.0f);


    }

    @Test
    public void burgerAddIngredientTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ing1);
        burger.addIngredient(ing2);

        String[] lines = burger.getReceipt().split("\n");
        Assertions.assertEquals("= sauce Ketchup =", lines[1].trim());
        Assertions.assertEquals("= filling Meat =", lines[2].trim());
    }
    @Test
    public void burgerMoveIngredientTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ing1);
        burger.addIngredient(ing2);

        burger.moveIngredient(0,1);
        String[] lines = burger.getReceipt().split("\n");
        Assertions.assertEquals("= filling Meat =", lines[1].trim());
        Assertions.assertEquals("= sauce Ketchup =", lines[2].trim());
    }
    @Test
    public void burgerRemoveIngredientTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ing1);
        burger.addIngredient(ing2);
        String[] lines = burger.getReceipt().split("\n");

        burger.removeIngredient(1);
        lines = burger.getReceipt().split("\n");
        Assertions.assertEquals("= sauce Ketchup =", lines[1].trim());
        Assertions.assertEquals("(==== Bulka ====)", lines[2].trim());
    }
}
