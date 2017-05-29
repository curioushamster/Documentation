<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Робочі навчальні плани</title>
    <!-- jTable Metro styles. -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
    <link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
    <!-- jTable script file. -->
    <script src="js/jquery-1.8.2.js" type="text/javascript"></script>
    <script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
    <script src="js/jquery.jtable.min.js" type="text/javascript"></script>
    <script src="js/jquery.jtable.editinline.js" type="text/javascript"></script>
    <!-- User Defined Jtable js file -->
    <script src="js/Workplan.js" type="text/javascript" charset="UTF-8"></script>
    <link rel="stylesheet" href="styles.css" />
</head>
<body>
    <header id="header"></header>
    <script type="text/javascript">
    $(function() {
        $( "#header" ).load( "menu.html" );
    });
    </script>
    <div style="text-align: center;">
        <div id="WorkplanTableContainer"></div>
    </div>
</body>
</html>
