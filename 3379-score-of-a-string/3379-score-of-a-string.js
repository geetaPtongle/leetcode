/**
 * @param {string} s
 * @return {number}
 */
var scoreOfString = function(s) {
      let n=s.length;
        let result =0;
        for(let i=1; i<n; i++){
            result +=Math.abs(s.charCodeAt(i-1)-s.charCodeAt(i));
        }
        return result;
};