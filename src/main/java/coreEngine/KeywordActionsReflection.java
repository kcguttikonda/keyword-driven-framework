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

    public void getMethods()  {
        try{
            actions =new keywordActions();
            method=cls.getDeclaredMethods();
        }
      catch (Exception e){
            System.out.println("unable get methods "+e.getMessage());
      }

    }

    public void performAction(String Identifier, String InputLocator, String InputData, String Action) throws InvocationTargetException, IllegalAccessException {
        try{
            for(int i=0;i<method.length;i++){
                if(method[i].getName().equalsIgnoreCase(Action)){
                    System.out.println("inside invoke condition" + method[i]);
                    method[i].invoke(actions,Identifier,InputLocator,InputData,Action);
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("unable invoke action methods"+e.getMessage());
        }


    }

    public WebElement identifyLocator(String identifier, WebDriver driver,String locator) throws InvocationTargetException, IllegalAccessException {

        try{
            locators = new Identifiers();
            method=identifierclass.getDeclaredMethods();

            for(int i=0;i<method.length;i++){
                if(method[i].getName().equalsIgnoreCase(identifier)){
                    System.out.println("inside invoke condition" + method[i]);
                    element= (WebElement) method[i].invoke(locators,driver,locator);
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("unable to invoke identifier method" + e.getMessage());
        }


        return element;
    }

}
