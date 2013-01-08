
package at.jku.ce.ue.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAllPartsByProducer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAllPartsByProducer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="producerid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllPartsByProducer", propOrder = {
    "producerid"
})
public class GetAllPartsByProducer {

    protected String producerid;

    /**
     * Gets the value of the producerid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducerid() {
        return producerid;
    }

    /**
     * Sets the value of the producerid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducerid(String value) {
        this.producerid = value;
    }

}
