<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CSS Test 06</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script>
    $(function() {
        $("a").click(function() { alert($(this).text()); });            
    });
</script>
<style type="text/css">
    ul.menu, ul.submenu { background-color: #dddddd; padding: 10px; border: 1px solid black; list-style-type: none; }
    ul.menu li { padding: 5px; width: 150px; }        
    ul.menu li:hover { background-color: white; }
    ul.menu > li { display: inline-block; }        
    
    ul.submenu { position: absolute; display: none; }
    li:hover > ul.submenu { display: block; }
    
    ul.menu a { cursor: pointer; text-decoration: none; color: black; }
</style>
</head>
<body>

<ul>
    <li>상위 메뉴 1
        <ul>
            <li><a>하위 메뉴 1-1</a></li>
            <li><a>하위 메뉴 1-2</a></li>
            <li><a>하위 메뉴 1-3</a></li>
        </ul>
    </li>
    <li><a>상위 메뉴 2</a></li>        
    <li>상위 메뉴 3
        <ul>
            <li><a>하위 메뉴 3-1</a></li>
            <li><a>하위 메뉴 3-2</a></li>
            <li><a>하위 메뉴 3-3</a></li>
        </ul>
    </li>
</ul>

<ul class="menu">
    <li>상위 메뉴 1
        <ul class="submenu">
            <li><a>하위 메뉴 1-1</a></li>
            <li><a>하위 메뉴 1-2</a></li>
            <li><a>하위 메뉴 1-3</a></li>
        </ul>
    </li>
    <li><a>상위 메뉴 2</a></li>        
    <li>상위 메뉴 3
        <ul class="submenu">
            <li><a>하위 메뉴 3-1</a></li>
            <li><a>하위 메뉴 3-2</a></li>
            <li><a>하위 메뉴 3-3</a></li>
        </ul>
    </li>
</ul>
</body>
</html>
