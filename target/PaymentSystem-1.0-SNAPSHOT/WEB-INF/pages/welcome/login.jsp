<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Login</title>
    <link href="/styles/assets/css/bootstrap.css" rel="stylesheet"/>
    <link href="/styles/assets/css/font-awesome.css" rel="stylesheet"/>
    <link href="/styles/assets/css/custom.css" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>

</head>
<body>
<div class="container">
    <div class="row ">
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
            <br/><br/>
            <h2>Terminal</h2>
           <div class="panel panel-default">
                <div class="panel-heading">
                    <strong> Put money on your card </strong>
                </div>
                <div class="panel-body">
                    <form role="form" method="post" action="/put">
                        <br/>

                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                            <input type="number" pattern="[0-9]{16}" class="form-control" placeholder="Card number*"
                                   name="cardNumber"/>
                        </div>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                            <input type="password" class="form-control" placeholder="Pin" name="pin"/>
                        </div>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                            <input type="number" class="form-control" placeholder="Sum" name="sum"/>
                        </div>
                        <button class="btn btn-primary " onclick="submit">Put money</button>
                        <hr/>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
            <br/><br/>
            <h2>Login</h2>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong> Enter your email and password </strong>
                </div>
                <div class="panel-body">
                    <form role="form" method="post">
                        <br/>

                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-tag"></i></span>
                            <input type="text" class="form-control" placeholder="Your email " name="Email"/>
                        </div>
                        <div class="form-group input-group">
                            <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                            <input type="password" class="form-control" placeholder="Your password" name="Password"/>
                        </div>
                        <%--<div class="form-group">--%>
                        <%--<label class="checkbox-inline">--%>
                        <%--<input type="checkbox" /> Remember me--%>
                        <%--</label>--%>
                        <%--<span class="pull-right">--%>
                        <%--<a href="#" >Forget password ? </a>--%>
                        <%--</span>--%>
                        <%--</div>--%>
                        <button class="btn btn-primary " onclick="submit">Login Now</button>
                        <hr/>
                        Not register? <a href="/registration">click here </a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="/styles/assets/js/jquery-1.10.2.js"></script>
<script src="/styles/assets/js/bootstrap.min.js"></script>
<script src="/styles/assets/js/jquery.metisMenu.js"></script>
<script src="/styles/assets/js/custom.js"></script>

</body>
</html>
