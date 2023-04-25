//Please check this video which has best explaination which is understandable.
//https://youtu.be/lJLcqDsmYfg

class Solution2 {
    public int largestRectangleArea(int[] heights) {

        int[] nextSmallerIndices = findNextSmallerIndex(heights);
        int[] prevSmallerIndices = findPrevSmallerIndex(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++){

            maxArea = Math.max(maxArea, ((nextSmallerIndices[i] == - 1 
            ? heights.length : nextSmallerIndices[i]) - prevSmallerIndices[i] - 1) * heights[i]);
        }
        return maxArea;
    }


    private int[] findNextSmallerIndex(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[heights.length];
        stack.push(-1);

        for (int i = heights.length - 1; i >=0 ; i--){
           while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                  stack.pop();
            }

            result[i] = stack.peek();
            stack.push(i);
            

        }
        return result;

    }

    private int[] findPrevSmallerIndex(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[heights.length];
        stack.push(-1);

        for (int i = 0; i < heights.length ; i++){
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                  stack.pop();
            }
            result[i] = stack.peek();
            stack.push(i);
            

        }
        return result;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
      int area = 0, n = heights.length;
      int start;
      Stack<Pair<Integer,Integer>> stack = new Stack<>();
      for(int i=0;i<heights.length;i++){
         int curHt =heights[i];
         start = i;
        while(!stack.isEmpty() && stack.peek().getValue() > curHt){
          Pair<Integer,Integer> pair = stack.pop();
          int index = pair.getKey();
          int h = pair.getValue();
          area = Math.max(area, h * (i - index));
          start = index;
        }
        stack.push(new Pair(start,curHt));
      }
      
       while(!stack.isEmpty()){
          Pair<Integer,Integer> pair = stack.pop();
          int index = pair.getKey();
          int h = pair.getValue();
          area = Math.max(area, h * (n - index));
       }
        return area;
    }
  
}
