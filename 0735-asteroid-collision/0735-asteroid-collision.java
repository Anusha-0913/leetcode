import java.util.*;
class Solution {
public int[] asteroidCollision(int[] asteroids) {
Deque<Integer> stack = new ArrayDeque<>();

for (int a : asteroids) {
boolean alive = true;
while (alive && a < 0 && !stack.isEmpty() && stack.peek() > 0) {
if (stack.peek() < -a) {
stack.pop();
} else if (stack.peek() == -a) {
stack.pop();
alive = false;
} else {
alive = false;
}
}
if (alive) stack.push(a);
}
int n = stack.size();
int[] result = new int[n];
for (int i = n - 1; i >= 0; i--) {
result[i] = stack.pop();
}
return result;
}
}
