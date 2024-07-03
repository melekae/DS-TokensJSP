<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Server</title>
    </head>
    <body>
        
        <div style="color:green;">${recenica}</div><br><br>
        
        <!-- ${recenica} je JSP Expression Language (EL) izraz koji će biti zamenjen vrednošću atributa "recenica" 
          koji je postavljen u servletu sa request.setAttribute("recenica", "Recenica podeljena na tokene: " + "[" + sb + "]");-->
        
        
        
    </body>
</html>
