package Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Word {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileNameA = "C:/Users/shi/Desktop/wordA.txt";
		String fileNameB = "C:/Users/shi/Desktop/wordB.txt";
		Set<String> A = new HashSet<String>();
		A = getWords(fileNameA);
		Set<String> B = new HashSet<String>();
		B = getWords(fileNameB);
		System.out.println("A���ϵ�Ԫ��:" + A.toString());
		System.out.println("B���ϵ�Ԫ��:" + B.toString());
		Set<String> A_OR_B = new HashSet<String>();
		A_OR_B.addAll(A);
		A_OR_B.addAll(B);
		System.out.println("A��B�Ĳ�����" + A_OR_B.toString());
		Set<String> A_AND_B = new HashSet<String>();
		A_AND_B.addAll(A);
		A_AND_B.retainAll(B);
		System.out.println("A��B�Ľ�����" + A_AND_B.toString());
		int countA = A.size();
		System.out.println("�ļ�A�е�������:" + countA);
		int countB = B.size();
		System.out.println("�ļ�B�е�������:" + countB);
		Set<String> A_B = new HashSet<String>();
		A_B.addAll(A);
		A_B.removeAll(B);
		System.out.println("�ļ�A�в������ļ�B�ĵ���ռA�е��ʵİٷֱ�:" + (double)A_B.size()/A.size());
		Set<String> B_A = new HashSet<String>();
		B_A.addAll(B);
		B_A.removeAll(A);
		System.out.println("�ļ�B�в������ļ�A�ĵ���ռB�е��ʵİٷֱ�:" + (double)B_A.size()/B.size());
	}
	private static  Set<String> getWords(String fileName) throws IOException{
		Set<String> wordSet = new HashSet<String>();
		try{
			 File f=new File(fileName);
	        InputStream in=new FileInputStream(f);
	        byte[] b=new byte[1024];
	        int count =0;
	        int temp=0;
	        while((temp=in.read())!=(-1)){
	            b[count++]=(byte)temp;
	        }
	        in.close();
	        String str = new String(b);
	        str = str.replaceAll("\r|\n", " ");
//	        str = str.substring(0, str.length());
	        str = str.substring(0, count);
//	        String words = "";
//	        System.out.println(str.length());
//	        System.out.println(str);
        	String words[] = str.split(" ");
        	for(String w : words){
        		String w1 = w.replaceAll(" ", "");
        		if(!w1.equals("")){
        			wordSet.add(w1);
        		}
//        		wordSet.add(w);
//        		wordSet.add(w.replaceAll(" ", ""));
        	}
			
		}catch(FileNotFoundException e){
			System.out.println("file not found");
		}
		return wordSet;
	}
}
