<%-- 
    Document   : upload
    Created on : 23 янв. 2021 г., 01:32:04
    Author     : 123
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
            <form action="FileUpload" method="post" enctype="multipart/form-data">
                
                
                
                <input type="file" name="file" />
                <input type="submit" value="Upload" />
                
                
        </form>
    </body>
</html>
