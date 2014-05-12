package com.steps;

import org.junit.Assert;

import com.pages.DictionaryPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.fest.assertions.Assertions.assertThat;
import java.util.List;

public class EndUserSteps extends ScenarioSteps {

    DictionaryPage dictionaryPage;

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }
    
    @Step
    public void click_definition() {
        dictionaryPage.click_link();
    }
    
    @Step
    public void should_see_definition(String definition) {
        List<String> definitions = dictionaryPage.getDefinitions();
        
        boolean found = false;
        
       
        
        for (String i : definitions){
         if (i.contains(definition)){
          found = true;
          break;
         }
         
        }
        
        Assert.assertTrue(found);
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
        getDriver().manage().window().maximize();
    }
   
    
    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}