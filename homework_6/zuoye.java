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
 * �ļ��Ķ�ȡ
 * 1��������ϵ   File����
	2��ѡ����     �ļ�������  InputStream FileInputStream
	3������  : byte[] car =new byte[1024];  +read+��ȡ��С
              ���
	4���ͷ���Դ :�ر�
 * @author Administrator
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		
		String[] vcb1 = null;//�����һ���ļ��ĵ���
		String[] vcb2 = null;//����ڶ����ļ��ĵ���
		//1��������ϵ   File����
		File src1 = new File("D:/test/a.txt");
		File src2 = new File("d:/test/b.txt");
		//2��ѡ����
		InputStream is1 =null; //����������
	//	InputStream is2 =null; //����������
		try {
			is1 =new FileInputStream(src1);
			//3������ ���϶�ȡ ��������
			byte[] car1 =new byte[1024];
			int len1 =0; //���� ʵ�ʶ�ȡ��С
			//ѭ����ȡ
			StringBuilder sb1 =new StringBuilder();
			while(-1!=(len1=is1.read(car1))){
				//���  �ֽ�����ת���ַ���
				String info1 =new String(car1,0,len1);
				sb1.append(info1);
			}
			//String info1=sb.toString().trim();
			//���ݸ�����������ʽ��ƥ������ִ��ַ�����\s+����˵���ո񲿷ֻ���
		     vcb1=sb1.toString().trim().split("\\s+");
//			System.out.println(vcb1.length);
//			for(int i=0;i<vcb1.length;i++){
//				System.out.println(vcb1[i]);
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("�ļ�������");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("��ȡ�ļ�ʧ��");
		}finally{
			try {
				//4���ͷ���Դ
				if (null != is1) {
					is1.close();
				}
			} catch (Exception e2) {
				System.out.println("�ر��ļ�������ʧ��");
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
				//��ȡ�ļ�ʧ��
				e.printStackTrace();
			}
		   } catch (FileNotFoundException e) {
			   //�ļ�������
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }finally{
				  
					try {
						if (null != is1) {
							is1.close();
						} 
					} catch (Exception e2) {
						//�ر�������ʧ��
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
		System.out.println("�����ļ�������������Ϊ:"+(vcb1update.length+vcb2update.length-count2)
				+"     "+"�����ļ�������������Ϊ:"+count2);
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
		System.out.println("���ļ����ʵĲ�������:");
		for(int i=0;i<vcbbing.length;i++)
			System.out.print(vcbbing[i]+"  ");
		System.out.println("");
		System.out.println("���ļ����ʵĽ�������:");
		for(int i=0;i<vcbjiao.length;i++)
			System.out.print(vcbjiao[i]+"  ");
		System.out.println("");
		
		DecimalFormat df=new DecimalFormat("0.00");
		System.out.println("A�ļ��ĵ�������Ϊ:"+vcb1update.length+"   "+"B�ļ��ĵ�������Ϊ:"+vcb2update.length);
		System.out.println("wd��A ��wd����B�ĵ���ռA�ļ��İٷֱ�:"+
		df.format(((float)((float)(vcb1update.length-count2)/(float)(vcb1update.length)))*100)+"%"
				+"  "+"wd��B ��wd����A�ĵ���B�ļ��İٷֱ�:"+
		df.format(((float)((float)(vcb2update.length-count2)/(float)(vcb2update.length)))*100)+"%");
		
		
	}
}
