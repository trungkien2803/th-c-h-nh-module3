<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Hello, world!</title>
</head>
<body>
<form>
    <input type="search" name="search">
</form>

<button type="submit" onclick="openForm('form-create','')">Add</button>
<form method="post" action="/products?action=create" style="display: none" id="form-create">
    <h1>Add New Product</h1>
    <input name="name" type="text" placeholder="name">
    <input name="price" type="number" placeholder="price">
    <input name="amount" type="number" placeholder="amount">
    <input name="color" type="text" placeholder="color">
    <input name="description" type="text" placeholder="description">
    <select name="category">
        <c:forEach items="${categories}" var="category22">
            <option  value= "<c:out value="${category22.id}"></c:out>">
                <c:out value="${category22.name}"></c:out>
            </option>
        </c:forEach>
    </select>
    <button type="submit">Add</button>
</form>
<form method="post" action="" style="display: none" id="form-edit">
    <h1>EDIT Product</h1>
    <input name="name" type="text" placeholder="name">
    <input name="price" type="number" placeholder="price">
    <input name="amount" type="number" placeholder="amount">
    <input name="color" type="text" placeholder="color">
    <input name="description" type="text" placeholder="description">
    <select name="category">
        <c:forEach items="${categories}" var="category22">
            <option  value= "<c:out value="${category22.id}"></c:out>">
                <c:out value="${category22.name}"></c:out>
            </option>
        </c:forEach>
    </select>
    <button type="submit">EDIT</button>
</form>
<table class="table table-striped table-hover">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>AMOUNT</th>
        <th>COLOR</th>
        <th>CATEGORY</th>
        <th>ACTION</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out value="${product.id}"></c:out></td>
            <td><c:out value="${product.name}"></c:out></td>
            <td><c:out value="${product.price}"></c:out></td>
            <td><c:out value="${product.amount}"></c:out></td>
            <td><c:out value="${product.color}"></c:out></td>
            <td><c:out value="${product.category}"></c:out></td>
            <td></td>
            <td>
                <button name="id" class="button">
                    <a href="/products?action=delete&id=${product.id}">DELETE</a>
                </button>
            </td>
            <td>
                <button id="${product.id}" onclick="openForm('form-edit',this.id)">
                   EDIT
                </button>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
<script>
    function openForm(form,name){
        let status = document.getElementById("form-create").style.display;
        let status2 = document.getElementById("form-edit").style.display;
        if (form == "form-create" && status =="none"){
            document.getElementById("form-create").style.display = "block"
        }else if (form == "form-edit" && status2 =="none"){
            document.getElementById("form-edit").style.display = "block"
            document.getElementById("form-edit").action = "/products?action=edit&id=" + name
        } else {
            document.getElementById("form-create").style.display = "none"
            document.getElementById("form-edit").style.display = "none"
        }

    }
    function edit(name){

    }

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</html>
