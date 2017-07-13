<%--
  Created by IntelliJ IDEA.
  User: mayesh
  Date: 7/3/17
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Automation</title>

    <!--fonts-->
    <link href="https://fonts.googleapis.com/css?family=Arvo" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Kurale" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Dancing+Script|Open+Sans" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">

    <link rel="stylesheet" href="fonts/font-awesome/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/automation.css" rel="stylesheet">

    <!--JS-->
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="javascript.js"></script>

</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <h1>Automation Test</h1>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <p id="jumbotron_p">We're in each other's life for a reason. Thanks for showing up.</p>

        <select onchange="enableTextValue()" id="action" class="action_of_lists">
            <option>Action</option>
            <option>NavigateTo</option>
            <option>Click</option>
            <option>Text</option>
        </select>

        <select id="stringType" class="action_of_lists">
            <option>String type</option>
            <option>name</option>
            <option>id</option>
            <option>Xpath</option>
            <option>Link text</option>
            <option>url</option>
        </select>

        <input type="text" class="form-control" placeholder="String" id="String">
        <input type="text" class="form-control" placeholder="Text value" id="Text_value" disabled>
        <input type="text" class="form-control" placeholder="Verification Message"
               id="Verification_Message">
        <button onclick="myAction()" type="button" class="add_row btn btn-success">Add</button>

    </div>

</div>
<div class="first_container">
    <div class="container">
        <form action="/automation" method="post">
            <p class="first_container_p">Don't use your energy on worry. Use it to believe & find a way.<input
                    type="submit" value="Run" name="tableSubmit" class="add_row btn btn-success"></p>

            <table border="1px solid" class="table">
                <thead>
                <th>Action</th>
                <th>String Type</th>
                <th>String</th>
                <th>Text Value</th>
                <th>Verification Message</th>
                </thead>
                <tbody id="mytable">
                <tr>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
</div>

<footer class="footer">
    <div class="container">
        <p class="text-muted">Coded By:<br><span id="footerName">Muhammad Ayesh</span></p>
    </div>
</footer>
</body>
</html>
