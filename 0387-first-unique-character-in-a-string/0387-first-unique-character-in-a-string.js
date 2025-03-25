/**
 * @param {string} s
 * @return {number}
 */

 //T.C : O(n)
//S.C : O(26) ~ O(1)
var firstUniqChar = function(s) {
    let array =new Array(26).fill(0);

    for(let i =0; i< s.length; i++){
        let char = s[i];
        array[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }

     for(let i =0; i< s.length; i++){
        let char = s[i];
        if(array[char.charCodeAt(0) - 'a'.charCodeAt(0)] ===1){
            return i;
        }
     }
     return -1;
};