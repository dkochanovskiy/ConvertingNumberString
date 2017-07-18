import ru.kochanovskiy.convertingnumberstring.Parser;
import org.junit.Test;

public class ParserTest {
    @Test
    public void testParser() throws Exception {

        Parser parser = new Parser();

        int enteredNumber = 131;

        System.out.println(parser.decimalParser(Integer.toString(enteredNumber)) + " в десятиричной системе счисления;");
        System.out.println(parser.decimalParser(parser.octalConversion(enteredNumber)) + " в восьмеричной системе счисления;");
    }
}
