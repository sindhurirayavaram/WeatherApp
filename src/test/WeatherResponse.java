package test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement(name="response")
public class WeatherResponse {

	@XmlTransient private String version;
	@XmlTransient private String terms;

	
	@XmlTransient private String weather;
//	@XmlTransient private String Forecast;
	

	public WeatherResponse() {
		
	}
	
	/**
	 * @return the version
	 */
	@XmlElement(name="version")
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the terms
	 */
	@XmlElement(name="termsofService")
	public String getTerms() {
		return terms;
	}

	/**
	 * @param terms the terms to set
	 */
	public void setTerms(String terms) {
		this.terms = terms;
	}

	/**
	 * @return the conditions
	 */
	@XmlElement(name="weather")
	public String getConditions() {
		return weather;
	}

	/**
	 * @param c the conditions to set
	 */
	/*@XmlElement(name="current_observation")
	public void setConditions(Conditions c) {
		this.conditions = c;
	}*/

	/**
	 * @return the forecast
	 */
	
	/**
	 * @param forecast the forecast to set
	 */
	
	

	
	
	
	
}
