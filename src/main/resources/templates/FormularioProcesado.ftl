<!DOCTYPE html>
<html lang="es">
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<#--    <title>${titulo}</title>-->
    <style>
        body {
            /*background: -webkit-linear-gradient(left, #0072ff, #00c6ff);*/
        }

        .contact-form {
            background: #fff;
            margin-top: 10%;
            margin-bottom: 5%;
            width: 70
        }

        .contact-form .form-control {
            border-radius: 1rem;
        }

        .contact-image {
            text-align: center;
        }

        .contact-image img {
            border-radius: 6rem;
            width: 11%;
            margin-top: -3%;
            transform: rotate(29deg);
        }

        .contact-form form {
            padding: 14%;
        }

        .contact-form form .row {
            margin-bottom: -7%;
        }

        .contact-form h3 {
            margin-bottom: 8%;
            margin-top: -10%;
            text-align: center;
            color: #0062cc;
        }

        .contact-form .btnContact {
            width: 50%;
            border: none;
            border-radius: 1rem;
            padding: 1.5%;
            background: #dc3545;
            font-weight: 600;
            color: #fff;
            cursor: pointer;
        }

        .btnContactSubmit {
            width: 50%;
            border-radius: 1rem;
            padding: 1.5%;
            color: #fff;
            background-color: #0062cc;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
<div class="row"></div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Matricula</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Carrera</th>
            <th scope="col">Telefono</th>
        </tr>
        </thead>
        <tbody>
        <#list listaEstudiante as x>
            <tr>
                <th scope="row">${x.matricula?long?c}</th>
                <td>${x.nombre}</td>
                <td>${x.apellido}</td>
                <td>${x.carrera}</td>
                <td>${x.telefono}</td>
                <form method="post" action="/Datoseliminado/${x.matricula?long?c}"><td><button class="btnContact" type="submit">Delete</button></td></form>
            <td><a href="/Modificar/${x.matricula?long?c}"  class="btnContact" >Edit</a></td>

            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>