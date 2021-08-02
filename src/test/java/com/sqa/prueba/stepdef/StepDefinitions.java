package com.sqa.prueba.stepdef;

import com.sqa.prueba.Driver;
import com.sqa.prueba.LoginPage;
import com.sqa.prueba.CrearCuenta;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

	private Driver driver;
	private LoginPage loginPage;
	private CrearCuenta crearCuenta;

	@Before
	public void setUp() throws Throwable {
		this.driver = new Driver();
	}

	@Given("^navegando en la pagina \"([^\"]*)\" con URL \"([^\"]*)\"$")
	public void navegando_en_la_pagina_con_URL(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("Ingreso")) {
			loginPage = new LoginPage(driver.getWebDriver());
			loginPage.Ir_pagina(arg2);
		} else {
			throw new Exception("No valid option");
		}
	}

	@Then("^visualizar el boton \"([^\"]*)\"$")
	public void debo_ver_el_boton(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("boton_sign_in")) {
			loginPage.verBotonSignIn();
		} else {
			throw new Exception("No valid option");
		}
	}

	@When("^click en el boton \"([^\"]*)\"$")
	public void si_hago_click_en_el_boton(String arg1) throws Throwable {

		if (arg1.equalsIgnoreCase("boton_sign_in")) {
			crearCuenta = loginPage.clickBotonSignIn();
		} else if (arg1.equalsIgnoreCase("crear_cuenta")) {
			crearCuenta.clickCrearCuenta();
		} else if (arg1.equalsIgnoreCase("registrarse")) {
			crearCuenta.clickRegistrarse();
		} else {
			throw new Exception("No valid option");
		}
	}

	@When("^click en el checkbox \"([^\"]*)\"$")
	public void click_en_el_checkbox(String arg1) throws Throwable {

		if (arg1.equalsIgnoreCase("titulo_senor")) {
			crearCuenta.clickCheckboxTituloSenor();
		} else if (arg1.equalsIgnoreCase("suscribase a noticias")) {
			crearCuenta.clickCheckboxSuscribase();
		} else if (arg1.equalsIgnoreCase("recibir ofertas")) {
			crearCuenta.clickCheckboxRecibirOfertas();
		} else {
			throw new Exception("No valid option");
		}
	}

	@Then("^visualizar el formulario \"([^\"]*)\"$")
	public void debo_ver_el_formulario(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("formulario_crear_cuenta")) {
			crearCuenta.verFormulario();
		} else {
			throw new Exception("No valid option");
		}
	}

	@Then("^visualizar el campo \"([^\"]*)\"$")
	public void debo_ver_el_campo(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("email")) {
			crearCuenta.verCampoEmail();
		} else {
			throw new Exception("No valid option");
		}
	}

	@When("^escribir en el campo \"([^\"]*)\" con \"([^\"]*)\"$")
	public void escribir_en_el_campo(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("email")) {
			crearCuenta.escribirEmail(arg2);
		} else if (arg1.equalsIgnoreCase("nombre_1")) {
			crearCuenta.escribirNombre1(arg2);
		} else if (arg1.equalsIgnoreCase("apellido_1")) {
			crearCuenta.escribirApellido1(arg2);
		} else if (arg1.equalsIgnoreCase("contrasena")) {
			crearCuenta.escribirContrasena(arg2);
		} else if (arg1.equalsIgnoreCase("nombre_2")) {
			crearCuenta.escribirNombre_2(arg2);
		} else if (arg1.equalsIgnoreCase("apellido_2")) {
			crearCuenta.escribirApellido2(arg2);
		} else if (arg1.equalsIgnoreCase("compañia")) {
			crearCuenta.escribirCompania(arg2);
		} else if (arg1.equalsIgnoreCase("direccion_1")) {
			crearCuenta.escribirDireccion1(arg2);
		} else if (arg1.equalsIgnoreCase("direccion_2")) {
			crearCuenta.escribirDireccion2(arg2);
		} else if (arg1.equalsIgnoreCase("ciudad")) {
			crearCuenta.escribirCiudad(arg2);
		} else if (arg1.equalsIgnoreCase("codigo postal")) {
			crearCuenta.escribirCodigoPostal(arg2);
		} else if (arg1.equalsIgnoreCase("información adicional")) {
			crearCuenta.escribirInformacionAdicional(arg2);
		} else if (arg1.equalsIgnoreCase("teléfono")) {
			crearCuenta.escribirTelefono(arg2);
		} else if (arg1.equalsIgnoreCase("celular")) {
			crearCuenta.escribirCelular(arg2);
		} else if (arg1.equalsIgnoreCase("alias de direcciones")) {
			crearCuenta.escribirAliasDirecciones(arg2);
		} else {
			throw new Exception("No valid option");
		}
	}

	@Then("^seleccionar el menu \"([^\"]*)\" con el valor \"([^\"]*)\"$")
	public void seleccionar_menu(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("día")) {
			crearCuenta.seleccionMenuDia(arg2);
		} else if (arg1.equalsIgnoreCase("mes")) {
			crearCuenta.seleccionMenuMes(arg2);
		} else if (arg1.equalsIgnoreCase("año")) {
			crearCuenta.seleccionMenuAnho(arg2);
		} else if (arg1.equalsIgnoreCase("estado")) {
			crearCuenta.seleccionMenuEstado(arg2);
		} else {
			throw new Exception("No valid option");
		}
	}
	
	@Then("^validar registro \"([^\"]*)\" con el valor \"([^\"]*)\"$")
	public void validar_registro(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("creación de usuario")) {
			crearCuenta.validarRegistro(arg2);
		}else {
			throw new Exception("No valid option");
		}
	}

	@After
	public void shutDown() throws Throwable {
		this.loginPage.dispose();
	}
}