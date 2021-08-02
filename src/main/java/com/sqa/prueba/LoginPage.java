package com.sqa.prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver pDriver) {
		super(pDriver);
	}

	@FindBy(css = ".login")
	private WebElement boton_sign_in;

	// ACTIONS

	public void Ir_pagina(String url) {
		this.getDriver().get(url);
	}

	public void verBotonSignIn() {
		try {
			getWait().until(ExpectedConditions.visibilityOf(boton_sign_in));
		} catch (NullPointerException e) {
			getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login")));
		}
	}

	public CrearCuenta clickBotonSignIn() {
		this.boton_sign_in.click();
		return new CrearCuenta(getDriver());
	}

}