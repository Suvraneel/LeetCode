<h2>902. Numbers At Most N Given Digit Set</h2><h3>Hard</h3><hr><div style="user-select: auto;"><p style="user-select: auto;">Given an array of <code style="user-select: auto;">digits</code> which is sorted in <strong style="user-select: auto;">non-decreasing</strong> order. You can write numbers using each <code style="user-select: auto;">digits[i]</code> as many times as we want. For example, if <code style="user-select: auto;">digits = ['1','3','5']</code>, we may write numbers such as <code style="user-select: auto;">'13'</code>, <code style="user-select: auto;">'551'</code>, and <code style="user-select: auto;">'1351315'</code>.</p>

<p style="user-select: auto;">Return <em style="user-select: auto;">the number of positive integers that can be generated </em>that are less than or equal to a given integer <code style="user-select: auto;">n</code>.</p>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Example 1:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> digits = ["1","3","5","7"], n = 100
<strong style="user-select: auto;">Output:</strong> 20
<strong style="user-select: auto;">Explanation: </strong>
The 20 numbers that can be written are:
1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 2:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> digits = ["1","4","9"], n = 1000000000
<strong style="user-select: auto;">Output:</strong> 29523
<strong style="user-select: auto;">Explanation: </strong>
We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbers.
In total, this is 29523 integers that can be written using the digits array.
</pre>

<p style="user-select: auto;"><strong style="user-select: auto;">Example 3:</strong></p>

<pre style="user-select: auto;"><strong style="user-select: auto;">Input:</strong> digits = ["7"], n = 8
<strong style="user-select: auto;">Output:</strong> 1
</pre>

<p style="user-select: auto;">&nbsp;</p>
<p style="user-select: auto;"><strong style="user-select: auto;">Constraints:</strong></p>

<ul style="user-select: auto;">
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= digits.length &lt;= 9</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">digits[i].length == 1</code></li>
	<li style="user-select: auto;"><code style="user-select: auto;">digits[i]</code> is a digit from&nbsp;<code style="user-select: auto;">'1'</code>&nbsp;to <code style="user-select: auto;">'9'</code>.</li>
	<li style="user-select: auto;">All the values in&nbsp;<code style="user-select: auto;">digits</code> are <strong style="user-select: auto;">unique</strong>.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">digits</code> is sorted in&nbsp;<strong style="user-select: auto;">non-decreasing</strong> order.</li>
	<li style="user-select: auto;"><code style="user-select: auto;">1 &lt;= n &lt;= 10<sup style="user-select: auto;">9</sup></code></li>
</ul>
</div>