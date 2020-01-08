// 2019-02-06

#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int operator()() {
        std::vector<int> v1{1,1,2,2,3,3,3,4,7,19};
        return removeDuplicates2(v1);
    }

    int removeDuplicates1(vector<int>& nums) {
        nums.erase( unique(nums.begin(), nums.end()), nums.end() );
        return nums.size();
    }

    int removeDuplicates2(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }

        int anchor_index = 0;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] != nums[anchor_index]) {
                anchor_index++;
                nums[anchor_index] = nums[i];
            }
        }
        return anchor_index + 1;
    }
};

