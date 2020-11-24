package org.flexlineitsolution.utils.jpa.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author mario.vansteenberghe@gmail.com
 * 16 okt. 2020
 *
 */

@MappedSuperclass
@SuppressWarnings("serial")
public abstract class AbstractModelObject implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	/**
	 * Constructor
	 */
	
	public AbstractModelObject() {
		super();
	}

	// ------------------------------ public methods ------------------------------------ //

	/**
	 * Returns ID
	 * @return ID
	 */
	
	public Long getId() {
		return id;
	}
	
	/**
	 * Sets ID
	 * @param id ID
	 */

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return id == null ? super.hashCode() : new HashCodeBuilder().append(this.id).toHashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof AbstractModelObject)) {
			return false;
		}

		if (this == obj) {
			return true;
		}
		
		if (getId() == null) {
			return false;
		}

		final AbstractModelObject otherObject = (AbstractModelObject) obj;

		return new EqualsBuilder().append(this.id, otherObject.id).isEquals();
	}
	
}
