import com.sergosoft.railwaymanager.railwaycar.RailwayCar;
import com.sergosoft.railwaymanager.railwaycar.passenger.ComfortType;
import com.sergosoft.railwaymanager.railwaycar.passenger.PassengerRailwayCar;
import com.sergosoft.wagonlist.RailwayCarList;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RailwayCarListTests {

    private RailwayCarList railwayCarList;

    @Before
    public void setUp() {
        railwayCarList = new RailwayCarList();
    }

    private PassengerRailwayCar createPassengerRailwayCar(int seats) {
        return new PassengerRailwayCar(20, 3, 200, 30, 10000f, seats, ComfortType.COUPE);
    }

    @Test
    public void testAdd() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        railwayCarList.add(railwayCar1);
        assertEquals(1, railwayCarList.size());
        assertSame(railwayCar1, railwayCarList.get(0));
    }

    @Test
    public void testAddAtIndex() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        PassengerRailwayCar railwayCar2 = createPassengerRailwayCar(130);
        railwayCarList.add(railwayCar1);
        railwayCarList.add(0, railwayCar2); // Adding at index 0
        assertEquals(2, railwayCarList.size());
        assertSame(railwayCar2, railwayCarList.get(0)); // Ensure it was added at the correct position
        assertSame(railwayCar1, railwayCarList.get(1)); // Ensure it shifted the other element
    }

    @Test
    public void testRemoveByIndex() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        railwayCarList.add(railwayCar1);
        PassengerRailwayCar removedCar = (PassengerRailwayCar) railwayCarList.remove(0);
        assertEquals(0, railwayCarList.size());
        assertSame(railwayCar1, removedCar);
    }

    @Test
    public void testRemoveByObject() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        railwayCarList.add(railwayCar1);
        assertTrue(railwayCarList.remove(railwayCar1));
        assertEquals(0, railwayCarList.size());
    }

    @Test
    public void testContains() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        railwayCarList.add(railwayCar1);
        assertTrue(railwayCarList.contains(railwayCar1));
    }

    @Test
    public void testClear() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        railwayCarList.add(railwayCar1);
        railwayCarList.clear();
        assertEquals(0, railwayCarList.size());
        assertFalse(railwayCarList.contains(railwayCar1));
    }

    @Test
    public void testIndexOf() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        PassengerRailwayCar railwayCar2 = createPassengerRailwayCar(130);
        railwayCarList.add(railwayCar1);
        railwayCarList.add(railwayCar2);
        assertEquals(0, railwayCarList.indexOf(railwayCar1));
        assertEquals(1, railwayCarList.indexOf(railwayCar2));
    }

    @Test
    public void testLastIndexOf() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        PassengerRailwayCar railwayCar2 = createPassengerRailwayCar(130);
        railwayCarList.add(railwayCar1);
        railwayCarList.add(railwayCar2);
        railwayCarList.add(railwayCar1); // Add railwayCar1 again at the end
        assertEquals(2, railwayCarList.lastIndexOf(railwayCar1));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(railwayCarList.isEmpty());
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        railwayCarList.add(railwayCar1);
        assertFalse(railwayCarList.isEmpty());
    }

    @Test
    public void testAddAll() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        PassengerRailwayCar railwayCar2 = createPassengerRailwayCar(130);
        List<PassengerRailwayCar> carList = Arrays.asList(railwayCar1, railwayCar2);
        railwayCarList.addAll(carList);
        assertEquals(2, railwayCarList.size());
        assertSame(railwayCar1, railwayCarList.get(0));
        assertSame(railwayCar2, railwayCarList.get(1));
    }

    @Test
    public void testSubList() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        PassengerRailwayCar railwayCar2 = createPassengerRailwayCar(130);
        PassengerRailwayCar railwayCar3 = createPassengerRailwayCar(140);
        railwayCarList.addAll(Arrays.asList(railwayCar1, railwayCar2, railwayCar3));
        List<RailwayCar> subList = railwayCarList.subList(1, 3);
        assertEquals(2, subList.size());
        assertSame(railwayCar2, subList.get(0));
        assertSame(railwayCar3, subList.get(1));
    }

    @Test
    public void testToArray() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        PassengerRailwayCar railwayCar2 = createPassengerRailwayCar(130);
        railwayCarList.addAll(Arrays.asList(railwayCar1, railwayCar2));
        Object[] array = railwayCarList.toArray();
        assertEquals(2, array.length);
        assertSame(railwayCar1, array[0]);
        assertSame(railwayCar2, array[1]);
    }

    @Test
    public void testToArrayWithType() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        PassengerRailwayCar railwayCar2 = createPassengerRailwayCar(130);
        railwayCarList.addAll(Arrays.asList(railwayCar1, railwayCar2));
        PassengerRailwayCar[] array = railwayCarList.toArray(new PassengerRailwayCar[0]);
        assertEquals(2, array.length);
        assertSame(railwayCar1, array[0]);
        assertSame(railwayCar2, array[1]);
    }

    @Test
    public void testRetainAll() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        PassengerRailwayCar railwayCar2 = createPassengerRailwayCar(130);
        railwayCarList.addAll(Arrays.asList(railwayCar1, railwayCar2));
        List<PassengerRailwayCar> retainList = Arrays.asList(railwayCar1);
        railwayCarList.retainAll(retainList);
        assertEquals(1, railwayCarList.size());
        assertSame(railwayCar1, railwayCarList.get(0));
    }

    @Test
    public void testRemoveAll() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        PassengerRailwayCar railwayCar2 = createPassengerRailwayCar(130);
        railwayCarList.addAll(Arrays.asList(railwayCar1, railwayCar2));
        List<PassengerRailwayCar> removeList = Arrays.asList(railwayCar1);
        railwayCarList.removeAll(removeList);
        assertEquals(1, railwayCarList.size());
        assertSame(railwayCar2, railwayCarList.get(0));
    }

    @Test
    public void testIterator() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        PassengerRailwayCar railwayCar2 = createPassengerRailwayCar(130);
        railwayCarList.addAll(Arrays.asList(railwayCar1, railwayCar2));
        assertTrue(railwayCarList.iterator().hasNext());
        assertSame(railwayCar1, railwayCarList.iterator().next());
    }

    @Test
    public void testListIterator() {
        PassengerRailwayCar railwayCar1 = createPassengerRailwayCar(120);
        PassengerRailwayCar railwayCar2 = createPassengerRailwayCar(130);
        railwayCarList.addAll(Arrays.asList(railwayCar1, railwayCar2));
        assertTrue(railwayCarList.listIterator().hasNext());
        assertSame(railwayCar1, railwayCarList.listIterator().next());
    }
}
