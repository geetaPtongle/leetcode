/**
 * @param {string} s
 * @return {number}
 */
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