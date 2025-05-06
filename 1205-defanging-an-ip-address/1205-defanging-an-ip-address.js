/**
 * @param {string} address
 * @return {string}
 */
var defangIPaddr = function (address) {
    let n = address.length;
    let result = '';
    for (let i = 0; i < n; i++)
        result += address[i] === '.' ? '[.]' : address[i];
    return result;
};