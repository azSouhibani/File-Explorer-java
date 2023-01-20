package hw2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application{
	
	Pane root = new Pane();
	TextArea output = new TextArea();
	EDoc rootFolder = new Folder("/Users/abdulaziz/Desktop/TESTfolder");  

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Folder Traverse"); 
		
		
		TreeView<EDoc> tree = displayTree(rootFolder);
		
        output.setEditable(false);
        output.setText("");
        output.setLayoutX(300);
        output.setLayoutY(10);
        output.setMinWidth(200);
        output.setMinHeight(400);

        root.getChildren().add(tree);
        root.getChildren().add(output);
  
        
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.show();
	}

	public void createTree(EDoc dir, TreeItem<EDoc> parent) {
      
		if(dir.isDir()) {
			TreeItem<EDoc> item = new TreeItem<>(dir);
			parent.getChildren().add(item);
			
			for(int i =0; i < dir.getAllChildren().size(); i++) {
				EDoc folder = dir.getAllChildren().get(i);
				createTree(folder,item);
			}
		}
		
		else
			parent.getChildren().add(new TreeItem<EDoc>(dir));
	}
	
	public TreeView<EDoc> displayTree(EDoc folder) {
		
		TreeItem<EDoc> rootItem = new TreeItem<EDoc>(folder);
		
		TreeView<EDoc> tree = new TreeView<EDoc> (rootItem); 
		tree.setShowRoot(false);
		

		createTree(folder,rootItem);
		
		tree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		    if(newValue != null && newValue != oldValue && observable.getValue().getValue().isDir()){
		    	
		    	EDoc selectedDocument = observable.getValue().getValue();
		    	addText(selectedDocument.getChildToStr(1));
		    	
		    }
		    
		    else if(newValue != null && newValue != oldValue && !observable.getValue().getValue().isDir()) {
		    	String nodePath = observable.getValue().getValue().pathName;
		    	File subFolder = new File(nodePath);
		    	addText(subFolder.getChildToStr(1));
		    }
		});
		
        tree.setMinWidth(150);
        tree.setMaxHeight(400);
        tree.setLayoutX(10);
        tree.setLayoutY(10);
        
        tree.setRoot(rootItem);
        
        return tree;
	}

	public void addText(String txt) {
		output.clear();
		output.setText(txt);
	}
	

}
