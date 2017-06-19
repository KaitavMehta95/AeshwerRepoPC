package AbstractFactoryPattern;
/*
 * Create a Factory to generate object of concrete class based on given information.
 */
public class ShapeFactory extends AbstractFactory{
	   //use getShape method to get object of type shape 
	   public Shape getShape(String shapeType){
	      if(shapeType == null){
	         return null;
	      }		
	      if(shapeType.equalsIgnoreCase("CIRCLE")){
	         return new Circle();
	         
	      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
	         return new Rectangle();
	         
	      } else if(shapeType.equalsIgnoreCase("SQUARE")){
	         return new Square();
	      }
	      
	      return null;
	   }

	   @Override
	   Colour getColour(String color) {
		return null;
	}
}