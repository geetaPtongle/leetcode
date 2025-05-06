/**
 * @param {string} address
 * @return {string}
 */
var defangIPaddr = function (address) {
    let n = address.length;
    let result = '';
    // for (let i = 0; i < n; i++)
    //     result += address[i] === '.' ? '[.]' : address[i];

    // result = address.replaceAll('.', '[.]');

    // result = address.split('.').join("[.]");

    // result = Array.from(address).map((element) => element ==='.' ? '[.]': element).join('');

    for (const ch of address)
        result += ch === '.' ? '[.]' : ch;



    return result;
};