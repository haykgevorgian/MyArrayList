import java.util.*;

public class Main {
    public static void main(String[] args) {
        Object[] str = new Object[3];
        List<Integer> numbers = new MyArrayList<>();
        List<Integer> nums = new MyArrayList<>();
        numbers.add(0);numbers.add(0,3);
        nums.add(0);nums.add(0,3);
        str = numbers.toArray(str);
        System.out.println(numbers);
        System.out.println(numbers.size());
        System.out.println(nums);
        System.out.println(nums.size());
        System.out.println(numbers.equals(nums));
        System.out.println(numbers.hashCode());
        numbers.addAll(nums);
        System.out.println(numbers.hashCode());
    }
}
