import java.util.*;

class Solution {
    
    HashMap<Integer, Employee> map = new HashMap<>();
    
    public int getImportance(List<Employee> employees, int id) {
        
        // Build map: id -> Employee
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        // DFS traversal
        return dfs(id);
    }
    
    private int dfs(int id) {
        Employee emp = map.get(id);
        
        int total = emp.importance;
        
        for (int subId : emp.subordinates) {
            total += dfs(subId);
        }
        
        return total;
    }
}