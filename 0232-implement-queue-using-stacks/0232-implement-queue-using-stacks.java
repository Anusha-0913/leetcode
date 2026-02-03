import java.util.*;
class MyQueue {
private Deque<Integer> stackIn;
private Deque<Integer> stackOut;
public MyQueue() {
stackIn = new ArrayDeque<>();
stackOut = new ArrayDeque<>();
}
public void push(int x) {
stackIn.push(x);
}
private void transfer() {
while (!stackIn.isEmpty()) {
stackOut.push(stackIn.pop());
}
}
public int pop() {
if (stackOut.isEmpty()) {
transfer();
}
return stackOut.pop();
}
public int peek() {
if (stackOut.isEmpty()) {
transfer();
}
return stackOut.peek();
}
public boolean empty() {
return stackIn.isEmpty() && stackOut.isEmpty();
}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */