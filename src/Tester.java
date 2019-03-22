import dynamicArray.DynamicArray;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tester {
    public static void main(String[] args) {
        int index = 10000000;
        DataType dataType = DataType.DYNAMIC_ARRAY;
        Scenario scenario = Scenario.READ_ALL;

        switch (dataType) {//you have to test them one at a time otherwise the results for time and memory use don't appear to be right
            case DYNAMIC_ARRAY: {
                dynamicArray(index, scenario);
                break;
            }
            case ARRAY: {
                array(index, scenario);
                break;
            }
            case LINKED_LIST: {
                linkedList(index, scenario);
                break;
            }
            case ARRAY_LIST: {
                arrayList(index, scenario);
                break;
            }
        }
    }

    private static void dynamicArray(int index, Scenario scenario) {
        Runtime runtime = Runtime.getRuntime();
        long before = runtime.totalMemory() - runtime.freeMemory();
        DynamicArray<String> strings = new DynamicArray<>();

        long start = System.currentTimeMillis();

        strings.set(index, "" + index);

        switch (scenario) {
            case READ_ALL: {
                for (String s : strings) {
                    if(s != null) {
                        System.out.println(s);
                    }
                }
                break;
            }
            case READ_INDEX: {
                System.out.println("Value at index " + index + " is " + strings.get(index));
                break;
            }
        }

        long end = System.currentTimeMillis();
        long after = runtime.totalMemory() - runtime.freeMemory();
        format(before, start, end, after);
    }

    private static void linkedList(int index, Scenario scenario) {
        Runtime runtime = Runtime.getRuntime();
        long before = runtime.totalMemory() - runtime.freeMemory();
        LinkedList<String> strings = new LinkedList<>();

        long start = System.currentTimeMillis();

        for(int i = 0; i < index + 1; i++) {
            if(i == index) {
                strings.add("" + index);
            } else {
                strings.add(null);
            }
        }

        switch (scenario) {
            case READ_ALL: {
                for (String s : strings) {
                    if(s != null) {
                        System.out.println(s);
                    }
                }
                break;
            }
            case READ_INDEX: {
                System.out.println("Value at index " + index + " is " + strings.get(index));
                break;
            }
        }

        long end = System.currentTimeMillis();
        long after = runtime.totalMemory() - runtime.freeMemory();
        format(before, start, end, after);
    }

    private static void array(int index, Scenario scenario) {
        Runtime runtime = Runtime.getRuntime();
        long before = runtime.totalMemory() - runtime.freeMemory();
        String[] strings = new String[index + 1];

        long start = System.currentTimeMillis();

        strings[index] = index + "";

        for(int i = 0; i < strings.length; i++) {
            if(i == index) {
                strings[i] = i + "";
            } else {
                strings[i] = null;
            }
        }

        switch (scenario) {
            case READ_ALL: {
                for (String s : strings) {
                    if(s != null) {
                        System.out.println(s);
                    }
                }
                break;
            }
            case READ_INDEX: {
                System.out.println("Value at index " + index + " is " + strings[index]);
                break;
            }
        }

        long end = System.currentTimeMillis();
        long after = runtime.totalMemory() - runtime.freeMemory();
        format(before, start, end, after);
    }

    private static void arrayList(int index, Scenario scenario) {
        Runtime runtime = Runtime.getRuntime();
        long before = runtime.totalMemory() - runtime.freeMemory();
        ArrayList<String> strings = new ArrayList<>();

        long start = System.currentTimeMillis();

        for(int i = 0; i < index + 1; i++) {
            if(i == index) {
                strings.add("" + i);
            } else {
                strings.add(null);
            }
        }

        switch (scenario) {
            case READ_ALL: {
                for (String s : strings) {
                    if(s != null) {
                        System.out.println(s);
                    }
                }
                break;
            }
            case READ_INDEX: {
                System.out.println("Value at index " + index + " is " + strings.get(index));
                break;
            }
        }

        long end = System.currentTimeMillis();
        long after = runtime.totalMemory() - runtime.freeMemory();
        format(before, start, end, after);
    }

    private static void format(long before, long start, long end, long after) {
        System.out.println("Hundredths of a second: " + (end - start) / 10);
        System.out.println("Seconds: " + (end - start) / 1000);
        System.out.println("Bytes: " + (after - before));
        System.out.println("Megabytes: " + ((after - before) / 1000000));
        System.out.println();
    }
}
