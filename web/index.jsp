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

    <!--icons-->
    <link rel="stylesheet" href="fonts/font-awesome/css/font-awesome.min.css">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/automation.css" rel="stylesheet">


    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <h1>Automation test</h1>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">

        <span><select id="action" class="action_of_lists">
        <option>Action</option>
        <option>NavigateTo</option>
        <option>Click</option>
        <option>Text</option>
        </select></span>

        <span><select id="stringType" class="action_of_lists">
        <option>String type</option>
        <option>name</option>
        <option>id</option>
        <option>Xpath</option>
        <option>Link text</option>
        <option>url</option>
        </select></span>

        <span><input type="text" class="form-control" placeholder="String" id="String"></span>
        <span><input type="text" class="form-control" placeholder="Text value" id="Text_value"></span>
        <span><input type="text" class="form-control" placeholder="Verification Message"
                     id="Verification_Message"></span>
        <span><button onclick="myAction()" type="button" class="add_row btn btn-success">Add</button></span>

    </div>

</div>

<div class="container">

    <form action="/automation" method="post">
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
        <span><input type="submit" value="Run" name="tableSubmit" class="add_row btn btn-success"></span>
    </form>

    <form action="/report" method="post">
    <input type="submit" value="View Report" name="viewReport" class="add_row btn btn-success">
    </form>
</div>

<script src="javascript.js"></script>
</body>
</html>
