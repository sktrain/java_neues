package other.samples.reactive;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MethodLogger {

    private static final Object lock = new Object();

    public static boolean enabled = true;

    public static void logMethodCall() {
        synchronized (lock) {
            final List<StackWalker.StackFrame> stack = StackWalker.getInstance()
                    .walk(s -> s.limit(2).collect(Collectors.toList()));
            System.out.println(" ");
            System.out.println("\u001b[36;3m/" + "-".repeat(79));
            System.out.println("| " + getSimpleClassName(stack.get(1).getClassName()) + "." + stack.get(1).getMethodName());
            System.out.println("\\" + "-".repeat(79) + "\u001b[0m");
            start();
        }
    }

    private static final Map<Long, Integer> indents = new HashMap<>();

    private static int indent = 0;

    public static void start() {
        indent = 0;
        indents.clear();
    }

    public static void tlogEnter(Object... params) {
        if (!enabled)
            return;
        synchronized (lock) {
            printIndent();
            String s = Arrays.stream(params)
                    .map(p -> p == null ? "null" : p.toString())
                    .collect(Collectors.joining(", "));
            System.out.printf("[%2d] >> %s(%s)\n", Thread.currentThread().getId(), methodName(), s);
        }
    }

    public static void tlogExit() {
        if (!enabled)
            return;
        synchronized (lock) {
            printIndent();
            System.out.printf("[%2d] << %s()\n", Thread.currentThread().getId(), methodName());
        }
    }

    public static void tlog(Object msg) {
        if (!enabled)
            return;
        synchronized (lock) {
            printIndent();
            System.out.printf("[%2d] -- %s\n", Thread.currentThread().getId(), msg);
        }
    }

    private static final StackWalker walker = StackWalker.getInstance();

    private static void printIndent() {
        int i = indents.computeIfAbsent(Thread.currentThread().getId(), k -> indent++);
        while (i-- > 0)
            System.out.print("    ");
    }

    private static String methodName() {
        StackWalker.StackFrame frame = walker
                .walk(s -> s.limit(3).collect(Collectors.toList())).get(2);
        String name = frame.getClassName();
        int index = name.lastIndexOf('.');
        if (index > 0)
            name = name.substring(index + 1);
        name += "." + frame.getMethodName();
        return name;
    }

    /**
     * Drops the package name and returns just the name of the class (a.k.a. the "simple name")
     */
    private static String getSimpleClassName(String className) {
        int dotIndex = className.lastIndexOf(".");
        return className.substring(dotIndex + 1);
    }
}
