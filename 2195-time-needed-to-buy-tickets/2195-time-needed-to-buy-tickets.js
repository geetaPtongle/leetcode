/**
 * @param {number[]} tickets
 * @param {number} k
 * @return {number}
 */
//Approach-1 (Using Queue to simply simulate the operations)
//T.C : O(n*m) -> Loop runs until queue is empty and in worst case all people have maximum m tickets 
//S.C : O(n)
var timeRequiredToBuy = function(tickets, k) {
    let queue = [];
    let n= tickets.length;
    let time =0;
     for (let i = 0; i < n; i++) {
        queue.push(i);
        }

     while (queue.length > 0) {
        time++;
        let front = queue.shift();
        
        tickets[front]--;
        
        if (front === k && tickets[front] === 0) {
            return time;
        }
        
        if (tickets[front] > 0) {
            queue.push(front);
        }
    }
    return time;
};

// Approach-3: Using simple observation
// Time Complexity: O(n)
// Space Complexity: O(1)
var timeRequiredToBuy = function(tickets, k) {
    let time = 0;
        
        for (let i = 0; i < tickets.length; i++) {
            
            if (i <= k) {
                time += Math.min(tickets[k], tickets[i]);
            } else {
                time += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        
        return time;
};