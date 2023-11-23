package storage;

/**
 * A Node class that holds both the key and 
 * the value of a key-value pair for a map.
 * 
 * @param <K> the datatype of the keys.
 * @param <V> the datatype of the values.
 * 
 * @author Val Lapensée-Rankine
 * @author Willow Sapphire
 * @version 11/23/2023
 */
public class Node<K, V>
{
    /**
     * The key associated with the Node.
     */
    private K key;

    /**
     * The value associated with the node.
     */
    private V value;

    /**
     * The next node in the linked list.
     */
    private Node<K, V> link;

    /**
     * Three-arg constructor that sets the
     * key, value, and link of the Node.
     * 
     * @param key the key of the created Node.
     * @param value the key of the created Node.
     * @param link the link of the created Node.
     */
    public Node(K key, V value, Node<K, V> link)
    {
        this.key = key;
        this.value = value;
        this.link = link;
    }

    /**
     * Accessor for key field.
     * 
     * @return the key of the key-value pair.
     */
    public K getKey()
    {
        return key;
    }

    /**
     * Accessor for value field.
     * 
     * @return the value of the key-value pair.
     */
    public V getValue()
    {
        return value;
    }

    /**
     * Accessor for link field.
     * 
     * @return the Node that this Node is linked to.
     */
    public Node<K, V> getLink()
    {
        return link;
    }

    /**
     * Mutator for the key field.
     * 
     * @param key to set the key.
     */
    public void setKey(K key)
    {
        this.key = key;
    }

    /**
     * Mutator for the value field.
     * 
     * @param value to set the value.
     */
    public void setValue(V value)
    {
        this.value = value;
    }

    /**
     * Mutator for the link field.
     * 
     * @param link to change the Node this NOde is linked to.
     */
    public void setLink(Node<K, V> link)
    {
        this.link = link;
    }
}
