/**
 * @param {string} palindrome
 * @return {string}
 */
var breakPalindrome = function(palindrome) {
    var len = palindrome.length;
        if(len===1)
            return "";
        var unchanged=true;
        var palindrome = [...palindrome];
        for(var i=0; i<Math.floor(palindrome.length/2); i++){
            if (palindrome[i]!=='a'){
                palindrome[i]='a';
                unchanged=false;
                break;
            }
        }
        if(unchanged)   // ie, all chars are a
            palindrome[len-1]='b';
        return palindrome.join('');
};