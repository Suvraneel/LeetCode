/**
 * Encodes a URL to a shortened URL.
 *
 * @param {string} longUrl
 * @return {string}
 */
 var encrypt = [];
 const alphaNumeric = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1","2","3","4","5","6","7","8","9"];
 var encode = function(longUrl) {
    var shortUrl = "";
    for(var i=0; i<6; i++){
        var random = Math.floor(Math.random() * alphaNumeric.length);
        shortUrl += alphaNumeric[random];
    }
     encrypt[shortUrl] = longUrl;
     console.log(shortUrl);
     return ("http://tinyurl.com/" + shortUrl);
 };
 
 /**
  * Decodes a shortened URL to its original URL.
  *
  * @param {string} shortUrl
  * @return {string}
  */
 var decode = function(shortUrl) {
     return (encrypt[shortUrl.replace("http://tinyurl.com/","")]);
 };
 
 /**
  * Your functions will be called as such:
  * decode(encode(url));
  */
 