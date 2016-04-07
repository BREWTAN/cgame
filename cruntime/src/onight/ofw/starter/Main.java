package onight.ofw.starter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			String cachedir = "felix-cache";

			deleteDir(new File(cachedir));
			
			List<String> arglist = new ArrayList<String>();
			arglist.addAll(Arrays.asList(args));
			arglist.add(cachedir);
			System.out.println(arglist);
			Thread.sleep(1);
			org.apache.felix.main.Main.main(arglist.toArray(new String[] {}));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteDir(File dir) {
		if(dir!=null||!dir.exists())return;
		for (File child : dir.listFiles()) {
			if (child.isDirectory()) {
				deleteDir(child);
			} else {
				child.delete();
			}
		}
		dir.delete();

	}
}
