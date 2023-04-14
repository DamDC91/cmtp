
package generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Colorpicker_QNAME = new QName("", "colorpicker");
    private final static QName _Datepicker_QNAME = new QName("", "datepicker");
    private final static QName _Text_QNAME = new QName("", "text");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReplyCheckbox }
     * 
     */
    public ReplyCheckbox createReplyCheckbox() {
        return new ReplyCheckbox();
    }

    /**
     * Create an instance of {@link Msg }
     * 
     */
    public Msg createMsg() {
        return new Msg();
    }

    /**
     * Create an instance of {@link Checkbox }
     * 
     */
    public Checkbox createCheckbox() {
        return new Checkbox();
    }

    /**
     * Create an instance of {@link CheckboxGroup }
     * 
     */
    public CheckboxGroup createCheckboxGroup() {
        return new CheckboxGroup();
    }

    /**
     * Create an instance of {@link Radio }
     * 
     */
    public Radio createRadio() {
        return new Radio();
    }

    /**
     * Create an instance of {@link RadioGroup }
     * 
     */
    public RadioGroup createRadioGroup() {
        return new RadioGroup();
    }

    /**
     * Create an instance of {@link TextInput }
     * 
     */
    public TextInput createTextInput() {
        return new TextInput();
    }

    /**
     * Create an instance of {@link EmailInput }
     * 
     */
    public EmailInput createEmailInput() {
        return new EmailInput();
    }

    /**
     * Create an instance of {@link PhoneNumberInput }
     * 
     */
    public PhoneNumberInput createPhoneNumberInput() {
        return new PhoneNumberInput();
    }

    /**
     * Create an instance of {@link IntegerInput }
     * 
     */
    public IntegerInput createIntegerInput() {
        return new IntegerInput();
    }

    /**
     * Create an instance of {@link DecimalInput }
     * 
     */
    public DecimalInput createDecimalInput() {
        return new DecimalInput();
    }

    /**
     * Create an instance of {@link Question }
     * 
     */
    public Question createQuestion() {
        return new Question();
    }

    /**
     * Create an instance of {@link ReplyCheckbox.CheckedBox }
     * 
     */
    public ReplyCheckbox.CheckedBox createReplyCheckboxCheckedBox() {
        return new ReplyCheckbox.CheckedBox();
    }

    /**
     * Create an instance of {@link ReplyRadio }
     * 
     */
    public ReplyRadio createReplyRadio() {
        return new ReplyRadio();
    }

    /**
     * Create an instance of {@link ReplyColor }
     * 
     */
    public ReplyColor createReplyColor() {
        return new ReplyColor();
    }

    /**
     * Create an instance of {@link ReplyDate }
     * 
     */
    public ReplyDate createReplyDate() {
        return new ReplyDate();
    }

    /**
     * Create an instance of {@link ReplyEmail }
     * 
     */
    public ReplyEmail createReplyEmail() {
        return new ReplyEmail();
    }

    /**
     * Create an instance of {@link ReplyPhoneNumber }
     * 
     */
    public ReplyPhoneNumber createReplyPhoneNumber() {
        return new ReplyPhoneNumber();
    }

    /**
     * Create an instance of {@link ReplyDecimal }
     * 
     */
    public ReplyDecimal createReplyDecimal() {
        return new ReplyDecimal();
    }

    /**
     * Create an instance of {@link ReplyInteger }
     * 
     */
    public ReplyInteger createReplyInteger() {
        return new ReplyInteger();
    }

    /**
     * Create an instance of {@link ReplyText }
     * 
     */
    public ReplyText createReplyText() {
        return new ReplyText();
    }

    /**
     * Create an instance of {@link Reply }
     * 
     */
    public Reply createReply() {
        return new Reply();
    }

    /**
     * Create an instance of {@link Form }
     * 
     */
    public Form createForm() {
        return new Form();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link Msg.Header }
     * 
     */
    public Msg.Header createMsgHeader() {
        return new Msg.Header();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "colorpicker")
    public JAXBElement<Object> createColorpicker(Object value) {
        return new JAXBElement<Object>(_Colorpicker_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "datepicker")
    public JAXBElement<Object> createDatepicker(Object value) {
        return new JAXBElement<Object>(_Datepicker_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "", name = "text")
    public JAXBElement<Object> createText(Object value) {
        return new JAXBElement<Object>(_Text_QNAME, Object.class, null, value);
    }

}
