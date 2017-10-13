package com.algo.interfaces;

public interface DynamicSetOperations {

    /**
     * insert a key Value pair to Dictionary.
     * @param key Integer key.
     * @param value Value associated with key.
     * @return true if operations successful,
     *         false otherwise.*/
    boolean insert(int key,Object value);

    /**
     * Searches for an element in the Dictionary.
     * @param key item {@link Object} to search for
     * @return key associated with the val {@param val} */
    Object search(int key);

    /**
     * Removes the item with {@param key} from Dictionary.
     * @param key key of item to be removed
     * @return true, if successful,false otherwise.
     * */
    boolean remove(int key);

    /**
     * finds the maximum key element
     *@return maximum key in the Priority Queue */
    int maximum();

    /**
     * finds the minimum key element
     *@return minimum key in the Priority Queue */
    int minimum();

    /**
     *finds successor of a key
     * @param key key of the item whose successor to be found
     * @return key of the successor node
     * */
    int successor(int key);

    /**
     *finds successor of a key
     * @param key key of the item whose predecessor to be found
     * @return key of the predecessor node
     * */
    int predecessor(int key);


}
