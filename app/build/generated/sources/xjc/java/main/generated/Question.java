
package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;choice&amp;gt;
 *         &amp;lt;element ref="{}checkbox-group"/&amp;gt;
 *         &amp;lt;element ref="{}colorpicker"/&amp;gt;
 *         &amp;lt;element ref="{}radio-group"/&amp;gt;
 *         &amp;lt;element ref="{}datepicker"/&amp;gt;
 *         &amp;lt;element ref="{}text-input"/&amp;gt;
 *         &amp;lt;element ref="{}email-input"/&amp;gt;
 *         &amp;lt;element ref="{}phone-number-input"/&amp;gt;
 *         &amp;lt;element ref="{}decimal-input"/&amp;gt;
 *         &amp;lt;element ref="{}integer-input"/&amp;gt;
 *       &amp;lt;/choice&amp;gt;
 *       &amp;lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *       &amp;lt;attribute name="text" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "checkboxGroup",
    "colorpicker",
    "radioGroup",
    "datepicker",
    "textInput",
    "emailInput",
    "phoneNumberInput",
    "decimalInput",
    "integerInput"
})
@XmlRootElement(name = "question")
public class Question {

    @XmlElement(name = "checkbox-group")
    protected CheckboxGroup checkboxGroup;
    protected Object colorpicker;
    @XmlElement(name = "radio-group")
    protected RadioGroup radioGroup;
    protected Object datepicker;
    @XmlElement(name = "text-input")
    protected TextInput textInput;
    @XmlElement(name = "email-input")
    protected EmailInput emailInput;
    @XmlElement(name = "phone-number-input")
    protected PhoneNumberInput phoneNumberInput;
    @XmlElement(name = "decimal-input")
    protected DecimalInput decimalInput;
    @XmlElement(name = "integer-input")
    protected IntegerInput integerInput;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "text", required = true)
    protected String text;

    /**
     * Gets the value of the checkboxGroup property.
     * 
     * @return
     *     possible object is
     *     {@link CheckboxGroup }
     *     
     */
    public CheckboxGroup getCheckboxGroup() {
        return checkboxGroup;
    }

    /**
     * Sets the value of the checkboxGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link CheckboxGroup }
     *     
     */
    public void setCheckboxGroup(CheckboxGroup value) {
        this.checkboxGroup = value;
    }

    /**
     * Gets the value of the colorpicker property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getColorpicker() {
        return colorpicker;
    }

    /**
     * Sets the value of the colorpicker property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setColorpicker(Object value) {
        this.colorpicker = value;
    }

    /**
     * Gets the value of the radioGroup property.
     * 
     * @return
     *     possible object is
     *     {@link RadioGroup }
     *     
     */
    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    /**
     * Sets the value of the radioGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link RadioGroup }
     *     
     */
    public void setRadioGroup(RadioGroup value) {
        this.radioGroup = value;
    }

    /**
     * Gets the value of the datepicker property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDatepicker() {
        return datepicker;
    }

    /**
     * Sets the value of the datepicker property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDatepicker(Object value) {
        this.datepicker = value;
    }

    /**
     * Gets the value of the textInput property.
     * 
     * @return
     *     possible object is
     *     {@link TextInput }
     *     
     */
    public TextInput getTextInput() {
        return textInput;
    }

    /**
     * Sets the value of the textInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextInput }
     *     
     */
    public void setTextInput(TextInput value) {
        this.textInput = value;
    }

    /**
     * Gets the value of the emailInput property.
     * 
     * @return
     *     possible object is
     *     {@link EmailInput }
     *     
     */
    public EmailInput getEmailInput() {
        return emailInput;
    }

    /**
     * Sets the value of the emailInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmailInput }
     *     
     */
    public void setEmailInput(EmailInput value) {
        this.emailInput = value;
    }

    /**
     * Gets the value of the phoneNumberInput property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneNumberInput }
     *     
     */
    public PhoneNumberInput getPhoneNumberInput() {
        return phoneNumberInput;
    }

    /**
     * Sets the value of the phoneNumberInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneNumberInput }
     *     
     */
    public void setPhoneNumberInput(PhoneNumberInput value) {
        this.phoneNumberInput = value;
    }

    /**
     * Gets the value of the decimalInput property.
     * 
     * @return
     *     possible object is
     *     {@link DecimalInput }
     *     
     */
    public DecimalInput getDecimalInput() {
        return decimalInput;
    }

    /**
     * Sets the value of the decimalInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecimalInput }
     *     
     */
    public void setDecimalInput(DecimalInput value) {
        this.decimalInput = value;
    }

    /**
     * Gets the value of the integerInput property.
     * 
     * @return
     *     possible object is
     *     {@link IntegerInput }
     *     
     */
    public IntegerInput getIntegerInput() {
        return integerInput;
    }

    /**
     * Sets the value of the integerInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerInput }
     *     
     */
    public void setIntegerInput(IntegerInput value) {
        this.integerInput = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

}
