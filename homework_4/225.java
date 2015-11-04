class MyStack {
    // Push element x onto stack.
    //List<Integer> list1=new ArrayList<Integer>();
   // List<Integer> list2=new ArrayList<Integer>();
   //����������ʵ��һ��ջ
   Queue<Integer> q1;
   Queue<Integer> q2;
    public void push(int x) {
       // list1.add(x);
       //��֤��������һ��Ϊ�գ�һ����Ϊ�գ�Ԫ����ջʱ��q1Ϊ�վͰ�x�ŵ�q1��ȥ��Ȼ��q2��Ԫ��ȫ���ŵ�q1�У�
       //ͬ��q2��ʱ��x�ŵ�q2�У�Ȼ��q1���Ԫ��ȫ���ŵ�q2��ȥ
       if(q1.isEmpty()){
           q1.offer(x);
           while(!q2.isEmpty()) q1.offer(q2.poll());
       }else{
           q2.offer(x);
           while(!q1.isEmpty()) q2.offer(q1.poll());
       }
    }
    // Removes the element on top of the stack.
    public void pop() {
        //list1.remove(list1.size()-1);
        // int tmp=0;
        // for(int i=0;i<list1.size();i++){
        //     tmp=list1.get(i);
        //     list2.add(tmp);
        // }
        // list1.length=list1.length-1;
        // for(int i=0;i<list2.length;i++){
        //     tmp=list1.get(i);
        //     list2.add(tmp);
        // }
        if(!q1.isEmpty()) q1.poll();//q1��Ϊ�յ�����һ��Ԫ�أ���q2��Ϊ��ʱ���͵���q2�ĵ�һ��Ԫ��
        else q2.poll();
    }

    // Get the top element.
    public int top() {
        //return list1.get(list1.size()-1);
        if(!q1.isEmpty()) return q1.poll();
        else return q2.poll();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        //return (list1.size()==0);
        return q1.isEmpty()&&q2.isEmpty();
    }
}