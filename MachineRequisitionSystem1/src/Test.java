import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DataSource fds = new FileDataSource("../WebContent/WEB-INF/resources/images/SlantWithLogo.png");
        System.out.println(fds.getContentType()+"It works");
    }

}
