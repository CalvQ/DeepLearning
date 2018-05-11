import java.util.Arrays;
import java.util.HashSet;

public class Test {
    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args){
        String temp = "asdfh";

        recurseComb(temp, "", 0, 2);

        System.out.println();System.out.println();System.out.println();
        for(String s: set){
            System.out.println(s);
        }
    }

    private static void recurseComb(String str, String built, int index, int count){
        System.out.println();

        System.out.println("Recurse: " + str + " " + built + " " + index + " " + count);
        if(count==0){
//            set.add(alphabetize(built + str.charAt(index)));
            System.out.println(alphabetize(built) + " terminate _____");
            set.add(alphabetize(built));
        }else {
            for (int i = index; i <= str.length() - count; i++) {
                System.out.println(i);
                System.out.println("Char: " + str.charAt(index));
                recurseComb(str, built + str.charAt(i), i + 1, count - 1);
            }
        }
    }

    private static String alphabetize(String s){
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        StringBuilder out = new StringBuilder();
        for(char c:temp){
            out.append(c);
        }
        return out.toString();
    }
}


