<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Register</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="/styles/assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- FONTAWESOME STYLES-->
    <link href="/styles/assets/css/font-awesome.css" rel="stylesheet"/>
    <!-- CUSTOM STYLES-->
    <link href="/styles/assets/css/custom.css" rel="stylesheet"/>
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>

</head>
<body>
<div class="container">
    <div class="row text-center  ">
        <div class="col-md-12">
            <br/><br/>
            <h2> Register</h2>
        </div>
    </div>
    <form method="post">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-10">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong> Step 1: About You </strong>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <br/>

                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" name="FirstName" placeholder="First Name*"
                                        value="${requestScope.FirstName}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" name="SecondName"
                                       placeholder="Second Name*" value="${requestScope.SecondName}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" name="Patronymic" placeholder="Patronymic*"
                                       value="${requestScope.Patronymic}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" pattern="+[0-9]{12}" name="PhoneNumber"
                                       placeholder="Phone number*" value="${requestScope.PhoneNumber}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon">@</span>
                                <input type="text" class="form-control" name="Email" placeholder="Your Email*"
                                       value="${requestScope.Email}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" class="form-control" name="Password1"
                                       placeholder="Enter Password*"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" class="form-control" name="Password2"
                                       placeholder="Retype Password*"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-10">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong> Step 2: Your first card </strong>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <br/>

                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="number" class="form-control" pattern="[0-9]{16}" name="CardNumber"
                                       placeholder="Card number*" value="${requestScope.CardNumber}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="date" class="form-control" name="ExpiryDate"
                                       placeholder="Expiry date*" value="${requestScope.ExpiryDate}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" class="form-control" name="Pin1"
                                       placeholder="Enter Pin*"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                <input type="password" class="form-control" name="Pin2"
                                       placeholder="Retype Pin*"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" name="CardTitle" placeholder="Title"
                                       value="${requestScope.CardTitle}"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-10">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong> Step 3: Your first account </strong>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <br/>

                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="number" class="form-control" pattern="[0-9]{16}" name="AccountNumber"
                                       placeholder="Account number*" value="${requestScope.AccountNumber}"/>
                            </div>
                            <div class="form-group input-group">
                                <span class="input-group-addon"><i class="fa fa-circle-o-notch"></i></span>
                                <input type="text" class="form-control" name="AccountTitle"
                                       placeholder="Title" value="${requestScope.AccountTitle}"/>
                            </div>

                            <button onclick="submit" class="btn btn-success ">Register Me</button>
                            <hr/>
                            Already Registered? <a href="/login/*">Login here</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>


<%@ include file="/WEB-INF/pages/fragment/includeJs.jspf"%>

</body>
</html>
