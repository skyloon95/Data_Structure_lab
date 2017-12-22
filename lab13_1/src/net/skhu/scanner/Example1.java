package net.skhu.scanner;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\user\\Documents\\java_project\\lab13_1\\src\\net\\skhu\\scanner\\a.java";
        Scanner scanner = new Scanner(Paths.get(filePath));
        
        Map<String, Integer> vocaMap = add(scanner);
        
        List<DataItem> vocaList = new ArrayList<>();
        for(String s : vocaMap.keySet())
        	vocaList.add(new DataItem(s, vocaMap.get(s)));
        
        Collections.sort(vocaList);
        for(DataItem d : vocaList)
        	System.out.printf("%s : %d\n", d.s, d.count);
        
        
        
        scanner.close();
    }
    
    public static Map<String, Integer> add(Scanner file){
    	Map<String, Integer> vocaMap = new HashMap<>();
    	int count;
    	
    	file.useDelimiter("[^a-zA-Z]+");
        while (file.hasNext("[a-zA-Z]+")) {
            String s = file.next();
            if(vocaMap.containsKey(s)) {
            	count = vocaMap.get(s);
            	count++;
            	vocaMap.put(s, count);
            }
            else {
            	vocaMap.put(s, 1);
            }
        }
        
        return vocaMap;
    }
    
}

class DataItem implements Comparable{
	public String s;
	public int count;
	
	public DataItem(String s, int count) {
		this.s = s;
		this.count = count;
	}
	
	@Override
	public int compareTo(Object o) {
		DataItem d = (DataItem)o;
		return d.count - this.count;
	}
}

