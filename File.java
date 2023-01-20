package hw2;

import java.util.ArrayList;

public class File extends EDoc{
	
	private String extension;
	
	public File(String name) {
		super(name);
	}
	
	@Override
	public String getName() {
		java.io.File file = new java.io.File(pathName);
		return file.getName();
	}

	public void setName(String path) {
		this.pathName = path;
	}

	public String getExtension() {
		String ext = getName();
		
		int index = ext.indexOf('.');
		
		this.extension = ext.substring(index+1);
		
		return extension;
	}

	@Override
	public void add(EDoc doc) {
		throw new UnsupportedOperationException("add() is not supported on File Documents");
	}

	@Override
	public void remove(EDoc doc) {
		throw new UnsupportedOperationException("remove() is not supported on File Documents");
		
	}
	
	@Override
	public ArrayList<EDoc> getAllChildren() {
		throw new UnsupportedOperationException("getAllChildren() is not supported on File Documents");
	}

	@Override
	public void getChild(int depth) {
		System.out.println(" ".repeat(depth)+ "-" + getName() +" (" + calculateSize() + " KB)");
	}
	
	@Override
	public int calculateSize() {
		return (int) ((new java.io.File(pathName).length())/1000);
	}
	
	@Override
	public boolean isDir() {
		
		return false;
	}

	@Override
	public String getChildToStr(int depth) {
		
		return " ".repeat(depth)+ "-" + getName() +" (" + calculateSize() + " KB)\n";
	}




}
