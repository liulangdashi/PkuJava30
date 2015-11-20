package wordSelect;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
//mport java.util.List;
import java.util.Scanner;
import java.util.Set;

//import javax.swing.text.html.HTMLDocument.Iterator;

public class wordSelect{
    
    public static void main(String[] args){
    	wordSelect ws =new wordSelect();
    	int countA =0;
    	//int countB =0;
    	//int countC = 0;
    	System.out.println("please input path of fileA");
    	Scanner s = new Scanner(System.in);
    	Set<String> listA = ws.getWord(s.nextLine());
    	countA = listA.size();
    	System.out.println("please input path of fileB");
    	Set<String> listB = ws.getWord(s.nextLine());
    	Set<String> listC = new HashSet<String>();
    	//String[] sb =null;
    	Object[] sb=listB.toArray();
    	for(int i = 0;i<sb.length;i++)
    		if(listA.contains(sb[i]))listC.add((String)sb[i]);
    		else listA.add((String)sb[i]);
    	System.out.println("并集为：");
    	System.out.println(listA.toString());
    	System.out.println("交集为：");
    	System.out.println(listC.toString());
    	System.out.println("A文件总单词数："+countA);
    	System.out.println("B文件总单词数："+listB.size());
    	System.out.println("属于A但不属于B的比例为"+(float)(countA-listC.size())/countA*100+"%");
    	System.out.println("属于B但不属于A的比例为"+(float)(listB.size()-listC.size())/listB.size()*100+"%");
    }
    
    public Set<String> getWord(String s){
    	File file = new File(s);
    	String str=null;
    	String[] strs = null;
    	Set<String> slist = new HashSet<String>();
			InputStreamReader reader;
			try {
				reader = new InputStreamReader(new FileInputStream(file));
				BufferedReader br = new BufferedReader(reader);
				str=br.readLine();
				while(str!=null){
					strs=str.split(" ");
					for(int i = 0;i<strs.length;i++){
						slist.add(strs[i]);
						
					}
				str = br.readLine();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return slist;
    }

    protected void percent(){}
}