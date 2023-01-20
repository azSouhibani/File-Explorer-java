package hw2;

import java.util.ArrayList;

public abstract class EDoc {
	
	protected String pathName;
	
	public EDoc(String path) {
		this.pathName = path;
	}
	
	public abstract void add(EDoc doc); 
	
	public abstract void remove(EDoc doc);
	
	public abstract void getChild(int depth);
	
	public abstract int calculateSize();

	public abstract ArrayList<EDoc> getAllChildren();
	
	public abstract boolean isDir();
	
	public abstract String getName();
	
	public abstract String getChildToStr(int depth);
	
	@Override
	public String toString() {
	    return this.getName();
	}
}
