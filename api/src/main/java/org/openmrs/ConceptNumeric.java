/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs;

import java.util.HashSet;
import java.util.TreeSet;

import org.simpleframework.xml.Attribute;

/**
 * The ConceptNumeric extends upon the Concept object by adding some number range values
 * 
 * @see Concept
 */
public class ConceptNumeric extends Concept implements java.io.Serializable {
	
	public static final long serialVersionUID = 47323L;
	
	// Fields
	
	private Double hiAbsolute;
	
	private Double hiCritical;
	
	private Double hiNormal;
	
	private Double lowAbsolute;
	
	private Double lowCritical;
	
	private Double lowNormal;
	
	private String units;
	
	private Boolean precise = false;
	
	/**
	 * displayPrecision, represents the number of significant digits
	 * to be used for display of a numeric value
	 */
	private Integer displayPrecision;
	
	// Constructors
	
	/** default constructor */
	public ConceptNumeric() {
	}
	
	/**
	 * Generic constructor taking the primary key
	 * 
	 * @param conceptId key for this numeric concept
	 */
	public ConceptNumeric(Integer conceptId) {
		setConceptId(conceptId);
	}
	
	/**
	 * Optional constructor for turning a Concept into a ConceptNumeric <br/>
	 * <br/>
	 * Note: This cannot copy over numeric specific values
	 * 
	 * @param c
	 * @should make deep copy of collections
	 * @should change reference to the parent object  for objects in answers collection
	 * @should change reference to the parent object  for objects in conceptSets collection
	 * @should change reference to the parent object  for objects in names collection
	 * @should change reference to the parent object  for objects in descriptions collection
	 * @should change reference to the parent object  for objects in conceptMappings collection
	 */
	public ConceptNumeric(Concept c) {
		this.setChangedBy(c.getChangedBy());
		this.setConceptClass(c.getConceptClass());
		this.setConceptId(c.getConceptId());
		this.setCreator(c.getCreator());
		this.setDatatype(c.getDatatype());
		this.setDateChanged(c.getDateChanged());
		this.setDateCreated(c.getDateCreated());
		this.setSet(c.isSet());
		this.setRetired(c.isRetired());
		this.setRetiredBy(c.getRetiredBy());
		this.setRetireReason(c.getRetireReason());
		this.setVersion(c.getVersion());
		this.setUuid(c.getUuid());
		
		this.setNames(new HashSet<ConceptName>(c.getNames()));
		for (ConceptName cName : this.getNames()) {
			cName.setConcept(this);
		}
		
		this.setAnswers(new HashSet<ConceptAnswer>(c.getAnswers(true)));
		for (ConceptAnswer cAnswer : this.getAnswers()) {
			cAnswer.setConcept(this);
		}
		
		this.setConceptSets(new TreeSet<ConceptSet>(c.getConceptSets()));
		for (ConceptSet cSet : this.getConceptSets()) {
			cSet.setConcept(this);
		}
		
		this.setDescriptions(new HashSet<ConceptDescription>(c.getDescriptions()));
		for (ConceptDescription cDescription : this.getDescriptions()) {
			cDescription.setConcept(this);
		}
		
		this.setConceptMappings(new HashSet<ConceptMap>(c.getConceptMappings()));
		for (ConceptMap cMap : this.getConceptMappings()) {
			cMap.setConcept(this);
		}
		
		this.hiAbsolute = null;
		this.hiCritical = null;
		this.hiNormal = null;
		this.lowAbsolute = null;
		this.lowCritical = null;
		this.lowNormal = null;
		this.units = "";
		this.precise = false;
	}
	
	// Property accessors
	
	/**
	 * 
	 */
	@Attribute(required = false)
	public Double getHiAbsolute() {
		return this.hiAbsolute;
	}
	
	@Attribute(required = false)
	public void setHiAbsolute(Double hiAbsolute) {
		this.hiAbsolute = hiAbsolute;
	}
	
	/**
	 * 
	 */
	@Attribute(required = false)
	public Double getHiCritical() {
		return this.hiCritical;
	}
	
	@Attribute(required = false)
	public void setHiCritical(Double hiCritical) {
		this.hiCritical = hiCritical;
	}
	
	/**
	 * 
	 */
	@Attribute(required = false)
	public Double getHiNormal() {
		return this.hiNormal;
	}
	
	@Attribute(required = false)
	public void setHiNormal(Double hiNormal) {
		this.hiNormal = hiNormal;
	}
	
	/**
	 * 
	 */
	@Attribute(required = false)
	public Double getLowAbsolute() {
		return this.lowAbsolute;
	}
	
	@Attribute(required = false)
	public void setLowAbsolute(Double lowAbsolute) {
		this.lowAbsolute = lowAbsolute;
	}
	
	/**
	 * 
	 */
	@Attribute(required = false)
	public Double getLowCritical() {
		return this.lowCritical;
	}
	
	@Attribute(required = false)
	public void setLowCritical(Double lowCritical) {
		this.lowCritical = lowCritical;
	}
	
	/**
	 * 
	 */
	@Attribute(required = false)
	public Double getLowNormal() {
		return this.lowNormal;
	}
	
	@Attribute(required = false)
	public void setLowNormal(Double lowNormal) {
		this.lowNormal = lowNormal;
	}
	
	/**
	 * 
	 */
	@Attribute(required = false)
	public String getUnits() {
		return this.units;
	}
	
	@Attribute(required = false)
	public void setUnits(String units) {
		this.units = units;
	}
	
	public Boolean isPrecise() {
		return (precise == null ? false : precise);
	}
	
	@Attribute
	public Boolean getPrecise() {
		return isPrecise();
	}
	
	@Attribute
	public void setPrecise(Boolean precise) {
		this.precise = precise;
	}
	
	/**
	 * This method will <i>always</i> return true for ConceptNumeric objects that have a datatype of
	 * Numeric
	 * 
	 * @see org.openmrs.Concept#isNumeric()
	 */
	@Override
	public boolean isNumeric() {
		return (getDatatype().getName().equals("Numeric"));
	}
	
	/**
	 * @return displayPrecision to be used for the display of a numeric value
	 */
	public Integer getDisplayPrecision() {
		return displayPrecision;
	}
	
	/**
	 * @param displayPrecision, sets displayPrecision to be used for the display of a numeric value
	 */
	public void setDisplayPrecision(Integer displayPrecision) {
		this.displayPrecision = displayPrecision;
	}
}
