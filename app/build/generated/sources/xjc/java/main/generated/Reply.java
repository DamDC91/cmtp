
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
 *         &amp;lt;element ref="{}reply-checkbox"/&amp;gt;
 *         &amp;lt;element ref="{}reply-radio"/&amp;gt;
 *         &amp;lt;element ref="{}reply-color"/&amp;gt;
 *         &amp;lt;element ref="{}reply-date"/&amp;gt;
 *         &amp;lt;element ref="{}reply-text"/&amp;gt;
 *         &amp;lt;element ref="{}reply-email"/&amp;gt;
 *         &amp;lt;element ref="{}reply-phone-number"/&amp;gt;
 *         &amp;lt;element ref="{}reply-decimal"/&amp;gt;
 *         &amp;lt;element ref="{}reply-integer"/&amp;gt;
 *       &amp;lt;/choice&amp;gt;
 *       &amp;lt;attribute name="question-id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "replyCheckbox",
    "replyRadio",
    "replyColor",
    "replyDate",
    "replyText",
    "replyEmail",
    "replyPhoneNumber",
    "replyDecimal",
    "replyInteger"
})
@XmlRootElement(name = "reply")
public class Reply {

    @XmlElement(name = "reply-checkbox")
    protected ReplyCheckbox replyCheckbox;
    @XmlElement(name = "reply-radio")
    protected ReplyRadio replyRadio;
    @XmlElement(name = "reply-color")
    protected ReplyColor replyColor;
    @XmlElement(name = "reply-date")
    protected ReplyDate replyDate;
    @XmlElement(name = "reply-text")
    protected ReplyText replyText;
    @XmlElement(name = "reply-email")
    protected ReplyEmail replyEmail;
    @XmlElement(name = "reply-phone-number")
    protected ReplyPhoneNumber replyPhoneNumber;
    @XmlElement(name = "reply-decimal")
    protected ReplyDecimal replyDecimal;
    @XmlElement(name = "reply-integer")
    protected ReplyInteger replyInteger;
    @XmlAttribute(name = "question-id", required = true)
    protected String questionId;

    /**
     * Gets the value of the replyCheckbox property.
     * 
     * @return
     *     possible object is
     *     {@link ReplyCheckbox }
     *     
     */
    public ReplyCheckbox getReplyCheckbox() {
        return replyCheckbox;
    }

    /**
     * Sets the value of the replyCheckbox property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyCheckbox }
     *     
     */
    public void setReplyCheckbox(ReplyCheckbox value) {
        this.replyCheckbox = value;
    }

    /**
     * Gets the value of the replyRadio property.
     * 
     * @return
     *     possible object is
     *     {@link ReplyRadio }
     *     
     */
    public ReplyRadio getReplyRadio() {
        return replyRadio;
    }

    /**
     * Sets the value of the replyRadio property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyRadio }
     *     
     */
    public void setReplyRadio(ReplyRadio value) {
        this.replyRadio = value;
    }

    /**
     * Gets the value of the replyColor property.
     * 
     * @return
     *     possible object is
     *     {@link ReplyColor }
     *     
     */
    public ReplyColor getReplyColor() {
        return replyColor;
    }

    /**
     * Sets the value of the replyColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyColor }
     *     
     */
    public void setReplyColor(ReplyColor value) {
        this.replyColor = value;
    }

    /**
     * Gets the value of the replyDate property.
     * 
     * @return
     *     possible object is
     *     {@link ReplyDate }
     *     
     */
    public ReplyDate getReplyDate() {
        return replyDate;
    }

    /**
     * Sets the value of the replyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyDate }
     *     
     */
    public void setReplyDate(ReplyDate value) {
        this.replyDate = value;
    }

    /**
     * Gets the value of the replyText property.
     * 
     * @return
     *     possible object is
     *     {@link ReplyText }
     *     
     */
    public ReplyText getReplyText() {
        return replyText;
    }

    /**
     * Sets the value of the replyText property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyText }
     *     
     */
    public void setReplyText(ReplyText value) {
        this.replyText = value;
    }

    /**
     * Gets the value of the replyEmail property.
     * 
     * @return
     *     possible object is
     *     {@link ReplyEmail }
     *     
     */
    public ReplyEmail getReplyEmail() {
        return replyEmail;
    }

    /**
     * Sets the value of the replyEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyEmail }
     *     
     */
    public void setReplyEmail(ReplyEmail value) {
        this.replyEmail = value;
    }

    /**
     * Gets the value of the replyPhoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ReplyPhoneNumber }
     *     
     */
    public ReplyPhoneNumber getReplyPhoneNumber() {
        return replyPhoneNumber;
    }

    /**
     * Sets the value of the replyPhoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyPhoneNumber }
     *     
     */
    public void setReplyPhoneNumber(ReplyPhoneNumber value) {
        this.replyPhoneNumber = value;
    }

    /**
     * Gets the value of the replyDecimal property.
     * 
     * @return
     *     possible object is
     *     {@link ReplyDecimal }
     *     
     */
    public ReplyDecimal getReplyDecimal() {
        return replyDecimal;
    }

    /**
     * Sets the value of the replyDecimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyDecimal }
     *     
     */
    public void setReplyDecimal(ReplyDecimal value) {
        this.replyDecimal = value;
    }

    /**
     * Gets the value of the replyInteger property.
     * 
     * @return
     *     possible object is
     *     {@link ReplyInteger }
     *     
     */
    public ReplyInteger getReplyInteger() {
        return replyInteger;
    }

    /**
     * Sets the value of the replyInteger property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReplyInteger }
     *     
     */
    public void setReplyInteger(ReplyInteger value) {
        this.replyInteger = value;
    }

    /**
     * Gets the value of the questionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuestionId() {
        return questionId;
    }

    /**
     * Sets the value of the questionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuestionId(String value) {
        this.questionId = value;
    }

}
