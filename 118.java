public class Solution {
    public List<List<Integer>> generate(int numRows) {
        int count = 1;
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        while(count <= numRows){
        	if(count == 1)
        		list.add(1);
        	else if(count == 2){
        		list.add(1);
        		list.add(1);
        	}
        	else{
        		list.add(1);
        		List<Integer> list2 = result.get(count-2);
        		List<Integer> list1 = new ArrayList<Integer>();
        		list1.addAll(list2);
        		int a = list1.remove(0);
        		int b = 0;
        		while(!list1.isEmpty()){
        			b = list1.remove(0);
        			list.add(a+b);
        			a = b;
        		}
        		list.add(1);
        	}
        	count++;
        	result.add(list);
        	list = new ArrayList<Integer>();
        }
        return result;
    }
}