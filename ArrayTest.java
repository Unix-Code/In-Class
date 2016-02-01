public class ArrayTest {
    public static void main(String[] args) {
        int[] array = {7, 8 , 10, 11, 4, 3};
        array[array[0]/2] = 15;
        array[array[4]+1] = 9;
        array[array.length/2 -1] = 5;
        array[1] = array[0] + 4;
        System.out.println(array[0]);
    }
}