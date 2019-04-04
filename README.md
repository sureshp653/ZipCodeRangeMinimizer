<h1>Zip Code Range Minimizer</h1>
<p>Author: Suresh Pasupuleti</p>
<p>Date: 04-04-2019</p>

<h2>BACKGROUND</h2>
<p>Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes.
<p>For example if the ranges are:</p>
<p>[94133,94133] [94200,94299] [94600,94699]</p>
<p>Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.</p>
<p>Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.</p>

<h2>PROBLEM</h2>
<p>Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.</p>

<h2>NOTES</h2>
<ul>
  <li>The ranges above are just examples, your implementation should work for any set of arbitrary ranges</li>
  <li>Ranges may be provided in arbitrary order</li>
  <li>Ranges may or may not overlap</li>
  <li>Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices</li>
</ul>
<h2>EXAMPLES</h2>
<p>If the input = [94133,94133] [94200,94299] [94600,94699] </p>
<p>Then the output should be = [94133,94133] [94200,94299] [94600,94699]</p>
<p>If the input = [94133,94133] [94200,94299] [94226,94399] </p>
<p>Then the output should be = [94133,94133] [94200,94399]</p>

<h2>Requirements</h2>
<p>In order to run the program you will need the following installed:</p>
<ul>
  <li>Java 8</li>
  <li>Gradel 4.0</li>
  <li>lombok</li>  
</ul>
