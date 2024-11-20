package storage;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * The LinkedMap class implements Map.
 * 
 * A map is a data structure that behaves something like an ArrayList.
 * Whereas an ArrayList stores values based on an int index (e.g.,
 * list.set(0, “hello”)), a map stores values based on an object
 * called the key.
 * 
 * For example, you might want to store the room numbers for
 * employees in a directory. If the employee is represented as a
 * String and the room number is an Integer, it might look like this:
 * 
 * Key                  Value
 * “Willow Sapphire”    308
 * “Shay McCann”        312
 * “Danielle Lapensée-  312
 * Rankine”
 * 
 * The Map is a generic interface where the type of key and value
 * are determined in the declaration of the map object.
 * 
 * @param <K> the datatype of the keys.
 * @param <V> the datatype of the values.
 * 
 * @author Val Lapensée-Rankine
 * @version 11/19/2024
 */
public class LinkedMap<K, V> implements Map<K, V> {
    
    // declare fields below

    // declare methods below

    // unsupported methods
    /**
     * values() method, unsupported for this lab final.
     * 
     * @throws UnsupportedOperationException as values is unsupported.
     */
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    /**
     * values() method, unsupported for this lab final.
     * 
     * @throws UnsupportedOperationException as values is unsupported.
     */
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    /**
     * values() method, unsupported for this lab final.
     * 
     * @throws UnsupportedOperationException as values is unsupported.
     */
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /**
     * values() method, unsupported for this lab final.
     * 
     * @throws UnsupportedOperationException as values is unsupported.
     */
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }
}