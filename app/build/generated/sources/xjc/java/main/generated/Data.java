
package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *       &amp;lt;choice maxOccurs="unbounded" minOccurs="0"&amp;gt;
 *         &amp;lt;element ref="{}question"/&amp;gt;
 *         &amp;lt;element ref="{}reply"/&amp;gt;
 *         &amp;lt;element ref="{}form"/&amp;gt;
 *         &amp;lt;element ref="{}text"/&amp;gt;
 *       &amp;lt;/choice&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "questionOrReplyOrForm"
})
@XmlRootElement(name = "data")
public class Data {

    @XmlElements({
        @XmlElement(name = "question", type = Question.class),
        @XmlElement(name = "reply", type = Reply.class),
        @XmlElement(name = "form", type = Form.class),
        @XmlElement(name = "text")
    })
    protected List<Object> questionOrReplyOrForm;

    /**
     * Gets the value of the questionOrReplyOrForm property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the questionOrReplyOrForm property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getQuestionOrReplyOrForm().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Question }
     * {@link Reply }
     * {@link Form }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getQuestionOrReplyOrForm() {
        if (questionOrReplyOrForm == null) {
            questionOrReplyOrForm = new ArrayList<Object>();
        }
        return this.questionOrReplyOrForm;
    }

}
