/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

// Time: O(n)
// Space: O(n) (for the map)
var findPairs = function (nums, k) {
    let map = new Map();
    let count = 0;
    for (let num of nums) map.set(num, (map.get(num) || 0) + 1)

    for(let [num, freq] of map.entries()){
        if (k === 0) {
            // case when difference is 0, look for duplicates
            if (freq > 1) count++;
        } else {
            if (map.has(num + k)) count++;
        }
    }
    return count;
};