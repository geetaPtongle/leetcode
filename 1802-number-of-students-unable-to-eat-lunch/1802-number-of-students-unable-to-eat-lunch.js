/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
//Aproach-1 (Using counter only)
//T.C : O(n)
//S.C : O(1)
var countStudents1 = function(students, sandwiches) {
    let res=students.length;
    let obj ={}
    students.forEach(num => {
    obj[num] = (obj[num] || 0) + 1;
    });
    for(let s of sandwiches){
        if(obj[s] > 0){
           res -= 1;
           obj[s] -=1;
        }else{
            return res
        }
    }
    return res;

};

//Approach-1 (Simply simulate whatever the problem asks for)
//T.C : O(n)
//S.C : O(n)
var countStudents = function(students, sandwiches) {
    let n=students.length;
  let queue=[];
  let stack =[];
 for (let i = 0; i < n; i++) {
        queue.push(students[i]);
        stack.push(sandwiches[i]);
    }

    let lastServed = 0; 
    while (queue.length !== 0 && lastServed < queue.length) {
        if (queue[0] === stack[0]) {
            queue.shift();
            stack.shift();
            lastServed = 0;
        } else {
            queue.push(queue.shift());
            lastServed++;
        }
    }
    return queue.length;
};