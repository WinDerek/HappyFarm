import com.haveacupofjava.happyfarm.task.Request;
import com.haveacupofjava.happyfarm.task.RequestCategory;
import com.haveacupofjava.happyfarm.task.RequestParsingRule;

/**
 * Tests DuplicateRequestParsingRuleException
 */
public class TestApplication2 {

    public static void main(String[] args) {
        RequestParsingRule requestParsingRule =
                new RequestParsingRule("collect eggs",
                        RequestCategory.PEN_REQUEST,
                        "",
                        TestApplication2.class);
        try {
            Request.addRequestParsingRule(requestParsingRule);
            Request.addRequestParsingRule(requestParsingRule);
        } catch (Exception exception) {
            exception.printStackTrace(System.out);
        }
    }

}
