// 201. Bitwise AND of Numbers Range (Leetcode)

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // How many bits are different in left and right from LSB to MSB.
        // As they are flipped so their AND will be 0.
        int count = 0;

        // To preserve the bits that are same in left and right from MSB to LSB.
        while (left != right) {
            // Right shift left and right.
            left >>= 1;
            right >>= 1;
            // Increase the count.
            count++;
        }

        // After the above loop, left will be equal to right.
        // Now left shift count times to add 0 on it's right side.
        return left <<= count;
    }
}