package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ClickElement;

import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
public class LoginPage extends PageObject {

    @FindBy(name="search")
    private WebElementFacade searchTerms;

    @FindBy(name="go")
    private WebElementFacade lookupButton;
    
    @FindBy(css="a[href='/wiki/apple']")
    private WebElementFacade click_definition;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }   
    
    public void click_link(){
    	click_definition.click();
    }
    	
    //commit
    	 
    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        List<WebElement> results = definitionList.findElements(By.tagName("li"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
    
    
    	
}