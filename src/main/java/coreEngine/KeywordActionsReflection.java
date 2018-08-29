package coreEngine;

import Actions.keywordActions;
import DataMapper.Identifiers;
import DataMapper.TestDataVariables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KeywordActionsReflection {
    public static Method[] method;
    public static keywordActions actions;
    public static Identifiers locators;
    static Class cls = keywordActions.class;
    static Class identifierclass = Identifiers.class;

    public void getMethods() throws NoSuchMethodException {
        actions =new keywordActions();
        method=cls.getDeclaredMethods();
        for (Method method:cls.getDeclaredMethods()) {
            System.out.println(method);
        }
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
        locators = new Identifiers();
        method=identifierclass.getDeclaredMethods();
    }

    public void identifyLocator(String identifier, WebDriver driver) throws InvocationTargetException, IllegalAccessException {
        for(int i=0;i<method.length;i++){
            if(method[i].getName().equalsIgnoreCase(identifier)){
                System.out.println("inside invoke condition" + method[i]);
                method[i].invoke(locators,driver);

                break;
            }
        }
    }

}
