import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import praktikum.Bun;

public class BunTest {
    @Test
    public void bunConstructorAndGettersTest(){
        Bun bun = new Bun("Bulka", 50.0f);
        Assertions.assertEquals("Bulka", bun.getName());
        Assertions.assertEquals(50.f, bun.getPrice());
    }
}
