package Mock;

import com.tt1.test.IEmail;

public class MailerFake implements IEmail {
    @Override
    public boolean enviarCorreo(String d, String m) {
        return true;
    }
}
