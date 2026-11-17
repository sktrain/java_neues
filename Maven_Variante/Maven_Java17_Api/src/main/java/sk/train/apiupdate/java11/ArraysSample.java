
package sk.train.apiupdate.java11;

import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * neue Methoden für Arrays
 */

public class ArraysSample {
    public static void main(final String[] args) throws Exception
    {
        final byte[] a = "Hallo Welt".getBytes();
        final byte[] b = "Hallo JDK 9".getBytes();
        final byte[] c = "JDK 9 Release".getBytes();

        executeEquals(a, b, c);
        executeMismatch(a, b, c);
        executeCompare(a, b, c);
    }

    private static void executeEquals(final byte[] a, final byte[] b, final byte[] c) throws Exception
    {
        perform("\nequals", a, 0, 6, b, 0, 6, () -> Arrays.equals(a, 0, 6, b, 0, 6));

        perform("equals", a, 0, 7, b, 0, 7, () -> Arrays.equals(a, 0, 7, b, 0, 7));

        perform("equals", c, 0, 5, b, 6, 11, () -> Arrays.equals(c, 0, 5, b, 6, 11));
    }

    private static void executeMismatch(final byte[] a, final byte[] b, final byte[] c) throws Exception
    {
        perform("\nmismatch", a, 0, 6, b, 0, 6, () -> Arrays.mismatch(a, 0, 6, b, 0, 6));

        perform("mismatch", a, 0, 7, b, 0, 7, () -> Arrays.mismatch(a, 0, 7, b, 0, 7));
    }

    private static void executeCompare(final byte[] a, final byte[] b, final byte[] c) throws Exception
    {
        perform("\ncompare", a, 0, 6, b, 0, 6, () -> Arrays.compare(a, 0, 6, b, 0, 6));

        perform("compare", a, 0, 7, b, 0, 7, () -> Arrays.compare(a, 0, 7, b, 0, 7));

        perform("compare", b, 0, 5, c, 0, 5, () -> Arrays.compare(b, 0, 5, c, 0, 5));
    }

    private static void perform(final String info, final byte[] array1, final int start1, final int end1,
                                final byte[] array2, final int start2, final int end2, final Callable<Object> action)
                    throws Exception
    {
        final String value1 = new String(array1, start1, end1 - start1);
        final String value2 = new String(array2, start2, end2 - start2);
        System.out.print(info + "('" + value1 + "', '" + value2 + "') => ");
        System.out.println(action.call());
    }
}
