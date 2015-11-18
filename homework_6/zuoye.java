package org.nihao.www;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * 文件的读取
 * 1、建立联系   File对象
	2、选择流     文件输入流  InputStream FileInputStream
	3、操作  : byte[] car =new byte[1024];  +read+读取大小
              输出
	4、释放资源 :关闭
 * @author Administrator
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		
		String[] vcb1 = null;//保存第一个文件的单词
		String[] vcb2 = null;//保存第二个文件的单词
		//1、建立联系   File对象
		File src1 = new File("D:/test/a.txt");
		File src2 = new File("d:/test/b.txt");
		//2、选择流
		InputStream is1 =null; //提升作用域
	//	InputStream is2 =null; //提升作用域
		try {
			is1 =new FileInputStream(src1);
			//3、操作 不断读取 缓冲数组
			byte[] car1 =new byte[1024];
			int len1 =0; //接收 实际读取大小
			//循环读取
			StringBuilder sb1 =new StringBuilder();
			while(-1!=(len1=is1.read(car1))){
				//输出  字节数组转成字符串
				String info1 =new String(car1,0,len1);
				sb1.append(info1);
			}
			//String info1=sb.toString().trim();
			//根据给定的正则表达式的匹配来拆分此字符串。\s+就是说按空格部分划分
		     vcb1=sb1.toString().trim().split("\\s+");
//			System.out.println(vcb1.length);
//			for(int i=0;i<vcb1.length;i++){
//				System.out.println(vcb1[i]);
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件不存在");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("读取文件失败");
		}finally{
			try {
				//4、释放资源
				if (null != is1) {
					is1.close();
				}
			} catch (Exception e2) {
				System.out.println("关闭文件输入流失败");
			}
		}
		
		
		try {
			is1=new FileInputStream(src2);
			byte[] car2=new byte[1024];
			int len2=0;
			StringBuilder sb2=new StringBuilder();
			try {
				while(-1!=(len2=is1.read(car2))){
					String info2=new String(car2,0,len2);
					sb2.append(info2);
				}
				vcb2=sb2.toString().trim().split("\\s+");
//				System.out.println(vcb2.length);
//				for(int i=0;i<vcb2.length;i++){
//					System.out.println(vcb2[i]);
//				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//读取文件失败
				e.printStackTrace();
			}
		   } catch (FileNotFoundException e) {
			   //文件不存在
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }finally{
				  
					try {
						if (null != is1) {
							is1.close();
						} 
					} catch (Exception e2) {
						//关闭输入流失败
						// TODO: handle exception
					} 
		  }
//		String[] vcb1update=null;
//		String[] vcb2update=null;
//		List<String> ss=(List<String>)new ArrayList<String>();
//		Set<String> list1=(Set<String>) new ArrayList<String>();
//		for(int i=0;i<vcb1.length;i++)
//			System.out.print(vcb1[i]+"  ");
//		System.out.println("////");
//		for(int i=0;i<vcb2.length;i++)
//			System.out.print(vcb2[i]+"  ");
		Arrays.sort(vcb1);
		int l1=vcb1.length;
		for(int i=0;i<vcb1.length-1;i++)
			if(vcb1[i].equals(vcb1[i+1])){
				vcb1[i]=" ";
				l1--;
			} 
		
		String[] vcb1update=new String[l1];
		for(int i=0,j=0;i<vcb1.length;i++){
				if(vcb1[i]!=" ") vcb1update[j++]=vcb1[i];
			}
		
		Arrays.sort(vcb2);
		int l2=vcb2.length;
		for(int i=0;i<vcb2.length-1;i++)
			if(vcb2[i].equals(vcb2[i+1])) {
				vcb2[i]=" ";
				l2--;
				}
		String[] vcb2update=new String[l2];
		for(int i=0,j=0;i<vcb2.length;i++){
				if(vcb2[i]!=" ") vcb2update[j++]=vcb2[i];
			}
//		System.out.println("////////////////////////");
//		System.out.println("////////////////////////");
//		for(int i=0;i<vcb1update.length;i++)
//			System.out.println(vcb1update[i]);
//		System.out.println("////////////////////////");
//		for(int i=0;i<vcb2update.length;i++)
//			System.out.println(vcb2update[i]);
//		
//		System.out.println("////////////////////////");
		int vcb1len=0,vcb2len=0,count1=0,count2=0;
		//System.out.println(vcb1update.length+"  "+vcb2update.length);
		while(vcb1update.length>vcb1len&&vcb2update.length>vcb2len){
			if(vcb1update[vcb1len].equals(vcb2update[vcb2len])){
				count1++;
				count2++;
			}
			else
				count1=count1+2;
			vcb1len++;
			vcb2len++;
		}
		if(vcb2len==vcb2update.length){
			while(vcb1len<vcb1update.length){
				count1++;
				vcb1len++;
			}
		}
		if(vcb1len==vcb2update.length){
			while(vcb2len<vcb2update.length){
				count2++;
				vcb2len++;
			}
		}
		String[] vcbbing=new String[vcb1update.length+vcb2update.length-count2];
		String[] vcbjiao=new String[count2];
		System.out.println("两个文件并集单词总数为:"+(vcb1update.length+vcb2update.length-count2)
				+"     "+"两个文件交集单词总数为:"+count2);
		//System.out.println(count1+" "+count2);
		
		 vcb1len=0;
		 vcb2len=0;
		 int m=0,n=0;
		while(vcb1update.length>vcb1len&&vcb2update.length>vcb2len){
			if(vcb1update[vcb1len].equals(vcb2update[vcb2len])){
				vcbjiao[m++]=vcb1update[vcb1len];
				vcbbing[n++]=vcb1update[vcb1len];
			}
			else{
				vcbbing[n++]=vcb1update[vcb1len];
				vcbbing[n++]=vcb2update[vcb2len];
			}
			vcb1len++;
			vcb2len++;
		}
		if(vcb2len==vcb2update.length){
			while(vcb1len<vcb1update.length){
				vcbbing[n++]=vcb1update[vcb1len];
				vcb1len++;
			}
		}
		if(vcb1len==vcb2update.length){
			while(vcb2len<vcb2update.length){
				vcbbing[n++]=vcb2update[vcb2len];
				vcb2len++;
			}
		}
		System.out.println("两文件单词的并集如下:");
		for(int i=0;i<vcbbing.length;i++)
			System.out.print(vcbbing[i]+"  ");
		System.out.println("");
		System.out.println("两文件单词的交集如下:");
		for(int i=0;i<vcbjiao.length;i++)
			System.out.print(vcbjiao[i]+"  ");
		System.out.println("");
		
		DecimalFormat df=new DecimalFormat("0.00");
		System.out.println("A文件的单词总数为:"+vcb1update.length+"   "+"B文件的单词总数为:"+vcb2update.length);
		System.out.println("wd∈A 且wd不在B的单词占A文件的百分比:"+
		df.format(((float)((float)(vcb1update.length-count2)/(float)(vcb1update.length)))*100)+"%"
				+"  "+"wd∈B 且wd不在A的单词B文件的百分比:"+
		df.format(((float)((float)(vcb2update.length-count2)/(float)(vcb2update.length)))*100)+"%");
		
		
	}
}
