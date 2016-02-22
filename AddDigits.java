/*
258.Add Digits 
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit. 
For example: 
Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it. 
Follow up: 
Could you do it without any loop/recursion in O(1) runtime?
*/

public class AddDigits {
    public int addDigits(int num) {
        int sum=num;
        while(sum - 9>0){
            num=sum;
            sum=0;
            while(num - 9 >0){
                sum += num%10;
                num /= 10;
            }
            sum += num%10;
        }
        return sum;
    }
}

class Solution {
    public int addDigits(int num) {
        return 1 + (num-1)%9;
    }
}