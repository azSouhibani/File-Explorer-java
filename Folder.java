package hw2;

import java.util.ArrayList;

public class Folder extends EDoc{
	
	
	private ArrayList<EDoc> children = new ArrayList<>();
	
	public Folder(String path) {
		super(path);
		traverse(path);
	}
	
	public String getName() {
		java.io.File file = new java.io.File(pathName);
		return file.getName();
	}

	public void setName(String name) {
		super.pathName = name;
	}

	@Override
	public void add(EDoc doc) {
		
		children.add(doc);
	}

	@Override
	public void remove(EDoc doc) {
		
		children.remove(doc);
	}

	@Override
	public void getChild(int depth) {

		System.out.println(" ".repeat(depth) + getName() +" (" + calculateSize() + " KB)");
		
		for(EDoc doc: children) {
			doc.getChild(depth + 2);
		}
	}
	
	@Override
	public int calculateSize() {
		
		int size = 0;
		for(EDoc doc: children) {
			size += doc.calculateSize();
		}
		
		return size;
		
	}
	
	public void traverse(String path) {
		java.io.File edoc = new java.io.File(path);
		
		if(edoc.isDirectory()) {
			java.io.File folder[] = edoc.listFiles();
			
			for(int i=0; folder!= null && i < folder.length; i++) {
				String name = folder[i].getAbsoluteFile().toString();
				
				if(folder[i].isDirectory())
					add(new Folder(name));
				else
					add(new File(name));
				
			}
		}
		
		else 
			add(new File(path));
	}
	
	public ArrayList<EDoc> getAllChildren(){
		return children;
	}

	
	@Override
	public boolean isDir() {
		return true;
	}

	
	@Override
	public String getChildToStr(int depth) {
		String name = " ".repeat(depth) + getName() +" (" + calculateSize() + " KB)\n";
		
		for(EDoc doc: children) {
			name += doc.getChildToStr(depth + 2);
		}
		return name;
	}

}


