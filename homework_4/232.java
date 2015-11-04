class MyQueue {
    // Push element x to the back of queue.
   // List<Integer> list=new ArrayList<Integer>();
   //利用两栈实现一个队列
   Stack<Integer> s1=new Stack<Integer>();
   Stack<Integer> s2=new Stack<Integer>(); 
    public void push(int x) {
        //list.add(x);
        s1.push(x);//直接将x放到栈s1中
    }

    // Removes the element from in front of queue.
    public void pop() {//如果栈s2不为空那么就将s2的栈元素弹出。如果s2为空，就将s1中的所有元素放到s2
    //中然后再弹出栈顶元素
        if(!s2.empty()) s2.pop();
        else{
            while(!s1.empty()) s2.push(s1.pop());
            s2.pop();
        }
    }

    // Get the front element.
    public int peek() {//类似pop方法
        if(!s2.empty()) return s2.peek();
        else{
            while(!s1.empty()) s2.push(s1.pop());
            return s2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (s1.empty()&&s2.empty());
    }
}