package package2;
import package1.Animal;

public class BabyDog extends Puppy{
	
	public static void main(String[] args){
		Animal a=new Animal();
		a.display();
		System.out.println(a.age);
	}
}