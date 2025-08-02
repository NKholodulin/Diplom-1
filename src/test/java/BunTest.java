import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun("Bulka", 50.0f);
    @Test
    public void bunConstructorTest() {
        Assertions.assertNotNull(bun, "Объект Bun не был создан");
    }

    @Test
    public void bunGetNameTest() {
        Assertions.assertEquals("Bulka", bun.getName());
    }

    @Test
    public void bunGetPriceTest() {
        Assertions.assertEquals(50.f, bun.getPrice());
    }
}
