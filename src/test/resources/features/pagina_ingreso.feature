@creacion_usuario
Feature: Creación de cuenta usuario
	Creación de usuario en la pagina http://automationpractice.com/index.php
	
	Background: Usuario navega a la pagina de Ingreso
		Given navegando en la pagina "Ingreso" con URL "http://automationpractice.com/index.php"
		When visualizar el boton "boton_sign_in"
				 
	Scenario Outline: creación de cuentas de usuarios 	
	
		When click en el boton "boton_sign_in"
		Then visualizar el campo "email"
		When escribir en el campo "email" con "____RANDOM_____"
#		When escribir en el campo "email" con <email>	
		And click en el boton "crear_cuenta"
		Then visualizar el formulario "formulario_crear_cuenta"
		And click en el checkbox "titulo_senor"	
		And escribir en el campo "nombre_1" con "Sebastián"
		And escribir en el campo "apellido_1" con "Marin"
		And escribir en el campo "contrasena" con "password123"	
		And seleccionar el menu "día" con el valor "22"
		And seleccionar el menu "mes" con el valor "July"
		And seleccionar el menu "año" con el valor "1989"
		And click en el checkbox "suscribase a noticias"	
		And click en el checkbox "recibir ofertas"
		And escribir en el campo "nombre_2" con "Jhoan"
		And escribir en el campo "apellido_2" con "Marín"
		And escribir en el campo "compañia" con "SQA"
		And escribir en el campo "direccion_1" con "carrera 81"
		And escribir en el campo "direccion_2" con "piso 2"
		And escribir en el campo "ciudad" con "Kansas City"
		And seleccionar el menu "estado" con el valor "Kansas"
		And escribir en el campo "codigo postal" con "66102"
		And escribir en el campo "información adicional" con "ninguna"
		And escribir en el campo "teléfono" con "4557698"
		And escribir en el campo "celular" con "3153650923"
		And escribir en el campo "alias de direcciones" con "ninguna"
		And click en el boton "registrarse"
		And validar registro "creación de usuario" con el valor "Sebastián Marín"
		Examples:
			| email|								
			|"test@gmail.com"|
			|"test1@gmail.com"|
			|"test2@gmail.com"|
			|"test3@gmail.com"|
			|"test4@gmail.com"|
			|"test5@gmail.com"|
			|"test6@gmail.com"|
			|"test7@gmail.com"|
			|"test8@gmail.com"|
		
								