public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int count = 0;
		List<Integer> list = new ArrayList<Integer>();
        while(count <= rowIndex){
        	if(count == 0)
        		list.add(1);
        	else if(count == 1){
        		list.add(1);
        	}
        	else{
        		List<Integer> list1 = new ArrayList<Integer>();
        		List<Integer> list2 = new ArrayList<Integer>();
        		list2.add(1);
        		list1.addAll(list);
        		int a = list1.remove(0);
        		int b = 0;
        		while(!list1.isEmpty()){
        			b = list1.remove(0);
        			list2.add(a+b);
        			a = b;
        		}
        		list2.add(1);
        		list = list2;
        	}
        	count++;
        }
        return list;
    }
}