import org.junit.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AutomobileSorterTest {
    List<Automobile> carlist;
    Automobile car1, car2, car3, car4;

    @Before
    public void setUp() throws Exception {
        car1 = new Automobile();
        car1.milesPerGallon = 25;
        car1.price = 11000;
        car1.name = "Subcompact";

        car2 = new Automobile();
        car2.milesPerGallon = 16;
        car2.price = 36400;
        car2.name = "Sports";

        car3 = new Automobile();
        car3.milesPerGallon = 25;
        car3.price = 16500;
        car3.name = "Compact";

        car4 = new Automobile();
        car4.milesPerGallon = 22;
        car4.price = 72000;
        car4.name = "Luxury";

        carlist = new ArrayList<Automobile>();
        carlist.add(car1);
        carlist.add(car2);
        carlist.add(car3);
        carlist.add(car4);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSort() throws Exception {
        List<Automobile> resultList;

        resultList = AutomobileSorter.sort(carlist, AutomobileSorter.Order.Name, true);
        assertEquals(car3, resultList.get(0));
        assertEquals(car4, resultList.get(1));
        assertEquals(car2, resultList.get(2));
        assertEquals(car1, resultList.get(3));

        resultList = AutomobileSorter.sort(carlist, AutomobileSorter.Order.Price, true);
        assertEquals(car1, resultList.get(0));
        assertEquals(car3, resultList.get(1));
        assertEquals(car2, resultList.get(2));
        assertEquals(car4, resultList.get(3));

        resultList = AutomobileSorter.sort(carlist, AutomobileSorter.Order.MPG, true);
        assertEquals(car2, resultList.get(0));
        assertEquals(car4, resultList.get(1));

        resultList = AutomobileSorter.sort(carlist, "name", false);
        assertEquals(car3, resultList.get(3));
        assertEquals(car4, resultList.get(2));
        assertEquals(car2, resultList.get(1));
        assertEquals(car1, resultList.get(0));

        resultList = AutomobileSorter.sort(carlist, "price", false);
        assertEquals(car1, resultList.get(3));
        assertEquals(car3, resultList.get(2));
        assertEquals(car2, resultList.get(1));
        assertEquals(car4, resultList.get(0));

        resultList = AutomobileSorter.sort(carlist, "milesPerGallon", false);
        assertEquals(car2, resultList.get(3));
        assertEquals(car4, resultList.get(2));

    }
}