class MyStack {
    // Push element x onto stack.
    //List<Integer> list1=new ArrayList<Integer>();
   // List<Integer> list2=new ArrayList<Integer>();
   //用两个队列实现一个栈
   Queue<Integer> q1;
   Queue<Integer> q2;
    public void push(int x) {
       // list1.add(x);
       //保证两个队列一个为空，一个不为空，元素入栈时若q1为空就把x放到q1中去，然后将q2的元素全部放到q1中，
       //同理当q2空时将x放到q2中，然后将q1里的元素全部放到q2中去
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
        if(!q1.isEmpty()) q1.poll();//q1不为空弹出第一个元素，若q2不为空时，就弹出q2的第一个元素
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