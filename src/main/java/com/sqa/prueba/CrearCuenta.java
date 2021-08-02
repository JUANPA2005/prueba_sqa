package com.sqa.prueba;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class CrearCuenta extends BasePage {

	public CrearCuenta(WebDriver pDriver) {
		super(pDriver);
	}

	@FindBy(css = "#email_create")
	private WebElement email;

	@FindBy(css = "#SubmitCreate")
	private WebElement boton_crear_cuenta;

	@FindBy(css = "#account-creation_form div.account_creation:first-child h3")
	private WebElement formulario_crear_cuenta;

	@FindBy(css = "#id_gender1")
	private WebElement checkbox_titulo_senor;

	@FindBy(css = "#customer_firstname")
	private WebElement campo_nombre_1;

	@FindBy(css = "#customer_lastname")
	private WebElement campo_apellido_1;

	@FindBy(css = "#passwd")
	private WebElement campo_contrasena;

	@FindBy(css = "#days")
	private WebElement menu_dia;

	@FindBy(css = "#months")
	private WebElement menu_mes;

	@FindBy(css = "#years")
	private WebElement menu_anho;

	@FindBy(css = "#uniform-newsletter span")
	private WebElement checkbox_suscribase;

	@FindBy(css = "#uniform-optin span")
	private WebElement checkbox_recibir_ofertas;

	@FindBy(css = "#firstname")
	private WebElement campo_nombre_2;

	@FindBy(css = "#lastname")
	private WebElement campo_apellido_2;

	@FindBy(css = "#company")
	private WebElement campo_compania;

	@FindBy(css = "#address1")
	private WebElement campo_direccion_1;

	@FindBy(css = "#address2")
	private WebElement campo_direccion_2;

	@FindBy(css = "#city")
	private WebElement campo_ciudad;

	@FindBy(css = "#id_state")
	private WebElement menu_estado;

	@FindBy(css = "#postcode")
	private WebElement campo_codigo_postal;

	@FindBy(css = "#other")
	private WebElement campo_informacion_adicional;

	@FindBy(css = "#phone")
	private WebElement campo_telefono;

	@FindBy(css = "#phone_mobile")
	private WebElement campo_celular;

	@FindBy(css = "#alias")
	private WebElement campo_alias_direccion;

	@FindBy(css = "#submitAccount")
	private WebElement boton_registrarse;

	@FindBy(css = ".account span")
	private WebElement validar_registro;

	@FindBy(css = "#create_account_error li")
	private WebElement validar_correo;

	// ACTIONS

	public void Ir_pagina(String url) {
		this.getDriver().get(url);
	}

	public void verCampoEmail() {
		try {
			getWait().until(ExpectedConditions.visibilityOf(email));
		} catch (NullPointerException e) {
			getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#email_create")));
		}
	}

	public void escribirEmail(String text) {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 5;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    
//		this.email.sendKeys("test@gmail.com");
		 this.email.sendKeys(generatedString+"@gmail.com");
//		 this.email.sendKeys(text);
	}

	public void clickCrearCuenta() {
		boton_crear_cuenta.click();

		try {
			getWait().until(ExpectedConditions.visibilityOf(formulario_crear_cuenta));
			Assert.assertTrue(true);
			System.out.println("@@@@@@@@@@@@@ El Correo es valido @@@@@@@@@@@@@");
		}catch(TimeoutException e ) {
			getWait().until(ExpectedConditions.visibilityOf(this.validar_correo));
			System.out.println("@@@@@@@@@@@@@ El Correo no es valido @@@@@@@@@@@@@");
			System.out.println(">>>>>>>"+ this.validar_correo.getText());
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			Assert.assertTrue(this.validar_correo.getText(), false);
		}
	}

	public void verFormulario() {
		try {
			getWait().until(ExpectedConditions.visibilityOf(formulario_crear_cuenta));
		} catch (NullPointerException e) {
			getWait().until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector("#account-creation_form div.account_creation:first-child h3")));
		}
	}

	public void clickCheckboxTituloSenor() {
		checkbox_titulo_senor.click();
	}

	public void escribirNombre1(String text) {
		this.campo_nombre_1.sendKeys(text);
	}

	public void escribirApellido1(String text) {
		this.campo_apellido_1.sendKeys(text);
	}

	public void escribirContrasena(String text) {
		this.campo_contrasena.sendKeys(text);
	}

	public void seleccionMenuDia(String seleccion) {
//		WebElement elemento_dia = getDriver().findElement(By.cssSelector("#days"));
		Select dropDown = new Select(this.menu_dia);
		dropDown.selectByValue(seleccion);
	}

	public void seleccionMenuMes(String seleccion) {
		WebElement cssSelector = getDriver().findElement(By.cssSelector("#months"));
		Select dropDown = new Select(cssSelector);
		dropDown.selectByIndex(7);
	}

	public void seleccionMenuAnho(String seleccion) {
		Select dropDown = new Select(this.menu_anho);
		dropDown.selectByValue(seleccion);
	}

	public void clickCheckboxSuscribase() {
		this.checkbox_suscribase.click();
	}

	public void clickCheckboxRecibirOfertas() {
		this.checkbox_recibir_ofertas.click();
	}

	public void escribirNombre_2(String text) {
		this.campo_nombre_2.sendKeys(text);
	}

	public void escribirApellido2(String text) {
		this.campo_apellido_2.sendKeys(text);
	}

	public void escribirCompania(String text) {
		this.campo_compania.sendKeys(text);
	}

	public void escribirDireccion1(String text) {
		this.campo_direccion_1.sendKeys(text);
	}

	public void escribirDireccion2(String text) {
		this.campo_direccion_2.sendKeys(text);
	}

	public void escribirCiudad(String text) {
		this.campo_ciudad.sendKeys(text);
	}

	public void seleccionMenuEstado(String seleccion) {
		Select dropDown = new Select(this.menu_estado);
		dropDown.selectByIndex(17);
	}

	public void escribirCodigoPostal(String text) {
		this.campo_codigo_postal.sendKeys(text);
	}

	public void escribirInformacionAdicional(String text) {
		this.campo_informacion_adicional.sendKeys(text);
	}

	public void escribirTelefono(String text) {
		this.campo_telefono.sendKeys(text);
	}

	public void escribirCelular(String text) {
		this.campo_celular.sendKeys(text);
	}

	public void escribirAliasDirecciones(String text) {
		this.campo_alias_direccion.clear();
		this.campo_alias_direccion.sendKeys(text);
	}

	public void clickRegistrarse() {
		this.boton_registrarse.click();
	}

	public void validarRegistro(String text) throws Exception {
//		WebElement elemento = getDriver().findElement(By.cssSelector(".account span"));
		getWait().until(ExpectedConditions.visibilityOf(validar_registro));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + validar_registro.getText());
		if(text.equalsIgnoreCase(text)) {
			Assert.assertTrue(true);
			System.out.println("@@@@@@@@@@@@@ registro exitoso @@@@@@@@@@@@@");
		}else {
			Assert.assertTrue(false);
			System.out.println("@@@@@@@@@@@@@ registro fallido @@@@@@@@@@@@@");
		}
		
	}

}