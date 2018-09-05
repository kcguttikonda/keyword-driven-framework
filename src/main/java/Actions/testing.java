package Actions;

import org.testng.annotations.Test;

public class testing {

    public static void createConnection(String Identifier, String Locator, String InputData, String Action)
    {
        String[] inputInputDataArray = InputData.split(",");
        String[] locatorsArray = Locator.split(",");
        for (String str:inputInputDataArray) {
            System.out.println(str);
        }



    }


@Test
public void test(){
    createConnection("identifier","locator","Name:'',DEscription:'',AuthRule:'',NameSpace:'',Key:''","Action");
}


}
