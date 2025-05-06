/**
 * @param {string[]} operations
 * @return {number}
 */
var finalValueAfterOperations = function (operations) {
    let X = 0;
    // let n = operations.length;
    // for(let i=0; i<n; i++){
    //     X +=operations[i].includes('+')? 1: -1; 
    // }

    // for (let op of operations) {
    //     X += op.includes('+') ? 1 : -1;
    // }
 X= operations.reduce((X, op) => X + (op.includes('+') ? 1: -1), 0);
    return X;
    
};