package client;

import directory.*;

public class DirectoryProxy implements Directory {

	private static MainDirectory md;
	
	@Override
	public void print() {
		return md.print();
	}

	@Override
	public void add(String s) {
		md.add(s);
	}

	@Override
	public void clr() {
		md.clr();
	}

}
