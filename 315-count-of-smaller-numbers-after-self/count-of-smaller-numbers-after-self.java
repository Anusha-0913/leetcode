import java.util.*;

class Solution {
    
    private int[] counts;
    private int[] indices;
    private int[] tempIndices;
    private int[] nums;
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        
        this.nums = nums;
        this.counts = new int[n];
        this.indices = new int[n];
        this.tempIndices = new int[n];
        
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        mergeSort(0, n - 1);
        
        List<Integer> result = new ArrayList<>();
        for (int c : counts) result.add(c);
        
        return result;
    }
    
    private void mergeSort(int left, int right) {
        if (left >= right) return;
        
        int mid = (left + right) / 2;
        
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        
        merge(left, mid, right);
    }
    
    private void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        
        int rightCount = 0;
        
        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                tempIndices[k++] = indices[j++];
                rightCount++;
            } else {
                counts[indices[i]] += rightCount;
                tempIndices[k++] = indices[i++];
            }
        }
        
        while (i <= mid) {
            counts[indices[i]] += rightCount;
            tempIndices[k++] = indices[i++];
        }
        
        while (j <= right) {
            tempIndices[k++] = indices[j++];
        }
        
        for (int x = left; x <= right; x++) {
            indices[x] = tempIndices[x];
        }
    }
}