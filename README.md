# BetBull_API_Web_Cucumber

This Framework tests both Web and APIs. Technical specifications are: <b>JAVA, Maven, Junit, Cucumber</b>
<br>Test can be run under <b>src/test/java/Runner/TestRunner.java</b> It runs both feature files.</br> 

If you want to run only one feature file, simply add the feature file to <b>@CucumberOptions name</b> at runner class
<br><b><i>Example</i></b>: features = "src/test/resources/Features/APIs.feature" </br>

If you want to run only one Sceanario, simply add Tag Name to <b>@CucumberOptions</b> at runner class
<br><b><i>Example</i></b>: tags = "@Registration" </br>



<h2> Task 1 – RESTful API tests </h2>

All tests in this section should be attempted against the API provided at https://reqres.in/. All
request payloads and responses are in JSON.

<h3> Registration </h3>
<h4> 1. Successful registration </h4>
<ul style="list-style-type:disc;">
<li> POST on https://reqres.in/api/register </li>
<li> Payload: email and password </li>
<li> Response: 201 along with a token </li>
</ul>

<h4> 2. Unsuccessful registration </h4>
<ul style="list-style-type:disc;">
<li> POST on https://reqres.in/api/register </li>
<li> Payload: email </li>
<li> Response: 400 along with an error </li>
</ul>

<h3> Get User List </h3>
<h4> 3. List users </h4>
<ul style="list-style-type:disc;">
<li> GET on https://reqres.in/api/users </li>
<li> No payload </li>
<li> Response: 200 with list of users </li>
</ul>

<h2> Task 2 – Webpage tests </h2>

Sign in (All Sign in tests should be attempted against the http://automationpractice.com website)
<ol>
<li>Sign in with no credentials. Ensure the correct error message is displayed.</li>
<li>Sign in with email and empty password. Ensure the correct error message is displayed.</li>
<li>Sign in with password and empty email. Ensure the correct error message is displayed.</li>
<li>Sign in with incorrect credentials. Ensure the correct error message is displayed.</li>
</ol>
