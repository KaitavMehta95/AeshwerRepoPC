package PrototypePattern;
/*
 * Prototype pattern refers to creating duplicate object while keeping performance in mind.This pattern involves implementing a prototype interface 
 * which tells to create a clone of the current object.This pattern is used when creation of object directly is costly
 */
public class PrototypePatternDemo {
	 public static void main(String[] args) {
	      ShapeCache.loadCache();

	      Shape clonedShape = (Shape) ShapeCache.getShape("1");
	      System.out.println("Shape : " + clonedShape.getType());		

	      Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
	      System.out.println("Shape : " + clonedShape2.getType());		
	 }
}