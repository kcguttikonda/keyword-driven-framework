package coreEngine;

import Actions.keywordActions;
import DataMapper.Identifiers;
import DataMapper.TestDataVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KeywordActionsReflection {
    public static Method[] method;
    public static keywordActions actions;
    public static Identifiers locators;
    static Class cls = keywordActions.class;
    static Class identifierclass = Identifiers.class;
    public WebElement element;

    public void getMethods() throws NoSuchMethodException {
        actions =new keywordActions();
        method=cls.getDeclaredMethods();

    }

    public void performAction(String Identifier, String InputLocator, String InputData, String Action) throws InvocationTargetException, IllegalAccessException {
        for(int i=0;i<method.length;i++){
            if(method[i].getName().equalsIgnoreCase(Action)){
                System.out.println("inside invoke condition" + method[i]);
                method[i].invoke(actions,Identifier,InputLocator,InputData,Action);
                break;
            }
        }
    }

    public void getMethodsIdentifiers() throws NoSuchMethodException {

    }

    public WebElement identifyLocator(String identifier, WebDriver driver,String locator) throws InvocationTargetException, IllegalAccessException {
        locators = new Identifiers();
        method=identifierclass.getDeclaredMethods();

        for(int i=0;i<method.length;i++){
            if(method[i].getName().equalsIgnoreCase(identifier)){
                System.out.println("inside invoke condition" + method[i]);
                element= (WebElement) method[i].invoke(locators,driver,locator);
                break;
            }
        }
        return element;
    }

}
