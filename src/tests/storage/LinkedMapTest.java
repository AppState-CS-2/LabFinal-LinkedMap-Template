package storage;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedMapTest
{
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    @BeforeEach
    public void beforeEach()
    {
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @AfterEach
    public void afterEach()
    {
        System.setOut(oldOut);
    }

    /**
     * Uses no-arg constructor, put, and get.
     */
    @Test
    public void testPutGet1()
    {
        LinkedMap<String, Integer> map = new LinkedMap<>();
        map.put("Hello", 0);
        assertEquals(0, map.get("Hello"));
    }

    /**
     * Uses no-arg constructor, put, and get.
     */
    @Test
    public void testPutGet2()
    {
        LinkedMap<Character, Character> map = new LinkedMap<>();
        map.put('a', 'A');
        assertEquals('A', map.get('a'));
    }

    /**
     * Uses no-arg constructor, put, and get.
     */
    @Test
    public void testPutGet3()
    {
        String[] t = {"Underwent", "the", "sloth", ", ", "nobly"};
        LinkedMap<Integer, String[]> map = new LinkedMap<>();
        map.put(67, t);
        assertEquals(t, map.get(67));
    }

    /**
     * Uses no-arg constructor, put, and toString.
     */
    @Test
    public void testToString1()
    {
        LinkedMap<String, Integer> map = new LinkedMap<>();
        String[] keys = {"this", "is", "whatever", "i", "want"};
        Integer[] values = {5, 65, 4, -3, 6};
        for (int i = 0; i < keys.length; i++)
        {
            map.put(keys[i], values[i]);
        }
        testToString(keys, values, map.toString());
    }

    /**
     * Uses no-arg constructor, put, and toString.
     */
    @Test
    public void testToString2()
    {
        LinkedMap<Integer, Integer[]> map = new LinkedMap<>();
        Integer[] keys = {0, 9, 4, 2, 5};
        Integer[][] values = {{1, 2}, {3, 4}, {-9, -9}, {42, 24, 424, 242}, {7, 77, 777, 7777}};
        for (int i = 0; i < keys.length; i++)
        {
            map.put(keys[i], values[i]);
        }
        testToString(keys, values, map.toString());
    }

    /**
     * Uses no-arg constructor, put, and toString.
     */
    @Test
    public void testToString3()
    {
        LinkedMap<Character, Character> map = new LinkedMap<>();
        Character[] keys = {'n', 'b', '4', 't'};
        Character[] values = {'r', 't', 's', 'l'};
        for (int i = 0; i < keys.length; i++)
        {
            map.put(keys[i], values[i]);
        }
        testToString(keys, values, map.toString());
    }

    /**
     * Uses no-arg constructor, put, clear
     */
    @Test
    public void testClear()
    {
        LinkedMap<Character, Character> map = new LinkedMap<>();
        Character[] keys = {'n', 'b', '4', 't'};
        Character[] values = {'r', 't', 's', 'l'};
        for (int i = 0; i < keys.length; i++)
        {
            map.put(keys[i], values[i]);
        }
        assertNotNull(map.get('n'), "put failed when preparing to test clear");
        assertNotNull(map.get('b'), "put failed when preparing to test clear");
        assertNotNull(map.get('4'), "put failed when preparing to test clear");
        assertNotNull(map.get('t'), "put failed when preparing to test clear");
        map.clear();
        assertNull(map.get('n'), "after clearing, all get requests "
            + "should return null");
        assertNull(map.get('b'), "after clearing, all get requests "
            + "should return null");
        assertNull(map.get('4'), "after clearing, all get requests "
            + "should return null");
        assertNull(map.get('t'), "after clearing, all get requests "
            + "should return null");
        assertEquals(0, map.size(), "After clearing, the map"
            + " should have a size of zero");
    }

    /**
     * Uses no-arg constructor, put, and containsKey
     */
    @Test
    public void testContainsKey()
    {
        LinkedMap<String, Integer> map = new LinkedMap<>();
        String[] keys = {"this", "is", "whatever"};
        Integer[] values = {5, 65, 4};
        for (int i = 0; i < keys.length; i++)
        {
            map.put(keys[i], values[i]);
        }
        assertTrue(map.containsKey("this"));
        assertTrue(map.containsKey("is"));
        assertTrue(map.containsKey("whatever"));
        assertFalse(map.containsKey("5"));
        assertFalse(map.containsKey("THIS"));
        assertFalse(map.containsKey("four"));
    }

    /**
     * Uses no-arg constructor, put, and containsValue
     */
    @Test
    public void testContainsValue()
    {
        LinkedMap<String, Integer> map = new LinkedMap<>();
        String[] keys = {"this", "is", "whatever"};
        Integer[] values = {5, 65, 4};
        for (int i = 0; i < keys.length; i++)
        {
            map.put(keys[i], values[i]);
        }
        assertTrue(map.containsValue(5));
        assertTrue(map.containsValue(65));
        assertTrue(map.containsValue(4));
        assertFalse(map.containsValue(2));
        assertFalse(map.containsValue(3));
        assertFalse(map.containsValue(7));
    }

    /**
     * Uses no-arg constructor, put, and isEmpty
     */
    @Test
    public void testIsEmpty()
    {
        LinkedMap<Integer, String> map = new LinkedMap<>();
        assertTrue(map.isEmpty());
        Integer[] keys = {5, 65, 4};
        String[] values = {"this", "is", "whatever"};
        for (int i = 0; i < keys.length; i++)
        {
            map.put(keys[i], values[i]);
        }
        assertFalse(map.isEmpty());
    }

    /**
     * Uses no-arg constructor, put, get, remove
     */
    @Test
    public void testRemove()
    {
        LinkedMap<Character, Character> map = new LinkedMap<>();
        Character[] keys = {'n', 'b', '4', 't'};
        Character[] values = {'r', 't', 's', 'l'};
        for (int i = 0; i < keys.length; i++)
        {
            map.put(keys[i], values[i]);
        }
        assertNotNull(map.get('b'));
        map.remove('b');
        assertNull(map.get('b'));
        assertNotNull(map.get('4'));
    }

    @Test
    public void testSize1()
    {
        LinkedMap<String, Integer> map = new LinkedMap<>();
        assertEquals(0, map.size());
        String[] keys = {"this", "is", "whatever"};
        Integer[] values = {5, 65, 4};
        for (int i = 0; i < keys.length; i++)
        {
            map.put(keys[i], values[i]);
        }
        assertEquals(3, map.size());
    }

    /**
     * Uses no-arg constructor, put, remove, size
     */
    @Test
    public void testSize2()
    {
        LinkedMap<Character, Character> map = new LinkedMap<>();
        assertEquals(0, map.size());
        Character[] keys = {'n', 'b', '4', 't'};
        Character[] values = {'r', 't', 's', 'l'};
        for (int i = 0; i < keys.length; i++)
        {
            map.put(keys[i], values[i]);
        }
        assertEquals(4, map.size());
        map.remove('b');
        assertEquals(3, map.size());
    }

    /**
     * Helper method that checks a string representation of a map.
     * 
     * @param keys the keys in the map.
     * @param values the values in the map.
     * @param output the toString output from the map.
     */
    private void testToString(Object[] keys, Object[] values, String output)
    {
        assertEquals(output.charAt(0), '<',
            "toString should begin with an opening angle bracket");
        assertEquals(output.charAt(output.length() - 1), '>',
            "toString should end with a closing angle bracket");
        String[] pairs = output.substring(1, output.length() - 1).split(", ");
        assertEquals(keys.length, pairs.length, String.format(
            "toString on a map with %d key/value pairs should have %d comma-separated entries",
            keys.length, keys.length));
        boolean[] found = new boolean[keys.length];
        for (int i = 0; i < keys.length; i++)
        {
            for (int j = 0; j < pairs.length; j++)
            {
                if (pairs[j].equals(String.format("(%s : %s)", keys[i], values[i])))
                {
                    found[i] = true;
                }
            }
        }
        for (int i = 0; i < found.length; i++)
        {
            if (!found[i])
            {
                fail(String.format("Could not find key/value pair (%s : %s) in "
                    + "toString output: %s", keys[i], values[i], output));
            }
        }
    }
}
