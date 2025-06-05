/**
 * @param {string} date
 * @return {string}
 */
var convertDateToBinary = function(date) {
    const year=parseInt(date.substring(0,4), 10);
    const month=parseInt(date.substring(5,7), 10);
    const day=parseInt(date.substring(8,10), 10);

    const binaryDate=[year.toString(2), month.toString(2), day.toString(2)].join('-');
    return binaryDate;
};