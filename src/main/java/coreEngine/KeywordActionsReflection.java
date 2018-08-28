package coreEngine;

import Actions.keywordActions;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KeywordActionsReflection {
    public static Method[] method;
    public static keywordActions actions;
    static Class cls = keywordActions.class;

    public void getMethods() throws NoSuchMethodException {
        actions =new keywordActions();
        method=cls.getDeclaredMethods();
        for (Method method:cls.getDeclaredMethods()) {
            System.out.println(method);
        }
    }

    public void performAction(String Keyword,String data) throws InvocationTargetException, IllegalAccessException {
        for(int i=0;i<method.length;i++){
            if(method[i].getName().equalsIgnoreCase(Keyword)){
                System.out.println("inside invoke condition" + method[i]);
                method[i].invoke(actions,data);
                break;
            }
        }
    }
}
