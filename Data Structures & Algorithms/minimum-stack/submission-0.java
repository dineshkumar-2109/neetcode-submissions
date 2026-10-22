class MinStack {
    Stack<Integer> ans;
    Stack<Integer> min;

    public MinStack() {
        ans=new Stack<>();
        min=new Stack<>();
        
    }
    
    public void push(int val) {
        ans.push(val);
        if(min.isEmpty()){
            min.push(val);
        }else{
            int vals=min.peek();
            min.push(Math.min(val,vals));
        }
    }
    
    public void pop() {
        ans.pop();
        min.pop();
    }
    
    public int top() {
        return ans.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
