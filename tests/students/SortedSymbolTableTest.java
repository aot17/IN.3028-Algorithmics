package students;

import ch.unifr.algo2023.students.search.BinarySearchTree;
import org.junit.Test;

public class SortedSymbolTableTest {

    @Test
    public void test() {
        BinarySearchTree<Character, Integer> table = new BinarySearchTree<Character, Integer>();

        String str = "EASYQUESTION";

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);

            table.put(c, i);
        }

        for (Character c : table.keys()) {
            System.out.println("Key:" + c + " -> Val:" + table.get(c));
        }

        assert !table.isEmpty();
        assert table.size() == 10;

        assert table.contains('I');
        assert table.contains('S');
        assert table.contains('E');
        assert table.contains('A');

        assert table.get('I') == 9;
        assert table.get('S') == 7;
        assert table.get('E') == 6;

        assert table.min() == 'A';
        table.deleteMin();
        assert table.min() == 'E';

        assert table.get(table.floor('Z')) == 3;
        assert table.get(table.ceiling('P')) == 4;

        table.deleteMax();
        assert table.get(table.floor('Z')) == 5;
    }
}