import java.util.ArrayList;
import java.util.List;

public class A{
    public void fly(){
        System.out.println("A");
    }
    public void test(){
        System.out.println("testing");
    }

    @Override
    public String toString(){
        return "Hi";
    }

    public static void main(String[] args){
        List<String> list = new ArrayList<>();

        A test = new A();
        System.out.println(test);
//        System.out.println((String) test);
    }
}
