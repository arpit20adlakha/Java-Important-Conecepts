public class LeetCode {
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
    }
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }

        boolean lastValue = false;
        int[][] arr = new int[nums.length][2];
        arr[0][1] = nums[1] > nums[0] ? -1 : 1;
        arr[0][0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && arr[j][1] == -1) {
                    if (arr[j][0] + 1 > arr[i][0]) {
                        arr[i][0] = arr[j][0] + 1;
                        if (arr[i][0] > max) {
                            max = arr[i][0];
                        }
                        arr[i][1] = 1;
                    }
                } else if (nums[i] < nums[j] && arr[j][1] == 1) {
                    if (arr[j][0] + 1 > arr[i][0]) {
                        arr[i][0] = arr[j][0] + 1;
                        if (arr[i][0] > max) {
                            max = arr[i][0];
                        }
                        arr[i][1] = -1;
                    }
                } else if (nums[i] == nums[j]) {
                    arr[i][0] = 1;
                    if (nums.length > i+1 && nums[i + 1] > nums[i]) {
                        arr[i][1] = -1;
                    } else if (nums.length > i+1 && nums[i + 1] < nums[i]) {
                        arr[i][1] = 1;
                    }
                }
            }
        }
        return max;

    }
}
