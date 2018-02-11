/**
 * Created by Ivan on 05.01.2018.
 */
public class InnerClassCheck {
    public Ain f1(){
      return new Ain(){
          @Override
          public void foo() {
              System.out.println("test");
          }
      };
    }

    public class Ain{
       public void foo(){

       }
    }
}
