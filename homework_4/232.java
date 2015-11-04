class MyQueue {
    // Push element x to the back of queue.
   // List<Integer> list=new ArrayList<Integer>();
   //������ջʵ��һ������
   Stack<Integer> s1=new Stack<Integer>();
   Stack<Integer> s2=new Stack<Integer>(); 
    public void push(int x) {
        //list.add(x);
        s1.push(x);//ֱ�ӽ�x�ŵ�ջs1��
    }

    // Removes the element from in front of queue.
    public void pop() {//���ջs2��Ϊ����ô�ͽ�s2��ջԪ�ص��������s2Ϊ�գ��ͽ�s1�е�����Ԫ�طŵ�s2
    //��Ȼ���ٵ���ջ��Ԫ��
        if(!s2.empty()) s2.pop();
        else{
            while(!s1.empty()) s2.push(s1.pop());
            s2.pop();
        }
    }

    // Get the front element.
    public int peek() {//����pop����
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