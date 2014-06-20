package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.AlgorithmRBTree;

public class AlgorithmRBTreeTest {
    AlgorithmRBTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new AlgorithmRBTree();
    }

    @After
    public void tearDown() throws Exception {
        tree = null;
    }

    @Test
    public void testInsert() throws Exception {
        String word = "Hi!";

        // should insert
        assertTrue(tree.insert(word));

        // shouldnt insert
        assertFalse(tree.insert(word));
    }

    @Test
    public void testContains() throws Exception {
        String word = "Hi!";

        // shouldnt contains
        assertFalse(tree.contains(word));

        tree.insert(word);

        // should caontains
        assertTrue(tree.contains(word));
    }

}
