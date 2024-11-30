import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import praktikum.Bun;

@RunWith(JUnit4.class)
public class BunTest {
    @Test
    public void getNameTest() {
        String expected = "Big Burger";
        Bun bun = new Bun(expected, 100);
        String actual = bun.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        float expected = 100;
        Bun bun = new Bun("Big Burger", expected);
        float actual = bun.getPrice();
        Assert.assertEquals(expected, actual, 0.01);
    }
}
