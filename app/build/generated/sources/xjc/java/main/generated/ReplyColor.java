
package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &amp;lt;attribute name="r" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" /&amp;gt;
 *       &amp;lt;attribute name="g" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" /&amp;gt;
 *       &amp;lt;attribute name="b" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" /&amp;gt;
 *       &amp;lt;attribute name="a" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" /&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "reply-color")
public class ReplyColor {

    @XmlAttribute(name = "r", required = true)
    @XmlSchemaType(name = "unsignedByte")
    protected short r;
    @XmlAttribute(name = "g", required = true)
    @XmlSchemaType(name = "unsignedByte")
    protected short g;
    @XmlAttribute(name = "b", required = true)
    @XmlSchemaType(name = "unsignedByte")
    protected short b;
    @XmlAttribute(name = "a", required = true)
    @XmlSchemaType(name = "unsignedByte")
    protected short a;

    /**
     * Gets the value of the r property.
     * 
     */
    public short getR() {
        return r;
    }

    /**
     * Sets the value of the r property.
     * 
     */
    public void setR(short value) {
        this.r = value;
    }

    /**
     * Gets the value of the g property.
     * 
     */
    public short getG() {
        return g;
    }

    /**
     * Sets the value of the g property.
     * 
     */
    public void setG(short value) {
        this.g = value;
    }

    /**
     * Gets the value of the b property.
     * 
     */
    public short getB() {
        return b;
    }

    /**
     * Sets the value of the b property.
     * 
     */
    public void setB(short value) {
        this.b = value;
    }

    /**
     * Gets the value of the a property.
     * 
     */
    public short getA() {
        return a;
    }

    /**
     * Sets the value of the a property.
     * 
     */
    public void setA(short value) {
        this.a = value;
    }

}
