<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

     <!-- Latest compiled and minified CSS -->
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    

     <!-- Latest compiled JavaScript -->
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
 
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
     <!-- <link rel="stylesheet" href="/css/demo.css"> -->
 
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 col-12 mx-auto">
                <h3>Create a user</h3>
                <hr/>

                <form:form method="post" action="/admin/user/create"
                modelAttribute="newUser"
                >
                    <div class="mb-3">
                      <label for="exampleInputEmail1" class="form-label">Email address</label>
                      <form:input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                      path="email"/>
                      <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>
                    <div class="mb-3">
                      <label for="exampleInputPassword1" class="form-label">Password</label>
                      <form:input type="password" class="form-control" id="exampleInputPassword1"
                      path="password"/>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Phone number</label>
                        <form:input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                        path="phone"/>
                           </div>
                      <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Full name</label>
                        <form:input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                        path="fullName"/>
                       </div>
                      <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Adress</label>
                        <form:input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                        path="address"/>
                         </div>
                    
                    <button type="submit" class="btn btn-primary">Create</button>
                  </form:form>

            </div>
        </div>
    </div>

  
    
</body>
</html>