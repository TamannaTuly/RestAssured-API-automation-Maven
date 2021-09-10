import org.testng.annotations.DataProvider;

public class DataSetforTest {

    @DataProvider(name = "data for post")
    public Object[][] dataforPost(){
//        Object[][] data = new Object[2][3];
//
//        data[0][0]="niger";
//        data[0][1]="sultana";
//        data[0][2]=1;
//
//        data[1][0]="karim";
//        data[1][1]="khan";
//        data[1][2]=2;

        return new Object[][]{
                {"rahima","khatun",1},
                {"lia","khan",2}
        };

    }
}
