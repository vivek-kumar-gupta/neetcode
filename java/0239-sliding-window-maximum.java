class Solution {
    //It also has nice explainasion.
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //here we are checking if this is in current bound if not removing it.
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) q.pollFirst();
            //here we are checking if current element is greater than value in queue.. then keep polling it.
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) q.pollLast();
            q.offer(i);
            if (i >= k - 1) ans[j++] = nums[q.peekFirst()];
        }
        return ans;
    }
}
