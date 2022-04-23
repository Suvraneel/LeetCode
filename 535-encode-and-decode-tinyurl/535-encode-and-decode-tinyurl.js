/**
 * Encodes a URL to a shortened URL.
 *
 * @param {string} longUrl
 * @return {string}
 */
var encrypt = [];
var i=0;
var encode = function(longUrl) {
    encrypt[i++] = longUrl;
    return (i-1);
};

/**
 * Decodes a shortened URL to its original URL.
 *
 * @param {string} shortUrl
 * @return {string}
 */
var decode = function(shortUrl) {
    return (encrypt[shortUrl]);
};

/**
 * Your functions will be called as such:
 * decode(encode(url));
 */