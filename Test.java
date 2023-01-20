package hw2;

public class Test {

	public static void main(String[] args) {
		
		Folder root = new Folder("/Users/abdulaziz/Desktop/TESTfolder");
													        
//		root.getChild(1);
		
		for(int i=0; i < root.getAllChildren().size(); i++)
			System.out.println(root.getAllChildren().get(i).getName());
		

	}

}
