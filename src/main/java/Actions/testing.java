package Actions;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class testing {

    public static void createConnection(String Identifier, String Locator, String InputData, String Action) {
        Map testmap = new HashMap();
        String[] inputInputDataArray = InputData.split(",");
        String[] locatorsArray = Locator.split(",");
        for (String str : inputInputDataArray) {
            String[] eachString = str.split(":");
            testmap.put(eachString[0],eachString[1]);

        }
        String selectValue = "\""+testmap.get("Connector").toString().replace("'","")+"\"";

        System.out.println(selectValue);
    }

public void test(){
    createConnection("identifier","locator","Connector:'Microsoft Azure ServiceBus Connector',name:'',description:'',authorizationRuleName:'',resourceURI:'',primarysecondaryKey:''","Action");
}


}
